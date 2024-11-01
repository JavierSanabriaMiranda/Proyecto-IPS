package shared.gestioninstalaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.ventas.reservas.ClienteReserva;
import backend.service.ventas.reservas.Instalacion;
import frontend.SwingUtil;
import frontend.reservaUI.HorarioReserva;
import frontend.reservaUI.ResumenReserva;
import frontend.reservaUI.VentanaPrincipalReserva;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

public class GestionPanelReservaShared {

	private VentanaPrincipalReserva view;
	private HorarioReserva diagHorario;
	private ResumenReserva diagReserva;
	private ReservaShared rs;

	public GestionPanelReservaShared(VentanaPrincipalReserva view) {
		this.view = view;
		this.rs = view.getReservaShared();
	}

	public VentanaPrincipalReserva getView() {
		return view;
	}

	public HorarioReserva getDiagHorario() {
		return diagHorario;
	}

	public ResumenReserva getDiagReserva() {
		return diagReserva;
	}

	public ReservaShared getRs() {
		return rs;
	}

	public void initController() {
		view.getComboBoxInstalaciones()
				.addActionListener(e -> SwingUtil.exceptionWrapper(() -> actualizarBotonSiguiente()));
		view.getDateChooser().addPropertyChangeListener("date", evt -> {
			actualizarBotonSiguiente();
		});
		view.getBtnSiguiente1().addActionListener(e -> SwingUtil.exceptionWrapper(() -> crearVentanaHorario()));

		view.getBtnAtras1().addActionListener(e -> SwingUtil.exceptionWrapper(() -> view.dispose()));

	}
	
	//---------------------------METODOS DE LA VENTANA PRINCIPAL-----------------------------

