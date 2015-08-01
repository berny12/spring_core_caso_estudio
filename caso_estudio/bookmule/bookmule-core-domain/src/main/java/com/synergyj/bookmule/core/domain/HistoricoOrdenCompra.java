/**
 * HistoricoOrdenCompra.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;
import java.util.Date;

import com.synergyj.bookmule.core.domain.catalog.StatusOrdenCompra;

/**
 * Entidad que contiene el historico de las ordenes de compra
 * @author Maricela Barrera
 * @version 1.0
 */
public class HistoricoOrdenCompra implements Serializable {

	private static final long serialVersionUID = -8175372899101095587L;

	private Long id;

	private Long ordenCompraId;

	private Date fechaStatus;

	private StatusOrdenCompra statusOrdenCompra;

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
	 * @return ordenCompraId
	 */
	public Long getOrdenCompraId() {
		return ordenCompraId;
	}

	/**
	 * @param ordenCompraId para inicializar el atributo ordenCompraId
	 */
	public void setOrdenCompraId(Long ordenCompraId) {
		this.ordenCompraId = ordenCompraId;
	}

	/**
	 * @return fechaStatus
	 */
	public Date getFechaStatus() {
		return fechaStatus;
	}

	/**
	 * @param fechaStatus para inicializar el atributo fechaStatus
	 */
	public void setFechaStatus(Date fechaStatus) {
		this.fechaStatus = fechaStatus;
	}

	/**
	 * @return statusOrdenCompra
	 */
	public StatusOrdenCompra getStatusOrdenCompra() {
		return statusOrdenCompra;
	}

	/**
	 * @param statusOrdenCompra para inicializar el atributo statusOrdenCompra
	 */
	public void setStatusOrdenCompra(StatusOrdenCompra statusOrdenCompra) {
		this.statusOrdenCompra = statusOrdenCompra;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HistoricoOrdenCompra [id=");
		builder.append(id);
		builder.append(", ordenCompraId=");
		builder.append(ordenCompraId);
		builder.append(", fechaStatus=");
		builder.append(fechaStatus);
		builder.append(", statusOrdenCompra=");
		builder.append(statusOrdenCompra);
		builder.append("]");
		return builder.toString();
	}

}
