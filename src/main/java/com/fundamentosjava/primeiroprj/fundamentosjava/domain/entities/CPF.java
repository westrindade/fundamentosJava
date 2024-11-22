package com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities;

public class CPF {
    private String cpf;

    public CPF() {
    }

    public CPF(String cpf) throws Exception {
        if (cpf == null) {
            throw new Exception("CPF é obrigatorio");
        }
        //validacao dos valores do cpf

        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return cpf;
    }
}
