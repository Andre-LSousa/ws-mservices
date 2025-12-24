package io.github.cursomservice.mscard.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cursomservice.mscard.domain.Card;
import io.github.cursomservice.mscard.domain.CardClient;
import io.github.cursomservice.mscard.domain.CardIssuanceRequestData;
import io.github.cursomservice.mscard.infra.repository.CardClientRepository;
import io.github.cursomservice.mscard.infra.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceSubscriber {

    private final CardRepository cardRepository;
    private final CardClientRepository cardClientRepository;

    @RabbitListener(queues = "${mq.queues.mscard_card_issuance}")
    public void receiveIssuanceRequest(@Payload String payload){
        try {
            var mapper = new ObjectMapper();
            CardIssuanceRequestData cardIssuanceRequestData = mapper
                    .readValue(payload, CardIssuanceRequestData.class);
            Card card = cardRepository
                    .findById(cardIssuanceRequestData.getCardId())
                    .orElseThrow();
            CardClient cardClient = new CardClient();
            cardClient.setCard(card);
            cardClient.setCpf(cardIssuanceRequestData.getCpf());
            cardClient.setCreditLimit(cardIssuanceRequestData.getReleasedCredit());
            cardClientRepository.save(cardClient);

        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
