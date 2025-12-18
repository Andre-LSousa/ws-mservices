package io.github.cursomservice.mscreditanalyzer.domain.model;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter
public class ClientData {
    private Long id;
    private String name;
    private BigDecimal age;
}
