package ar.com.educacionit.bootcamp;

import java.util.List;

public class User extends IEntity{

	private Long id;
	private String username;
	private String password;
	private List<Rol> roles;
	
	
	//se usa cuando el registro venga de la base
	public User(Long id, String username, String password) {
		//anticorruption layer, por si alguien modifico la base de datos con error
		if(id == null || username == null || password == null) {
			throw new IllegalArgumentException("algun campo es null");
		}
		
		this.id = id;
		this.username = username;
		this.password = password;
	}
	//cuando envie a grabar a la db
	public User( String username, String password) {
		
		if(username == null || password == null) {
			throw new IllegalArgumentException("algun campo es null");
		}
		
		this.username = username;
		this.password = password;
		
		
	}
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public void addRole(Rol role) {
		if(role == null) {
			throw new IllegalArgumentException();
		}
		this.roles.add(role);
	}
	
	public void setRoles(List<Rol> roles) {
		if(roles == null) {
			throw new IllegalArgumentException();
		}
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
