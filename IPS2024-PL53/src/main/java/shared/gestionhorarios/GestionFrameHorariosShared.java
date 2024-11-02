package shared.gestionhorarios;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.nodeportivos.horarios.Turno;
import frontend.SwingUtil;
import frontend.empleados.horarios.FrameHorariosEmpleados;
import frontend.empleados.horarios.PanelHora;
import util.DateToLocalDate;
import util.DateToLocalTime;

public class GestionFrameHorariosShared {

	
	private FrameHorariosEmpleados view;
	private GestionHorariosShared gesHor;

	public GestionFrameHorariosShared(FrameHorariosEmpleados view) {
		this.view = view;
		this.gesHor = view.getGesHor();
		inicializarPanel();
	}
	
	public void initController() {
		view.getBtSalir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> salir()));
		view.getBtAddSemanal().addActionListener(e -> SwingUtil.exceptionWrapper(() -> addTurno()));
		view.getListEmpleados().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtil.exceptionWrapper(() -> mostrarHorario());
            }
        });
		view.getClFecha().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                SwingUtil.exceptionWrapper(() -> mostrarHorario());
            }
        });
	}
	
	private void salir() {
		view.dispose();
	}

	private void addTurno() {
		if (cumpleCondiciones()) {
			EmpleadoNoDeportivo empleado = view.getListEmpleados().getSelectedValue();
			LocalTime hInicio = DateToLocalTime.convertDateToLocalTime((Date) view.getSpHoraInicio().getValue());
			LocalTime hFin = DateToLocalTime.convertDateToLocalTime((Date) view.getSpHoraFin().getValue());
			LocalDate dia = DateToLocalDate.convertToLocalDate(view.getClFecha().getDate());
			
			boolean adicionCorrecta = false;
			
			if (view.getRdbtPuntual().isSelected()) {
				adicionCorrecta = gesHor.addTurnoPuntual(empleado, hInicio, hFin, dia);
			}
			else {
				DayOfWeek diaSemana = dia.getDayOfWeek();
				adicionCorrecta = gesHor.addTurnoSemanal(empleado, hInicio, hFin, diaSemana);
			}
			
			if (adicionCorrecta) {
				JOptionPane.showMessageDialog(view, "Se ha añadido el turno correctamente",
						"Éxito al Añadir Turno", JOptionPane.INFORMATION_MESSAGE);
				inicializarPanel();
			}
				
			else
				JOptionPane.showMessageDialog(view, "Se ha superado el límite de horas (8h diarias o 40h semanales)",
						"Error al Añadir Turno", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private boolean cumpleCondiciones() {
		if (view.getClFecha().getDate() == null)  {
			JOptionPane.showMessageDialog(view, "Se debe seleccionar la fecha para el turno",
					"Error al Añadir Turno", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!view.getRdbtPuntual().isSelected() && !view.getRdbtSemanal().isSelected()) {
			JOptionPane.showMessageDialog(view, "Se debe seleccionar el tipo de turno (Semanal o Puntual)",
					"Error al Añadir Turno", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (view.getListEmpleados().isSelectionEmpty()) {
			JOptionPane.showMessageDialog(view, "Se debe seleccionar al empleado al que asignar el turno",
					"Error al Añadir Turno", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		
		Date inicio = (Date) view.getSpHoraInicio().getValue();
		Date fin = (Date) view.getSpHoraFin().getValue();
		
		if (inicio.after(fin) || inicio.equals(fin)) {
			JOptionPane.showMessageDialog(view, "La hora de inicio debe ser inferior a la hora de final del turno",
					"Error al Añadir Turno", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;	
	}
	
	private void inicializarPanel() {
		Date horaInicial;
        try {
        	horaInicial = new SimpleDateFormat("HH:mm").parse("00:00");
        } catch (Exception e) {
            throw new RuntimeException("Error al parsear las horas.", e);
        }
		
		// Establecemos los Spinners a 00:00
        view.getSpHoraInicio().setValue(horaInicial);
        view.getSpHoraFin().setValue(horaInicial);
        view.getListEmpleados().clearSelection();
		
		// Llena la lsita con los empleados no deportivos
        view.getModeloList().clear();
		List<EmpleadoNoDeportivo> lista = gesHor.getEmpleadosNoDeportivosFromGestor();
		Collections.sort(lista);
        view.getModeloList().addAll(lista);
		
		
		view.getClFecha().setDate(null);
	}
	
	private void mostrarHorario() {
		if (!view.getListEmpleados().isSelectionEmpty() && view.getClFecha().getDate() != null)
			mostrarHorarioEmpleado();
	}
	
	private void mostrarHorarioEmpleado() {
		view.getPnTablaHorario().removeAll();
		
		LocalDate fechaSeleccionada = DateToLocalDate.convertToLocalDate(view.getClFecha().getDate());
		
		List<Turno> turnos = gesHor.getHorario(view.getListEmpleados().getSelectedValue(), fechaSeleccionada);
		crearTablaHorarioEmpleado(turnos);
	}
	
	private void crearTablaHorarioEmpleado(List<Turno> turnos) {
		for (int i = 0; i < 24; i++) {
			PanelHora pnHora = new PanelHora();
			LocalTime horaPanel = LocalTime.of(i, 0);
			LocalTime horaSiguiente = horaPanel.plusHours(1);
			pnHora.setHora(horaPanel);
			
			for (Turno turno : turnos) {
				LocalTime inicio = turno.getHoraInicio();
				LocalTime fin = turno.getHoraFin();
				
				if (!inicio.isBefore(horaPanel) && inicio.isBefore(horaSiguiente) || 
						fin.isAfter(horaPanel) && fin.isBefore(horaSiguiente) || 
						inicio.isBefore(horaPanel) && fin.isAfter(horaPanel))
					pnHora.setOcupado(inicio, fin);
			}
			view.getPnTablaHorario().add(pnHora);
		}
		view.getPnTablaHorario().revalidate();
		view.getPnTablaHorario().repaint();
	}
}
