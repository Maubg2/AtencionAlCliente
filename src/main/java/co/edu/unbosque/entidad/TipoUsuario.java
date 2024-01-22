package co.edu.unbosque.entidad;

import javax.persistence.*;


@Entity
@Table(name="tipo_usuario")
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo_usuario")
	private int idTipoUsuario;

	@Column(name = "tipo")
	private String tipo;

	public TipoUsuario() {
	}

	public int getIdTipoUsuario() {
		return this.idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}