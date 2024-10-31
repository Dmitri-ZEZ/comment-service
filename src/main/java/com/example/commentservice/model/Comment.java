package com.example.commentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String comment;
    @NotNull
    private String kodikId;
    @NotNull
    private String userId;
    @NotNull
    private String userNickname;
    @NotNull
    private String userAvatar;
    @NotNull
    private LocalDateTime addingTime;
}
