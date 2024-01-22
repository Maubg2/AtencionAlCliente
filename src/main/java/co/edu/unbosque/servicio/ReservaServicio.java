package co.edu.unbosque.servicio;

import co.edu.unbosque.entidad.Reserva;

public interface ReservaServicio {
	
	Reserva obtenerReservasPorIdUsuario(int idUsuario, int idVuelo);
	
	Reserva encontrarReservaPorUsuarioYVuelo(int idUsuario, String origen, String destino);
	
	void actualizarPreferenciaComida(int id, String preferenciaComida);
	
	void actualizarVueloUsuario(int idVuelo, int idReserva);
	
	void actualizarReservaActiva(int idReserva);

	void actualizarCantMaletas(int idReserva, int cantMaletas);
	
	void actualizarPrecioReserva(int idReserva, double nuevoPrecio);
	
	void actualizarCantReservas(int idReserva, int cantPersonas);
	
	Reserva encontrarReservaPorBooking (int booking);
	
	void actualizarTitular(int id, String nombre, String apellido);
	
}
