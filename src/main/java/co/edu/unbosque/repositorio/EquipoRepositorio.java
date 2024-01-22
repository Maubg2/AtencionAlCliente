package co.edu.unbosque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entidad.Equipo;

@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo, Integer>{
	
	@Query("SELECT e FROM Equipo e "
			+ "INNER JOIN Avion a ON e.idEquipo = a.fkEquipo "
			+ "WHERE a.idAvion = :idAvion")
	Equipo traerEquipoConAvion(@Param("idAvion")int idAvion);

}
