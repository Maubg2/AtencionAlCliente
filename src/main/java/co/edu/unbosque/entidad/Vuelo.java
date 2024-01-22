package co.edu.unbosque.entidad;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "vuelo")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_vuelo")
	private int idVuelo;

	@Column(name = "destino")
	private String destino;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_despegue")
	private Date fechaDespegue;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_llegada")
	private Date fechaLlegada;

	@Column(name="nombre_vuelo")
	private String nombreVuelo;

	@Column(name = "origen")
	private String origen;

	@Column(name="tiempo_vuelo")
	private float tiempoVuelo;
	
	@Column(name = "fk_avion")
	private int fkAvion;

	public Vuelo() {
	}

	public int getIdVuelo() {
		return this.idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getFechaDespegue() {
		return this.fechaDespegue;
	}

	public void setFechaDespegue(Date fechaDespegue) {
		this.fechaDespegue = fechaDespegue;
	}

	public Date getFechaLlegada() {
		return this.fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public String getNombreVuelo() {
		return this.nombreVuelo;
	}

	public void setNombreVuelo(String nombreVuelo) {
		this.nombreVuelo = nombreVuelo;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public float getTiempoVuelo() {
		return this.tiempoVuelo;
	}

	public void setTiempoVuelo(float tiempoVuelo) {
		this.tiempoVuelo = tiempoVuelo;
	}

	public int getFkAvion() {
		return fkAvion;
	}

	public void setFkAvion(int fkAvion) {
		this.fkAvion = fkAvion;
	}

}