package com.example.commentservice.service;

import com.example.commentservice.config.ConfigurationParam;
import com.example.commentservice.dto.CommentDto;
import com.example.commentservice.dto.CommentView;
import com.example.commentservice.mapper.CommentMapper;
import com.example.commentservice.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final ConfigurationParam configurationParam;

    public CommentDto getCommentById(String id) {
        return commentRepository.findById(UUID.fromString(id))
            .map(commentMapper::toDto)
            .orElseThrow(() -> new IllegalArgumentException(String.format("Not found comment by id %s", id)));
    }

    public List<CommentDto> getCommentsByKodikId(String id) {
        return commentRepository.findByKodikId(id)
            .stream()
            .map(commentMapper::toDto)
            .collect(Collectors.toList());
    }

    public List<CommentDto> getCommentsByUserId(String id) {
        return commentRepository.findByUserId(id)
            .stream()
            .map(commentMapper::toDto)
            .collect(Collectors.toList());
    }

    public List<CommentView> getCommentView(String kodikId, String userId, Integer pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, configurationParam.getPageSize(),
            Sort.by(configurationParam.getSortFiled()).descending());
        return commentRepository.findCommentsByKodikIdAndUserId(kodikId, userId, pageRequest);
    }

    public CommentDto createComment(CommentDto commentDto) {
        return commentMapper.toDto(commentRepository.save(commentMapper.toEntity(commentDto)));
    }

    public void deleteCommentById(String id) {
        commentRepository.deleteById(UUID.fromString(id));
    }
}
