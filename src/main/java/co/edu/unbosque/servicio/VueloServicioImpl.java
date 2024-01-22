package co.edu.unbosque.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entidad.Vuelo;
import co.edu.unbosque.repositorio.VueloRepositorio;

@Service
public class VueloServicioImpl implements VueloServicio{
	
	@Autowired
	private VueloRepositorio repositorio;

	/*@Override
	public Vuelo encontrarVueloPorUsername(String username) {
		return repositorio.encontrarVueloPorUsername(username);
	}*/

	@Override
	public Vuelo obtenerVueloPorUsuarioYRuta(String username, String origen, String destino) {
		return repositorio.obtenerVueloPorUsuarioYRuta(username, origen, destino);
	}

	@Override
	public List<Vuelo> obtenerVuelosDisponibles(Date fechaDespegueActual, String origen, String destino) {
		return repositorio.obtenerVuelosDisponibles(fechaDespegueActual, origen, destino);
	}

	@Override
	public Vuelo obtenerVueloPorBooking(int booking) {
		return repositorio.obtenerVueloPorBooking(booking);
	}

}
