package com.ifoodmvpapi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ifoodmvpapi.domain.model.Cozinha;

@Component
public class CadastroCozinha {


	//gerencia o contexto de persistencia
	//responsavel por fazer a intermediação dos comandos da traducao do sql
	@PersistenceContext
	private EntityManager manager;

	public List<Cozinha> listar(){
		return  manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();			

	}
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);

	}

}
