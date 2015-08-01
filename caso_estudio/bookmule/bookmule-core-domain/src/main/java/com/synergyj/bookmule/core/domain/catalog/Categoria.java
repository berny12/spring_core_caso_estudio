/**
 * Categoria.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain.catalog;

/**
 * Catálogo de las catagorias de los libros
 * 
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public enum Categoria {

	ANIMALES_Y_MASCOTAS(1, "ANIMALES Y MASCOTAS", "ANIMALES Y MASCOTAS", true),

	CIENCIAS_NATURALES(2, "CIENCIAS NATURALES", "CIENCIAS NATURALES", true),

	CIENCIAS_SOCIALES(3, "CIENCIAS SOCIALES", "CIENCIAS SOCIALES", true),

	CONTABILIDAD(4, "CONTABILIDAD", "CONTABILIDAD", true),

	DERECHO(5, "DERECHO", "DERECHO", true),

	ESOTERISMO(6, "ESOTERISMO", "ESOTERISMO", true),

	FILOSOFIA(7, "FILOSOFIA", "FILOSOFIA", true),

	GASTRONOMIA(8, "GASTRONOMIA", "GASTRONOMIA", true),

	GEOGRAFIA(9, "GEOGRAFIA", "GEOGRAFIA", true),

	HISTORIA(10, "HISTORIA", "HISTORIA", true),

	INFORMATICA(11, "INFORMATICA", "INFORMATICA", true),

	LINGÜISTICA(12, "LINGÜISTICA", "LINGÜISTICA", true),

	LITERATURA(13, "LITERATURA", "LITERATURA", true),

	MATEMATICAS(14, "MATEMATICAS", "MATEMATICAS", true),

	MEDICINA(15, "MEDICINA", "MEDICINA", true),

	NIÑOS(16, "NIÑOS", "NIÑOS", true),

	SICOLOGIA(17, "SICOLOGIA", "SICOLOGIA", true),

	RELIGION(18, "RELIGION", "RELIGION", true),

	SALUD_ALTERNATIVA(19, "SALUD ALTERNATIVA", "SALUD ALTERNATIVA", true),

	TEATRO(20, "TEATRO", "TEATRO", true),

	TEXTOS_ESCOLARES(21, "TEXTOS ESCOLARES", "TEXTOS ESCOLARES", true),

	TURISMO(22, "TURISMO", "TURISMO", true);

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
	private Categoria(int id, String clave, String descripcion, boolean activo) {
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public Categoria valueOf(int id) {
		for (Categoria categoria : Categoria.values()) {
			if (categoria.getId() == id) {
				return categoria;
			}
		}

		throw new IllegalArgumentException("No existe un identificador valido en Categoria para: "
				+ id);
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
