package co.edu.unbosque.entidad;

import javax.persistence.*;


@Entity
@Table(name = "reserva")
public class Reserva  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_reserva")
	private int idReserva;

	@Column(name="cant_reservas")
	private int cantReservas;

	@Column(name="precio_reserva")
	private double precioReserva;
	
	@Column(name = "fk_usuario")
	private int fkUsuario;
	
	@Column(name = "fk_vuelo")
	private int fkVuelo;
	
	@Column(name = "cant_maletas")
	private int cantMaletas;
	
	@Column(name = "preferencia_comida")
	private String preferenciaComida;
	
	@Column(name = "reserva_activa")
	private boolean reservaActiva;
	
	@Column(name = "nombre_titular")
	private String nombreTitular;
	
	@Column(name = "apellido_titular")
	private String apellidoTitular;
	
	@Column(name = "booking")
	private int booking;

	public Reserva() {
	}

	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getCantReservas() {
		return this.cantReservas;
	}

	public void setCantReservas(int cantReservas) {
		this.cantReservas = cantReservas;
	}

	public double getPrecioReserva() {
		return this.precioReserva;
	}

	public void setPrecioReserva(double precioReserva) {
		this.precioReserva = precioReserva;
	}

	public int getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(int fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public int getFkVuelo() {
		return fkVuelo;
	}

	public void setFkVuelo(int fkVuelo) {
		this.fkVuelo = fkVuelo;
	}

	public int getCantMaletas() {
		return cantMaletas;
	}

	public void setCantMaletas(int cantMaletas) {
		this.cantMaletas = cantMaletas;
	}

	public String getPreferenciaComida() {
		return preferenciaComida;
	}

	public void setPreferenciaComida(String preferenciaComida) {
		this.preferenciaComida = preferenciaComida;
	}

	public boolean getReservaActiva() {
		return reservaActiva;
	}

	public void setReservaActiva(boolean reservaActiva) {
		this.reservaActiva = reservaActiva;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getApellidoTitular() {
		return apellidoTitular;
	}

	public void setApellidoTitular(String apellidoTitular) {
		this.apellidoTitular = apellidoTitular;
	}

	public int getBooking() {
		return booking;
	}

	public void setBooking(int booking) {
		this.booking = booking;
	}

}