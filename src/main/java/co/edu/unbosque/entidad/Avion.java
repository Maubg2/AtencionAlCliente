package co.edu.unbosque.entidad;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "avion")
public class Avion  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_avion")
	private int idAvion;

	@Column(name="marca_avion")
	private String marcaAvion;
	
	@Column(name = "fk_equipo")
	private int fkEquipo;
	
	@Column(name = "fk_cupo")
	private int fkCupo;
	
	@Column(name = "fk_aerolinea")
	private int fkAerolinea;

	public Avion() {
	}

	public int getIdAvion() {
		return this.idAvion;
	}

	public void setIdAvion(int idAvion) {
		this.idAvion = idAvion;
	}


	public String getMarcaAvion() {
		return this.marcaAvion;
	}

	public void setMarcaAvion(String marcaAvion) {
		this.marcaAvion = marcaAvion;
	}

	public int getFkEquipo() {
		return fkEquipo;
	}

	public void setFkEquipo(int fkEquipo) {
		this.fkEquipo = fkEquipo;
	}

	public int getFkCupo() {
		return fkCupo;
	}

	public void setFkCupo(int fkCupo) {
		this.fkCupo = fkCupo;
	}

	public int getFkAerolinea() {
		return fkAerolinea;
	}

	public void setFkAerolinea(int fkAerolinea) {
		this.fkAerolinea = fkAerolinea;
	}

}