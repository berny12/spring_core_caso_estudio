/**
 * Cliente.java
 * Copyright (c) SynergyJ. 
 * Todos los derechos reservados.
 *
 * Este software pueder ser mofificado ó utilizado
 * haciendo referencia al autor intelectual.
 */
package com.synergyj.bookmule.core.domain;

import java.io.Serializable;
import java.util.Set;

import com.synergyj.bookmule.core.domain.catalog.TipoCliente;

/**
 * Entidad que contiene los datos de los usuarios
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 * @version 1.0
 */
public class Cliente implements Serializable {

	private static final long serialVersionUID = 6029943144227793393L;

	private Long id;

	private String nombre;

	private String apellidoPaterno;

	private String apellidoMaterno;

	private String email;

	private String rfc;

	private String telefono;

	private String direccion;

	private String usuario;

	private String password;

	private String confirmacionPassword;

	private Set<TarjetaCredito> tarjetasCredito;

	private TipoCliente tipoCliente;

	private Long clienteFrecuenteId;

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
	 * @return apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno para inicializar el atributo apellidoPaterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno para inicializar el atributo apellidoMaterno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email para inicializar el atributo email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc para inicializar el atributo rfc
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono para inicializar el atributo telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion para inicializar el atributo direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario para inicializar el atributo usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password para inicializar el atributo password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return confirmacionPassword
	 */
	public String getConfirmacionPassword() {
		return confirmacionPassword;
	}

	/**
	 * @param confirmacionPassword para inicializar el atributo confirmacionPassword
	 */
	public void setConfirmacionPassword(String confirmacionPassword) {
		this.confirmacionPassword = confirmacionPassword;
	}

	/**
	 * @return tarjetasCredito
	 */
	public Set<TarjetaCredito> getTarjetasCredito() {
		return tarjetasCredito;
	}

	/**
	 * @param tarjetasCredito para inicializar el atributo tarjetasCredito
	 */
	public void setTarjetasCredito(Set<TarjetaCredito> tarjetasCredito) {
		this.tarjetasCredito = tarjetasCredito;
	}

	/**
	 * @return tipoCliente
	 */
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	/**
	 * @param tipoCliente para inicializar el atributo tipoCliente
	 */
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	/**
	 * @return clienteFrecuenteId
	 */
	public Long getClienteFrecuenteId() {
		return clienteFrecuenteId;
	}

	/**
	 * @param clienteFrecuenteId para inicializar el atributo clienteFrecuenteId
	 */
	public void setClienteFrecuenteId(Long clienteFrecuenteId) {
		this.clienteFrecuenteId = clienteFrecuenteId;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", email=");
		builder.append(email);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", password=");
		builder.append(password);
		builder.append(", confirmacionPassword=");
		builder.append(confirmacionPassword);
		builder.append(", tarjetasCredito=");
		builder.append(tarjetasCredito);
		builder.append(", tipoCliente=");
		builder.append(tipoCliente);
		builder.append(", clienteFrecuenteId=");
		builder.append(clienteFrecuenteId);
		builder.append("]");
		return builder.toString();
	}

}
