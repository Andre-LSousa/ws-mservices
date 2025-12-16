package io.github.cursomservice.mscreditanalyzer.application;

import io.github.cursomservice.mscreditanalyzer.application.ex.DataClientNotFoundException;
import io.github.cursomservice.mscreditanalyzer.application.ex.ServiceCommunicationException;
import io.github.cursomservice.mscreditanalyzer.domain.model.ClientStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> checkClientStatus(@RequestParam("cpf") String cpf){
        try {
            ClientStatus clientStatus = creditAnalyzerService.getClientStatus(cpf);
            return ResponseEntity.ok(clientStatus);
        } catch (DataClientNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ServiceCommunicationException e) {
            HttpStatus status = HttpStatus.resolve(e.getStatus());
            if (status == null) {
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            return ResponseEntity.status(status).body(e.getMessage());

            /*return ResponseEntity.status(HttpStatus.
                    resolve(e.getStatus())).
                    body(e.getMessage());
            */

        }

    }


}
