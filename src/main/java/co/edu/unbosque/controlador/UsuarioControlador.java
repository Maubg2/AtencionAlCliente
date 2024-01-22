package co.edu.unbosque.controlador;

import java.util.List;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.unbosque.entidad.Peticion;
import co.edu.unbosque.entidad.Reserva;
import co.edu.unbosque.entidad.Usuario;
import co.edu.unbosque.entidad.Vuelo;
import co.edu.unbosque.entidad.Aerolinea;
import co.edu.unbosque.entidad.Auditoria;
import co.edu.unbosque.entidad.Avion;
import co.edu.unbosque.entidad.Equipo;
import co.edu.unbosque.servicio.AerolineaServicio;
import co.edu.unbosque.servicio.AuditoriaServicio;
import co.edu.unbosque.servicio.PeticionServicio;
import co.edu.unbosque.servicio.ReservaServicio;
import co.edu.unbosque.servicio.UsuarioServicio;
import co.edu.unbosque.servicio.VueloServicio;
import co.edu.unbosque.servicio.AvionServicio;
import co.edu.unbosque.servicio.EquipoServicio;

@Controller
public class UsuarioControlador {
	
	private final UsuarioServicio usuarioServicio;
    private final VueloServicio vueloServicio;
    private final PeticionServicio peticionServicio;
    private final ReservaServicio reservaServicio;
    private final AuditoriaServicio auditoriaServicio;
    private final AvionServicio avionServicio;
    private final AerolineaServicio aerolineaServicio;
    private final EquipoServicio equipoServicio;

