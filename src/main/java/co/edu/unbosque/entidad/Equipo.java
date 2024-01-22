package co.edu.unbosque.entidad;

import javax.persistence.*;


@Entity
@Table(name = "equipo")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_equipo")
	private int idEquipo;

	@Column(name="cant_ayudantes")
	private int cantAyudantes;

	@Column(name="nombre_copiloto")
	private String nombreCopiloto;

	@Column(name="nombre_piloto")
	private String nombrePiloto;

	public Equipo() {
	}

	public int getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public int getCantAyudantes() {
		return this.cantAyudantes;
	}

	public void setCantAyudantes(int cantAyudantes) {
		this.cantAyudantes = cantAyudantes;
	}

	public String getNombreCopiloto() {
		return this.nombreCopiloto;
	}

	public void setNombreCopiloto(String nombreCopiloto) {
		this.nombreCopiloto = nombreCopiloto;
	}

	public String getNombrePiloto() {
		return this.nombrePiloto;
	}

	public void setNombrePiloto(String nombrePiloto) {
		this.nombrePiloto = nombrePiloto;
	}

}