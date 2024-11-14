package com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities;

import jakarta.persistence.*;

@Table(name = "tb_endereco")
@Entity
public class EndecoEntity {
    @Id
    @Column(name = "cd_cep", unique = true)
    private String cep;

    @Column(name = "ds_logradouro")
    private String logradouro;

    @Column(name = "ds_cidade")
    private String cidade;

    @Column(name = "ds_uf")
    private String uf;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private PessoaEntity pessoa;

    public EndecoEntity(){}

    public EndecoEntity(String cep, PessoaEntity pessoa) throws Exception {
        if (cep == null){
            throw new Exception("Cep não informado");
        }

        if (pessoa == null) {
            throw new Exception("Pessoa não informado");
        }

        this.cep = cep;
        this.pessoa = pessoa;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
