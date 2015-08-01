/**
 * OrdenCompra.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.synergyj.bookmule.core.domain.catalog.StatusOrdenCompra;

/**
 * Entidad que contiene los datos de las ordenes de compra
 * @author Maricela Barrera
 * @version 1.0
 */
public class OrdenCompra implements Serializable {

	private static final long serialVersionUID = 532840844029831765L;

	private Long id;

	private Cliente cliente;

	private Date fechaStatus;

	private Set<DetalleOrdenCompra> detalleOrdenCompra;

	private StatusOrdenCompra statusOrdenCompra;

	private String seguimientoEntregaId;

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
	 * @return cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente para inicializar el atributo cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	 * @return detalleOrdenCompra
	 */
	public Set<DetalleOrdenCompra> getDetalleOrdenCompra() {
		return detalleOrdenCompra;
	}

	/**
	 * @param detalleOrdenCompra para inicializar el atributo detalleOrdenCompra
	 */
	public void setDetalleOrdenCompra(Set<DetalleOrdenCompra> detalleOrdenCompra) {
		this.detalleOrdenCompra = detalleOrdenCompra;
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

	/**
	 * @return seguimientoEntregaId
	 */
	public String getSeguimientoEntregaId() {
		return seguimientoEntregaId;
	}

	/**
	 * @param seguimientoEntregaId para inicializar el atributo seguimientoEntregaId
	 */
	public void setSeguimientoEntregaId(String seguimientoEntregaId) {
		this.seguimientoEntregaId = seguimientoEntregaId;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrdenCompra [id=");
		builder.append(id);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", fechaStatus=");
		builder.append(fechaStatus);
		builder.append(", detalleOrdenCompra=");
		builder.append(detalleOrdenCompra);
		builder.append(", statusOrdenCompra=");
		builder.append(statusOrdenCompra);
		builder.append(", seguimientoEntregaId=");
		builder.append(seguimientoEntregaId);
		builder.append("]");
		return builder.toString();
	}

}
