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

import com.synergyj.bookmule.core.domain.Editorial;
import com.synergyj.bookmule.core.domain.Libro;
import com.synergyj.bookmule.core.domain.beans.CriterioBusquedaLibro;
import com.synergyj.bookmule.core.domain.catalog.StatusLibro;
import com.synergyj.bookmule.persistence.dao.LibroDAO;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
// TODO C) configurar SpringJUnit4ClassRunner y @ContextConfiguration
// TODO D) Hacer que la clase extienda de AbstractTransactionalJUnit4SpringContextTests
public class LibroDAOTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(LibroDAOTestCase.class);

	@Resource
	private LibroDAO libroDAO;

	/**
	 * Observar que al terminar la prueba se hace rollback para dejar la base intacta, esto con el
	 * simple hecho de extender de la clase {@link AbstractTransactionalJUnit4SpringContextTests}
	 */
	@Test
	public void creaYbuscaLibro() {
		Libro libro, libroObtenido = null;

		libro = construyeLibroFicticio();

		// TODO E) invocar la creación del libro haciendo uso del DAO

		logger.debug("Libro creado {}", libro);
		Assert.assertNotNull(libro.getId());
		logger.debug("consultando el libro para verificar");

		// TODO F) invocar al dao para consultar el libro creado usando su Id

		// comparando properties para validar su correcta persistencia.
		BeanPropertiesComparator.compare(libro, libroObtenido, "id", "titulo", "edicion", "isbn",
				"codigoColor", "codigoClasificacion", "numeroEjemplares", "precioVenta",
				"editorial.id", "statusLibro.id");
	}

	/**
	 * Verifica el comportamiento del DAO cuando no hay resultados.
	 */
	// TODO G) indicarle a Junit que se lanzará excepción IncorrectResultSizeDataAccessException
	@Test
	public void buscaLibroInexistente() {
		Set<Libro> libroSet;
		CriterioBusquedaLibro criterios;

		logger.debug("buscando  libros inexistentes ");
		criterios = new CriterioBusquedaLibro();
		criterios.setId(-10L);
		criterios.setTitulo("No existo");
		criterios.setIsbn("No existo");
		libroSet = libroDAO.busca(criterios);
		Assert.assertNotNull(libroSet);
		Assert.assertEquals(0, libroSet.size());

		logger.debug("Aqui se debe lanzar excepcion");
		libroDAO.findById(-1L);
	}

	/**
	 * @return
	 */
	private Libro construyeLibroFicticio() {
		Libro libro = new Libro();
		Editorial editorial = null;
		libro.setCodigoClasificacion("B034");
		libro.setCodigoColor("002343");
		libro.setCodigoClasificacion("WL0092");
		libro.setEdicion(1);
		// TODO H) consultar cualquier editorial de la BD para completar el objeto Libro a crear.
		Assert.assertNotNull(editorial.getId());
		libro.setEditorial(editorial);
		libro.setIsbn("9788481812275");
		libro.setNumeroEjemplares(1);
		libro.setPrecioVenta(new Float(234.56));
		libro.setStatusLibro(StatusLibro.DISPONIBLE);
		libro.setTitulo("100 años de Soledad");
		return libro;
	}

}
