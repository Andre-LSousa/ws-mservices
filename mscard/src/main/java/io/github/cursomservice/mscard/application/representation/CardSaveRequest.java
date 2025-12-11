package io.github.cursomservice.mscard.application.representation;

import io.github.cursomservice.mscard.domain.Card;
import io.github.cursomservice.mscard.domain.CardBrand;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String name;
    private CardBrand brand;
    private BigDecimal income;
    private BigDecimal creditLimit;

    public Card toModel(){
            return new Card(name, brand, income, creditLimit);
    }

}
