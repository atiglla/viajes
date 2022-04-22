package com.dojo.projects.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.projects.models.Gasto;

@Repository
public interface RepositorioViajes extends CrudRepository<Gasto, Long>{
	
	List<Gasto> findAll();
	List<Gasto> findById(long id);
	
	Gasto save(Gasto gasto);
	
	void deleteById(Long id);
}
