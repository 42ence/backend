package com._42ence.backend.dto.Response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CommentResponseDTO {
    private String intraId;
    private double userLevel;
    private String subjectName;
    private Long commentId;
    private String content;
    private LocalDateTime updateTime;
    private Integer rating;
    private String timeTaken;
    private String amountStudy;
    private String bonus;
    private String difficulty;
}
