package ar.com.educacionit.bootcamp.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.bootcamp.Rol;
import ar.com.educacionit.bootcamp.User;

public class UserRepositoryImpl extends BaseCrud<User> implements UserRepository {

	public UserRepositoryImpl() {
		super(User.class, "user");
		
	}

	@Override
	protected User fromResultSetToEntity(ResultSet resultSet) throws SQLException {

		Long id =resultSet.getLong(1);
		String username =resultSet.getString(2);
		String password =resultSet.getString(3);
		
		return new User(id,username,password);
	}

	@Override
	protected String getSaveSQL() {
		
		return "(username,password) values(?,?)";
	}

	@Override
	protected void saveEntity(User entidad, PreparedStatement pst) throws SQLException {
		pst.setString(1, entidad.getUsername());
		pst.setString(2, entidad.getPassword());
		
	}

	@Override
	protected String getUpdateSQL() {
		
		return "username = ?, password = ?";
	}

	@Override
	protected void setUpdateSQL(User entity, PreparedStatement pst) throws SQLException {
		pst.setString(1, entity.getUsername());
		pst.setString(2, entity.getPassword());
	
		
	}

	

	
}
