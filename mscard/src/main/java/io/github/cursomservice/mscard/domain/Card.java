package io.github.cursomservice.mscard.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private CardBrand brand;

    private BigDecimal income;
    private BigDecimal creditLimit;

    public Card(String name, CardBrand brand, BigDecimal income, BigDecimal creditLimit) {
        this.name = name;
        this.brand = brand;
        this.income = income;
        this.creditLimit = creditLimit;
    }
}
