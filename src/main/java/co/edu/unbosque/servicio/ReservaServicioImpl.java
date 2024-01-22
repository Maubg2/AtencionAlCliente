package co.edu.unbosque.servicio;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entidad.Reserva;
import co.edu.unbosque.repositorio.ReservaRepositorio;

@Service
public class ReservaServicioImpl implements ReservaServicio{

	@Autowired
	private ReservaRepositorio repositorio;

	@Override
	public Reserva obtenerReservasPorIdUsuario(int idUsuario, int idVuelo) {
		return repositorio.obtenerReservasPorIdUsuario(idUsuario, idVuelo);
	}
	
	@Override
	public Reserva encontrarReservaPorUsuarioYVuelo(int idUsuario, String origen, String destino) {
		return repositorio.encontrarReservaPorUsuarioYVuelo(idUsuario, origen, destino);
	}

	@Transactional
	@Override
	public void actualizarPreferenciaComida(int id, String preferenciaComida) {
		repositorio.actualizarPreferenciaComida(id, preferenciaComida);
	}

	@Transactional
	@Override
	public void actualizarVueloUsuario(int idVuelo, int idReserva) {
		repositorio.actualizarVueloUsuario(idVuelo, idReserva);
	}

	@Transactional
	@Override
	public void actualizarReservaActiva(int idReserva) {
		repositorio.actualizarReservaActiva(idReserva);
	}

	@Transactional
	@Override
	public void actualizarCantMaletas(int idReserva, int cantMaletas) {
		repositorio.actualizarCantMaletas(idReserva, cantMaletas);
	}

	@Transactional
	@Override
	public void actualizarPrecioReserva(int idReserva, double nuevoPrecio) {
		repositorio.actualizarPrecioReserva(idReserva, nuevoPrecio);
	}

	@Transactional
	@Override
	public void actualizarCantReservas(int idReserva, int cantPersonas) {
		repositorio.actualizarCantReservas(idReserva, cantPersonas);
	}

	@Override
	public Reserva encontrarReservaPorBooking(int booking) {
		return repositorio.encontrarReservaPorBooking(booking);
	}

	@Transactional
	@Override
	public void actualizarTitular(int id, String nombre, String apellido) {
		repositorio.actualizarTitular(id, nombre, apellido);
	}

}
