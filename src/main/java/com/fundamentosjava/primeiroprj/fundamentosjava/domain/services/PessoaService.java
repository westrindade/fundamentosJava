package com.fundamentosjava.primeiroprj.fundamentosjava.domain.services;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.dtos.EnderecoDto;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.dtos.PessoaDto;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.CPF;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.EnderecoEntity;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.PessoaEntity;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<PessoaDto> findAll() {
        return repository.findAll().stream().map(PessoaEntity::toDto).toList();
    }

    public PessoaDto findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa Não Existe")).toDto();
    }

    public PessoaDto findByIdade(int idade) {
        return repository.findByIdade(idade).orElseThrow(() -> new RuntimeException("Idade Não Encontrada")).toDto();
    }

    public List<PessoaDto> findByIdadeLessThan(int idade) {
        return repository.findByIdadeLessThan(idade).stream().map(PessoaEntity::toDto).toList();
    }

    public PessoaDto save(PessoaDto pessoaDto){
        try {
            PessoaEntity pessoa = pessoaDto.toPessoa();
            if (!pessoa.getEnderecos().isEmpty()) {
                for (EnderecoEntity endereco : pessoa.getEnderecos()) {
                    endereco.setPessoa(pessoa);
                }
            }

            return repository.save(pessoa).toDto();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}