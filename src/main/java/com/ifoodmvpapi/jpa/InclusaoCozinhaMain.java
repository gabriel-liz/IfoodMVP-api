package com.ifoodmvpapi.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifoodmvpapi.IfoodmvpApiApplication;
import com.ifoodmvpapi.domain.model.Cozinha;

public class InclusaoCozinhaMain {
	
	@PersistenceContext
	private EntityManager manager;
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(IfoodmvpApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");
		
		
		
		//se nao passar com as variaveis cozinha1/2, o ID ira ficar nulo, pois é necessario ter o retorno do metodo merge que é o valor do ID.
		//cadastroCozinha.adicionar(cozinha1);		
		//cadastroCozinha.adicionar(cozinha2);
		
		cozinha1 = cadastroCozinha.adicionar(cozinha1);
		cozinha2 = cadastroCozinha.adicionar(cozinha2);
		
		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());		
		
	}

}
