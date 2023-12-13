package org.app.console;

import org.app.service.RoleService;
import org.app.service.ServiceLocator;
import ar.com.educacionit.bootcamp.Rol;

public class RoleMain {

	public static void main(String[] args) {
		
		RoleService service = (RoleService) ServiceLocator.getService(RoleService.class);
		//System.out.println(service.buscarPorId(1L));
		Rol newUser = service.buscarPorId(1L);
		
		//update
		newUser.setRole("juan");
		
		
		service.actualizar(newUser);
	}

}
