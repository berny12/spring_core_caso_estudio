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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.synergyj.bookmule.core.domain.Proveedor;
import com.synergyj.bookmule.persistence.dao.ProveedorDAO;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@Repository("proveedorDAO")
public class ProveedorDAOJdbc extends GenericJdbcDAO implements ProveedorDAO {

	private static final String queryBuscaProveedorPrefix = " select proveedor_id,nombre,direccion,"
			+ "url_pedidos from proveedor where ";

	private static final String queryNombre = " nombre like :nombre";

	private static final String queryDireccion = " direccion like :direccion ";

	private static final String queryUrl = " url_pedidos like :urlPedidos ";

	private static final String queryId = " proveedor_id = :id";

	private static final String queryAnd = " and ";

	// este objeto va realizar el insert de los objetos
	private SimpleJdbcInsert simpleJdbcInsert;

	private NamedParameterJdbcTemplate namedTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synergyj.bookmule.persistence.repository.jdbc.GenericJdbcDAO#
	 * setJdbcDataSource(javax.sql. DataSource)
	 */
	@Resource
	@Override
	public void setJdbcDataSource(DataSource ds) {
		super.setJdbcDataSource(ds);
		namedTemplate = new NamedParameterJdbcTemplate(getDataSource());
		// TODO E) instanciar a simpleJdbcInsert, especificar la tabla y el
		// campo autoincrementable.
		simpleJdbcInsert = new SimpleJdbcInsert(ds);
		// se le especifica la columna que son llaves
		simpleJdbcInsert.withTableName("proveedor").usingGeneratedKeyColumns(
				"proveedor_id");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.persistence.dao.ProveedorDAO#crea(com.synergyj.
	 * bookmule.core.domain. Proveedor)
	 */
	@Override
	public void crea(Proveedor proveedor) {
		Map<String, Object> params;
		Number id = null;
		params = new HashMap<>(5);
		params.put("nombre", proveedor.getNombre());
		params.put("direccion", proveedor.getDireccion());
		params.put("url_pedidos", proveedor.getUrlPedidos());

		// params puede ser también un SqlParameterSource
		// TODO F) invocar al método executeAndReturnKey para realizar la
		// insercion.
		id = simpleJdbcInsert.executeAndReturnKey(params);
		proveedor.setId(id.longValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.persistence.dao.ProveedorDAO#busca(com.synergyj
	 * .bookmule.core.domain. Proveedor)
	 */
	@Override
	public Set<Proveedor> busca(Proveedor proveedor) {
		List<String> condiciones;
		MapSqlParameterSource params;
		StringBuilder query;
		int size;

		condiciones = new ArrayList<>();
		params = new MapSqlParameterSource();
		if (proveedor.getId() != null) {
			condiciones.add(queryId);
			params.addValue("id", proveedor.getId());
		}
		if (proveedor.getNombre() != null) {
			condiciones.add(queryNombre);
			params.addValue("nombre", "%" + proveedor.getNombre() + "%");
		}
		if (proveedor.getDireccion() != null) {
			condiciones.add(queryDireccion);
			params.addValue("direccion", "%" + proveedor.getDireccion() + "%");
		}
		if (proveedor.getUrlPedidos() != null) {
			condiciones.add(queryUrl);
			params.addValue("urlPedidos", "%" + proveedor.getUrlPedidos() + "%");
		}
		size = condiciones.size();
		query = new StringBuilder(queryBuscaProveedorPrefix);
		for (int i = 0; i < size; i++) {
			query.append(condiciones.get(i));
			if (i < size - 1) {
				query.append(queryAnd);
			}
		}
		return new HashSet<>(namedTemplate.query(query.toString(), params,
				new ProveedorRowMapper()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.persistence.dao.ProveedorDAO#findById(java.lang
	 * .Long)
	 */
	@Override
	public Proveedor findById(Long id) {

		return namedTemplate.queryForObject(
				queryBuscaProveedorPrefix + queryId, new MapSqlParameterSource(
						"id", id), new ProveedorRowMapper());
	}

	private static final class ProveedorRowMapper implements
			RowMapper<Proveedor> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
		 * int)
		 */
		@Override
		public Proveedor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Proveedor proveedor;
			int index = 0;
			proveedor = new Proveedor();
			proveedor.setId(rs.getLong(++index));
			proveedor.setNombre(rs.getString(++index));
			proveedor.setDireccion(rs.getString(++index));
			proveedor.setUrlPedidos(rs.getString(++index));
			return proveedor;
		}

	}
}
