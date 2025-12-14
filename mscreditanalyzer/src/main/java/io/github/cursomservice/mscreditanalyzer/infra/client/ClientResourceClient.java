package io.github.cursomservice.mscreditanalyzer.infra.client;

import io.github.cursomservice.mscreditanalyzer.domain.model.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(value = "msclient", path = "/client")
public interface ClientResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity <Optional<ClientData>> dataClient(@RequestParam("cpf") String cpf);
}
