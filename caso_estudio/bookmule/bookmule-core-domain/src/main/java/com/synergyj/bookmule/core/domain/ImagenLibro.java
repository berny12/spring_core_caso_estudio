/**
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software es de propósito educativo, puede ser
 * empleado para fines sin lucro haciendo referencia 
 * al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;

/**
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class ImagenLibro implements Serializable {

	private static final long serialVersionUID = -2219035291044771186L;

	private Long id;

	private Integer numImagen;

	private byte[] imagen;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumImagen() {
		return numImagen;
	}

	public void setNumImagen(Integer numImagen) {
		this.numImagen = numImagen;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ImagenLibro [id=");
		builder.append(id);
		builder.append(", numImagen=");
		builder.append(numImagen);
		builder.append(", imagen (bytes)=");
		builder.append(imagen.length);
		builder.append("]");
		return builder.toString();
	}

}
