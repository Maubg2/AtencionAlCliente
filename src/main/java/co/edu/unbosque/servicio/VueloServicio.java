package co.edu.unbosque.servicio;

import java.util.Date;
import java.util.List;

import co.edu.unbosque.entidad.Vuelo;

public interface VueloServicio {
	
//	Vuelo encontrarVueloPorUsername(String username);
	
	Vuelo obtenerVueloPorUsuarioYRuta(String username, String origen, String destino);
	
	List<Vuelo> obtenerVuelosDisponibles(Date fechaDespegueActual, String origen, String destino);

	Vuelo obtenerVueloPorBooking(int booking);
	
}
