package io.github.cursomservice.mscreditanalyzer.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientCard {
    private String name;
    private String brand;
    private BigDecimal releasedCredit;
}
