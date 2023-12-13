package ar.com.educacionit.bootcamp.controllers;

import java.io.IOException;
import java.io.InputStream;

import org.app.service.ArticuloService;
import org.app.service.ServiceLocator;

import ar.com.educacionit.bootcamp.Articulo;
import ar.com.educacionit.bootcamp.controllers.parsers.CSVArticuloFileParser;
import ar.com.educacionit.bootcamp.controllers.parsers.IParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/api/articulo/upload")
@MultipartConfig

public class UploadController extends HttpServlet {

	private static final long serialVersionUID = 5978527756194115502L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Part filePart = req.getPart("file");
		
		String fileName = filePart.getSubmittedFileName();
		
		//Long size = filePart.getSize();
		
		IParser parser = ParserBuilder.buildParser(fileName);
		
		InputStream is = filePart.getInputStream();
		
		var nuevosRegistros = parser.parse(is);
		
		//ahora podria cargarlos en la db	
		System.out.println(nuevosRegistros);
		/*
		ArticuloService service = (ArticuloService) ServiceLocator.getService(ArticuloService.class);
		for (Articulo articulo : nuevosRegistros) {
			service.guardar(articulo);
		}*/
	}
}
