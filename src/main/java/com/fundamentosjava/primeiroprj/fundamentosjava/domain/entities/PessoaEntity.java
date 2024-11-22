package com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.dtos.EnderecoDto;
import com.fundamentosjava.primeiroprj.fundamentosjava.domain.dtos.PessoaDto;
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
    @Embedded
    private CPF cpf;

    @Column(name = "idade")
    private int idade;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EnderecoEntity> enderecos = new ArrayList<>();

    public PessoaEntity() {}

    public PessoaEntity(String nome, CPF cpf, int idade, List<EnderecoEntity> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.enderecos = enderecos;
    }

    public PessoaEntity(String nome, CPF cpf) throws Exception {

        if (nome == null){
            throw new Exception("Nome é obrigatorio");
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

    public CPF getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<EnderecoEntity> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoEntity> enderecos) {
        this.enderecos = enderecos;
    }

    public PessoaDto toDto() {
        final List<EnderecoDto> enderecos = this.getEnderecos().stream().map(EnderecoEntity::toDto).toList();

        return new PessoaDto(
                this.cpf.toString(),
                this.nome,
                this.idade,
                enderecos
        );
    }
}
