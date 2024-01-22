package co.edu.unbosque.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entidad.Auditoria;
import co.edu.unbosque.repositorio.AuditoriaRepositorio;

@Service
public class AuditoriaServicioImpl implements AuditoriaServicio{
	
	@Autowired
	AuditoriaRepositorio repositorio;

	@Override
	public void crearAuditoria(int id, String asunto, Date fecha, String resultado) {
		repositorio.crearAuditoria(id, asunto, fecha, resultado);
	}

	@Override
	public List<Auditoria> obtenerListaDeAuditorias() {
		return repositorio.obtenerListaDeAuditorias();
	}

}
