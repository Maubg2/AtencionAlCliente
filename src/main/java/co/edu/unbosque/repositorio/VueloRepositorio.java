package co.edu.unbosque.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entidad.Usuario;
import co.edu.unbosque.entidad.Vuelo;

@Repository
public interface VueloRepositorio extends JpaRepository<Usuario, Integer>{
	
/*	 @Query("SELECT v FROM Vuelo v " +
	           "JOIN Reserva r ON v.idVuelo = r.fkVuelo " +
	           "JOIN Usuario u ON r.fkUsuario = u.idUsuario " +
	           "WHERE u.username = :username")
	 Vuelo encontrarVueloPorUsername(@Param("username") String username);
	 */
	 @Query("SELECT v FROM Vuelo v " +
	           "JOIN Avion a ON v.fkAvion = a.idAvion " +
	           "JOIN Reserva r ON v.idVuelo = r.fkVuelo " +
	           "JOIN Usuario u ON r.fkUsuario = u.idUsuario " +
	           "WHERE u.username = :username AND v.origen = :origen AND v.destino = :destino")
	 Vuelo obtenerVueloPorUsuarioYRuta(@Param("username") String username, 
	                                      @Param("origen") String origen, 
	                                      @Param("destino") String destino);
	 
	 @Query("SELECT v FROM Vuelo v WHERE v.fechaDespegue > :fechaDespegueActual AND v.origen = :origen AND v.destino = :destino")
	 List<Vuelo> obtenerVuelosDisponibles(@Param("fechaDespegueActual") Date fechaDespegueActual, @Param("origen") String origen, @Param("destino") String destino);

	 @Query("SELECT v FROM Vuelo v "
	 		+ "INNER JOIN Reserva r ON r.fkVuelo = v.idVuelo "
	 		+ "WHERE r.booking=:booking")
	 Vuelo obtenerVueloPorBooking(@Param("booking")int booking);
	 
	 
/*	 @Query("SELECT v FROM Vuelo v "
		 		+ "INNER JOIN Reserva r ON r.fkVuelo = v.idVuelo "
		 		+ "WHERE v.fechaDespegue > :fechaDespegueActual AND r.booking=:booking")
	 List<Vuelo> obtenerVuelosDisponibles(@Param("fechaDespegueActual") Date fechaDespegueActual, @Param("booking") int booking);
	*/ 
}
