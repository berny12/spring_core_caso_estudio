/**
 * Banco.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;

/**
 * Entidad que contiene los datos del Banco
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class Banco implements Serializable {

	private static final long serialVersionUID = 4733840385388433876L;

	private Long id;

	private String nombre;

	private String urlCargo;

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id para inicializar el atributo id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre para inicializar el atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return urlCargo
	 */
	public String getUrlCargo() {
		return urlCargo;
	}

	/**
	 * @param urlCargo para inicializar el atributo urlCargo
	 */
	public void setUrlCargo(String urlCargo) {
		this.urlCargo = urlCargo;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Banco [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", urlCargo=");
		builder.append(urlCargo);
		builder.append("]");
		return builder.toString();
	}

}
