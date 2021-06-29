package com.ifoodmvpapi.domain.repository;

import java.util.List;

import com.ifoodmvpapi.domain.model.Cozinha;

//A interface de um repositorio é quem faz a abstração de acesso a dados
//é considerado algo da camada de domain, ou seja, camada de negocio.

public interface CozinhaRepository {
	
	List<Cozinha> todas();
	
	Cozinha porId(Long id);
	
	Cozinha adicionar(Cozinha cozinha);
	
	void remover(Cozinha cozinha);

}
