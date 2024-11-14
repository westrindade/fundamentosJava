package com.fundamentosjava.primeiroprj.fundamentosjava.domain.services;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.PessoaEntity;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<PessoaEntity> findAll() {
        return repository.findAll();
    }

    public PessoaEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa Não Existe"));
    }

    public PessoaEntity findByIdade(int idade) {
        return repository.findByIdade(idade)
                .orElseThrow(() -> new RuntimeException("Idade Não Encontrada"));
    }

    public List<PessoaEntity> findByIdadeLessThan(int idade) {
        return repository.findByIdadeLessThan(idade);
    }

    public PessoaEntity save(PessoaEntity pessoa){
        return repository.save(pessoa);
    }
}