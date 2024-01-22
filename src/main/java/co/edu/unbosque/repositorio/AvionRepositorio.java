package co.edu.unbosque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entidad.Avion;

@Repository
public interface AvionRepositorio extends JpaRepository<Avion, Integer>{
	
	@Query("SELECT a FROM Avion a "
			+ "JOIN Vuelo v ON v.fkAvion = a.idAvion "
			+ "JOIN Reserva r ON r.fkVuelo = v.idVuelo "
			+ "WHERE r.idReserva = :idReserva")
	Avion traerAvionConReserva(@Param("idReserva")int idReserva);

}
