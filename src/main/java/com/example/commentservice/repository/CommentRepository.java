package com.example.commentservice.repository;

import com.example.commentservice.dto.CommentView;
import com.example.commentservice.model.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends CrudRepository<Comment, UUID> {
    List<Comment> findByKodikId(String kodikId);

    List<Comment> findByUserId(String userId);

    @Query(value = "SELECT main_comment.id AS id, " +
        "       main_comment.comment AS comment, " +
        "       main_comment.kodik_id AS kodikid, " +
        "       main_comment.user_id AS userid, " +
        "       main_comment.user_nickname AS usernickname, " +
        "       main_comment.user_avatar AS useravatar, " +
        "       main_comment.adding_time AS addingtime, " +
        "       (SELECT COUNT(*) AS likes_count " +
        "        FROM likes " +
        "                 LEFT JOIN comment AS sub_comment1 ON likes.comment_id = sub_comment1.id " +
        "        WHERE sub_comment1.id = main_comment.id " +
        "        GROUP BY sub_comment1.id) AS likes, " +
        "        (CASE WHEN (SELECT likes.user_id " +
        "         FROM likes " +
        "                  LEFT JOIN comment AS sub_comment2 ON likes.comment_id = sub_comment2.id " +
        "         WHERE sub_comment2.id = main_comment.id " +
        "         AND likes.user_id = :userId) NOTNULL THEN TRUE ELSE FALSE END) AS thisuserliked " +
        "FROM comment AS main_comment " +
        "WHERE main_comment.kodik_id = :kodikId ", nativeQuery = true)
    List<CommentView> findCommentsByKodikIdAndUserId(@Param("kodikId") String kodikId,
                                                     @Param("userId") String userId,
                                                     Pageable pageable);

}

