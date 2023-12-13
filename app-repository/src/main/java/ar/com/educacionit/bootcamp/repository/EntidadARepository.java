package ar.com.educacionit.bootcamp.repository;

import java.util.Collection;

import ar.com.educacionit.bootcamp.EntidadA;

public interface EntidadARepository extends BaseRepository<EntidadA>{

	
	public Collection<EntidadA> findByAtributoX();
}
