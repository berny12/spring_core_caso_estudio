/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de prop�sito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.core.services.test;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.synergyj.bookmule.core.domain.Libro;
import com.synergyj.bookmule.core.domain.beans.CriterioBusquedaLibro;
import com.synergyj.bookmule.core.services.impl.LibroServiceImpl;
import com.synergyj.bookmule.persistence.dao.LibroDAO;

//import com.synergyj.bookmule.core.services.impl.LibroServiceImpl;

/**
 * Mockito test case. {@link MockitoJUnitRunner} permite hacer uso de las
 * anotaciones de la herramienta para construir e inyectar Mock Objects.
 * Observar que se pueden probar servicios de negocio inclusive, anotados con
 * Spring, s sin la necesidad de crear un aplication context, y sin la necesidad
 * de la existencia de la base de datos. El enfoque es probar el comportamiento
 * del servicio {@link ClienteServiceImpl}
 * 
 * @author Jorge Rodr�guez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
// TODO A) configurar MockitoJunitRunner
@RunWith(MockitoJUnitRunner.class)
public class LibroServiceMockTestCase {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(LibroServiceMockTestCase.class);

	/**
	 * Esta anotacion, crea una instancia de LibroServiceImpl. Sus dependencias
	 * son inyectadas con los atributos de esta clase anotados con @Mock
	 */
	// TODO B) Anotar con @InjectMocks y revisar el tipo de dato del atributo
	// Se le indica al framework que injecte los mockobjcts que se encuentren en
	// esta clase
	@InjectMocks
	private LibroServiceImpl libroService;

	/**
	 * Mock object inyectado en el atributo clienteService
	 */
	// TODO C) Anotar con @Mock
	// se llama libroDAO para que por nombre pueda inyectar el recurso que
	// ocupala clase servicionimpl
	@Mock
	private LibroDAO libroDAO;

	private CriterioBusquedaLibro libroNuevo, libroExistente;

	@Before
	public void setup() {

		HashSet<Libro> setLibro;

		libroNuevo = new CriterioBusquedaLibro();
		libroNuevo.setIsbn("9788481812275");
		libroExistente = new CriterioBusquedaLibro();
		libroExistente.setIsbn("9788481812280");
		setLibro = new HashSet<Libro>();
		setLibro.add(libroExistente);
		/*
		 * Esto es una belleza, porque Mockito, nos permite crear al vuelo
		 * clases que implementen las interfases que necesitemos, tambien se
		 * puede usar con clases concretas. En la siguiente linea de codigo,
		 * vamos a crear el mock de la interfase ClienteService.
		 */
		Mockito.when(libroDAO.busca(libroNuevo)).thenReturn(
				new HashSet<Libro>(0));
		Mockito.when(libroDAO.busca(libroExistente)).thenReturn(setLibro);

		// TODO D) Agregar una instrucci�n para el m�todo crea del dao, emplear
		// doNothing
		Mockito.doNothing().when(libroDAO).crea(libroNuevo);

	}

	/**
	 * Happy path, se crea un libro que no existe en la BD El metodo verify
	 * revisa que se haya ejecutado el metodo busca de libroDAO para validar que
	 * se haya validado su existencia. Verifica que se haya invocao 1 vez el
	 * m�todo crea del dao, la validaci�n es exitosa.
	 */
	@Test
	public void creaLibroInexistente() {

		logger.debug("Creando un libro");
		libroService.creaLibro(libroNuevo);

		// verificamos si efectivamente se invokquen los metodos y las veces
		// necesarias
		Mockito.verify(libroDAO).busca(libroNuevo);
		Mockito.verify(libroDAO, Mockito.times(1)).crea(libroNuevo);

	}

	/**
	 * En este escenario se intenta crear un libro existente. Se espera una
	 * excepcion y se valida que nunca se invoque al m�todo crea de LibroDAO
	 */
	@Test(expected = IllegalArgumentException.class)
	public void creaLibroExistente() throws Exception {
		logger.debug("creando un libro existente");
		try {
			libroService.creaLibro(libroExistente);
		} catch (IllegalArgumentException e) {
			// TODO E) agregar 2 expresiones con Mockito para validar que se
			// invoque al m�todo busca
			// del dao, y que no se haya ejecutado al metodo crea.

			Mockito.verify(libroDAO).busca(libroExistente);
			Mockito.verify(libroDAO, Mockito.times(0)).crea(libroExistente);

			logger.debug("excepcion lanzada: {}", e.getMessage());
			throw e;
		}
	}
}
