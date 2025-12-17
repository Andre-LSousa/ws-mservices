package io.github.cursomservice.mscreditanalyzer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomerAssessmentResponse {
    private List<CardApproved> cardApprovedList;

}
