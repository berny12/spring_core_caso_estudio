/**
 * TipoCliente.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain.catalog;

/**
 * Catálogo que contiene los tipos de clientes
 * 
 * @author Maricela Barrera
 * @version 1.0
 */

// los enums son constantes que representa pequeños catalogos estaticos
// dentro de las bae de datos para mantener integridad referencial de 3 tipo
// en java usamos la enum para eviar la consulta se pueden usar en == o
public enum TipoCliente {

	AFICIONADO(1, "AFICIONADO", "CON 5 O MENOS LIBROS COMPRADOS", true),

	APASIONADO(2, "APASIONADO", "ENTRE 6 Y 15 LIBROS COMPRADOS", true),

	ADICTO(3, "ADICTO", "MAS DE 15 LIBROS COMPRADOS", true);

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
	TipoCliente(int id, String clave, String descripcion, boolean activo) {
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public static TipoCliente valueOf(int id) {
		for (TipoCliente tipoCliente : TipoCliente.values()) {
			if (tipoCliente.getId() == id) {
				return tipoCliente;
			}
		}

		throw new IllegalArgumentException(
				"No existe un identificador valido en TipoCliente para: " + id);
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            para inicializar el atributo id
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
	 * @param clave
	 *            para inicializar el atributo clave
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
	 * @param descripcion
	 *            para inicializar el atributo descripcion
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
	 * @param activo
	 *            para inicializar el atributo activo
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
