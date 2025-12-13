package io.github.cursomservice.mscard.application;

import io.github.cursomservice.mscard.application.representation.CardClientResponse;
import io.github.cursomservice.mscard.application.representation.CardSaveRequest;
import io.github.cursomservice.mscard.domain.Card;
import io.github.cursomservice.mscard.domain.CardClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("card")
@RequiredArgsConstructor
public class CardResource {

    private final CardService cardService;
    private final ClientCardService clientCardService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Card> cardRegistration(@RequestBody CardSaveRequest request){
        Card card = request.toModel();
        cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsWithIncomeUpTo(@RequestParam("income") BigDecimal income){
        List<Card> list = cardService.getCardsIncomeLessEqual(income);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardClientResponse>> getCardByClient(@RequestParam("cpf") String cpf){
        List<CardClient> list = clientCardService.cardListByCpf(cpf);
        List<CardClientResponse> resultList = list.stream()
                .map(CardClientResponse::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);

    }
}
