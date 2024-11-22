package com.fundamentosjava.primeiroprj.fundamentosjava.domain.controller;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.EnderecoEntity;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.PessoaEntity;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(
                    service.findAll()
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ex.getMessage()
            );
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody EnderecoEntity endereco) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    service.save(endereco)
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ex.getMessage()
            );
        }

    }
}
