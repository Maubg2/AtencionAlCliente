package co.edu.unbosque.entidad;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "peticion")
public class Peticion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_peticion")
	private int idPeticion;

	@Column(name="agregar_maletas")
	private int agregarMaletas;

	@Column(name="agregar_persona")
	private int agregarPersona;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cambio_hora_vuelo")
	private Date cambioHoraVuelo;

	@Column(name="cambio_titular")
	private String cambioTitular;

	@Column(name="cancelar_reserva")
	private boolean cancelarReserva;
	
	@Column(name="preferencia_comida")
	private String preferenciaComida;
	
	@Column(name = "fk_usuario")
	private int fkUsuario; 
	
	@Column(name = "cambio_titular_apellido")
	private String cambioTitularApellido;
	
	@Column(name = "fk_reserva")
	private int fkReserva;

	public Peticion() {
	}

	public int getIdPeticion() {
		return this.idPeticion;
	}

	public void setIdPeticion(int idPeticion) {
		this.idPeticion = idPeticion;
	}

	public int getAgregarMaletas() {
		return this.agregarMaletas;
	}

	public void setAgregarMaletas(int agregarMaletas) {
		this.agregarMaletas = agregarMaletas;
	}

	public int getAgregarPersona() {
		return this.agregarPersona;
	}

	public void setAgregarPersona(int agregarPersona) {
		this.agregarPersona = agregarPersona;
	}

	public Date getCambioHoraVuelo() {
		return this.cambioHoraVuelo;
	}

	public void setCambioHoraVuelo(Date cambioHoraVuelo) {
		this.cambioHoraVuelo = cambioHoraVuelo;
	}

	public String getCambioTitular() {
		return this.cambioTitular;
	}

	public void setCambioTitular(String cambioTitular) {
		this.cambioTitular = cambioTitular;
	}

	public boolean getCancelarReserva() {
		return this.cancelarReserva;
	}

	public void setCancelarReserva(boolean cancelarReserva) {
		this.cancelarReserva = cancelarReserva;
	}

	public String getPreferenciaComida() {
		return this.preferenciaComida;
	}

	public void setPreferenciaComida(String preferenciaComida) {
		this.preferenciaComida = preferenciaComida;
	}

	public int getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(int fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public String getCambioTitularApellido() {
		return cambioTitularApellido;
	}

	public void setCambioTitularApellido(String cambioTitularApellido) {
		this.cambioTitularApellido = cambioTitularApellido;
	}

	public int getFkReserva() {
		return fkReserva;
	}

	public void setFkReserva(int fkReserva) {
		this.fkReserva = fkReserva;
	}

}