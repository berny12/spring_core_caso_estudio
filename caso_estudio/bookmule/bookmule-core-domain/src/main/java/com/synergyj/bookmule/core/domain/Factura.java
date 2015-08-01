/**
 * Factura.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Entidad que contiene los datos de la factura
 * @author Maricela Barrera
 * @version 1.0
 */
public class Factura implements Serializable {

	private static final long serialVersionUID = -3351184373960252376L;

	private Long id;

	private Date fechaFactura;

	private OrdenCompra ordenCompra;

	private String selloDigital;

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
	 * @return fechaFactura
	 */
	public Date getFechaFactura() {
		return fechaFactura;
	}

	/**
	 * @param fechaFactura para inicializar el atributo fechaFactura
	 */
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	/**
	 * @return ordenCompra
	 */
	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	/**
	 * @param ordenCompra para inicializar el atributo ordenCompra
	 */
	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	/**
	 * @return selloDigital
	 */
	public String getSelloDigital() {
		return selloDigital;
	}

	/**
	 * @param selloDigital para inicializar el atributo selloDigital
	 */
	public void setSelloDigital(String selloDigital) {
		this.selloDigital = selloDigital;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Factura [id=");
		builder.append(id);
		builder.append(", fechaFactura=");
		builder.append(fechaFactura);
		builder.append(", ordenCompra=");
		builder.append(ordenCompra);
		builder.append(", selloDigital=");
		builder.append(selloDigital);
		builder.append("]");
		return builder.toString();
	}

}
