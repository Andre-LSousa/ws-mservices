package io.github.cursomservice.mscreditanalyzer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Value("${mq.queues.mscard_card_issuance}")
    private String cardIssuanceQueueName;

    //METODO PARA CRIAR A FILA
    @Bean
    public Queue cardIssuanceQueue(){
        return new Queue(cardIssuanceQueueName, true);
    }
}
