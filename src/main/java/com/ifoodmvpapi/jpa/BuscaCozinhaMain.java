package com.ifoodmvpapi.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.ifoodmvpapi.IfoodmvpApiApplication;
import com.ifoodmvpapi.domain.model.Cozinha;

public class BuscaCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(IfoodmvpApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cozinha = cadastroCozinha.buscar(1L);
		
		System.out.println(cozinha.getNome());
	}	
	

}
