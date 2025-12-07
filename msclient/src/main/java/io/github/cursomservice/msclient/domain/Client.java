package io.github.cursomservice.msclient.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String cpf;
    @Column
    private Integer age;

    public Client(String name, String cpf, Integer age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }
}
