package com.fundamentosjava.primeiroprj.fundamentosjava.domain.controllers;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.dtos.PessoaDto;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.PessoaEntity;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(
                    service.findById(id)
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ex.getMessage()
            );
        }
    }

    @GetMapping("/idade/{idade}")
    public ResponseEntity<?> findByIdade(@PathVariable int idade){
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(
                    service.findByIdade(idade)
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ex.getMessage()
            );
        }
    }

    @GetMapping("/idadeMenorQue/{idade}")
    public ResponseEntity<?> findByIdadeLessThan(@PathVariable int idade){
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(
                    service.findByIdadeLessThan(idade)
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ex.getMessage()
            );
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PessoaDto pessoa) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    service.save(pessoa)
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    ex.getMessage()
            );
        }

    }

}
