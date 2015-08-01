/**
 * Proveedor.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;

/**
 * Entidad que contiene los datos de los proveedores
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 3206402580950832212L;

	private Long id;

	private String nombre;

	private String direccion;

	private String urlPedidos;

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
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion para inicializar el atributo direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return urlPedidos
	 */
	public String getUrlPedidos() {
		return urlPedidos;
	}

	/**
	 * @param urlPedidos para inicializar el atributo urlPedidos
	 */
	public void setUrlPedidos(String urlPedidos) {
		this.urlPedidos = urlPedidos;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Proveedor [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", urlPedidos=");
		builder.append(urlPedidos);
		builder.append("]");
		return builder.toString();
	}

}
