package org.app.console;

import java.time.LocalDate;

import org.app.service.ArticuloService;
import org.app.service.ServiceLocator;

import ar.com.educacionit.bootcamp.Articulo;

public class ArticuloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArticuloService service = (ArticuloService) ServiceLocator.getService(ArticuloService.class);
		
		Articulo entity = new Articulo(1l, 1234L, 472, "español", LocalDate.of(2023,9,1));
		service.guardar(entity);
	}

}
