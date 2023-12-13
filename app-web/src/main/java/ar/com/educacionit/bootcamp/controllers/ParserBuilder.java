package ar.com.educacionit.bootcamp.controllers;

import ar.com.educacionit.bootcamp.controllers.parsers.CSVArticuloFileParser;
import ar.com.educacionit.bootcamp.controllers.parsers.IParser;

public class ParserBuilder {

	public static IParser buildParser(String fileName) {
		switch (getExt(fileName)) {
		case "CSV": {
			
			return new CSVArticuloFileParser();
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + fileName);
		}
	}

	public static String getExt(String fileName) {
		String[] aux = fileName.split("\\.");
		return aux[aux.length-1].toUpperCase();
	}
}
