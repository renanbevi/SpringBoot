package com.aulajava.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot.model.Pessoa;

@Repository
@Transactional // controlar toda a parte de persistencia 

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{
	
	

}
