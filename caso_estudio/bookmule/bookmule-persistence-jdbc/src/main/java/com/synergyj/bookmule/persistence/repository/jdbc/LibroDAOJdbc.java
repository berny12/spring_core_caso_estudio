/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.persistence.repository.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.synergyj.bookmule.core.domain.Editorial;
import com.synergyj.bookmule.core.domain.Libro;
import com.synergyj.bookmule.core.domain.beans.CriterioBusquedaLibro;
import com.synergyj.bookmule.core.domain.catalog.StatusLibro;
import com.synergyj.bookmule.persistence.dao.LibroDAO;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@Repository("libroDAO")
// inyeccion de datasource de forma automatica cuando extiende de genericdao
public class LibroDAOJdbc extends GenericJdbcDAO implements LibroDAO {

	// todas las sentencias sql debe estar delcaradas como variables estaticas
	// privads para una rapida revision
	private static final String queryCreaLibro = "insert into libro (titulo,edicion,isbn,codigo_color,"
			+ "codigo_clasificacion,numero_ejemplares,precio_venta,editorial_id,status_libro_id)"
			+ " values(?,?,?,?,?,?,?,?,?)";

	private static final String queryBuscaLibrosPrefix = "select libro_id,titulo,edicion,isbn,"
			+ "codigo_color,codigo_clasificacion,numero_ejemplares,precio_venta,editorial_id,"
			+ "status_libro_id from libro  where ";

	private static final String queryAnd = " and ";

	private static final String queryLibroId = " libro_id = ? ";

	private static final String queryTitulo = " lower(titulo) like ? ";

	private static final String queryEdicion = " edicion = ? ";

	private static final String queryIsbn = " isbn like ? ";

	private static final String queryCodigoColor = " codigo_color = ? ";

	private static final String queryCodigoClasificacion = " codigo_clasificacion like ? ";

	private static final String queryEditorial = " editorial_id = ? ";

	private static final String queryPrecioVenta = " precio_venta = ? ";

	private static final String queryPrecioVentaRangoInicial = " precio_venta >= ? ";

	private static final String queryPrecioVentaRangoFinal = " precio_venta <= ? ";

	private static final int min_condiciones = 3;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.persistence.dao.LibroDAO#crea(com.synergyj.bookmule
	 * .core.domain.Libro)
	 */
	@Override
	public void crea(final Libro libro) {
		int rows;
		GeneratedKeyHolder keyHolder;

		keyHolder = new GeneratedKeyHolder();

		rows = getJdbcTemplate().update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// aqui debemos indicar que se asigne la PK al objeto
				// GeneratedKeyHolder que se pasa
				// como segundo parametro.
				PreparedStatement ps;
				int index = 0;
				ps = con.prepareStatement(queryCreaLibro,
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(++index, libro.getTitulo());
				ps.setInt(++index, libro.getEdicion());
				ps.setString(++index, libro.getIsbn());
				ps.setString(++index, libro.getCodigoColor());
				ps.setString(++index, libro.getCodigoClasificacion());
				ps.setInt(++index, libro.getNumeroEjemplares());
				ps.setFloat(++index, libro.getPrecioVenta());
				ps.setLong(++index, libro.getEditorial().getId());
				ps.setInt(++index, libro.getStatusLibro().getId());
				return ps;
			}
		}, keyHolder);
		libro.setId(keyHolder.getKey().longValue());
		// para los daos que afectan los o insertan en base de datos , se
		// validen el enumero de registroa aemplear
		if (rows != 1) {
			throw new IncorrectResultSizeDataAccessException(queryCreaLibro, 1,
					rows);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.persistence.dao.LibroDAO#busca(com.synergyj.bookmule
	 * .core.domain.Libro)
	 */
	@Override
	public Set<Libro> busca(CriterioBusquedaLibro libro) {
		List<Object> values;
		Object[] valuesArray;
		List<String> condiciones;
		StringBuilder sb;
		List<Libro> libroList;
		int size;

		values = new ArrayList<>();
		condiciones = new ArrayList<String>();

		if (libro.getId() != null) {
			condiciones.add(queryLibroId);
			values.add(libro.getId());
		}
		if (libro.getCodigoClasificacion() != null) {
			condiciones.add(queryCodigoClasificacion);
			values.add("%" + libro.getCodigoClasificacion() + "%");
		}
		if (libro.getCodigoColor() != null) {
			condiciones.add(queryCodigoColor);
			values.add(libro.getCodigoColor());
		}
		if (libro.getEdicion() != null) {
			condiciones.add(queryEdicion);
			values.add(libro.getEdicion());
		}
		if (libro.getEditorial() != null) {
			condiciones.add(queryEditorial);
			values.add(libro.getEditorial().getId());
		}
		if (libro.getIsbn() != null) {
			condiciones.add(queryIsbn);
			values.add("%" + libro.getIsbn() + "%");
		}
		if (libro.getTitulo() != null) {
			condiciones.add(queryTitulo);
			values.add("%" + libro.getTitulo().toLowerCase() + "%");
		}
		if (libro.getPrecioVenta() != null) {
			condiciones.add(queryPrecioVenta);
			values.add(libro.getPrecioVenta());
		}
		if (libro.getPrecioInicial() != null) {
			condiciones.add(queryPrecioVentaRangoInicial);
			values.add(libro.getPrecioInicial());
		}
		if (libro.getPrecioFinal() != null) {
			condiciones.add(queryPrecioVentaRangoFinal);
			values.add(libro.getPrecioFinal());
		}

		if (condiciones.size() < min_condiciones) {
			throw new IllegalArgumentException("Se requieren al menos "
					+ min_condiciones
					+ " para realizar una busqueda generica de libros");
		}
		sb = new StringBuilder(queryBuscaLibrosPrefix);
		size = condiciones.size();
		for (int i = 0; i < size; i++) {
			sb.append(condiciones.get(i));
			if (i < size - 1) {
				sb.append(queryAnd);
			}
		}
		valuesArray = new Object[condiciones.size()];
		values.toArray(valuesArray);
		libroList = getJdbcTemplate().query(sb.toString(), valuesArray,
				new LibroRowMapper());
		return new HashSet<Libro>(libroList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.persistence.dao.LibroDAO#findById(java.lang.Long)
	 */
	@Override
	public Libro findById(Long id) {
		// TODO A) Implementar este método
		return getJdbcTemplate()
				.queryForObject(queryBuscaLibrosPrefix + queryLibroId,
						new LibroRowMapper(), id);
	}
}

/**
 * RowMapper para un Libro.
 * 
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
final class LibroRowMapper implements RowMapper<Libro> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Libro libro;
		int index = 0;
		Editorial editorial;

		libro = new Libro();
		libro.setId(rs.getLong(++index));
		libro.setTitulo(rs.getString(++index));
		libro.setEdicion(rs.getInt(++index));
		libro.setIsbn(rs.getString(++index));
		libro.setCodigoColor(rs.getString(++index));
		libro.setCodigoClasificacion(rs.getString(++index));
		libro.setNumeroEjemplares(rs.getInt(++index));
		libro.setPrecioVenta(rs.getFloat(++index));
		editorial = new Editorial();
		editorial.setId(rs.getLong(++index));
		libro.setEditorial(editorial);
		libro.setStatusLibro(StatusLibro.valueOf(rs.getInt(++index)));
		return libro;
	}

}
