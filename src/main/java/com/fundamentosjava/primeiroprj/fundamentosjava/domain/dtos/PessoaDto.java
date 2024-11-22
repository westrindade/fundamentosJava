package com.fundamentosjava.primeiroprj.fundamentosjava.domain.dtos;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.CPF;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.EnderecoEntity;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.PessoaEntity;

import java.util.List;
import java.util.stream.Collectors;

public record PessoaDto (
        String cpf,
        String nome,
        int idade,
        List<EnderecoDto> enderecos
) {

    public PessoaEntity toPessoa() throws Exception {
        List<EnderecoEntity> lstEnderecos = enderecos.stream().map(dto -> {
                try {
                    return dto.toEndereco();
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        ).collect(Collectors.toList());

        return new PessoaEntity(
                nome,
                new CPF(cpf),
                idade,
                lstEnderecos
        );
    }
}
