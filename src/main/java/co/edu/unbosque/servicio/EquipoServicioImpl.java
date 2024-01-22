package co.edu.unbosque.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entidad.Equipo;
import co.edu.unbosque.repositorio.EquipoRepositorio;

@Service
public class EquipoServicioImpl implements EquipoServicio{
	
	@Autowired
	private EquipoRepositorio repositorio;

	@Override
	public Equipo traerEquipoConAvion(int idAvion) {
		return repositorio.traerEquipoConAvion(idAvion);
	}

}
