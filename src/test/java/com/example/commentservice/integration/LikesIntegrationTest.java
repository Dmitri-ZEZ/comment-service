package com.example.commentservice.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.example.commentservice.dto.CommentDto;
import com.example.commentservice.dto.CommentView;
import com.example.commentservice.dto.LikesDto;
import com.example.commentservice.service.CommentService;
import com.example.commentservice.service.LikesService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.UUID;

@Sql(
    scripts = "classpath:sql/comment/likes.sql",
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
@Sql(
    scripts = "classpath:sql/clear-all.sql",
    executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
)
public class LikesIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private LikesService likesService;
    @Autowired
    private CommentService commentService;


    @Test
    @Transactional
    void createAndDeleteLikeTest() {
        LikesDto likesDto = new LikesDto();
        likesDto.setCommentId(UUID.randomUUID());
        likesDto.setUserId("userId");
        likesService.createLike(likesDto);

        likesService.deleteLike(likesDto);
    }

    @Test
    @Transactional
    void getCommentsByKodikIdAndUserIdTest() {
        List<CommentView> comments = commentService.getCommentView("serial-0001", "user1", 0);

        System.out.println();
        assertEquals(2, comments.size());

        assertEquals("коммент 3", comments.get(0).getComment());
        assertNull(comments.get(0).getLikes());
        assertEquals(false, comments.get(0).getThisUserLiked());

        assertEquals("коммент 1", comments.get(1).getComment());
        assertEquals(3, comments.get(1).getLikes());
        assertEquals(true, comments.get(1).getThisUserLiked());
    }
}
