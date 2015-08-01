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
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.synergyj.bookmule.core.domain.Autor;
import com.synergyj.bookmule.persistence.dao.AutorDAO;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbcAppContext.xml")
public class AutorDAOTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	@Resource
	private AutorDAO autorDAO;

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(AutorDAOTestCase.class);

	@Test
	public void creaYbuscaAutor() {

		Autor autor;
		Set<Autor> autores;

		autor = creaAutorFicticio();
		autorDAO.crea(autor);

		logger.debug("autor creado {}", autor);
		Assert.assertNotNull(autor.getId());

		logger.debug("validando datos:");
		autores = autorDAO.busca(autor);
		Assert.assertTrue(autores.size() == 1);
		BeanPropertiesComparator.compare(autor, autores.iterator().next(), "id", "nombre",
				"apellidoPaterno");
	}

	@Test(expected = IncorrectResultSizeDataAccessException.class)
	public void buscaAutorPorId() {
		Autor autor;

		autor = creaAutorFicticio();
		autorDAO.crea(autor);
		logger.debug("Valudando busqueda por id");
		Assert.assertEquals(autor.getId(), autorDAO.findAutorById(autor.getId()).getId());
		logger.debug("validando con autor inexistente, se debe lanzar excepcion");
		autorDAO.findAutorById(Long.MAX_VALUE);

	}

	/**
	 * @return
	 */
	private Autor creaAutorFicticio() {
		Autor autor;
		autor = new Autor();
		autor.setNombre("Pablo");
		autor.setApellidoPaterno("Neruda");
		return autor;
	}
}
