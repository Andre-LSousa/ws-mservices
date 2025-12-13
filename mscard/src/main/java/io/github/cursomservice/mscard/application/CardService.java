package io.github.cursomservice.mscard.application;

import io.github.cursomservice.mscard.domain.Card;
import io.github.cursomservice.mscard.infra.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card card){
        return cardRepository.save(card);
    }

    public List<Card> getCardsIncomeLessEqual(BigDecimal income){
        return cardRepository.findByIncomeLessThanEqual(income);
    }
}
