package ar.com.educacionit.bootcamp.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import ar.com.educacionit.bootcamp.Articulo;

public class ArticuloRepositoryImpl extends BaseCrud<Articulo> implements ArticuloRepository {

	public ArticuloRepositoryImpl() {
		super(Articulo.class, "articulo");

	}

	@Override
	protected Articulo fromResultSetToEntity(ResultSet res) throws SQLException {
		Long id = res.getLong(1);
		Long editorial_id = res.getLong(2);
		Long isbn = res.getLong(3);
		Integer paginas = res.getInt(4);
		String idioma = res.getString(5);
		LocalDate fechaPublicacion = res.getDate(6).toLocalDate();
		return new Articulo(id,editorial_id, isbn, paginas, idioma, fechaPublicacion);
	}
	@Override
	protected String getSaveSQL() {
		
		return "(editorial_id,isbn,nro_paginas,idioma,fecha_publicacion) values (?,?,?,?,?)";
	}

	@Override
	protected void saveEntity(Articulo entidad, PreparedStatement pst) throws SQLException {
		pst.setLong(1, entidad.getEditorial());
		pst.setLong(2, entidad.getIsbn());
		pst.setLong(3, entidad.getNroPaginas());
		pst.setString(4, entidad.getIdioma());
		Instant i = entidad.getFechaPublicacion().atStartOfDay(ZoneId.systemDefault()).toInstant();
		pst.setDate(5, new java.sql.Date(Date.from(i).getTime()));
		
	}

	@Override
	protected String getUpdateSQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setUpdateSQL(Articulo entity, PreparedStatement pst) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
