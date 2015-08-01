/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.persistence.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.synergyj.bookmule.core.domain.Autor;
import com.synergyj.bookmule.persistence.dao.AutorDAO;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@Repository("autorDAO")
public class AutorDAOJdbc extends GenericJdbcDAO implements AutorDAO {

	private static final String queryCreaAutor = "insert into autor "
			+ "(nombre,apellido_paterno,apellido_materno) values "
			+ "(:nombre,:apellidoPaterno,:apellidoMaterno)";

	private static final String queryBuscaAutorPrefix = "select autor_id,nombre,apellido_paterno,"
			+ "apellido_materno from autor where ";

	private static final String queryNombre = " nombre like :nombre ";

	private static final String queryApPat = " apellido_paterno like :ap_pat ";

	private static final String queryApMat = " apellido_materno like :ap_mat";

	private static final String queryId = " autor_id = :id";

	private static final String queryAnd = " and ";

	private NamedParameterJdbcTemplate namedTemplate;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.synergyj.bookmule.persistence.repository.jdbc.GenericJdbcDAO#setJdbcDataSource(javax.sql.
	 * DataSource)
	 */
	@Override
	@Resource
	public void setJdbcDataSource(DataSource ds) {
		super.setJdbcDataSource(ds);
		// TODO A) Inicializar namedTemplate. Observar que este objeto podría instanciarse en la
		// clase base en caso que se use con alta frecuencia.

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.synergyj.bookmule.persistence.dao.AutorDAO#crea(com.synergyj.bookmule.core.domain.Autor)
	 */
	@Override
	public void crea(Autor autor) {
		int rows = 0;
		GeneratedKeyHolder keyHolder;
		SqlParameterSource params;

		keyHolder = new GeneratedKeyHolder();

		// Ejemplo de un BeanPropertySqlParameterSource, los nombres de los parámetros deben
		// coincidir con los nombres atributos del objeto.
		// TODO B) Completar este método empleando BeanPropertySqlParameterSource

		if (rows != 1) {
			throw new IncorrectResultSizeDataAccessException(queryCreaAutor, 1, rows);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.synergyj.bookmule.persistence.dao.AutorDAO#busca(com.synergyj.bookmule.core.domain.Autor)
	 */
	@Override
	public Set<Autor> busca(Autor autor) {
		List<String> condiciones;
		StringBuilder sb;
		List<Autor> autorList = null;
		MapSqlParameterSource params = null;
		int size;

		condiciones = new ArrayList<>();
		// C) TODO ejemplo de MapSqlParameterSource, empleado para especificar los nombres de los
		// parametros cuando no coinciden con los del bean. Inicializar la variable params.

		if (autor.getId() != null) {
			condiciones.add(queryId);
			params.addValue("id", autor.getId());
		}
		if (autor.getNombre() != null) {
			condiciones.add(queryNombre);
			params.addValue("nombre", "%" + autor.getNombre() + "%");
		}
		if (autor.getApellidoPaterno() != null) {
			condiciones.add(queryApPat);
			params.addValue("ap_pat", "%" + autor.getApellidoPaterno() + "%");
		}
		if (autor.getApellidoMaterno() != null) {
			condiciones.add(queryApMat);
			params.addValue("ap_mat", "%" + autor.getApellidoMaterno() + "%");
		}
		sb = new StringBuilder(queryBuscaAutorPrefix);
		size = condiciones.size();
		if (condiciones.size() < 1) {
			throw new IllegalArgumentException("Se requieren al menos un criterio"
					+ " para realizar una busqueda generica de autores");
		}
		for (int i = 0; i < size; i++) {
			sb.append(condiciones.get(i));
			if (i < size - 1) {
				sb.append(queryAnd);
			}
		}

		// TODO D) invocar el método query de namedTemplate para lanzar la búsqueda

		return new HashSet<>(autorList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.synergyj.bookmule.persistence.dao.AutorDAO#findAutorById(java.lang.Long)
	 */
	@Override
	public Autor findAutorById(Long id) {

		return namedTemplate.queryForObject(queryBuscaAutorPrefix + queryId,
				new MapSqlParameterSource("id", id), new AutorRowMapper());
	}

	private final class AutorRowMapper implements RowMapper<Autor> {

		/*
		 * (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		@Override
		public Autor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Autor autor = new Autor();
			int index = 0;
			autor.setId(rs.getLong(++index));
			autor.setNombre(rs.getString(++index));
			autor.setApellidoPaterno(rs.getString(++index));
			autor.setApellidoMaterno(rs.getString(++index));
			return autor;
		}

	}

}
