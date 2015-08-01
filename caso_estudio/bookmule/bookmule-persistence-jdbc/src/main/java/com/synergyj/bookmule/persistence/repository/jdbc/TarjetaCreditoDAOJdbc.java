/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.persistence.repository.jdbc;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.synergyj.bookmule.core.domain.TarjetaCredito;
import com.synergyj.bookmule.persistence.dao.TarjetaCreditoDAO;
import com.synergyj.bookmule.persistence.repository.jdbc.mapping.TarjetaCreditoMappingQuery;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@Repository("tarjetaCreditoDAO")
public class TarjetaCreditoDAOJdbc extends GenericJdbcDAO implements TarjetaCreditoDAO {

	@Resource(name = "tarjetaByCliente")
	private TarjetaCreditoMappingQuery tarjetaByCliente;

	@Resource(name = "tarjetaById")
	private TarjetaCreditoMappingQuery tarjetaById;

	@Resource(name = "tarjetaByNumero")
	private TarjetaCreditoMappingQuery tarjetaByNumero;

	private static final String queryCrea = "insert into tarjeta_credito (numero_tarjeta,"
			+ "mes_expiracion,anio_expiracion,numero_seguridad,cliente_id,banco_id,tipo_tarjeta_id)"
			+ " values(:numeroTarjeta,:mesExpiracion,:anioExpiracion,:numeroSeguridad,"
			+ ":clienteId,:bancoId,:tipoTarjetaId)";

	private NamedParameterJdbcTemplate namedTemplate;

	/**
	 * 
	 */
	@Override
	@Resource
	public void setJdbcDataSource(javax.sql.DataSource ds) {
		super.setJdbcDataSource(ds);
		namedTemplate = new NamedParameterJdbcTemplate(ds);
	}

	/*
	 * (non-Javadoc)
	 * @see com.synergyj.bookmule.persistence.dao.TarjetaCreditoDAO#crea(com.synergyj.bookmule.core.
	 * domain.TarjetaCredito)
	 */
	@Override
	public void crea(TarjetaCredito tarjeta, Long clienteId) {

		GeneratedKeyHolder keyHolder;
		MapSqlParameterSource params;

		keyHolder = new GeneratedKeyHolder();
		params = new MapSqlParameterSource();
		params.addValue("numeroTarjeta", tarjeta.getNumeroTarjeta());
		params.addValue("anioExpiracion", tarjeta.getAnioExpiracion());
		params.addValue("bancoId", tarjeta.getBanco().getId());
		params.addValue("mesExpiracion", tarjeta.getMesExpiracion());
		params.addValue("numeroSeguridad", tarjeta.getNumeroSeguridad());
		params.addValue("tipoTarjetaId", tarjeta.getTipoTarjeta().getId());
		params.addValue("clienteId", clienteId);
		namedTemplate.update(queryCrea, params, keyHolder);
		tarjeta.setId(keyHolder.getKey().longValue());
	}

	/*
	 * (non-Javadoc)
	 * @see com.synergyj.bookmule.persistence.dao.TarjetaCreditoDAO#buscaPorNumero(java.lang.String)
	 */
	@Override
	public TarjetaCredito buscaPorNumero(String numero) {

		return tarjetaByNumero.findObject(numero);
	}

	/*
	 * (non-Javadoc)
	 * @see com.synergyj.bookmule.persistence.dao.TarjetaCreditoDAO#buscaPorId(java.lang.Long)
	 */
	@Override
	public TarjetaCredito buscaPorId(Long id) {

		return tarjetaById.findObject(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.synergyj.bookmule.persistence.dao.TarjetaCreditoDAO#buscaPorCliente(java.lang.Long)
	 */
	@Override
	public Set<TarjetaCredito> buscaPorCliente(Long id) {

		return new HashSet<>(tarjetaByCliente.execute(id));
	}

}
