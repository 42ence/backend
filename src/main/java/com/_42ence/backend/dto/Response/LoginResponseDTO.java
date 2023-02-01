package com._42ence.backend.dto.Response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoginResponseDTO {
    private String intraId;
    private double userLevel;
    private LocalDateTime reloadTime;
}
