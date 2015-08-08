/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.persistence.repository.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.synergyj.bookmule.core.domain.ImagenLibro;
import com.synergyj.bookmule.persistence.dao.ImagenLibroDAO;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@Repository("imagenLibroDAO")
public class ImagenLibroDAOJdbc extends GenericJdbcDAO implements
		ImagenLibroDAO {

	private static final String queryCrea = "insert into imagen_libro (num_imagen,imagen,libro_id) "
			+ " values(?,?,?)";

	private static final String queryBusca = "select imagen_libro_id,num_imagen,imagen from "
			+ "imagen_libro where libro_id = ?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.persistence.dao.ImagenLibro#crea(com.synergyj.bookmule
	 * .persistence.dao. ImagenLibro)
	 */
	@Override
	// para java 7, en java 8 ya no lo lleva
	// public void crea( ImagenLibro imagen, Long libroId) {
	public void crea(final ImagenLibro imagen, final Long libroId) {

		int rows = 0;
		// se instancia el lobhandler
		LobHandler lobHandler;
		lobHandler = new DefaultLobHandler();

		// TODO A) Completar este método
		rows = getJdbcTemplate().execute(queryCrea,
				new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

					@Override
					protected void setValues(PreparedStatement ps,
							LobCreator lobCreator) throws SQLException,
							DataAccessException {
						// TODO inicializar el preperadstetment
						int index = 0;
						ps.setInt(++index, imagen.getNumImagen());
						lobCreator.setBlobAsBytes(ps, ++index,
								imagen.getImagen());
						ps.setLong(++index, libroId);

					}

				});

		if (rows != 1) {
			throw new IncorrectResultSizeDataAccessException(queryCrea, 1, rows);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.persistence.dao.ImagenLibro#busca(java.lang.Long)
	 */
	@Override
	public Set<ImagenLibro> busca(Long libroId) {

		// para java 7 tiene que llevar final, para java 8 no
		// LobHandler lobHandler;
		final LobHandler lobHandler;
		List<ImagenLibro> imagenes = null;

		// TODO B) Completar este método
		lobHandler = new DefaultLobHandler();
		imagenes = getJdbcTemplate().query(queryBusca,
				new RowMapper<ImagenLibro>() {

					@Override
					public ImagenLibro mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						// TODO implementamos
						int index = 0;
						ImagenLibro imagen;
						imagen = new ImagenLibro();
						imagen.setId(rs.getLong(++index));
						imagen.setNumImagen(rs.getInt(++index));
						imagen.setImagen(lobHandler.getBlobAsBytes(rs, ++index));
						return imagen;
					}

				}, libroId);

		return new HashSet<>(imagenes);
	}

}
