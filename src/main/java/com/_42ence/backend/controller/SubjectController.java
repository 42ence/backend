package com._42ence.backend.controller;

import com._42ence.backend.dto.Response.SubjectListResponseDTO;
import com._42ence.backend.dto.Response.SubjectResponseDTO;
import com._42ence.backend.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/List")
    public List<SubjectListResponseDTO> getSubjectList() {
        return subjectService.getSubjectList();
    }

    @GetMapping("/{subjectName}")
    public SubjectResponseDTO getSubjectDetail(@PathVariable String subjectName) {
        return subjectService.getSubjectDetail(subjectName);
    }
}
