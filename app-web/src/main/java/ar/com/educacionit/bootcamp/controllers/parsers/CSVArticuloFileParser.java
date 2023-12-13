package ar.com.educacionit.bootcamp.controllers.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.bootcamp.Articulo;

public class CSVArticuloFileParser implements IParser {

	@Override
	public Collection<Articulo> parse(InputStream is) {
		
		var registros = new ArrayList<Articulo>();
		
		try(InputStreamReader isr = new InputStreamReader(is)) {

			BufferedReader br = new BufferedReader(isr);
			
			//leer
			
			String line = br.readLine();
			if(line == null || line.length() == 0) {
				throw new IllegalArgumentException();
				}
			
			while ((line = br.readLine()) != null){
				registros.add(parseLine(line));
			}
		}catch (Exception e) {


		}
		return registros;
	}
	
	private Articulo parseLine(String line) {
		String[] values = line.split(";");
		Long editorialId = Long.parseLong(values[0]);
		Long isbn = Long.parseLong(values[1]);
		Integer paginas = Integer.parseInt(values[2]);
		String idioma = values[3].toUpperCase();
		LocalDate fechaPublicacion = LocalDate.parse(values[4]);
		
		return new Articulo(editorialId, isbn, paginas, idioma, fechaPublicacion);
				
		
	}
}
