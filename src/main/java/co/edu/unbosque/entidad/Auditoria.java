package co.edu.unbosque.entidad;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "auditoria")
public class Auditoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_auditoria")
	private int idAuditoria;

	@Column(name = "asunto")
	private String asunto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "resultado")
	private String resultado;

	public Auditoria() {
	}

	public int getIdAuditoria() {
		return this.idAuditoria;
	}

	public void setIdAuditoria(int idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Date getFechaAuditoria() {
		return this.fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}