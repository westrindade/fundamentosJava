package com.fundamentosjava.primeiroprj.fundamentosjava.domain.repositories;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, String> {

}
