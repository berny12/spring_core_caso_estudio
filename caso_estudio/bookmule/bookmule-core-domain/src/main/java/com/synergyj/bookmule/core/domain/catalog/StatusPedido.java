/**
 * StatusPedido.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain.catalog;

/**
 * Catálogo que contiene los status de los pedidos;
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public enum StatusPedido {

	REGISTRADO(1, "REGISTRADO", "REGISTRADO", true),

	ENVIADO_PROVEEDOR(2, "ENVIADO AL PROVEEDOR", "ENVIADO AL PROVEEDOR", true),

	RECIBIDO(3, "RECIBIDO", "RECIBIDO", true);

	private int id;

	private String clave;

	private String descripcion;

	private boolean activo;

	/**
	 * @param id
	 * @param clave
	 * @param descripcion
	 * @param activo
	 */
	StatusPedido(int id, String clave, String descripcion, boolean activo) {
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public StatusPedido valueOf(int id) {
		for (StatusPedido statusPedido : StatusPedido.values()) {
			if (statusPedido.getId() == id) {
				return statusPedido;
			}
		}

		throw new IllegalArgumentException(
				"No existe un identificador valido en StatusPedido para: " + id);
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id para inicializar el atributo id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave para inicializar el atributo clave
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion para inicializar el atributo descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo para inicializar el atributo activo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
