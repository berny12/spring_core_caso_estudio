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
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.synergyj.bookmule.core.domain.Proveedor;
import com.synergyj.bookmule.persistence.dao.ProveedorDAO;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbcAppContext.xml")
public class ProveedorDAOTestCase {

	@Resource
	ProveedorDAO proveedorDAO;

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProveedorDAOTestCase.class);

	@Test
	public void creaYbuscaProveedor() {

		Proveedor proveedor;
		Set<Proveedor> proveedores;

		proveedor = creaProveedorFicticio();
		proveedorDAO.crea(proveedor);

		logger.debug("autor creado {}", proveedor);
		Assert.assertNotNull(proveedor.getId());

		logger.debug("validando datos:");
		proveedores = proveedorDAO.busca(proveedor);
		Assert.assertTrue(proveedores.size() == 1);
		BeanPropertiesComparator.compare(proveedor, proveedores.iterator().next(), "id", "nombre",
				"direccion", "urlPedidos");
	}

	@Test(expected = IncorrectResultSizeDataAccessException.class)
	public void buscaProveedorPorId() {
		Proveedor proveedor;

		proveedor = creaProveedorFicticio();
		proveedorDAO.crea(proveedor);
		logger.debug("Validando busqueda por id");
		Assert.assertEquals(proveedor.getId(), proveedorDAO.findById(proveedor.getId()).getId());
		logger.debug("validando con proveedor inexistente, se debe lanzar excepcion");
		proveedorDAO.findById(Long.MAX_VALUE);

	}

	/**
	 * @return
	 */
	private Proveedor creaProveedorFicticio() {
		Proveedor proveedor;
		proveedor = new Proveedor();
		proveedor.setNombre("Super libros S.A de C.V");
		proveedor.setDireccion("Paseo de la reforma 1500, Mexico DF,");
		proveedor.setUrlPedidos("http://www.superlibros.com");
		return proveedor;
	}
}
