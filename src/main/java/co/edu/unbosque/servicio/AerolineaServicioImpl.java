package co.edu.unbosque.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entidad.Aerolinea;
import co.edu.unbosque.repositorio.AerolineaRepositorio;

@Service
public class AerolineaServicioImpl implements AerolineaServicio{
	
	@Autowired
	private AerolineaRepositorio repositorio;

	@Override
	public Aerolinea traerAerolineaConAvion(int idAvion) {
		return repositorio.traerAerolineaConAvion(idAvion);
	}

}
