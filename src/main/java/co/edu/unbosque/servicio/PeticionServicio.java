package co.edu.unbosque.servicio;

import java.util.Date;
import java.util.List;

import co.edu.unbosque.entidad.Peticion;

public interface PeticionServicio {
	
	List<Peticion> obtenerPeticionesPorUsername(String username);
	
	Peticion obtenerPeticionesPorId(int id);
	
	void actualizarPreferenciaComida(int id, String preferenciaComida);
	
	void actualizarFechaVuelo(Date cambioHoraVuelo, int idPeticion);
	
	void actualizarCancelarReserva(int idPeticion);
	
	void actualizarCantMaletas(int idPeticion);
	
	void actualizarTitularPeticion(int idPeticion, String nombre, String apellido);
	
	void actualizarCantPersonas(int idPeticion, int cantPersonas);
	
	List<Peticion> obtenerPeticionPorBooking(int booking);
	
}
