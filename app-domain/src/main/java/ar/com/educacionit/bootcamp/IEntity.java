package ar.com.educacionit.bootcamp;

import java.io.Serializable;

public abstract class IEntity {
	
	protected Long id;
	
	public void setId(Long id) {
		this.id = id;
	}
	public Serializable getId() {
		return this.id;
	}

	
}
