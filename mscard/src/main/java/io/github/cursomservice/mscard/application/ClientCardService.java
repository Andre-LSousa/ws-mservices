package io.github.cursomservice.mscard.application;

import io.github.cursomservice.mscard.domain.CardClient;
import io.github.cursomservice.mscard.infra.repository.CardClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final CardClientRepository cardClientRepository;

    public List<CardClient> cardListByCpf(String cpf){
        return cardClientRepository.findByCpf(cpf);
    }
}
