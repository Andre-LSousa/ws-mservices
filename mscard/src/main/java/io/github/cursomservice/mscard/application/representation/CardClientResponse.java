package io.github.cursomservice.mscard.application.representation;

import io.github.cursomservice.mscard.domain.CardClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardClientResponse {
    private String name;
    private String brand;
    private BigDecimal releasedCredit;

    public static CardClientResponse fromModel(CardClient model){
        return new CardClientResponse(model.getCard().getName(),
                model.getCard().getBrand().toString(),
                model.getCreditLimit());
    }
}
