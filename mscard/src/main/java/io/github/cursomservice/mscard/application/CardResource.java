package io.github.cursomservice.mscard.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cards")
public class CardResource {

    @GetMapping
    public String status(){
        return "ok";
    }
}
