package co.edu.unbosque.servicio;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entidad.Usuario;
import co.edu.unbosque.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public List<Usuario> listarTodosLosUsuarios() {
		return usuarioRepositorio.findAll();
	}
	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}
	
	@Override
    public boolean validarCredenciales(String username, String contrasena) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findByUsername(username);
        return usuarioOptional.map(usuario -> usuario.getContrasena().equals(contrasena)).orElse(false);
    }
	@Override
	public Usuario traerUsuario(String username) {
		return usuarioRepositorio.findByUsername1(username);
	}
	@Override
	public boolean tieneVueloPendienteConCiudades(String username, String origen, String destino) {
		return usuarioRepositorio.tieneVueloPendienteConCiudades(username, origen, destino);
	}
	@Override
	public Usuario buscarPorIdPeticion(int idPeticion) {
		return usuarioRepositorio.buscarPorIdPeticion(idPeticion);
	}
	
	@Override
	public List<Usuario> buscarUsuarios(String criterio) {
        List<Usuario> todosLosUsuarios = listarTodosLosUsuarios();
        List<Usuario> usuariosFiltrados = new ArrayList<Usuario>();

        for (Usuario usuario : todosLosUsuarios) {
            if (contieneCriterio(usuario, criterio)) {
                usuariosFiltrados.add(usuario);
            }
        }

        return usuariosFiltrados;
    }

    private boolean contieneCriterio(Usuario usuario, String criterio) {
        return usuario.getNombreUsuario().contains(criterio) ||
                usuario.getApellidoUsuario().contains(criterio) ||
                usuario.getUsername().contains(criterio);
    }
	
	
	
/*	@Transactional
	@Override
	public void actualizarTitular(int id, String nombre, String apellido) {
		usuarioRepositorio.actualizarTitular(id, nombre, apellido);
	}*/
}
