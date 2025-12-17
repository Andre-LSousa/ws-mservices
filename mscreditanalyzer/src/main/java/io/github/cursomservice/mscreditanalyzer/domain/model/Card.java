package io.github.cursomservice.mscreditanalyzer.domain.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Card {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal creditLimit;

}
