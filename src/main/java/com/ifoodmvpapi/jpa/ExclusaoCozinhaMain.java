package com.ifoodmvpapi.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifoodmvpapi.IfoodmvpApiApplication;
import com.ifoodmvpapi.domain.model.Cozinha;

public class ExclusaoCozinhaMain {
	
	@PersistenceContext
	private EntityManager manager;
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(IfoodmvpApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);
		
		cadastroCozinha.remover(cozinha);	
		
		
	}

}
