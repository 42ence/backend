package com._42ence.backend.service;

import com._42ence.backend.dto.Response.*;
import com._42ence.backend.entity.Subject;
import com._42ence.backend.entity.Wiki;
import com._42ence.backend.repository.RatingRepository;
import com._42ence.backend.repository.SubjectRepository;
import com._42ence.backend.repository.WikiRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final RatingRepository ratingRepository;
    private final WikiRepository wikiRepository;


    public List<SubjectListResponseDTO> getSubjectList(){
        return subjectRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private SubjectListResponseDTO convertEntityToDto(Subject subject) {

        SubjectListResponseDTO subjectListResponseDTO =  new SubjectListResponseDTO();
        subjectListResponseDTO.setSubjectName(subject.getName());
        subjectListResponseDTO.setCircle(subject.getCircle());

        subjectListResponseDTO.setAvgStarRating(ratingRepository.starRatingAvg(subject.getId()));
        subjectListResponseDTO.setTotalRatingNum(ratingRepository.countRating(subject.getId()));
        if (subjectListResponseDTO.getAvgStarRating() == null ){
            subjectListResponseDTO.setAvgStarRating(0.0);
        }
        if (subjectListResponseDTO.getTotalRatingNum() == null){
            subjectListResponseDTO.setTotalRatingNum(0);
        }
        return subjectListResponseDTO;
    }

}
