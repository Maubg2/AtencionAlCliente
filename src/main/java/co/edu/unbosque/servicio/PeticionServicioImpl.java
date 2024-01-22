package co.edu.unbosque.servicio;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entidad.Peticion;
import co.edu.unbosque.repositorio.PeticionRepositorio;

@Service
public class PeticionServicioImpl implements PeticionServicio{
	
	@Autowired
	private PeticionRepositorio repositorio;

	@Override
	public List<Peticion> obtenerPeticionesPorUsername(String username) {
		return repositorio.obtenerPeticionesPorUsername(username);
	}

	@Override
	public Peticion obtenerPeticionesPorId(int id) {
		return repositorio.obtenerPeticionesPorId(id);
	}

	@Transactional
	@Override
	public void actualizarPreferenciaComida(int id, String preferenciaComida) {
		repositorio.actualizarPreferenciaComida(id, preferenciaComida);
	}

	@Transactional
	@Override
	public void actualizarFechaVuelo(Date cambioHoraVuelo, int idPeticion) {
		repositorio.actualizarFechaVuelo(cambioHoraVuelo, idPeticion);
	}

	@Transactional
	@Override
	public void actualizarCancelarReserva(int idReserva) {
		repositorio.actualizarCancelarReserva(idReserva);
	}

	@Transactional
	@Override
	public void actualizarCantMaletas(int idReserva) {
		repositorio.actualizarCantMaletas(idReserva);
	}

	@Transactional
	@Override
	public void actualizarTitularPeticion(int idReserva, String nombre, String apellido) {
		repositorio.actualizarTitularPeticion(idReserva, nombre, apellido);
	}

	@Transactional
	@Override
	public void actualizarCantPersonas(int idPeticion, int cantPersonas) {
		repositorio.actualizarCantPersonas(idPeticion, cantPersonas);
	}

	@Override
	public List<Peticion> obtenerPeticionPorBooking(int booking) {
		return repositorio.obtenerPeticionPorBooking(booking);
	}

}
