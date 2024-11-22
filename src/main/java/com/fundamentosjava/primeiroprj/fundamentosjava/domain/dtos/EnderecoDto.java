package com.fundamentosjava.primeiroprj.fundamentosjava.domain.dtos;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.EnderecoEntity;
import jakarta.persistence.Column;

public record EnderecoDto(
    String cep,
    String logradouro,
    String cidade,
    String uf
) {

    public EnderecoEntity toEndereco() throws Exception {
        return new EnderecoEntity(
                cep,
                logradouro,
                cidade,
                uf
        );
    }
}
