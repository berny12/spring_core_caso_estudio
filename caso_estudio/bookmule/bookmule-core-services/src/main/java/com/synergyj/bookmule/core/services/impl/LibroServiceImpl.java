/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.core.services.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergyj.bookmule.core.domain.Libro;
import com.synergyj.bookmule.core.domain.beans.CriterioBusquedaLibro;
import com.synergyj.bookmule.core.services.LibroService;
import com.synergyj.bookmule.persistence.dao.LibroDAO;

@Service("libroService")
public class LibroServiceImpl implements LibroService {

	/**
	 * Logger para todas las instancias de la clase
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(LibroServiceImpl.class);

	@Resource
	private LibroDAO libroDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.core.services.LibroService#creaLibro(com.synergyj
	 * .bookmule.core.domain .Libro)
	 */
	@Override
	@Transactional
	public void creaLibro(Libro libro) {
		Set<Libro> setLibro;
		CriterioBusquedaLibro criterioBusqueda;

		logger.debug("creando un nuevo libro, validando su existencia {}",
				libro);

		// TODO agregar código que valide que el libro a registrar no exista
		// empleando el ISBN como
		// criterio de búsqueda.

		criterioBusqueda = new CriterioBusquedaLibro();
		criterioBusqueda.setIsbn(libro.getIsbn());

		setLibro = buscaLibros(criterioBusqueda);
		if (setLibro.size() > 0) {
			throw new IllegalArgumentException("El libro con el ISB: "
					+ libro.getIsbn() + " ya existe");
		}

		logger.debug("creando un nuevo libro");
		libroDAO.crea(libro);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.core.services.LibroService#buscaLibros(com.synergyj
	 * .bookmule.core. domain .beans.CriterioBusquedaLibro)
	 */
	@Override
	@Transactional(readOnly = true)
	public Set<Libro> buscaLibros(CriterioBusquedaLibro criterios) {
		Set<Libro> libroSet;
		logger.debug("buscado libros con criterios: {}", criterios);
		libroSet = libroDAO.busca(criterios);
		logger.debug("se obtuvieron {} libros", libroSet.size());
		return libroSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.synergyj.bookmule.core.services.LibroService#getLibroById(java.lang
	 * .Long)
	 */
	@Override
	@Transactional(readOnly = true)
	public Libro buscaPorId(Long id) {
		return libroDAO.findById(id);
	}

}
