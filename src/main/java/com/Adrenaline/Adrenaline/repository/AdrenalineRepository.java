package com.Adrenaline.Adrenaline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Adrenaline.Adrenaline.models.Adrenaline;

public interface AdrenalineRepository extends CrudRepository<Adrenaline, Long>{
	
	Adrenaline findById(long id);
	Adrenaline findByNome(String nome);
	
	// Query para a busca
	@Query(value = "select u from Adrenaline u where u.nome like %?1%")
	List<Adrenaline>findByNomes(String nome);

}
