package io.github.cursomservice.mscreditanalyzer.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardApproved {
    private String card;
    private String brand;
    private BigDecimal approvedLimit;
}
