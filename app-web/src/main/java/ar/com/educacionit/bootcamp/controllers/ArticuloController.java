package ar.com.educacionit.bootcamp.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

import org.app.service.ArticuloService;
import org.app.service.ServiceLocator;
import org.app.service.UserService;

import ar.com.educacionit.bootcamp.Articulo;
import ar.com.educacionit.bootcamp.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/articulo")
public class ArticuloController extends HttpServlet {

	private static final long serialVersionUID = 5767005755079879117L;
	private UserService service = (UserService) ServiceLocator.getService(UserService.class);
	private ArticuloService serviceArt = (ArticuloService) ServiceLocator.getService(ArticuloService.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//permito acceder a todos los dominios
		
		
		if(req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
			Collection<User> articulos = service.buscarTodos();
			resp.getWriter().print(articulos); 
		}else {
			Long id = Long.parseLong(req.getParameter("id"));			
			User articulo = service.buscarPorId(id);
			resp.getWriter().print(articulo); 
		}
				
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("llegamos al doget de loginController");
		
		//recibir datos por request
		
		ArticuloRequestVO input = new ArticuloRequestVO(req);
		
		LocalDate fechaPublicacion = LocalDate.now();
		
		Articulo newArticulo = new Articulo(input.getEditorial(), input.getIsbn(), input.getNroPaginas(), input.getIdioma(), fechaPublicacion);
		serviceArt.guardar(newArticulo);
		
		resp.getWriter().print("articulo id " + newArticulo.getId() + " alta ok");
		
	}

	}

