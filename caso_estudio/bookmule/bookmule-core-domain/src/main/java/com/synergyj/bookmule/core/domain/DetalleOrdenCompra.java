/**
 * DetalleOrdenCompra.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Entidad que contiene el detalle de la orden de compra
 * @author Maricela Barrera
 * @version 1.0
 */
public class DetalleOrdenCompra implements Serializable {

	private static final long serialVersionUID = 4550865548814644274L;

	private Long id;

	private Libro libro;

	private Integer cantidad;

	private BigDecimal costoUnitario;

	private Promocion promocion;

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
	 * @return libro
	 */
	public Libro getLibro() {
		return libro;
	}

	/**
	 * @param libro para inicializar el atributo libro
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	/**
	 * @return cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad para inicializar el atributo cantidad
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return costoUnitario
	 */
	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}

	/**
	 * @param costoUnitario para inicializar el atributo costoUnitario
	 */
	public void setCostoUnitario(BigDecimal costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	/**
	 * @return promocion
	 */
	public Promocion getPromocion() {
		return promocion;
	}

	/**
	 * @param promocion para inicializar el atributo promocion
	 */
	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetalleOrdenCompra [id=");
		builder.append(id);
		builder.append(", libro=");
		builder.append(libro);
		builder.append(", cantidad=");
		builder.append(cantidad);
		builder.append(", costoUnitario=");
		builder.append(costoUnitario);
		builder.append(", promocion=");
		builder.append(promocion);
		builder.append("]");
		return builder.toString();
	}

}
