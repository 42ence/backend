package com._42ence.backend.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TotalTimeTakenResponseDTO {
    @JsonProperty(value = "a_week")
    private Integer aWeek;
    private Integer twoWeek;
    private Integer threeWeek;
    @JsonProperty(value = "a_month")
    private Integer aMonth;
    private Integer threeMonth;
}
