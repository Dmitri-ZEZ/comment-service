package com.example.commentservice.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public interface CommentView {

    UUID getId();

    String getComment();

    String getKodikId();

    String getUserId();

    String getUserNickname();

    String getUserAvatar();

    Integer getLikes();

    Boolean getThisUserLiked();

    LocalDateTime getAddingTime();
}
