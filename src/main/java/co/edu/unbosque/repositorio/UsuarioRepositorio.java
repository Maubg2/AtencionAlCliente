package co.edu.unbosque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entidad.Reserva;
import co.edu.unbosque.entidad.Usuario;
import co.edu.unbosque.entidad.Vuelo;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio  extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByUsername(String username);
	
	@Query("SELECT u FROM Usuario u WHERE u.username = :username")
	Usuario findByUsername1(@Param("username")String username);
	
	 @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END " +
	           "FROM Reserva r " +
	           "JOIN Vuelo v ON r.fkVuelo = v.idVuelo " +
	           "JOIN Usuario u ON r.fkUsuario = u.idUsuario " +
	           "WHERE u.username = :username " +
	           "AND v.origen = :origen " +
	           "AND v.destino = :destino")
	 boolean tieneVueloPendienteConCiudades(@Param("username") String username,
	                                   @Param("origen") String origen,
	                                   @Param("destino") String destino);
	 
	 @Query("SELECT u FROM Usuario u "+
			 	"JOIN Peticion p on u.idUsuario = p.fkUsuario WHERE p.idPeticion = :idPeticion")
	 Usuario buscarPorIdPeticion(@Param("idPeticion") int idPeticion);
	 
	 
/*	 @Modifying
	 @Query("UPDATE Usuario u SET u.nombreUsuario =:nombre, u.apellidoUsuario =:apellido WHERE u.idUsuario =:idUsuario")
	 void actualizarTitular(@Param("idUsuario") int idUsuario, @Param("nombre")String nombre, @Param("apellido")String apellido);
	*/
	 
}
