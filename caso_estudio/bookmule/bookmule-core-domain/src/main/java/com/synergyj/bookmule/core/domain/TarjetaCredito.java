/**
 * TarjetaCredito.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;

import com.synergyj.bookmule.core.domain.catalog.TipoTarjeta;

/**
 * Entidad que contiene los datos de la tarjeta de credito
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class TarjetaCredito implements Serializable {

	private static final long serialVersionUID = 7906830331471877433L;

	private Long id;

	private String numeroTarjeta;

	private Integer mesExpiracion;

	private Integer anioExpiracion;

	private Integer numeroSeguridad;

	private TipoTarjeta tipoTarjeta;

	private Banco banco;

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
	 * @return numeroTarjeta
	 */
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	/**
	 * @param numeroTarjeta para inicializar el atributo numeroTarjeta
	 */
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	/**
	 * @return mesExpiracion
	 */
	public Integer getMesExpiracion() {
		return mesExpiracion;
	}

	/**
	 * @param mesExpiracion para inicializar el atributo mesExpiracion
	 */
	public void setMesExpiracion(Integer mesExpiracion) {
		this.mesExpiracion = mesExpiracion;
	}

	/**
	 * @return anioExpiracion
	 */
	public Integer getAnioExpiracion() {
		return anioExpiracion;
	}

	/**
	 * @param anioExpiracion para inicializar el atributo anioExpiracion
	 */
	public void setAnioExpiracion(Integer anioExpiracion) {
		this.anioExpiracion = anioExpiracion;
	}

	/**
	 * @return numeroSeguridad
	 */
	public Integer getNumeroSeguridad() {
		return numeroSeguridad;
	}

	/**
	 * @param numeroSeguridad para inicializar el atributo numeroSeguridad
	 */
	public void setNumeroSeguridad(Integer numeroSeguridad) {
		this.numeroSeguridad = numeroSeguridad;
	}

	/**
	 * @return tipoTarjeta
	 */
	public TipoTarjeta getTipoTarjeta() {
		return tipoTarjeta;
	}

	/**
	 * @param tipoTarjeta para inicializar el atributo tipoTarjeta
	 */
	public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	/**
	 * @return banco
	 */
	public Banco getBanco() {
		return banco;
	}

	/**
	 * @param banco para inicializar el atributo banco
	 */
	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TarjetaCredito [id=");
		builder.append(id);
		builder.append(", numeroTarjeta=");
		builder.append(numeroTarjeta);
		builder.append(", mesExpiracion=");
		builder.append(mesExpiracion);
		builder.append(", anioExpiracion=");
		builder.append(anioExpiracion);
		builder.append(", numeroSeguridad=");
		builder.append(numeroSeguridad);
		builder.append(", tipoTarjeta=");
		builder.append(tipoTarjeta);
		builder.append(", banco=");
		builder.append(banco);
		builder.append("]");
		return builder.toString();
	}

}
