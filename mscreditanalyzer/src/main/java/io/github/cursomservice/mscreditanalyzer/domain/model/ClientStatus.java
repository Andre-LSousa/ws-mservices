package io.github.cursomservice.mscreditanalyzer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientStatus {
    private ClientData clientData;
    private List<ClientCard> clientCardList;

}
