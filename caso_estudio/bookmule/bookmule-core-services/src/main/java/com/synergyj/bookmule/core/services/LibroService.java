package com.synergyj.bookmule.core.services;

import java.util.Set;

import com.synergyj.bookmule.core.domain.Libro;
import com.synergyj.bookmule.core.domain.beans.CriterioBusquedaLibro;

public interface LibroService {

	void creaLibro(Libro libro);

	Set<Libro> buscaLibros(CriterioBusquedaLibro criterios);

	Libro buscaPorId(Long id);
}
