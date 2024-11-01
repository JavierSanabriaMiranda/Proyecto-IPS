package shared.gestionequipos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.equipos.NivelEquipoProfesional;
import frontend.SwingUtil;
import frontend.equiposUI.DialogEquipoFormacion;
import frontend.equiposUI.DialogEquipoProfesional;
import frontend.equiposUI.VentanaPrincipalEquipos;

public class GestionPanelEquiposShared {
	
	private VentanaPrincipalEquipos view;
	private DialogEquipoProfesional diagPro;
	private DialogEquipoFormacion diagFor;
	private GestionEquiposShared ges;
	
	public GestionPanelEquiposShared(VentanaPrincipalEquipos view) {
		this.view = view;
		this.ges = view.getGestionEquiposShared();
	}

	public VentanaPrincipalEquipos getView() {
		return view;
	}

	public DialogEquipoProfesional getDiagPro() {
		return diagPro;
	}

	public DialogEquipoFormacion getDiagFor() {
		return diagFor;
	}

	public GestionEquiposShared getGes() {
		return ges;
	}
	
	//-------------------------------------METODOS DE LA VENTANA PRINCIPAL--------------------------

	public void initControllers() {
		view.getBtnEquipoProfesional().addActionListener(e -> SwingUtil.exceptionWrapper(() -> creaVentanaEquipoProfesional()));
		
		view.getBtnEquipoFormacion().addActionListener(e -> SwingUtil.exceptionWrapper(() ->  creaVentanaEquipoFormacion()));
	}
	
	
	
