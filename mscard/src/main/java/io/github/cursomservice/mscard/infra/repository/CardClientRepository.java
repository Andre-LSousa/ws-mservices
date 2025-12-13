package io.github.cursomservice.mscard.infra.repository;

import io.github.cursomservice.mscard.domain.CardClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardClientRepository extends JpaRepository<CardClient, Long> {
    List<CardClient> findByCpf(String cpf);
}
