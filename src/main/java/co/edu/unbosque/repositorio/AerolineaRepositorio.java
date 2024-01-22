package co.edu.unbosque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entidad.Aerolinea;

@Repository
public interface AerolineaRepositorio extends JpaRepository<Aerolinea, Integer>{
	
	@Query("SELECT a FROM Aerolinea a "
			+ "INNER JOIN Avion av ON av.fkAerolinea = a.idAerolinea "
			+ "WHERE av.idAvion =:idAvion")
	Aerolinea traerAerolineaConAvion(@Param("idAvion")int idAvion);

}
