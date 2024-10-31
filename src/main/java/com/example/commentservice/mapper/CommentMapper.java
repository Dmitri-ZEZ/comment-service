package com.example.commentservice.mapper;

import com.example.commentservice.dto.CommentDto;
import com.example.commentservice.model.Comment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CommentMapper {

    public Comment toEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setUserId(commentDto.getUserId());
        comment.setKodikId(commentDto.getKodikId());
        comment.setUserNickname(commentDto.getUserNickname());
        comment.setUserAvatar(commentDto.getUserAvatar());
        comment.setAddingTime(LocalDateTime.now());

        return comment;
    }

    public CommentDto toDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setComment(comment.getComment());
        commentDto.setUserId(comment.getUserId());
        commentDto.setKodikId(comment.getKodikId());
        commentDto.setUserNickname(comment.getUserNickname());
        commentDto.setUserAvatar(comment.getUserAvatar());
        commentDto.setAddingTime(comment.getAddingTime());

        return commentDto;
    }
}