	private void crearVentanaHorario() {
		try {
			HorarioReserva dialog = new HorarioReserva(view);
			this.diagHorario = dialog;
			initControllersDiagHorario();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void crearVentanaResumen() {
		try {
			ResumenReserva dialog = new ResumenReserva(diagHorario);
			this.diagReserva = dialog;
			initControllersDiagResumen();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void actualizarBotonSiguiente() {
		// Habilitar el botón solo si hay una instalación seleccionada y una fecha
		// seleccionada
		boolean isInstalacionSelected = view.getComboBoxInstalaciones().getSelectedItem() != null;
		boolean isFechaSelected = view.getDateChooser().getDate() != null;
		if (isFechaSelected) {
			Date fecha = view.getDateChooser().getDate(); // Este getDate me devuelve null
			Calendar cal = Calendar.getInstance();
			cal.setTime(fecha);
			view.setFechaSeleccionada(cal.getTime());
		}
		view.getBtnSiguiente1().setEnabled(isInstalacionSelected && isFechaSelected);
	}

	//------------------------------METODOS DE LA VENTANA DEL HORARIO------------------------------------
	
	private void initControllersDiagHorario() {
		iniciaSipnnerInicio();
		iniciaSpinnerFin();
		diagHorario.getSpinnerInicio().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				diagHorario.getBtnSiguiente2().setEnabled(false);
			}
		});

		diagHorario.getSpinnerHoraFin().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				diagHorario.getBtnSiguiente2().setEnabled(false);
			}
		});

		diagHorario.getBtnSiguiente2().addActionListener(e -> SwingUtil.exceptionWrapper(() -> crearVentanaResumen()));

		diagHorario.getBtnAtras2().addActionListener(e -> SwingUtil.exceptionWrapper(() -> diagHorario.dispose()));

		diagHorario.getBtnValidador().addActionListener(e -> SwingUtil.exceptionWrapper(() -> validarHorario()));
	}

	private boolean verificarHoraInicio(Date minHora, Date maxHora) {
		try {
			Date horaInicio = (Date) diagHorario.getSpinnerInicio().getValue();

			// Asegurarse de que esté dentro del rango permitido
			if (horaInicio.before(minHora) || horaInicio.after(maxHora)) {
				JOptionPane.showMessageDialog(null, "La hora de inicio debe estar entre las 08:00 y las 22:00.");
				return false;
			}
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al verificar la hora de inicio.");
			return false;
		}
	}

	/**
	 * Verifica si el horario es valido y habilita el boton siguiente si lo es
	 */
	private void validarHorario() {
		Date horaInicio = (Date) diagHorario.getSpinnerInicio().getValue();
		Date horaFin = (Date) diagHorario.getSpinnerHoraFin().getValue();

		LocalTime inicio = DateToLocalTimeConverter.convertDateToLocalTime(horaInicio);
		LocalTime fin = DateToLocalTimeConverter.convertDateToLocalTime(horaFin);
		FranjaTiempo franja = new FranjaTiempo(TipoEvento.RESERVA, inicio, fin,
				DateToLocalDate.convertToLocalDate(diagHorario.getVpr().getDateChooser().getDate()));
		Instalacion instalacion = (Instalacion) diagHorario.getVpr().getComboBoxInstalaciones().getSelectedItem();

		if (diagHorario.getVpr().getReservaShared().isHorarioValido(instalacion, franja)) {
			diagHorario.getBtnSiguiente2().setEnabled(true);
			diagHorario.getLblHorarioValido().setVisible(true);
			diagHorario.getLblHorarioValido().setText("El horario escogido es válido.");
			diagHorario.getBtnSiguiente2().setEnabled(true);
		} else {
			diagHorario.getBtnSiguiente2().setEnabled(false);
			diagHorario.getLblHorarioValido().setVisible(true);
			diagHorario.getLblHorarioValido().setText("El horario escogido no es válido.");
			diagHorario.getBtnSiguiente2().setEnabled(false);
		}

	}

	private void iniciaSpinnerFin() {
		try {

			// Limitar el rango de horas a estar entre las 08:00 y las 22:00
			Date minHora = new SimpleDateFormat("HH:mm").parse("08:00");
			Date maxHora = new SimpleDateFormat("HH:mm").parse("22:00");

			// Formatear el JSpinner para que muestre solo horas y minutos
			JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(diagHorario.getSpinnerHoraFin(), "HH:mm");
			diagHorario.getSpinnerHoraFin().setEditor(timeEditor);
			diagHorario.getSpinnerHoraFin().setValue(maxHora); // Establecer el valor inicial

			// Verificar que la hora seleccionada sea válida
			JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) diagHorario.getSpinnerHoraFin()
					.getEditor()).getTextField();
			spinnerTextField.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent input) {
					return verificarHoraFin(minHora, maxHora);
				}
			});

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al inicializar el spinner de hora de fin.");
		}

	}

	private boolean verificarHoraFin(Date minHora, Date maxHora) {
		try {
			Date horaInicio = (Date) diagHorario.getSpinnerInicio().getValue();
			Date horaFin = (Date) diagHorario.getSpinnerHoraFin().getValue();

			// Asegurarse de que la hora de fin sea posterior a la de inicio
			if (horaFin.before(horaInicio)) {
				JOptionPane.showMessageDialog(null, "La hora de fin debe ser posterior a la hora de inicio.");
				return false;
			}

			// Asegurarse de que la duración mínima sea de 1 hora
			long diferenciaEnMillis = horaFin.getTime() - horaInicio.getTime();
			long duracionEnMinutos = diferenciaEnMillis / (1000 * 60);

			if (duracionEnMinutos < 60) {
				JOptionPane.showMessageDialog(null, "La duración mínima de la reserva debe ser de 1 hora.");
				return false;
			}

			// Asegurarse de que esté dentro del rango permitido
			if (horaFin.before(minHora) || horaFin.after(maxHora)) {
				JOptionPane.showMessageDialog(null, "La hora de fin debe estar entre las 08:00 y las 22:00.");
				return false;
			}

			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al verificar la hora de fin.");
			return false;
		}
	}

	private void iniciaSipnnerInicio() {
		// Limitar el rango de horas a estar entre las 08:00 y las 22:00
		try {
			Date minHora = new SimpleDateFormat("HH:mm").parse("08:00");

			Date maxHora = new SimpleDateFormat("HH:mm").parse("22:00");

			// Formatear el JSpinner para que muestre solo horas y minutos
			JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(diagHorario.getSpinnerInicio(), "HH:mm");
			diagHorario.getSpinnerInicio().setEditor(timeEditor);
			diagHorario.getSpinnerInicio().setValue(minHora); // Establecer el valor inicial

			// Verificar que la hora seleccionada sea válida
			JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) diagHorario.getSpinnerInicio().getEditor())
					.getTextField();
			spinnerTextField.setInputVerifier(new InputVerifier() {
				@Override
				public boolean verify(JComponent input) {
					return verificarHoraInicio(minHora, maxHora);
				}

			});
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Error al inicializar el spinner de hora de inicio.");
		}
	}
	
	
	//--------------------------------METODOS DE LA VENTANA DEL RESUMEN
	
	private void initControllersDiagResumen() {
		diagReserva.getBtnReservar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> botonReservar()));
		diagReserva.getTxtNumTarjeta().getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                actualizarBotonReserva();
            }
            public void removeUpdate(DocumentEvent e) {
                actualizarBotonReserva();
            }
            public void changedUpdate(DocumentEvent e) {
                actualizarBotonReserva();
            }
        });
		
		diagReserva.getTxtNombreApellidos().getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                actualizarBotonReserva();
            }
            public void removeUpdate(DocumentEvent e) {
                actualizarBotonReserva();
            }
            public void changedUpdate(DocumentEvent e) {
                actualizarBotonReserva();
            }
        });
		
		diagReserva.getTxtDNI().getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                actualizarBotonReserva();
            }
            public void removeUpdate(DocumentEvent e) {
                actualizarBotonReserva();
            }
            public void changedUpdate(DocumentEvent e) {
                actualizarBotonReserva();
            }
        });
		
		diagReserva.getBtnAtras3().addActionListener(e -> SwingUtil.exceptionWrapper(() ->  diagReserva.dispose()));
	}
	
	private void botonReservar() {
		reservar();
		mostrarMensajeExito();
		cerrarVentanas();
	}
	
	private void cerrarVentanas() {
		System.exit(0);
	}
	
	private void reservar() {
		FranjaTiempo franja = diagReserva.getHr().getFranjaReserva();
		Instalacion inst = diagReserva.getHr().getInstalacionReserva();
		ClienteReserva cl = new ClienteReserva(diagReserva.getTxtNombreApellidos().getText());
		float precio = diagReserva.getHr().getPrecioReserva();
		Date fecha = diagReserva.getHr().getDateReserva();
		String dni = diagReserva.getTxtDNI().getText();
		String numTarj = diagReserva.getTxtNumTarjeta().getText();
		
		diagReserva.getHr().getVpr().getReservaShared().addReserva(franja, inst, cl, precio, fecha, dni, numTarj);
	}
	
	private static void mostrarMensajeExito() {
        // Usamos JOptionPane para mostrar el mensaje
        JOptionPane.showMessageDialog(null, "Reserva realizada con éxito", 
                                      "Mensaje de Confirmación", 
                                      JOptionPane.INFORMATION_MESSAGE);
    }

	private void actualizarBotonReserva() {
		String dni = diagReserva.getTxtDNI().getText();
	    String nombreApellidos = diagReserva.getTxtNombreApellidos().getText();
	    String numTarjeta = diagReserva.getTxtNumTarjeta().getText();

	    if (!dni.isEmpty() && !nombreApellidos.isEmpty() && !numTarjeta.isEmpty()) {
	        // Si todos los campos tienen valor, habilitar el botón "Reservar"
	    	diagReserva.getBtnReservar().setEnabled(true);
	    } else {
	        // Si algún campo está vacío, deshabilitar el botón "Reservar"
	    	diagReserva.getBtnReservar().setEnabled(false);
	    }
	}

}
