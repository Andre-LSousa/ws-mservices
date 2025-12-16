package io.github.cursomservice.mscreditanalyzer.application;

import feign.FeignException;
import io.github.cursomservice.mscreditanalyzer.application.ex.DataClientNotFoundException;
import io.github.cursomservice.mscreditanalyzer.application.ex.ServiceCommunicationException;
import io.github.cursomservice.mscreditanalyzer.domain.model.ClientCard;
import io.github.cursomservice.mscreditanalyzer.domain.model.ClientData;
import io.github.cursomservice.mscreditanalyzer.domain.model.ClientStatus;
import io.github.cursomservice.mscreditanalyzer.infra.client.ClientResourceCard;
import io.github.cursomservice.mscreditanalyzer.infra.client.ClientResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditAnalyzerService {

    private final ClientResourceClient clientResourceClient;

    private final ClientResourceCard clientResourceCard;

    public ClientStatus getClientStatus(String cpf)
            throws DataClientNotFoundException, ServiceCommunicationException {
        try {
            ResponseEntity<Optional<ClientData>> dataClientResponse = clientResourceClient.dataClient(cpf);
            Optional<ClientData> clientOptional = dataClientResponse.getBody();
            /*if (clientOptional == null || clientOptional.isEmpty()) {
                throw new RuntimeException("Cliente não encontrado com CPF: " + cpf);
            }*/
            ClientData clientData = clientOptional.get();

            ResponseEntity<List<ClientCard>> dataCardResponse = clientResourceCard.getCardByClient(cpf);
            List<ClientCard> clientCardList = dataCardResponse.getBody();
            /*if (clientCardList == null) {
                clientCardList = Collections.emptyList();
            }*/
            return ClientStatus
                    .builder()
                    .clientData(clientData)
                    .clientCardList(clientCardList)
                    .build();
        }catch (FeignException.FeignClientException e){
            int status = e.status();
            if(HttpStatus.NOT_FOUND.value() == status){
                throw new DataClientNotFoundException();
            }
            throw new ServiceCommunicationException(e.getMessage(), status);
        }
    }

}
