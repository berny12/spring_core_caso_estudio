/**
 * DetallePedido.java
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
 * Entidad que contiene el detalle de cada pedido
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class DetallePedido implements Serializable {

	private static final long serialVersionUID = 3128891102137467071L;

	private Long id;

	private Libro libro;

	private Integer cantidadSolicitada;

	private Proveedor proveedor;

	private BigDecimal precioCompra;

	private Integer cantidadRecibida;

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
	 * @return cantidadSolicitada
	 */
	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	/**
	 * @param cantidadSolicitada para inicializar el atributo cantidadSolicitada
	 */
	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	/**
	 * @return proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor para inicializar el atributo proveedor
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return precioCompra
	 */
	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	/**
	 * @param precioCompra para inicializar el atributo precioCompra
	 */
	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	/**
	 * @return cantidadRecibida
	 */
	public Integer getCantidadRecibida() {
		return cantidadRecibida;
	}

	/**
	 * @param cantidadRecibida para inicializar el atributo cantidadRecibida
	 */
	public void setCantidadRecibida(Integer cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetallePedido [id=");
		builder.append(id);
		builder.append(", libro=");
		builder.append(libro);
		builder.append(", cantidadSolicitada=");
		builder.append(cantidadSolicitada);
		builder.append(", proveedor=");
		builder.append(proveedor);
		builder.append(", precioCompra=");
		builder.append(precioCompra);
		builder.append(", cantidadRecibida=");
		builder.append(cantidadRecibida);
		builder.append("]");
		return builder.toString();
	}

}
