package com.example.commentservice.controller;

import com.example.commentservice.dto.LikesDto;
import com.example.commentservice.service.LikesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/like")
@CrossOrigin(origins = "http://localhost:3000/")
public class LikesController {

    private final LikesService likesService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public void createLike(@RequestBody LikesDto likesDto) {
        likesService.createLike(likesDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/delete")
    public void deleteLike(@RequestBody LikesDto likesDto) {
        likesService.deleteLike(likesDto);
    }
}
