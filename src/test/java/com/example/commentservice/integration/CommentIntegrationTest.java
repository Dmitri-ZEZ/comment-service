package com.example.commentservice.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.commentservice.dto.CommentDto;
import com.example.commentservice.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

@Sql(
    scripts = "classpath:sql/comment/comment.sql",
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
@Sql(
    scripts = "classpath:sql/clear-all.sql",
    executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
)
public class CommentIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private CommentService commentService;

    @Test
    void getCommentByIdtest() {
        CommentDto comment = commentService.getCommentById("6cb321de-d6e3-46f3-993d-fe3f7f30d630");

        assertEquals(comment.getComment(), "коммент 1");
    }

    @Test
    void getCommentsByKodikId() {
        List<CommentDto> comments = commentService.getCommentsByKodikId("serial-0002");

        assertEquals(comments.size(), 2);
        assertEquals(comments.get(0).getComment(), "коммент 2");
        assertEquals(comments.get(1).getComment(), "коммент 3");
    }

    @Test
    void getCommentsByUserId() {
        List<CommentDto> comments = commentService.getCommentsByUserId("65275dee-d664-47d8-a6b9-78927e7cdcc3");

        assertEquals(comments.size(), 2);
        assertEquals(comments.get(0).getComment(), "коммент 3");
        assertEquals(comments.get(1).getComment(), "коммент 4");
    }

    @Test
    void createAndGetAndDeleteComment() {
        String kodikId = "serial-4321";
        String user = "user";
        String newComment = "новый коммент";
        CommentDto commentDto = new CommentDto();
        commentDto.setComment(newComment);
        commentDto.setUserNickname(user);
        commentDto.setKodikId(kodikId);
        commentDto.setUserId("65275dee-d664-47d8-a6b9-78927e7cdcc4");
        commentDto.setAddingTime(LocalDateTime.now());
        commentService.createComment(commentDto);

        List<CommentDto> comments = commentService.getCommentsByKodikId(kodikId);

        assertEquals(comments.size(), 1);
        assertEquals(comments.get(0).getComment(), newComment);
        assertEquals(comments.get(0).getUserNickname(), user);
    }
}
