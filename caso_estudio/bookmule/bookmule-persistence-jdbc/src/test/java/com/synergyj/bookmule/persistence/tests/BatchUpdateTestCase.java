/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.persistence.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.synergyj.bookmule.core.domain.Proveedor;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbcAppContext.xml")
public class BatchUpdateTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	@Test
	public void creaProveedoresBatch() {
		List<Proveedor> proveedorList;
		int[] resultados = null;
		proveedorList = construyeBatch();
		// TODO A) Completar este código.

		for (int result : resultados) {
			Assert.assertEquals(result, 1);
		}

		Assert.assertTrue(proveedorList.size() <= countRowsInTable("proveedor"));
	}

	/**
	 * @return
	 */
	private List<Proveedor> construyeBatch() {
		Proveedor proveedor;
		Random random;
		List<Proveedor> proveedorList = new ArrayList<>();
		random = new Random();
		for (int i = 0; i < 10_000; i++) {
			proveedor = new Proveedor();
			proveedor.setNombre("Valor generado " + new Date().getTime());
			proveedor.setDireccion("Direccion aleatoria: " + random.nextLong());
			proveedor.setUrlPedidos("http://" + random.nextLong());
			proveedorList.add(proveedor);
		}

		return proveedorList;
	}
}
