package shared.gestionlogin;

import java.util.Optional;

import backend.data.CreadorDataService;
import backend.data.accionistas.AccionistaDTO;
import backend.data.accionistas.AccionistasCRUDService;
import backend.data.empleados.DtoAssembler;
import backend.data.empleados.EmpleadoDTO;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.equipos.EntrenadorDto;
import backend.data.equipos.JugadorDto;
import backend.data.usuarios.UsuarioDTO;
import backend.data.usuarios.UsuariosCRUDService;
import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.usuarios.TipoUsuario;
import backend.service.usuarios.Usuario;

public class GestionLogInShared {
	
	private UsuariosCRUDService serviceUsuarios = CreadorDataService.getUsuariosService();
	private AccionistasCRUDService serviceAccionistas = CreadorDataService.getAccionistasService();
	private EmpleadosCRUDService serviceEmpleados = CreadorDataService.getEmpleadosService();
	
	public Optional<Usuario> getUsuarioPorNombreYPassword(String nombreUsuario, String passwordCifrada) {
		UsuarioDTO dtoBusqueda = new UsuarioDTO();
		dtoBusqueda.nombreUsuario = nombreUsuario;
		dtoBusqueda.password = passwordCifrada;
		
		Optional<UsuarioDTO> optUs = serviceUsuarios.findUsuarioByNombreYPassword(dtoBusqueda);
		if (optUs.isEmpty())
			return Optional.empty();
		
		UsuarioDTO dtoUsuario = optUs.get();
		// Se obtiene el usuario
		Usuario usuario = buscarInfoUsuario(dtoUsuario);
		
		return Optional.of(usuario);
	}

	/**
	 * Devuelve el tipo del usuario (su puesto) en función de la tabla en la que encuentra el id
	 * introducido como parámetro
	 * 
	 * @param id
	 * @return tipo del usuario cuyo id se introduce como parámetro
	 */
	private Usuario buscarInfoUsuario(UsuarioDTO dto) {
		String id = dto.id;
		
		Optional<AccionistaDTO> optAcc = serviceAccionistas.findByIdAccionista(id);
		if (optAcc.isPresent()) {
			AccionistaDTO dtoAcc = optAcc.get();
			return new Usuario(dtoAcc.idAccionista, dtoAcc.dniAccionista, dto.nombreUsuario, 
					TipoUsuario.ACCIONISTA);
		}
		Optional<EmpleadoDTO> optEmpNoDep = serviceEmpleados.findEmpleadoNoDeportivoById(id);
		if (optEmpNoDep.isPresent()) {
			EmpleadoDTO dtoEmp = optEmpNoDep.get();
			TipoUsuario tipoEmp = getTipoUsuarioDeEmpleadoNoDeportivo(dtoEmp);
			return new Usuario(dtoEmp.id, dtoEmp.DNI, dto.nombreUsuario, tipoEmp);
		}
		Optional<JugadorDto> optJugador = serviceEmpleados.findJugadorById(id);
		if (optJugador.isPresent()) {
			JugadorDto dtoJug = optJugador.get();
			return new Usuario(dtoJug.id_jugador, dtoJug.DNI, dto.nombreUsuario, 
					TipoUsuario.JUGADOR);
		}
		Optional<EntrenadorDto> optEntrenador = serviceEmpleados.findEntrenadorById(id);
		if (optEntrenador.isPresent()) {
			EntrenadorDto dtoEnt = optEntrenador.get();
			return new Usuario(dtoEnt.id_entrenador, dtoEnt.DNI, dto.nombreUsuario, 
					TipoUsuario.ENTRENADOR);
		}
		else 
			throw new IllegalStateException("Se ha obtenido un Usuario de la base de datos "
					+ "que no tiene un puesto (Su id no está en ninguna de las tablas hijas)");
	}

	private TipoUsuario getTipoUsuarioDeEmpleadoNoDeportivo(EmpleadoDTO empleadoDTO) {
		EmpleadoNoDeportivo emp =  DtoAssembler.dtoToEmpleadoNoDeportivo(empleadoDTO);
		switch (emp.getPuesto()) {
		case GERENTE:
			return TipoUsuario.GERENTE;
		case DIRECTOR_COMUNICACIONES:
			return TipoUsuario.DIRECTOR_COMUNICACIONES;
		case EMPLEADO_COCINA:
			return TipoUsuario.EMPLEADO_COCINA;
		case EMPLEADO_JARDINERIA:
			return TipoUsuario.EMPLEADO_JARDINERIA;
		case EMPLEADO_TIENDA:
			return TipoUsuario.EMPLEADO_TIENDA;
		case ENCARGADO_TIENDA:
			return TipoUsuario.ENCARGADO_TIENDA;
		case ENTRENADOR:
			return TipoUsuario.ENTRENADOR;
		case GESTOR_INSTALACIONES:
			return TipoUsuario.GESTOR_INSTALACIONES;
		case JUGADOR:
			return TipoUsuario.JUGADOR;
		case VENDEDOR_ABONOS:
			return TipoUsuario.VENDEDOR_ENTRADAS_ABONOS;
		default:
			throw new IllegalStateException("Hay un empleado deportivo que no tiene puesto en la BDD");
		}
	}

}
