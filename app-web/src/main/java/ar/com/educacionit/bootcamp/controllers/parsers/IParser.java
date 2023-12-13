package ar.com.educacionit.bootcamp.controllers.parsers;

import java.io.InputStream;
import java.util.Collection;

import ar.com.educacionit.bootcamp.Articulo;

public interface IParser {

	public Collection<Articulo> parse(InputStream is);
}
