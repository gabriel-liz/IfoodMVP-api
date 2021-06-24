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
	
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Transactional
	public void remover(Cozinha cozinha) {
		//caso não tenha a linha abaixo, ira dar erro ao rodar a exclusão pelo main, ler artigo https://blog.algaworks.com/tutorial-jpa/
		cozinha = buscar(cozinha.getId());
		manager.remove(cozinha);
	}

}
