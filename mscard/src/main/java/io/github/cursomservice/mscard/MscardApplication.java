package io.github.cursomservice.mscard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
@Slf4j
public class MscardApplication {

	public static void main(String[] args) {
		log.info("informacao: {}", "teste info");
		log.error("error: {}", "teste error");
		log.warn("aviso: {}", "teste aviso");
		SpringApplication.run(MscardApplication.class, args);
	}

}
