package ar.com.educacionit.bootcamp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.com.educacionit.bootcamp.IEntity;
import ar.com.educacionit.bootcamp.db.AdministradorDeConexiones;

public abstract class BaseCrud<T extends IEntity> implements BaseRepository<T> {

	private Class<T> type;
	private String table;
	
	public BaseCrud(Class<T> type, String table){
		this.type=type;
		this.table=table;
	}
	
	@Override
	public void delete(Long id){
		System.out.println("Eliminando "+ type.getName() + "por Id= "+id);
		String sql = "DELETE FROM " + this.table + " WHERE ID = ?";
		
		try(Connection conection = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statment = conection.prepareStatement(sql);
			
			statment.setLong(1,id);
			
			int res = statment.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Collection<T> findAll() {
		System.out.println("Buscando todos "+ type.getName());
		String sql = "SELECT * FROM " + this.table;
			
		
		List<T> list = new ArrayList<>();
		
		try(Connection conection = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statment = conection.prepareStatement(sql);						
			ResultSet resultSet = statment.executeQuery();
			
			while(resultSet.next()){
				
				list.add(this.fromResultSetToEntity(resultSet));				
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		  return list;
	}
	
	@Override
	public T getById(Long id) {
		
		System.out.println("Buscando"+ type.getName() + "por Id= "+id);
		String sql = "SELECT * FROM " + this.table + " WHERE ID = " + id;
		
		
		T entity = null;
		
		//jdbc para poder consultar a la table via java
		
		try(Connection conection = AdministradorDeConexiones.getConnection()) {
			//armar el sql
			PreparedStatement statment = conection.prepareStatement(sql);
			
			//recibir los datos
			ResultSet resultSet = statment.executeQuery();
			
			
			//procesar los registros
			if(resultSet.next()){//hay registros que mirar
				//extraigo los datos
				
				entity = this.fromResultSetToEntity(resultSet);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return entity;
	}
	
	//cada repositoryImpl debe implementar como extrae la data desde ResultSet
	protected abstract T fromResultSetToEntity(ResultSet res) throws SQLException;
	
	
	@Override
	public void save(T entidad) {
		System.out.println("Grabando "+ type.getName() + entidad);
		String sql = "INSERT INTO " + this.table + this.getSaveSQL();
		
		try(Connection conection = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statment = conection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);	
			System.out.println(statment);
			saveEntity(entidad, statment);
			
			statment.executeUpdate();
			
			ResultSet resKey = statment.getGeneratedKeys();
			if (resKey.next()) {
				entidad.setId(resKey.getLong(1));
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

	protected abstract String getSaveSQL();
	protected abstract void saveEntity(T entidad,PreparedStatement pst) throws SQLException;
	
	@Override
	public void update(T entidad) {
		System.out.println("Actualizando "+ type.getName() + entidad);
		String sql = "update " + this.table + " set " + getUpdateSQL() + "where id = ?";
		
		try(Connection conection = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statment = conection.prepareStatement(sql);	
			
			setUpdateSQL(entidad, statment);
			
			statment.setLong(getLast(sql),(Long)entidad.getId());
			
			statment.executeUpdate();

		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
		public int getLast(String sql) {
			
			int idx = 0;
			for(char c : sql.toCharArray()) {
				if(c == '?') {
					idx++;
				}
			}
			return idx;
		}
		
	

	protected abstract String getUpdateSQL();
	protected abstract void setUpdateSQL(T entity,PreparedStatement pst) throws SQLException;
	
	public List<T> findBySQL(String sql) {
		
		
		List<T> list = new ArrayList<>();
		
		try(Connection conection = AdministradorDeConexiones.getConnection()) {
			
			PreparedStatement statment = conection.prepareStatement(sql);						
			ResultSet resultSet = statment.executeQuery();
			
			while(resultSet.next()){
				
				list.add(this.fromResultSetToEntity(resultSet));				
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		  return list;
	}
	public T fromSQLResultSetToEntity(ResultSet res) throws SQLException{
		
		return null;
	}
	
}
