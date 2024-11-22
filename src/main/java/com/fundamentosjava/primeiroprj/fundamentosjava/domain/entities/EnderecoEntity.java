package com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.dtos.EnderecoDto;
import jakarta.persistence.*;

@Table(name = "tb_endereco")
@Entity
public class EnderecoEntity {
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

    public EnderecoEntity() { }

    public EnderecoEntity(String cep, String logradouro, String cidade, String uf) throws Exception {

        if (cep == null){
            throw new Exception("Cep não informado");
        }

//        if (pessoa == null) {
//            throw new Exception("Pessoa não informado");
//        }

        this.cep = cep;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.uf = uf;
//        this.pessoa = pessoa;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }

    public EnderecoDto toDto(){
        return new EnderecoDto(
                this.getCep(),
                this.getLogradouro(),
                this.getCidade(),
                this.getUf()
        );
    }
}
