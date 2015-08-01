package com.synergyj.bookmule.persistence.dao;

import java.util.Set;

import com.synergyj.bookmule.core.domain.Libro;
import com.synergyj.bookmule.core.domain.beans.CriterioBusquedaLibro;

public interface LibroDAO {

	void crea(Libro libro);

	Set<Libro> busca(CriterioBusquedaLibro criterios);

	Libro findById(Long id);

}