    @Autowired
    public UsuarioControlador(UsuarioServicio usuarioServicio,
                              VueloServicio vueloServicio,
                              PeticionServicio peticionServicio,
                              ReservaServicio reservaServicio,
                              AuditoriaServicio auditoriaServicio,
                              AvionServicio avionServicio,
                              AerolineaServicio aerolineaServicio,
                              EquipoServicio equipoServicio) {
        this.usuarioServicio = usuarioServicio;
        this.vueloServicio = vueloServicio;
        this.peticionServicio = peticionServicio;
        this.reservaServicio = reservaServicio;
        this.auditoriaServicio = auditoriaServicio;
        this.avionServicio = avionServicio;
        this.aerolineaServicio = aerolineaServicio;
        this.equipoServicio = equipoServicio;
    }

	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "registrar";
	}
	
	@PostMapping("/index")
	public String index(@ModelAttribute("usuario") Usuario usuario, Model model)  {
		
		Usuario userValidacion = usuarioServicio.traerUsuario(usuario.getUsername());
		
		Usuario userLogeado = usuarioServicio.traerUsuario(usernameP);
		
		if(userValidacion != null || userLogeado.getFkTipoUsuario() == 1) {
			auditoriaServicio.crearAuditoria(0, "registro", new Date(), "desfavorable");
			model.addAttribute("mensajeError", "Usuario ya existe");
			return "registrar";
		}else {
			auditoriaServicio.crearAuditoria(0, "registro", new Date(), "favorable");
			usuario.setFkTipoUsuario(1);
			usuarioServicio.guardarUsuario(usuario);
			return "redirect:/listarUsuarios";
		}
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	String usernameP;
	@PostMapping("/login")
	public String validarCredenciales(@ModelAttribute("usuario") Usuario usuario, Model model) {
		Usuario user = usuarioServicio.traerUsuario(usuario.getUsername());
		if(usuarioServicio.validarCredenciales(usuario.getUsername(), usuario.getContrasena())) {
			auditoriaServicio.crearAuditoria(0, "login", new Date(), "favorable");
			usernameP = user.getUsername();
			return "redirect:/buscar";
		}else {
			auditoriaServicio.crearAuditoria(0, "login", new Date(), "desfavorable");
			model.addAttribute("mensajeError", "Usuario y/o contraseña incorrectos");
			return "login";
		}
	}
	
	@GetMapping("/buscar")
    public String mostrarFormulario(Model model) {
   //     model.addAttribute("usuario", new Usuario());
        return "buscar";
    }
	
	int bookingA;
	@PostMapping("/buscar")
	public String buscarUsuario(Model model, @RequestParam String booking) {
		Reserva reserva = null;
		try {
			reserva = reservaServicio.encontrarReservaPorBooking(Integer.parseInt(booking));
		}catch(NumberFormatException e) {
			return "buscar";
		}
		
		if(reserva != null && reserva.getReservaActiva()) {
			auditoriaServicio.crearAuditoria(0, "busca-cliente", new Date(), "favorable");
			bookingA = reserva.getBooking();
			return "redirect:/menu";
		}else {
			auditoriaServicio.crearAuditoria(0, "busca-cliente", new Date(), "desfavorable");
			model.addAttribute("mensajeError", "Consulta no válida");
			return "buscar";
		}
	}
	
	@GetMapping("/menu")
	public String menuPrincipal(Model model) {
		
		Vuelo vuelo = vueloServicio.obtenerVueloPorBooking(bookingA);
		
		List<Peticion> peticiones = peticionServicio.obtenerPeticionPorBooking(bookingA);
		
		Reserva reserva = reservaServicio.encontrarReservaPorBooking(bookingA);
		
		Avion avion = avionServicio.traerAvionConReserva(reserva.getIdReserva());
		
	    Aerolinea aerolinea = aerolineaServicio.traerAerolineaConAvion(avion.getIdAvion());
	    
	    Equipo equipo = equipoServicio.traerEquipoConAvion(avion.getIdAvion());
	    
	    model.addAttribute("vuelo", vuelo);
	    model.addAttribute("peticiones", peticiones);
	    model.addAttribute("reserva", reserva);
	    
	    model.addAttribute("avion", avion);
	    model.addAttribute("aerolinea", aerolinea);
	    model.addAttribute("equipo", equipo);
	    
		return "menu";
	}
	
	
	@GetMapping("/modificar/{id}")
	public String modificarPeticion(@PathVariable int id, Model model) {
	    // Lógica para cargar y mostrar la peticion con el ID proporcionado
	    Peticion peticion = peticionServicio.obtenerPeticionesPorId(id);
	    model.addAttribute("peticion", peticion);
	    return "modificar";
	}
	
	
	@PostMapping("/guardarCambios/{id}")
	public String guardarCambios(@PathVariable int id, @RequestParam("preferenciaComida") String preferenciaComida) {
		
		peticionServicio.actualizarPreferenciaComida(id, "No hay preferencia");
	//	Reserva reserva = reservaServicio.encontrarReservaPorUsuarioYVuelo(user.getIdUsuario(), origen, destino);
		Reserva reserva = reservaServicio.encontrarReservaPorBooking(bookingA);
		reservaServicio.actualizarPreferenciaComida(reserva.getIdReserva(), preferenciaComida);
		
		auditoriaServicio.crearAuditoria(0, "preferencia-comida", new Date(), "favorable");
		return "redirect:/menu";
	}
	
	@GetMapping("/cambioHora/{idPeticion}")
	public String mostrarVuelosDisponibles(@PathVariable int idPeticion, Model model) {
	    Peticion peticion = peticionServicio.obtenerPeticionesPorId(idPeticion);
	    
	    // Obtener la fecha de despegue del vuelo actual
	    Vuelo vuelo = vueloServicio.obtenerVueloPorBooking(bookingA);
	    Date fechaDespegueActual = (Date) vuelo.getFechaDespegue(); 
	    
	    // Obtener vuelos disponibles para el cambio de hora
	    List<Vuelo> vuelosDisponibles = vueloServicio.obtenerVuelosDisponibles(fechaDespegueActual, vuelo.getOrigen(), vuelo.getDestino());
	    
	    model.addAttribute("vuelosDisponibles", vuelosDisponibles);
	    model.addAttribute("peticionId", idPeticion);
	    
	    return "cambioHora";
	}
	
	@PostMapping("/seleccionarVuelo/{idPeticion}")
	public String seleccionarVuelo(@PathVariable int idPeticion, @RequestParam int idVuelo) {
		
	//	Usuario usuario = usuarioServicio.buscarPorIdPeticion(idPeticion);
		Reserva reserva = reservaServicio.encontrarReservaPorBooking(bookingA);
		
		reservaServicio.actualizarVueloUsuario(idVuelo, reserva.getIdReserva());
		
		peticionServicio.actualizarFechaVuelo(null, idPeticion);
		
		auditoriaServicio.crearAuditoria(0, "cambio-vuelo", new Date(), "favorable");
		
	    return "redirect:/menu";
	}
	
	@GetMapping("/cancelarReserva/{idPeticion}")
	public String cancelarReserva(@PathVariable int idPeticion) {
		
		peticionServicio.actualizarCancelarReserva(idPeticion);
		
		Reserva reserva = reservaServicio.encontrarReservaPorBooking(bookingA);
		reservaServicio.actualizarReservaActiva(reserva.getIdReserva());
		
		auditoriaServicio.crearAuditoria(0, "cancela-reserva", new Date(), "favorable");
		
		return "redirect:/buscar";
	}
	
	@GetMapping("/cantMaletas/{idPeticion}")
	public String modificarCantMaletas(@PathVariable int idPeticion, Model model) {
		
		Peticion peticion = peticionServicio.obtenerPeticionesPorId(idPeticion);
		model.addAttribute("peticion", peticion);
		
		return "cantMaletas";
	}
	
	@PostMapping("/guardarCantMaletas/{idPeticion}")
	public String guardarCantMaletas(@PathVariable int idPeticion, @RequestParam("cantMaletas") String cantMaletas, Model model) {
		
		Peticion peticion = peticionServicio.obtenerPeticionesPorId(idPeticion);
		
		if(peticion.getAgregarMaletas() == Integer.parseInt(cantMaletas)) {
			
			peticionServicio.actualizarCantMaletas(idPeticion);
			
			Reserva reserva = reservaServicio.encontrarReservaPorBooking(bookingA);
			reservaServicio.actualizarCantMaletas(reserva.getIdReserva(), reserva.getCantMaletas() + Integer.parseInt(cantMaletas));
		
			reservaServicio.actualizarPrecioReserva(reserva.getIdReserva(), reserva.getPrecioReserva() + (50000 * Integer.parseInt(cantMaletas)));
		
			auditoriaServicio.crearAuditoria(0, "cant-maletas", new Date(), "favorable");
		
		}else {
			auditoriaServicio.crearAuditoria(0, "cant-maletas", new Date(), "desfavorable");
			model.addAttribute("mensajeError", "Debe agregar la misma cantidad que indica el cliente");
			//Mostrar ventana que no deja
			System.out.println("Debe elegir la misma cantidad solicitada");
		}
		
		return "redirect:/menu";
	}
	
	@GetMapping("/cambioTitular/{idPeticion}")
	public String cambioTitular(@PathVariable int idPeticion, Model model) {
		Peticion peticion = peticionServicio.obtenerPeticionesPorId(idPeticion);
		model.addAttribute("peticion", peticion);
		return "cambioTitular";
	}
	
	@PostMapping("/guardarCambioTitular/{idPeticion}")
	public String guardarCambioTitular(@PathVariable int idPeticion, @RequestParam String nombreTitular, @RequestParam String apellidoTitular) {
		Peticion peticion = peticionServicio.obtenerPeticionesPorId(idPeticion);
		Reserva reserva = reservaServicio.encontrarReservaPorBooking(bookingA);
		Usuario usuario = usuarioServicio.buscarPorIdPeticion(idPeticion);
		
		if(peticion.getCambioTitular().equalsIgnoreCase(nombreTitular) 
				&& peticion.getCambioTitularApellido().equalsIgnoreCase(apellidoTitular)) {
			
			reservaServicio.actualizarTitular(reserva.getIdReserva(), nombreTitular, apellidoTitular);
		//	usuarioServicio.actualizarTitular(usuario.getIdUsuario(), nombreTitular, apellidoTitular);
			peticionServicio.actualizarTitularPeticion(idPeticion, null, null);
			
			auditoriaServicio.crearAuditoria(0, "cambio-titular", new Date(), "favorable");
			
		}else {
			auditoriaServicio.crearAuditoria(0, "cambio-titular", new Date(), "desfavorable");
			System.out.println("Avisar");
		}
		
		return "redirect:/menu";
	}
	
	@GetMapping("/listarUsuarios")
	public String listarUsuarios(@RequestParam(name = "busqueda", required = false) String busqueda, Model model, @ModelAttribute("user")Usuario user) {
	    List<Usuario> usuarios;
	    
	    List<Auditoria> auditoria = auditoriaServicio.obtenerListaDeAuditorias();

	    model.addAttribute("auditoria", auditoria);

	    
	    if (busqueda != null && !busqueda.isEmpty()) {
	        usuarios = usuarioServicio.buscarUsuarios(busqueda);
	        auditoriaServicio.crearAuditoria(0, "busca-usuario", new Date(), "favorable");
	    } else {
	        usuarios = usuarioServicio.listarTodosLosUsuarios();
	        auditoriaServicio.crearAuditoria(0, "busca-usuario", new Date(), "desfavorable");
	    }

	    model.addAttribute("usuarios", usuarios);
	    return "listarUsuarios";
	}

}
