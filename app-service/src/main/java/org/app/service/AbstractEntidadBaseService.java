package org.app.service;

import java.util.Collection;

import ar.com.educacionit.bootcamp.User;
import ar.com.educacionit.bootcamp.repository.BaseRepository;

public abstract class AbstractEntidadBaseService<T> implements EntidadBaseService<T> {

	protected BaseRepository<T> repository;
	
	public AbstractEntidadBaseService(BaseRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Collection<T> buscarTodos() {
		
		return this.repository.findAll();
	}

	public T buscarPorId(Long id) {
		return this.repository.getById(id);
	}
	
	@Override
	public void eliminarPorId(Long id) {
		this.repository.delete(id);
		
	}
	
	public void guardar(T entity) {
		this.repository.save(entity);
	}
	
	public void actualizar(T newUser) {
		this.repository.update(newUser);
	}

}
