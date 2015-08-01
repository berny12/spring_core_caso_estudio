/**
 * Editorial.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;

/**
 * Entidad que contiene los datos de las Editoriales
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class Editorial implements Serializable {

	private static final long serialVersionUID = -8059446324034276364L;

	private Long id;

	private String nombre;

	private Boolean activo;

	/**
	 * Constructor
	 */
	public Editorial() {

	}

	/**
	 * @param id
	 * @param nombre
	 * @param activo
	 */
	public Editorial(Long id, String nombre, Boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
	}

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
	 * @return activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * @param activo para inicializar el atributo activo
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Editorial [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", activo=");
		builder.append(activo);
		builder.append("]");
		return builder.toString();
	}

}
