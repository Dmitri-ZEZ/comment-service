package com.example.commentservice.repository;

import com.example.commentservice.model.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LikesRepository extends CrudRepository<Likes, UUID> {
    Optional<Likes> findByCommentIdAndUserId(UUID commentId, String userId);
}
