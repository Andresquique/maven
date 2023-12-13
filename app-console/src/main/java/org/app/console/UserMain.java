package org.app.console;

import org.app.service.ServiceLocator;
import org.app.service.UserService;

import ar.com.educacionit.bootcamp.User;

public class UserMain {

	public static void main(String[] args) {
		// buscar todas las entidades
		//UserService service = new UserServiceImpl();
		//var todos = service.buscarTodos();
		//System.out.println(todos);
		
		UserService service = (UserService) ServiceLocator.getService(UserService.class);
		//System.out.println(service.buscarPorId(1L));
		User user = service.buscarPorId(1L);
		System.out.println(user);
		/*
		//save
		User newUser = new User("PEPE","PEPE1234");
		service.guardar(newUser);
		System.out.println(newUser.getId());
		
		//eliminar		
		User user6 = service.buscarPorId(6L);
		service.eliminarPorId(6L);
		
		//update
		newUser.setUsername("juan");
		newUser.setPassword("1234");
		
		service.actualizar(newUser);*/
	}

}
