package com.example.commentservice.integration;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = "com.example.commentservice")
@ActiveProfiles("test")
public abstract class BaseIntegrationTest {


    /**
     * postgreSQLContainer.
     */
    public static PostgreSQLContainer<?> POSTGRESQL_CONTAINER = new PostgreSQLContainer<>("postgres:11.10-alpine")
        .withDatabaseName("test-db")
        .withUsername("postgres")
        .withPassword("postgres");

    static {
        if (!Boolean.parseBoolean(System.getProperty("testcontainers.disabled"))) {

            POSTGRESQL_CONTAINER.start();
            System.setProperty("spring.datasource.url", POSTGRESQL_CONTAINER.getJdbcUrl());
            System.setProperty("spring.datasource.username", POSTGRESQL_CONTAINER.getUsername());
            System.setProperty("spring.datasource.password", POSTGRESQL_CONTAINER.getPassword());
        }
    }
}
