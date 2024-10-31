package com.example.commentservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "comment.param")
public class ConfigurationParam {
    private Integer pageSize;
    private String sortFiled;
}
