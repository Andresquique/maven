package ar.com.educacionit.bootcamp;

public class Rol extends IEntity {

	private Long id;
	private String role;
	
	public Rol(Long id, String role) {
		if(id == null || role == null) {
			throw new IllegalArgumentException("algun campo es null");
		}
		this.id = id;
		this.role = role;
	}
	
	public Rol(String role) {
		if(role == null) {
			throw new IllegalArgumentException("algun campo es null");
		}
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public String getrole() {
		return role;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", role=" + role + "]";
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
