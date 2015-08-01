/**
 * Pedido.java
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

import com.synergyj.bookmule.core.domain.catalog.StatusPedido;

/**
 * Entidad que contiene los datos de los pedidos
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class Pedido implements Serializable {

	private static final long serialVersionUID = -3505255134753370561L;

	private Long id;

	private Date fechaStatus;

	private Date fechaEstimadaRecepcion;

	private StatusPedido statusPedido;

	private Set<DetallePedido> detallePedido;

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
	 * @return fechaEstimadaRecepcion
	 */
	public Date getFechaEstimadaRecepcion() {
		return fechaEstimadaRecepcion;
	}

	/**
	 * @param fechaEstimadaRecepcion para inicializar el atributo fechaEstimadaRecepcion
	 */
	public void setFechaEstimadaRecepcion(Date fechaEstimadaRecepcion) {
		this.fechaEstimadaRecepcion = fechaEstimadaRecepcion;
	}

	/**
	 * @return statusPedido
	 */
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	/**
	 * @param statusPedido para inicializar el atributo statusPedido
	 */
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	/**
	 * @return detallePedido
	 */
	public Set<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	/**
	 * @param detallePedido para inicializar el atributo detallePedido
	 */
	public void setDetallePedido(Set<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [id=");
		builder.append(id);
		builder.append(", fechaStatus=");
		builder.append(fechaStatus);
		builder.append(", fechaEstimadaRecepcion=");
		builder.append(fechaEstimadaRecepcion);
		builder.append(", statusPedido=");
		builder.append(statusPedido);
		builder.append(", detallePedido=");
		builder.append(detallePedido);
		builder.append("]");
		return builder.toString();
	}

}
