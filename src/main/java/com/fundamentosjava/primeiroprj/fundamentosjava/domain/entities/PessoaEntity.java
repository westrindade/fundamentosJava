package com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "tb_pessoa")
@Entity
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_pessoa", unique = true)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "idade")
    private int idade;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EndecoEntity> enderecos = new ArrayList<>();

    public PessoaEntity() {}

    public PessoaEntity(String nome, String cpf) throws Exception {

        if (nome == null){
            throw new Exception("Nome é obrigatorio");
        }

        if (cpf == null) {
            throw new Exception("CPF é obrigatorio");
        }

        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<EndecoEntity> getEnderecos() {
        return enderecos;
    }
}
