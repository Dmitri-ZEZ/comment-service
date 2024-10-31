package com.example.commentservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CommentDto {
    private UUID id;
    private String comment;
    private String kodikId;
    private String userId;
    private String userNickname;
    private String userAvatar;
    private Integer likes;
    private Boolean thisUserLiked;
    private LocalDateTime addingTime;
}
