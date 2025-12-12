package io.github.cursomservice.mscard.application;

import io.github.cursomservice.mscard.application.representation.CardSaveRequest;
import io.github.cursomservice.mscard.domain.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("card")
@RequiredArgsConstructor
public class CardResource {

    private final CardService service;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Card> cardRegistration(@RequestBody CardSaveRequest request){
        Card card = request.toModel();
        service.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsWithIncomeUpTo(@RequestParam("income") BigDecimal income){
        List<Card> list = service.getCardsIncomeLessEqual(income);
        return ResponseEntity.ok(list);
    }
}
