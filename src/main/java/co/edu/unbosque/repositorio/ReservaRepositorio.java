package co.edu.unbosque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entidad.Reserva;
import co.edu.unbosque.entidad.Usuario;

@Repository
public interface ReservaRepositorio  extends JpaRepository<Usuario, Integer>{
	
	@Query("SELECT r FROM Reserva r WHERE r.fkUsuario = :idUsuario AND r.fkVuelo = :idVuelo")
	Reserva obtenerReservasPorIdUsuario(@Param("idUsuario") int idUsuario, @Param("idVuelo") int idVuelo);
	
	@Query("SELECT r FROM Reserva r " +
	           "JOIN Usuario u ON r.fkUsuario = u.idUsuario " +
	           "JOIN Vuelo v ON r.fkVuelo = v.idVuelo " +
	           "WHERE u.idUsuario = :idUsuario " +
	           "AND v.origen = :origen " +
	           "AND v.destino = :destino")
	Reserva encontrarReservaPorUsuarioYVuelo(@Param("idUsuario") int idUsuario,
	                                             @Param("origen") String origen,
	                                             @Param("destino") String destino);

	
	@Modifying	
    @Query("UPDATE Reserva r SET r.preferenciaComida = :preferenciaComida WHERE r.idReserva = :idReserva")
    void actualizarPreferenciaComida(@Param("idReserva") int idReserva, @Param("preferenciaComida") String preferenciaComida);

	@Modifying
	@Query("UPDATE Reserva r SET r.fkVuelo = :idVuelo WHERE r.idReserva = :idReserva")
	void actualizarVueloUsuario(@Param("idVuelo") int idVuelo, @Param("idReserva") int idReserva);
	
	@Modifying
	@Query("UPDATE Reserva r SET r.reservaActiva = 0 WHERE r.idReserva = :idReserva")
	void actualizarReservaActiva(@Param("idReserva") int idReserva);
	
	@Modifying
	@Query("UPDATE Reserva r SET r.cantMaletas = :cantMaletas WHERE r.idReserva = :idReserva")
	void actualizarCantMaletas(@Param("idReserva") int idReserva, @Param("cantMaletas") int cantMaletas);
	
	@Modifying
	@Query("UPDATE Reserva r SET r.precioReserva = :nuevoPrecio WHERE r.idReserva = :idReserva")
	void actualizarPrecioReserva(@Param("idReserva") int idReserva, @Param("nuevoPrecio") double nuevoPrecio);
	
	@Modifying
	@Query("UPDATE Reserva r SET r.cantReservas = :cantPersonas WHERE r.idReserva = :idReserva")
	void actualizarCantReservas(@Param("idReserva")int idReserva, @Param("cantPersonas")int cantPersonas);

	@Query("SELECT r FROM Reserva r WHERE r.booking = :booking")
	Reserva encontrarReservaPorBooking(@Param("booking")int booking);
	
	
	@Modifying
	@Query("UPDATE Reserva r SET r.nombreTitular =:nombre, r.apellidoTitular =:apellido WHERE r.idReserva =:idReserva")
	void actualizarTitular(@Param("idReserva") int idReserva, @Param("nombre")String nombre, @Param("apellido")String apellido);
	
}
