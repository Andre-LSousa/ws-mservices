package io.github.cursomservice.mscreditanalyzer.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credit-analyzer")
public class CreditAnalyzerResource {

    @GetMapping
    public String status(){
        return "ok";
    }
}
