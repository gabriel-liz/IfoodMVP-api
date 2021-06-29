package com.ifoodmvpapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ifoodmvpapi.domain.model.Cozinha;
import com.ifoodmvpapi.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository{

	@PersistenceContext
	private EntityManager manager;

	
	@Override
	public List<Cozinha> todas(){
		return  manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();			

	}
	
	@Override
	public Cozinha porId(Long id) {
		return manager.find(Cozinha.class, id);
	}
	 
	@Transactional
	@Override
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Transactional
	@Override
	public void remover(Cozinha cozinha) {
		//caso não tenha a linha abaixo, ira dar erro ao rodar a exclusão pelo main, ler artigo https://blog.algaworks.com/tutorial-jpa/
		cozinha = porId(cozinha.getId());
		manager.remove(cozinha);
	}
}