	private void creaVentanaEquipoProfesional() {
		try {
			DialogEquipoProfesional dialog = new DialogEquipoProfesional(view);
			this.diagPro = dialog;
			initControllersPros();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void creaVentanaEquipoFormacion() {
		try {
			DialogEquipoFormacion dialog = new DialogEquipoFormacion(view);
			this.diagFor = dialog;
			initControllersFor();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//---------------------------METODOS DE LA VENTANA DE EQUIPOS PROFESIONALES-----------------------------

	private void initControllersPros() {
		diagPro.getRdbtnPrimerEquipo().addActionListener(e -> SwingUtil.exceptionWrapper(() -> radioBotonPrimerEquipo()));
		
		diagPro.getRdbtnEquipoFilial().addActionListener(e -> SwingUtil.exceptionWrapper(() ->radioBotonEquipoFilial()));
		
		diagPro.getBtnAñadirEquipo().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actionAñadirEquipo() ));
		
		diagPro.getBtnAñadirJugador().addActionListener(e -> SwingUtil.exceptionWrapper(() -> añadirJugador()));
		
		diagPro.getBtnEliminarJugador().addActionListener(e -> SwingUtil.exceptionWrapper(() -> eliminarJugador()) );
		
		diagPro.getBtnAñadirEntrenador().addActionListener(e -> SwingUtil.exceptionWrapper(() -> añadirEntrenador()));
		
		diagPro.getBtnEliminarEntrenador().addActionListener(e -> SwingUtil.exceptionWrapper(() -> eliminarEntrenador()));
	}
	
	private void radioBotonPrimerEquipo() {
		diagPro.getCbEquiposProfesionales().setEnabled(false);
		diagPro.getLblFilialDe().setEnabled(false);
	}
	
	private void radioBotonEquipoFilial() {
		diagPro.getCbEquiposProfesionales().setEnabled(true);
		diagPro.getLblFilialDe().setEnabled(true);
	}
	
	private void actionAñadirEquipo() {
		if (compruebaEquipo())
			confirmarAñadirEquipo();
		else
			mostrarAdvertencia();
	}
	
	/**
	 * @return true si el equipo tiene al menos 7 jugadores y al menos 2 entrenadores
	 */
	private boolean compruebaEquipo() {
		// Obtener el modelo de la lista de jugadores y verificar su tamaño
	    DefaultListModel<EmpleadoDeportivo> jugadoresModel = (DefaultListModel<EmpleadoDeportivo>) diagPro.getListJugadoresEquipo().getModel();
	    if (jugadoresModel.getSize() < 7) {
	        return false;
	    }

	    // Obtener el modelo de la lista de entrenadores y verificar su tamaño
	    DefaultListModel<EmpleadoDeportivo> entrenadoresModel = (DefaultListModel<EmpleadoDeportivo>) diagPro.getListEntrenadoresAñadidos().getModel();
	    if (entrenadoresModel.getSize() < 2) {
	        return false;
	    }

	    return true;
	}
	
	private void confirmarAñadirEquipo() {
	    // Mensaje de confirmación
	    String mensaje = "<html>" +
	                     "<h3 style='color:blue;'>¿Deseas añadir el equipo?</h3>" +
	                     "<p>Recuerda que el orden de los entrenadores marcará su posición:</p>" +
	                     "<ul>" +
	                     "<li><strong>Primer Entrenador</strong></li>" +
	                     "<li><strong>Segundo Entrenador</strong></li>" +
	                     "<li><strong>Tercer Entrenador</strong></li>" +
	                     "</ul>" +
	                     "<p>Por favor, asegúrate de que el equipo cumple con los requisitos antes de proceder.</p>" +
	                     "</html>";

	    // Mostrar el JOptionPane de confirmación
	    int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar Añadir Equipo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

	    // Procesar la respuesta
	    if (respuesta == JOptionPane.YES_OPTION) {
	    		añadeEquipo();
	    		diagPro.dispose();
	    }
	}
	
	private void añadeEquipo() {
		List<EmpleadoDeportivo> jugadoresEquipo = extraerJugadoresDesdeJList(diagPro.getListJugadoresEquipo());
		List<EmpleadoDeportivo> entrenadoresEquipo = extraerJugadoresDesdeJList(diagPro.getListEntrenadoresAñadidos());
		NivelEquipoProfesional nivel;
		String filialDe = null;
		if (diagPro.getRdbtnEquipoFilial().isSelected()) {
			nivel = NivelEquipoProfesional.FILIAL;
			filialDe = getPrimerEquipoDelQueEsFilial();
		}
		else
			nivel = NivelEquipoProfesional.PRIMER_EQUIPO;
		diagPro.getVpe().getGestionEquiposShared().añadeEquipoProfesional(jugadoresEquipo, entrenadoresEquipo, nivel, filialDe);
	}
	private List<EmpleadoDeportivo> extraerJugadoresDesdeJList(JList<EmpleadoDeportivo> listJugadoresEquipo) {
	    // Crear una nueva lista para almacenar los jugadores
	    List<EmpleadoDeportivo> jugadoresEquipo = new ArrayList<>();

	    // Obtener el modelo de la JList
	    DefaultListModel<EmpleadoDeportivo> model = (DefaultListModel<EmpleadoDeportivo>) listJugadoresEquipo.getModel();

	    // Iterar sobre los elementos del modelo y agregarlos a la lista
	    for (int i = 0; i < model.getSize(); i++) {
	        jugadoresEquipo.add(model.getElementAt(i));
	    }

	    // Devolver la lista con los jugadores
	    return jugadoresEquipo;
	}
	
	private String getPrimerEquipoDelQueEsFilial() {
		return diagPro.getCbEquiposProfesionales().getSelectedItem().toString();
	}
	
	private void mostrarAdvertencia() {
	    // Mensaje con formato
	    String mensaje = "<html>" +
	                     "<h3 style='color:red;'>¡Atención!</h3>" +
	                     "<p>El número de jugadores debe ser mayor que <strong>7</strong>.</p>" +
	                     "<p>El número de entrenadores debe ser mayor que <strong>2</strong>.</p>" +
	                     "<p>Recuerda que el orden de los entrenadores marcará su posición:</p>" +
	                     "<ul>" +
	                     "<li><strong>Primer Entrenador</strong></li>" +
	                     "<li><strong>Segundo Entrenador</strong></li>" +
	                     "<li><strong>Tercer Entrenador</strong></li>" +
	                     "</ul>" +
	                     "</html>";

	    // Mostrar el JOptionPane con el mensaje
	    JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Añade el jugador seleccionado al equipo
	 */
	private void añadirJugador() {
	    // Obtener el jugador seleccionado de la lista de jugadores
	    EmpleadoDeportivo jugadorSeleccionado = diagPro.getListJugadores().getSelectedValue();
	    
	    if (jugadorSeleccionado != null) {
	        // Obtener el modelo de la lista de jugadores del equipo y de la lista original
	        DefaultListModel<EmpleadoDeportivo> modeloJugadoresEquipo = (DefaultListModel<EmpleadoDeportivo>) diagPro.getListJugadoresEquipo().getModel();
	        DefaultListModel<EmpleadoDeportivo> modeloJugadores = (DefaultListModel<EmpleadoDeportivo>) diagPro.getListJugadores().getModel();
	        
	        // Añadir el jugador seleccionado al modelo de la lista de jugadores del equipo
	        modeloJugadoresEquipo.addElement(jugadorSeleccionado);
	        
	        // Remover el jugador del modelo de la lista de jugadores sin equipo
	        modeloJugadores.removeElement(jugadorSeleccionado);
	        
	        
	    } else {
	        // Si no se seleccionó ningún jugador, mostrar un mensaje de error o advertencia
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un jugador para añadir.");
	    }
	}
	
	private void eliminarJugador() {
	    // Obtener el jugador seleccionado de la lista de jugadores del equipo
	    EmpleadoDeportivo jugadorSeleccionado = diagPro.getListJugadoresEquipo().getSelectedValue();
	    
	    if (jugadorSeleccionado != null) {
	        // Obtener el modelo de la lista de jugadores del equipo
	        DefaultListModel<EmpleadoDeportivo> modeloJugadoresEquipo = (DefaultListModel<EmpleadoDeportivo>) diagPro.getListJugadoresEquipo().getModel();
	        
	        // Eliminar el jugador seleccionado del modelo
	        modeloJugadoresEquipo.removeElement(jugadorSeleccionado);
	        
	        // También puedes agregarlo nuevamente a la lista de jugadores sin equipo si es necesario
	        DefaultListModel<EmpleadoDeportivo> modeloJugadores = (DefaultListModel<EmpleadoDeportivo>) diagPro.getListJugadores().getModel();
	        modeloJugadores.addElement(jugadorSeleccionado);
	    } else {
	        // Si no se seleccionó ningún jugador, mostrar un mensaje de advertencia
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un jugador para eliminar.");
	    }
	}
	
	/**
	 * Añade un jugador a la lista de jugadores
	 */
	private void añadirEntrenador() {
		 // Obtener el entrenador seleccionado de la lista de jugadores
	    EmpleadoDeportivo entrenadorSeleccionado = diagPro.getListEntrenadores().getSelectedValue();
	    
	    if (entrenadorSeleccionado != null) {
	        // Obtener el modelo de la lista de entrenador del equipo y de la lista original
	        DefaultListModel<EmpleadoDeportivo> modeloEntrenadoresEquipo = (DefaultListModel<EmpleadoDeportivo>) diagPro.getListEntrenadoresAñadidos().getModel();
	        DefaultListModel<EmpleadoDeportivo> modeloEntrenadores = (DefaultListModel<EmpleadoDeportivo>) diagPro.getListEntrenadores().getModel();
	        
	        // Añadir el jugador seleccionado al modelo de la lista de entrenadores del equipo
	        modeloEntrenadoresEquipo.addElement(entrenadorSeleccionado);
	        
	        // Remover el jugador del modelo de la lista de entrenadores sin equipo
	        modeloEntrenadores.removeElement(entrenadorSeleccionado);
	    } else {
	        // Si no se seleccionó ningún jugador, mostrar un mensaje de error o advertencia
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un entrenador para añadir.");
	    }
	}
	

	private void eliminarEntrenador() {
	    // Obtener el entrenador seleccionado de la lista de entrenadores añadidos
	    EmpleadoDeportivo entrenadorSeleccionado = diagPro.getListEntrenadoresAñadidos().getSelectedValue();
	    
	    if (entrenadorSeleccionado != null) {
	        // Obtener el modelo de la lista de entrenadores añadidos
	        DefaultListModel<EmpleadoDeportivo> modeloEntrenadoresAñadidos = (DefaultListModel<EmpleadoDeportivo>) diagPro.getListEntrenadoresAñadidos().getModel();
	        
	        // Remover el entrenador seleccionado del modelo
	        modeloEntrenadoresAñadidos.removeElement(entrenadorSeleccionado);
	        
	        // También puedes agregarlo nuevamente a la lista de entrenadores sin equipo si es necesario
	        DefaultListModel<EmpleadoDeportivo> modeloEntrenadores = (DefaultListModel<EmpleadoDeportivo>) diagPro.getListEntrenadores().getModel();
	        modeloEntrenadores.addElement(entrenadorSeleccionado);
	    } else {
	        // Si no se seleccionó ningún entrenador, mostrar un mensaje de advertencia
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un entrenador para eliminar.");
	    }
	}
	
	//---------------------------METODOS DE LA VENTANA DE EQUIPOS EN FORMACION-----------------------------

	private void initControllersFor() {
		diagFor.getCbCategorias().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actionCombo()) );
		
		diagFor.getBtnAñadirEquipo().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actionAñadeEquipoFor()) );
		
