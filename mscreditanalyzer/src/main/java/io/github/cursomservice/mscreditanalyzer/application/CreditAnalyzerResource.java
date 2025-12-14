package io.github.cursomservice.mscreditanalyzer.application;

import io.github.cursomservice.mscreditanalyzer.domain.model.ClientStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credit-analyzer")
@RequiredArgsConstructor
public class CreditAnalyzerResource {

    private final CreditAnalyzerService creditAnalyzerService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @GetMapping(value = "client-status", params = "cpf")
    public ResponseEntity<ClientStatus> checkClientStatus(@RequestParam("cpf") String cpf){
        ClientStatus clientStatus = creditAnalyzerService.getClientStatus(cpf);
        return ResponseEntity.ok(clientStatus);
    }


}
