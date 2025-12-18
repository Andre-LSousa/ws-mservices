package io.github.cursomservice.mscard.infra.mqueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CardIssuanceSubscriber {

    @RabbitListener(queues = "${mq.queues.mscard_card_issuance}")
    public void receiveIssuanceRequest(@Payload String payload){
        System.out.println(payload);
    }
}