		diagFor.getBtnAñadirJugador().addActionListener(e -> SwingUtil.exceptionWrapper(() -> añadirJugadorFor()));
		
		diagFor.getBtnEliminarJugador().addActionListener(e -> SwingUtil.exceptionWrapper(() -> eliminarJugadorFor()));
		
		diagFor.getBtnAñadirEntrenador().addActionListener(e -> SwingUtil.exceptionWrapper(() -> añadirEntrenadorFor()));
		
		diagFor.getBtnEliminarEntrenador().addActionListener(e -> SwingUtil.exceptionWrapper(() -> eliminarEntrenadorFor()) );
	}
	
	
	private void eliminarEntrenadorFor() {
		// Obtener el entrenador seleccionado de la lista de entrenadores añadidos
		EmpleadoDeportivo entrenadorSeleccionado = diagFor.getListEntrenadoresAñadidos().getSelectedValue();

		if (entrenadorSeleccionado != null) {
			// Obtener el modelo de la lista de entrenadores añadidos
			DefaultListModel<EmpleadoDeportivo> modeloEntrenadoresAñadidos = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListEntrenadoresAñadidos()
					.getModel();

			// Remover el entrenador seleccionado del modelo
			modeloEntrenadoresAñadidos.removeElement(entrenadorSeleccionado);

			// También puedes agregarlo nuevamente a la lista de entrenadores sin equipo si
			// es necesario
			DefaultListModel<EmpleadoDeportivo> modeloEntrenadores = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListEntrenadores()
					.getModel();
			modeloEntrenadores.addElement(entrenadorSeleccionado);
		} else {
			// Si no se seleccionó ningún entrenador, mostrar un mensaje de advertencia
			JOptionPane.showMessageDialog(null, "Por favor, seleccione un entrenador para eliminar.");
		}
	}
	/**
	 * Añade un jugador a la lista de jugadores
	 */
	private void añadirEntrenadorFor() {
		// Obtener el entrenador seleccionado de la lista de entrenadores
		EmpleadoDeportivo entrenadorSeleccionado = diagFor.getListEntrenadores().getSelectedValue();

		if (entrenadorSeleccionado != null) {
			// Obtener el modelo de la lista de entrenador del equipo y de la lista original
			DefaultListModel<EmpleadoDeportivo> modeloEntrenadoresEquipo = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListEntrenadoresAñadidos()
					.getModel();
			DefaultListModel<EmpleadoDeportivo> modeloEntrenadores = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListEntrenadores()
					.getModel();

			// Añadir el jugador seleccionado al modelo de la lista de entrenadores del
			// equipo
			modeloEntrenadoresEquipo.addElement(entrenadorSeleccionado);

			// Remover el jugador del modelo de la lista de entrenadores sin equipo
			modeloEntrenadores.removeElement(entrenadorSeleccionado);
		} else {
			// Si no se seleccionó ningún jugador, mostrar un mensaje de error o advertencia
			JOptionPane.showMessageDialog(null, "Por favor, seleccione un entrenador para añadir.");
		}
	}
	
	private void eliminarJugadorFor() {
		// Obtener el jugador seleccionado de la lista de jugadores del equipo
		EmpleadoDeportivo jugadorSeleccionado = diagFor.getListJugadoresEquipo().getSelectedValue();

		if (jugadorSeleccionado != null) {
			// Obtener el modelo de la lista de jugadores del equipo
			DefaultListModel<EmpleadoDeportivo> modeloJugadoresEquipo = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListJugadoresEquipo()
					.getModel();

			// Eliminar el jugador seleccionado del modelo
			modeloJugadoresEquipo.removeElement(jugadorSeleccionado);

			// También puedes agregarlo nuevamente a la lista de jugadores sin equipo si es
			// necesario
			DefaultListModel<EmpleadoDeportivo> modeloJugadores = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListJugadores()
					.getModel();
			modeloJugadores.addElement(jugadorSeleccionado);
		} else {
			// Si no se seleccionó ningún jugador, mostrar un mensaje de advertencia
			JOptionPane.showMessageDialog(null, "Por favor, seleccione un jugador para eliminar.");
		}
	}
	
	/**
	 * Añade el jugador seleccionado al equipo
	 */
	private void añadirJugadorFor() {
		// Obtener el jugador seleccionado de la lista de jugadores
		EmpleadoDeportivo jugadorSeleccionado = diagFor.getListJugadores().getSelectedValue();

		if (jugadorSeleccionado != null) {
			// Obtener el modelo de la lista de jugadores del equipo y de la lista original
			DefaultListModel<EmpleadoDeportivo> modeloJugadoresEquipo = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListJugadoresEquipo()
					.getModel();
			DefaultListModel<EmpleadoDeportivo> modeloJugadores = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListJugadores()
					.getModel();

			// Añadir el jugador seleccionado al modelo de la lista de jugadores del equipo
			modeloJugadoresEquipo.addElement(jugadorSeleccionado);

			// Remover el jugador del modelo de la lista de jugadores sin equipo
			modeloJugadores.removeElement(jugadorSeleccionado);
		} else {
			// Si no se seleccionó ningún jugador, mostrar un mensaje de error o advertencia
			JOptionPane.showMessageDialog(null, "Por favor, seleccione un jugador para añadir.");
		}
	}
	
	private void actionAñadeEquipoFor() {
		if (compruebaEquipoFor())
			confirmarAñadirEquipoFor();
		else
			mostrarAdvertencia();
	}
	
	/**
	 * @return true si el equipo tiene al menos 7 jugadores y al menos 2
	 *         entrenadores
	 */
	private boolean compruebaEquipoFor() {
		// Obtener el modelo de la lista de jugadores y verificar su tamaño
		DefaultListModel<EmpleadoDeportivo> jugadoresModel = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListJugadoresEquipo()
				.getModel();
		if (jugadoresModel.getSize() < 7) {
			return false;
		}

		// Obtener el modelo de la lista de entrenadores y verificar su tamaño
		DefaultListModel<EmpleadoDeportivo> entrenadoresModel = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListEntrenadoresAñadidos()
				.getModel();
		if (entrenadoresModel.getSize() < 2) {
			return false;
		}

		return true;
	}

	private void confirmarAñadirEquipoFor() {
		// Mensaje de confirmación
		String mensaje = "<html>" + "<h3 style='color:blue;'>¿Deseas añadir el equipo?</h3>"
				+ "<p>Recuerda que el orden de los entrenadores marcará su posición:</p>" + "<ul>"
				+ "<li><strong>Primer Entrenador</strong></li>" + "<li><strong>Segundo Entrenador</strong></li>"
				+ "<li><strong>Tercer Entrenador</strong></li>" + "</ul>"
				+ "<p>Por favor, asegúrate de que el equipo cumple con los requisitos antes de proceder.</p>"
				+ "</html>";

		// Mostrar el JOptionPane de confirmación
		int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar Añadir Equipo",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		// Procesar la respuesta
		if (respuesta == JOptionPane.YES_OPTION) {
			añadeEquipoFor();
			diagFor.dispose();
		}
	}

	private void añadeEquipoFor() {
		List<EmpleadoDeportivo> jugadoresEquipo = extraerJugadoresDesdeJListFor(diagFor.getListJugadoresEquipo());
		List<EmpleadoDeportivo> entrenadoresEquipo = extraerJugadoresDesdeJListFor(diagFor.getListEntrenadoresAñadidos());
		String categoria = diagFor.getCbCategorias().getSelectedItem().toString();

		diagFor.getVpe().getGestionEquiposShared().añadeEquipoEnFormacion(jugadoresEquipo, entrenadoresEquipo, categoria);
	}

	private List<EmpleadoDeportivo> extraerJugadoresDesdeJListFor(JList<EmpleadoDeportivo> listJugadoresEquipo) {
		// Crear una nueva lista para almacenar los jugadores
		List<EmpleadoDeportivo> jugadoresEquipo = new ArrayList<>();

		// Obtener el modelo de la JList
		DefaultListModel<EmpleadoDeportivo> model = (DefaultListModel<EmpleadoDeportivo>) listJugadoresEquipo
				.getModel();

		// Iterar sobre los elementos del modelo y agregarlos a la lista
		for (int i = 0; i < model.getSize(); i++) {
			jugadoresEquipo.add(model.getElementAt(i));
		}

		// Devolver la lista con los jugadores
		return jugadoresEquipo;
	}

	
	private void actionCombo() {
		eliminaJugadoresYEntrenadoresDeEquipo();
		modificaListaDeJugadoresDisponibles();
	}
	

	private void eliminaJugadoresYEntrenadoresDeEquipo() {
		if (diagFor.getListJugadoresEquipo() != null) {
			DefaultListModel<EmpleadoDeportivo> modeloJugadores = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListJugadoresEquipo()
					.getModel();
			modeloJugadores.clear(); // Vacia la lista de jugadores
		}

		if (diagFor.getListEntrenadoresAñadidos() != null) {
			DefaultListModel<EmpleadoDeportivo> modeloEntrenadores = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListEntrenadoresAñadidos()
					.getModel();
			modeloEntrenadores.clear(); // Vacia la lista de entrenadores
		}
	}

	private void modificaListaDeJugadoresDisponibles() {
		if (diagFor.getListJugadores() != null) {
			DefaultListModel<EmpleadoDeportivo> listModel = (DefaultListModel<EmpleadoDeportivo>) diagFor.getListJugadores()
					.getModel();
			listModel.clear(); // Limpia el modelo actual
			List<EmpleadoDeportivo> listaJugadores = diagFor.getVpe().getGestionEquiposShared()
					.getJugadoresSinEquipoEnRangoEdad(diagFor.getCbCategorias().getSelectedItem().toString());
			Collections.sort(listaJugadores);
			listModel.addAll(listaJugadores);

		}
	}
	
}
