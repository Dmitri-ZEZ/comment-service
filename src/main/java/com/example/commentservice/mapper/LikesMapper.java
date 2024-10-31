package com.example.commentservice.mapper;

import com.example.commentservice.dto.CommentDto;
import com.example.commentservice.dto.LikesDto;
import com.example.commentservice.model.Comment;
import com.example.commentservice.model.Likes;
import org.springframework.stereotype.Component;

@Component
public class LikesMapper {
    public Likes toEntity(LikesDto likesDto) {
        Likes likes = new Likes();
        likes.setCommentId(likesDto.getCommentId());
        likes.setUserId(likesDto.getUserId());
        return likes;
    }

}
