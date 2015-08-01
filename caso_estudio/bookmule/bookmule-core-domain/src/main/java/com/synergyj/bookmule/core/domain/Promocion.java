/**
 * Promocion.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entidad que contiene los datos de la promocion
 * @author Maricela Barrera
 * @version 1.0
 */
public class Promocion implements Serializable {

	private static final long serialVersionUID = -987045082326579957L;

	private Long id;

	private String nombre;

	private String descripcion;

	private String expresion;

	private Date fechaInicio;

	private Date fechaFin;

	private BigDecimal descuento;

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
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre para inicializar el atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return expresion
	 */
	public String getExpresion() {
		return expresion;
	}

	/**
	 * @param expresion para inicializar el atributo expresion
	 */
	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}

	/**
	 * @return fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio para inicializar el atributo fechaInicio
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin para inicializar el atributo fechaFin
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return descuento
	 */
	public BigDecimal getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento para inicializar el atributo descuento
	 */
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Promocion [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", expresion=");
		builder.append(expresion);
		builder.append(", fechaInicio=");
		builder.append(fechaInicio);
		builder.append(", fechaFin=");
		builder.append(fechaFin);
		builder.append(", descuento=");
		builder.append(descuento);
		builder.append("]");
		return builder.toString();
	}

}
