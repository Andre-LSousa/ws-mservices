package io.github.cursomservice.mscreditanalyzer.infra.client;

import io.github.cursomservice.mscreditanalyzer.domain.model.Card;
import io.github.cursomservice.mscreditanalyzer.domain.model.ClientCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(value = "mscard", path = "/card")
public interface ClientResourceCard {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCard>> getCardByClient(@RequestParam("cpf") String cpf);
    @GetMapping(params = "cpf")
    ResponseEntity<List<Card>> getCardsWithIncomeUpTo(@RequestParam("income") BigDecimal income);
}
