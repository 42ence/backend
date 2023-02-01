package com._42ence.backend.controller;

import com._42ence.backend.dto.Response.CommentResponseDTO;
import com._42ence.backend.repository.SubjectRepository;
import com._42ence.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final SubjectRepository subjectRepository;

    @GetMapping("/{subjectName}/comment")
    public List<CommentResponseDTO> getCommentList(@PathVariable String subjectName){
        return commentService.getAllSubjectComment(subjectRepository.findByName(subjectName));
    }

}
