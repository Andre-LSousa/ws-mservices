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

    @Autowired
    private CardRepository repository;

    @Transactional
    public Card save(Card card){
        return repository.save(card);
    }

    public List<Card> getCardsIncomeLessEqual(Long income){
        var IncomeBigDecimal = BigDecimal.valueOf(income);
        return repository.findByIncomeLessThanEqual(IncomeBigDecimal);
    }
}
