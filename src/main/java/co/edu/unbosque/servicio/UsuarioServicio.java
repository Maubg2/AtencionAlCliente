package co.edu.unbosque.servicio;

import java.util.List;

import co.edu.unbosque.entidad.Peticion;
import co.edu.unbosque.entidad.Reserva;
import co.edu.unbosque.entidad.Usuario;


public interface UsuarioServicio {
	
	public List<Usuario> listarTodosLosUsuarios();
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public boolean validarCredenciales(String username, String contrasena);
	
	public Usuario traerUsuario(String username);
	
	public boolean tieneVueloPendienteConCiudades(String username, String origen, String destino);
	
	public Usuario buscarPorIdPeticion(int idPeticion);
	
	public List<Usuario> buscarUsuarios(String criterio);
	
	
}
