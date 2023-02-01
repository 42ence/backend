package com._42ence.backend.dto.Response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TotalAmountStudyResponseDTO {
    private Integer low;
    private Integer middle;
    private Integer high;

}
