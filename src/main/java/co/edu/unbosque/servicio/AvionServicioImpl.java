package co.edu.unbosque.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entidad.Avion;
import co.edu.unbosque.repositorio.AvionRepositorio;

@Service
public class AvionServicioImpl implements AvionServicio{
	
	@Autowired
	private AvionRepositorio repositorio;

	@Override
	public Avion traerAvionConReserva(int idReserva) {
		return repositorio.traerAvionConReserva(idReserva);
	}

}
