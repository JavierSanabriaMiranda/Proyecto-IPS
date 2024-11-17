package shared.gestionequipos.partidos;

import java.time.LocalTime;
import java.util.Date;

import javax.swing.JOptionPane;

import backend.service.equipos.Equipo;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import frontend.SwingUtil;
import frontend.equiposUI.partidos.VentanaPartidos;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

public class GestionPanelPartidosShared {

	private VentanaPartidos view;

	public GestionPanelPartidosShared(VentanaPartidos view) {
		this.view = view;
	}

	public void initController() {
		view.getBtnAtras().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.dispose()));

		view.getBtnCrearPartido().addActionListener(e -> SwingUtil.exceptionWrapper(() -> crearPartido()));

	}

	private void crearPartido() {
		if (campoEquipoVisitanteVacio()) {
			JOptionPane.showMessageDialog(null,
					"Debes indicar el nombre del Equipo Visitante para registrar el partido.", "Error Equipo Visitante",
					JOptionPane.WARNING_MESSAGE);
		} else if (verificarSeleccionDeFecha()) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar el día del partido.", "Error en la selección de día",
					JOptionPane.WARNING_MESSAGE);
		} else {
			addPartido();
			JOptionPane.showMessageDialog(null, "El partido ha sido registrado.", "Partido registrado",
					JOptionPane.INFORMATION_MESSAGE);
			view.dispose();
		}

	}

	private boolean campoEquipoVisitanteVacio() {
		if (view.getTxtEquipoVisitante().getText().isBlank())
			return true;
		return false;
	}

	private boolean verificarSeleccionDeFecha() {
		if (view.getDateChooser().getDate() == null)
			return true;
		return false;
	}

	private void addPartido() {
		Equipo equipo = getEquipo();
		String visitante = view.getTxtEquipoVisitante().getText();
		Date fecha = view.getDateChooser().getDate();
		FranjaTiempo franja = getFranjaPartido();
		boolean isEspecial = view.getChckbxPartidoEspecial().isSelected();
		view.getGps().addPartido(equipo, visitante, fecha, franja, isEspecial);
	}

	private Equipo getEquipo() {
		Equipo equipoCb = (Equipo) view.getCbEquiposLocales().getSelectedItem();
		String idEquipo = equipoCb.getIdEquipo();
		Equipo equipo = view.getGps().buscaEquipo(idEquipo);
		return equipo;
	}
	
	public FranjaTiempo getFranjaPartido() {
		Date horaInicio = (Date) view.getSpHoraInicio().getValue();
		LocalTime inicio = DateToLocalTimeConverter.convertDateToLocalTime(horaInicio);
		LocalTime fin = inicio.plusHours(2);
		FranjaTiempo franja = new FranjaTiempo(TipoEvento.PARTIDO, inicio, fin,
				DateToLocalDate.convertToLocalDate(view.getDateChooser().getDate()));
		return franja;
	}

}
