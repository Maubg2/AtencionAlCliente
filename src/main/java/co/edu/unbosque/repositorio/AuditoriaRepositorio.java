package co.edu.unbosque.repositorio;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entidad.Auditoria;

@Repository
public interface AuditoriaRepositorio extends JpaRepository<Auditoria, Integer>{
	
	@Modifying
	@Query(value = "INSERT INTO Auditoria VALUES (:id, :asunto, :fecha, :resultado)", nativeQuery = true)
	@Transactional
	void crearAuditoria(@Param("id")int id, @Param("asunto")String asunto, @Param("fecha")Date fecha, @Param("resultado")String resultado);

	@Query("SELECT a FROM Auditoria a")
    List<Auditoria> obtenerListaDeAuditorias();
	
}
