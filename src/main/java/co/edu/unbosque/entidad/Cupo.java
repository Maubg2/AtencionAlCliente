package co.edu.unbosque.entidad;

import javax.persistence.*;


@Entity
@Table(name = "cupo")
public class Cupo  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cupo")
	private int idCupo;

	@Column(name="cant_max_maletas")
	private int cantMaxMaletas;

	@Column(name="cant_max_tripulantes")
	private int cantMaxTripulantes;

	public Cupo() {
	}

	public int getIdCupo() {
		return this.idCupo;
	}

	public void setIdCupo(int idCupo) {
		this.idCupo = idCupo;
	}

	public int getCantMaxMaletas() {
		return this.cantMaxMaletas;
	}

	public void setCantMaxMaletas(int cantMaxMaletas) {
		this.cantMaxMaletas = cantMaxMaletas;
	}

	public int getCantMaxTripulantes() {
		return this.cantMaxTripulantes;
	}

	public void setCantMaxTripulantes(int cantMaxTripulantes) {
		this.cantMaxTripulantes = cantMaxTripulantes;
	}

}