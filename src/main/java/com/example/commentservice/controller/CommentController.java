package com.example.commentservice.controller;

import com.example.commentservice.dto.CommentDto;
import com.example.commentservice.dto.CommentView;
import com.example.commentservice.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/comment")
@CrossOrigin(origins = "http://localhost:3000/")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDto getCommentById(@PathVariable("id") String id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/byKodikId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getCommentsByKodikId(@PathVariable("id") String id) {
        return commentService.getCommentsByKodikId(id);
    }

    @GetMapping("/view")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentView> getCommentsView(@RequestParam("kodikId") String kodikId,
                                             @RequestParam("userId") String userId,
                                             @RequestParam("pageNumber") Integer pageNumber) {
        return commentService.getCommentView(kodikId, userId, pageNumber);
    }

    @GetMapping("/byUserId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDto> getCommentsByUserId(@PathVariable("id") String id) {
        return commentService.getCommentsByUserId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto createComment(@RequestBody CommentDto commentDto) {
        return commentService.createComment(commentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommentById(@PathVariable("id") String id) {
        commentService.deleteCommentById(id);
    }
}
