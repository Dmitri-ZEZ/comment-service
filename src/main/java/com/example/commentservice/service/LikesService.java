package com.example.commentservice.service;

import com.example.commentservice.dto.LikesDto;
import com.example.commentservice.mapper.LikesMapper;
import com.example.commentservice.model.Likes;
import com.example.commentservice.repository.LikesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;
    private final LikesMapper likesMapper;

    public void createLike(LikesDto likesDto){
        likesRepository.save(likesMapper.toEntity(likesDto));
    }

    public void deleteLike(LikesDto likesDto){
        Optional<Likes> likes = likesRepository
            .findByCommentIdAndUserId(likesDto.getCommentId(), likesDto.getUserId());
        likes.ifPresent(likesRepository::delete);
    }

}
