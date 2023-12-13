package ar.com.educacionit.bootcamp.controllers;

import java.io.IOException;

import org.app.service.ArticuloService;
import org.app.service.ServiceLocator;

import ar.com.educacionit.bootcamp.exporters.IExport;
import ar.com.educacionit.bootcamp.exporters.PDFExporter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/api/articulo/export")
public class ExportController extends HttpServlet {


	private static final long serialVersionUID = -5973059335540196110L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String ext = req.getParameter("EXPORT_TYPE");
		
		
		IExport export = null;
		
		if(ext.equals("PDF")) {
			export = new PDFExporter();
		}
		export.setPath(getServletContext().getResource("/reports/listado_articulos.jasper"));
		
		ArticuloService list = (ArticuloService) ServiceLocator.getService(ArticuloService.class);
		
		export.export(list.buscarTodos());

	}
}
