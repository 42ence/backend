package com._42ence.backend.dto.Request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WikiRequestDTO {
    private String body;
    private Long version;
    private String intraId;
    private String subjectName;

}
