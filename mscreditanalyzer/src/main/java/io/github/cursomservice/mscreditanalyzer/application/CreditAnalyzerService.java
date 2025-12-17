package io.github.cursomservice.mscreditanalyzer.application;

import feign.FeignException;
import io.github.cursomservice.mscreditanalyzer.application.ex.DataClientNotFoundException;
import io.github.cursomservice.mscreditanalyzer.application.ex.ServiceCommunicationException;
import io.github.cursomservice.mscreditanalyzer.domain.model.*;
import io.github.cursomservice.mscreditanalyzer.infra.client.ClientResourceCard;
import io.github.cursomservice.mscreditanalyzer.infra.client.ClientResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public CustomerAssessmentResponse customerAssessmentResponse(String cpf,Long income)
            throws DataClientNotFoundException, ServiceCommunicationException{
        try {
            ResponseEntity<Optional<ClientData>> dataClientResponse = clientResourceClient.dataClient(cpf);
            ResponseEntity<List<Card>> cardResponse = clientResourceCard.getCardsWithIncomeUpTo(income);

            List<Card> cardList = cardResponse.getBody();
                if (cardList == null) {
                cardList = new ArrayList<>();
                }

            Optional<ClientData> clientData = dataClientResponse.getBody();

            var approvedCardList = cardList.stream().map(card -> {

                BigDecimal creditLimit = card.getCreditLimit();
                // BigDecimal bdIncome = BigDecimal.valueOf(income);

                BigDecimal bdAge = BigDecimal.valueOf(clientData.getAge());

                var ageFactor = bdAge.divide(BigDecimal.valueOf(10));

                BigDecimal approvedLimit= ageFactor.multiply(creditLimit);

                CardApproved cardApproved = new CardApproved();
                cardApproved.setCard(card.getName());
                cardApproved.setBrand(card.getBrand());
                cardApproved.setApprovedLimit(approvedLimit);

                return cardApproved;
            }).collect(Collectors.toList());
            return new CustomerAssessmentResponse(approvedCardList);

        }catch (FeignException.FeignClientException e){
            int status = e.status();
            if(HttpStatus.NOT_FOUND.value() == status){
                throw new DataClientNotFoundException();
            }
            throw new ServiceCommunicationException(e.getMessage(), status);
        }
    }

}
