/**
 * HistoricoPedido.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;
import java.util.Date;

import com.synergyj.bookmule.core.domain.catalog.StatusPedido;

/**
 * Entidad que contiene el historico de los pedidos
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class HistoricoPedido implements Serializable {

	private static final long serialVersionUID = 46838488336023177L;

	private Long id;

	private Long pedidoId;

	private Date fechaStatus;

	private StatusPedido statusPedido;

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
	 * @return pedidoId
	 */
	public Long getPedidoId() {
		return pedidoId;
	}

	/**
	 * @param pedidoId para inicializar el atributo pedidoId
	 */
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HistoricoPedido [id=");
		builder.append(id);
		builder.append(", pedidoId=");
		builder.append(pedidoId);
		builder.append(", fechaStatus=");
		builder.append(fechaStatus);
		builder.append(", statusPedido=");
		builder.append(statusPedido);
		builder.append("]");
		return builder.toString();
	}

}
