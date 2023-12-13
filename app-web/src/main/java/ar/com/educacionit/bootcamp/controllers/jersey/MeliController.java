package ar.com.educacionit.bootcamp.controllers.jersey;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.bootcamp.connectors.meli.MeliCategoriaService;
import ar.com.educacionit.bootcamp.connectors.meli.MeliCategoriaServiceImpl;
import ar.com.educacionit.bootcamp.connectors.meli.dto.Categoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/meli/categoria")

public class MeliController extends HttpServlet{

	private static final long serialVersionUID = -612164317061697532L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MeliCategoriaService serviceRest = new MeliCategoriaServiceImpl(
				"https://api.mercadolibre.com");
		

		
		List<Categoria> categorias = serviceRest.findCategorias();
		Categoria categoria = serviceRest.getCategoria("MLA3530");		
		ObjectMapper mapper = new ObjectMapper();

		String jsonList = mapper.writeValueAsString(categorias);

		System.out.println(jsonList);
		
		resp.getWriter().print(jsonList);
		
	}
	
}
