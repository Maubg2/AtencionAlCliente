package co.edu.unbosque.entidad;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="apellido_usuario")
	private String apellidoUsuario;

	@Column(name = "contrasena")
	private String contrasena;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	@Column(name = "username")
	private String username;
	
	@Column(name = "fk_tipo_usuario")
	private int fkTipoUsuario;
	
	/*	@Column(name="id_peticion")
	private int idPeticion;

	@Column(name="id_reserva")
	private int idReserva;

	@Column(name="id_tipo_usuario")
	private int idTipoUsuario;
*/
	
	public Usuario() {
	}
	
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidoUsuario() {
		return this.apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getFkTipoUsuario() {
		return fkTipoUsuario;
	}

	public void setFkTipoUsuario(int fkTipoUsuario) {
		this.fkTipoUsuario = fkTipoUsuario;
	}
	
	
	/*
	public int getIdPeticion() {
		return this.idPeticion;
	}

	public void setIdPeticion(int idPeticion) {
		this.idPeticion = idPeticion;
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdTipoUsuario() {
		return this.idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
*/

}