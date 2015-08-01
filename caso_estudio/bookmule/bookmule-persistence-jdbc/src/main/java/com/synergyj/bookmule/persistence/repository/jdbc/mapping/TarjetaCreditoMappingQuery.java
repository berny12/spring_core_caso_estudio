/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.persistence.repository.jdbc.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.synergyj.bookmule.core.domain.Banco;
import com.synergyj.bookmule.core.domain.TarjetaCredito;
import com.synergyj.bookmule.core.domain.catalog.TipoTarjeta;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */

public class TarjetaCreditoMappingQuery extends MappingSqlQuery<TarjetaCredito> {

	private static final String queryTarjetaPrefix = "select tarjeta_credito_id,numero_tarjeta,"
			+ "mes_expiracion,anio_expiracion,numero_seguridad,banco_id,tipo_tarjeta_id"
			+ " from tarjeta_credito where ";

	public static final int BY_ID = 1;

	public static final int BY_NUMERO = 2;

	public static final int BY_CLIENTE = 3;

	private static final String queryNumTarjeta = " numero_tarjeta = ? ";

	private static final String queryTarjetaId = " tarjeta_credito_id = ?";

	private static final String queryCliente = " cliente_id = ?";

	public TarjetaCreditoMappingQuery(DataSource ds, int tipoConsulta) {
		StringBuilder sb;
		sb = new StringBuilder(queryTarjetaPrefix);
		setDataSource(ds);
		switch (tipoConsulta) {
		case BY_ID:
			sb.append(queryTarjetaId);
			declareParameter(new SqlParameter(Types.NUMERIC));
			break;
		case BY_NUMERO:
			sb.append(queryNumTarjeta);
			declareParameter(new SqlParameter(Types.VARCHAR));
			break;
		case BY_CLIENTE:
			sb.append(queryCliente);
			declareParameter(new SqlParameter(Types.NUMERIC));
			break;

		default:
			throw new IllegalArgumentException("Tipo de usqueda invalido :" + tipoConsulta);
		}
		setSql(sb.toString());
		compile();
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.jdbc.object.MappingSqlQuery#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	protected TarjetaCredito mapRow(ResultSet rs, int rowNum) throws SQLException {
		TarjetaCredito tarjeta;
		Banco banco;
		tarjeta = new TarjetaCredito();

		int index = 0;
		tarjeta.setId(rs.getLong(++index));
		tarjeta.setNumeroTarjeta(rs.getString(++index));
		tarjeta.setMesExpiracion(rs.getInt(++index));
		tarjeta.setAnioExpiracion(rs.getInt(++index));
		tarjeta.setNumeroSeguridad(rs.getInt(++index));
		banco = new Banco();
		banco.setId(rs.getLong(++index));
		tarjeta.setBanco(banco);
		tarjeta.setTipoTarjeta(TipoTarjeta.valueOf(rs.getInt(++index)));

		return tarjeta;
	}

}
