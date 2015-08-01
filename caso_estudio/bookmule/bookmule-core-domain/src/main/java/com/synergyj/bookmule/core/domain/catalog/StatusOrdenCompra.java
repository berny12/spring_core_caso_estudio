/**
 * StatusOrdenCompra.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain.catalog;

/**
 * Catálogo que contiene los status de la orden de compra
 * @author Maricela Barrera
 * @version 1.0
 */
public enum StatusOrdenCompra {

	REGISTRADA(1, "REGISTRADA", "REGISTRADA", true),

	PAGO_EN_VALIDACION(2, "PAGO EN VALIDACION", "PAGO EN VALIDACION", true),

	PAGO_REALIZADO(3, "PAGO REALIZADO", "PAGO REALIZADO", true),

	ENVIADA_PAQUETERIA(4, "ENVIADA A PAQUETERIA", "ENVIADA A PAQUETERIA", true);

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
	StatusOrdenCompra(int id, String clave, String descripcion, boolean activo) {
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public StatusOrdenCompra valueOf(int id) {
		for (StatusOrdenCompra statusOrdenCompra : StatusOrdenCompra.values()) {
			if (statusOrdenCompra.getId() == id) {
				return statusOrdenCompra;
			}
		}

		throw new IllegalArgumentException(
				"No existe un identificador valido en StatusOrdenCompra para: " + id);
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
