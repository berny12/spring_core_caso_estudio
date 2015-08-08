/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.persistence.tests;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.synergyj.bookmule.core.domain.Banco;
import com.synergyj.bookmule.core.domain.TarjetaCredito;
import com.synergyj.bookmule.core.domain.catalog.TipoCliente;
import com.synergyj.bookmule.core.domain.catalog.TipoTarjeta;
import com.synergyj.bookmule.persistence.dao.TarjetaCreditoDAO;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbcAppContext.xml")
public class TarjetaCreditoDAOTestCase extends
		AbstractTransactionalJUnit4SpringContextTests {
	@Resource
	TarjetaCreditoDAO tarjetaCreditoDAO;

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ProveedorDAOTestCase.class);

	@Test
	public void creaYbuscaTarjeta() {

		TarjetaCredito tarjeta, otraTarjeta;
		Long clienteId;
		Set<TarjetaCredito> tarjetaList;

		tarjeta = creaTarjetaFicticia();
		clienteId = creaClienteFicticio();
		tarjetaCreditoDAO.crea(tarjeta, clienteId);

		logger.debug("tarjeta creada {}", tarjeta);
		Assert.assertNotNull(tarjeta.getId());

		logger.debug("buscando por cliente:");
		tarjetaList = tarjetaCreditoDAO.buscaPorCliente(clienteId);
		Assert.assertTrue(tarjetaList.size() == 1);
		BeanPropertiesComparator.compare(tarjeta,
				tarjetaList.iterator().next(), "id", "numeroTarjeta",
				"mesExpiracion", "anioExpiracion", "numeroSeguridad",
				"banco.id", "tipoTarjeta.id");

		logger.debug("buscando por id");
		otraTarjeta = tarjetaCreditoDAO.buscaPorId(tarjeta.getId());
		BeanPropertiesComparator.compare(tarjeta, otraTarjeta, "id",
				"numeroTarjeta", "mesExpiracion", "anioExpiracion",
				"numeroSeguridad", "banco.id", "tipoTarjeta.id");

		// TODO B) Agregar la busqueda por número de tarjeta y su
		// correspondiente assert.
		logger.debug(" buscando por numero de tarjeta");
		otraTarjeta = tarjetaCreditoDAO.buscaPorNumero(tarjeta
				.getNumeroTarjeta());
		BeanPropertiesComparator.compare(tarjeta, otraTarjeta, "id",
				"numeroTarjeta", "mesExpiracion", "anioExpiracion",
				"numeroSeguridad", "banco.id", "tipoTarjeta.id");

	}

	/**
	 * 
	 */
	@Test
	public void buscaTarjetaInexistente() {

		TarjetaCredito tarjeta = tarjetaCreditoDAO.buscaPorNumero("XXX");
		// TODO C) Observar que para un MappingSQLQuery el método findObject
		// regresa null si no
		// existe el objeto. Comprobarlo con un assert.
		// en jdbctemplate tenmos exception, en mapping tenemos null
		Assert.assertNull(tarjeta);
	}

	/**
	 * @return
	 */
	private TarjetaCredito creaTarjetaFicticia() {
		TarjetaCredito tarjeta;
		Banco banco;
		tarjeta = new TarjetaCredito();
		tarjeta.setAnioExpiracion(2015);
		banco = new Banco();
		banco.setId(jdbcTemplate.queryForObject(
				"select min(banco_id) from banco", Long.class));
		tarjeta.setBanco(banco);
		tarjeta.setMesExpiracion(1);
		tarjeta.setNumeroSeguridad(23);
		tarjeta.setNumeroTarjeta("9999999999999999");
		tarjeta.setTipoTarjeta(TipoTarjeta.VISA);
		return tarjeta;
	}

	/**
	 * @return
	 */
	private Long creaClienteFicticio() {

		Long id = jdbcTemplate.queryForObject(
				"select max(cliente_id) from cliente", Long.class);
		id = id == null ? 1L : id + 1L;

		int result = jdbcTemplate
				.update("insert into cliente(cliente_id,nombre,apellido_paterno,"
						+ "apellido_materno,email,rfc,direccion,telefono,usuario,password,tipo_cliente_id)"
						+ " values(?,?,?,?,?,?,?,?,?,?,?)", id, "Juan", "Lara",
						"Luna", "email", "rfc", "direccion", "telefono",
						"user", "pass", TipoCliente.ADICTO.getId());
		Assert.assertEquals(1, result);
		return id;
	}
}
