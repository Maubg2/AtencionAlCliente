package co.edu.unbosque.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entidad.Peticion;
import co.edu.unbosque.entidad.Usuario;

@Repository
public interface PeticionRepositorio extends JpaRepository<Usuario, Integer>{
	
	@Query("SELECT p FROM Peticion p " +
	           "JOIN Usuario u ON p.fkUsuario = u.idUsuario " +
	           "WHERE u.username = :username")
	List <Peticion> obtenerPeticionesPorUsername(@Param("username") String username);
	
	@Query("SELECT p FROM Peticion p "+
				"JOIN Usuario u ON p.fkUsuario = u.idUsuario "+
				"WHERE p.idPeticion = :id")
	Peticion obtenerPeticionesPorId(@Param("id") int id);
	
	@Modifying	
    @Query("UPDATE Peticion p SET p.preferenciaComida = :preferenciaComida WHERE p.idPeticion = :idPeticion")
    void actualizarPreferenciaComida(@Param("idPeticion") int idPeticion, @Param("preferenciaComida") String preferenciaComida);

	@Modifying
	@Query("UPDATE Peticion p SET p.cambioHoraVuelo = :cambioHoraVuelo WHERE p.idPeticion = :idPeticion")
	void actualizarFechaVuelo(@Param("cambioHoraVuelo") Date cambioHoraVuelo, @Param("idPeticion") int idPeticion);
	
	@Modifying
	@Query("UPDATE Peticion p SET p.cancelarReserva = 0 WHERE p.idPeticion = :idPeticion")
	void actualizarCancelarReserva(@Param("idPeticion") int idPeticion);
	
	@Modifying
	@Query("UPDATE Peticion p SET p.agregarMaletas = 0 WHERE p.idPeticion = :idPeticion")
	void actualizarCantMaletas(@Param("idPeticion") int idPeticion);
	
	@Modifying
	@Query("UPDATE Peticion p SET p.cambioTitular=:nombre, p.cambioTitularApellido=:apellido WHERE p.idPeticion=:idPeticion")
	void actualizarTitularPeticion(@Param("idPeticion") int idPeticion, @Param("nombre")String nombre, @Param("apellido")String apellido);

	@Modifying
	@Query("UPDATE Peticion p SET p.agregarPersona=:cantPersonas WHERE p.idPeticion =:idPeticion")
	void actualizarCantPersonas(@Param("idPeticion")int idPeticion, @Param("cantPersonas")int cantPersonas);

	
	@Query("SELECT p FROM Peticion p "
			+ "INNER JOIN Reserva r ON r.idReserva = p.fkReserva "
			+ "WHERE r.booking = :booking")
	List<Peticion> obtenerPeticionPorBooking(@Param("booking")int booking);
	
	
}
