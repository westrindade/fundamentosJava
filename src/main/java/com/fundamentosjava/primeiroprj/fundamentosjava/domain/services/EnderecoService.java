package com.fundamentosjava.primeiroprj.fundamentosjava.domain.services;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.EnderecoEntity;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public List<EnderecoEntity> findAll() {
        return repository.findAll();
    }

    public EnderecoEntity save(EnderecoEntity endereco){
        return repository.save(endereco);
    }

}
