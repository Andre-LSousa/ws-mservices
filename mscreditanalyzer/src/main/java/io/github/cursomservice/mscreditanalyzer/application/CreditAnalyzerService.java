package io.github.cursomservice.mscreditanalyzer.application;

import io.github.cursomservice.mscreditanalyzer.domain.model.ClientData;
import io.github.cursomservice.mscreditanalyzer.domain.model.ClientStatus;
import io.github.cursomservice.mscreditanalyzer.infra.client.ClientResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditAnalyzerService {

    private final ClientResourceClient clientResourceClient;

    public ClientStatus getClientStatus(String cpf) {
        ResponseEntity<Optional<ClientData>> dataClientResponse = clientResourceClient.dataClient(cpf);
        Optional<ClientData> clientOptional = dataClientResponse.getBody();
        if (clientOptional == null || clientOptional.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado com CPF: " + cpf);}
            ClientData clientData = clientOptional.get();
        return ClientStatus
                .builder()
                .clientData(clientData)
                .build();
    }
}
