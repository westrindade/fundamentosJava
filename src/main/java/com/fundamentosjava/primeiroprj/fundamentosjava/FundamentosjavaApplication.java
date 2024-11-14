package com.fundamentosjava.primeiroprj.fundamentosjava;

import com.fundamentosjava.primeiroprj.fundamentosjava.domain.entities.PessoaEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosjavaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FundamentosjavaApplication.class, args);

//		try {
//			PessoaEntity pessoa = new PessoaEntity("weslei","123");
//
//			System.out.println(pessoa);
//		} catch (Exception ex) {
//			throw ex;
//		}
	}

}