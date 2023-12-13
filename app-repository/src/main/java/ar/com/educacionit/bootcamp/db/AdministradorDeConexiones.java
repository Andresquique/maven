package ar.com.educacionit.bootcamp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {

	public static Connection getConnection() {
		String usernameDb = "root";
		String passwordDb = "Magodeoz1";
		String url = "jdbc:mysql://127.0.0.1:3306/educacionit-bootcamp-vicente-lopez?serverTimeZone=UTC&useSSL=false";
		String driverClassName = "com.mysql.cj.jdbc.Driver";//mysql,postgress,oracle
		
		try {
			//carga dinamicamente el diver en la jvm
			Class.forName(driverClassName);
			
			return DriverManager.getConnection(url,usernameDb,passwordDb);			
		} catch (Exception e) {
		
			throw new IllegalArgumentException("No se pudo obtener coneccion para "+ url +" - " + driverClassName);
		}
		
	}	
}
