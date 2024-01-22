package co.edu.unbosque.entidad;

import javax.persistence.*;


@Entity
@Table(name = "aerolinea")
public class Aerolinea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_aerolinea")
	private int idAerolinea;

	@Column(name="nombre_aerolinea")
	private String nombreAerolinea;

	public Aerolinea() {
	}

	public int getIdAerolinea() {
		return this.idAerolinea;
	}

	public void setIdAerolinea(int idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

	public String getNombreAerolinea() {
		return this.nombreAerolinea;
	}

	public void setNombreAerolinea(String nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}

}