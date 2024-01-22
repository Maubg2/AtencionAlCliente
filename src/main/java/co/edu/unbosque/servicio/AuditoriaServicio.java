package co.edu.unbosque.servicio;

import java.util.Date;
import java.util.List;

import co.edu.unbosque.entidad.Auditoria;

public interface AuditoriaServicio {
	
	public void crearAuditoria(int id, String asunto, Date fecha, String resultado);

	public List<Auditoria> obtenerListaDeAuditorias();
	
	
}
