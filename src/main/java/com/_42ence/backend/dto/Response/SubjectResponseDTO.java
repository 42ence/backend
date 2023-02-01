package com._42ence.backend.dto.Response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com._42ence.backend.entity.Wiki;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SubjectResponseDTO {
    private String subjectName;
    private int circle;
    private String subjectDescription;
    private Wiki subjectWiki;
    private double avgStarRating;
    private int totalRatingNum;
    private TotalTimeTakenResponseDTO totalTimeTaken;
    private TotalAmountStudyResponseDTO totalAmountStudy;
    private TotalBonusResponseDTO totalBonus;
    private TotalDifficultyResponseDTO totalDifficulty;
}
