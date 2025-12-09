package io.github.cursomservice.msclient.application.representation;

import io.github.cursomservice.msclient.domain.Client;
import lombok.Data;

@Data
public class ClientSaveRequest {
    private String name;
    private String cpf;
    private Integer age;

    public Client toModel(){
        return new Client(name, cpf, age);
    }


}
