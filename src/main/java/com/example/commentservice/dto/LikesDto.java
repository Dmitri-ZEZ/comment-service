package com.example.commentservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class LikesDto {
    private UUID commentId;

    private String userId;
}
