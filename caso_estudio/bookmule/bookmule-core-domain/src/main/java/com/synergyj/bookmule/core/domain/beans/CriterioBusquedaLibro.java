/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.core.domain.beans;

import com.synergyj.bookmule.core.domain.Libro;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class CriterioBusquedaLibro extends Libro {

	private static final long serialVersionUID = -3030032244987432343L;

	private Double precioInicial;

	private Double precioFinal;

	/**
	 * @return the precioInicial
	 */
	public Double getPrecioInicial() {
		return precioInicial;
	}

	/**
	 * @param precioInicial the precioInicial to set
	 */
	public void setPrecioInicial(Double precioInicial) {
		this.precioInicial = precioInicial;
	}

	/**
	 * @return the precioFinal
	 */
	public Double getPrecioFinal() {
		return precioFinal;
	}

	/**
	 * @param precioFinal the precioFinal to set
	 */
	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("CriterioBusquedaLibro [precioInicial=");
		builder.append(precioInicial);
		builder.append(", precioFinal=");
		builder.append(precioFinal);
		builder.append("]");
		return builder.toString();
	}

}
