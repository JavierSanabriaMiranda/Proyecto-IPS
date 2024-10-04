package frontend.reservaUI;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import backend.service.eventos.Entrenamiento;
import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.reservas.Instalacion;
import util.DateToLocalTimeConverter;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class HorarioReserva extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private VentanaPrincipalReserva vpr;
	private JScrollPane scrollPanelHorario;
	private JPanel panelSeleccion;
	private JPanel panelHorario;
	private JSpinner spinnerHoraInicio;
	private JSpinner spinnerHoraFin;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JButton btnSiguiente2;
	private JButton btnAtras2;
	private JButton btnValidador;
	private JLabel lblHorarioValido;

	/**
	 * Create the dialog.
	 */
	public HorarioReserva(VentanaPrincipalReserva vpr) {
		setTitle("ReservaHorario");
		setModal(true);
		this.vpr = vpr;
		setBounds(100, 100, 655, 665);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		contentPanel.add(getScrollPanelHorario());
		contentPanel.add(getPanelSeleccion());
		
		getPanelSeleccion().add(getSpinnerInicio());
		getPanelSeleccion().add(getSpinnerHoraFin());
		actualizarPanelHorario();
	}

	public VentanaPrincipalReserva getVpr() {
		return vpr;
	}
	
	private JScrollPane getScrollPanelHorario() {
		if (scrollPanelHorario == null) {
			scrollPanelHorario = new JScrollPane();
			scrollPanelHorario.setViewportView(getPanelHorario());
		}
		return scrollPanelHorario;
	}
	private JPanel getPanelSeleccion() {
		if (panelSeleccion == null) {
			panelSeleccion = new JPanel();
			panelSeleccion.setBackground(new Color(255, 255, 255));
			panelSeleccion.setLayout(null);
			panelSeleccion.add(getSpinnerHoraFin());
			panelSeleccion.add(getLblHoraInicio());
			panelSeleccion.add(getLblHoraFin());
			panelSeleccion.add(getBtnSiguiente2());
			panelSeleccion.add(getBtnAtras2());
			panelSeleccion.add(getBtnValidador());
			panelSeleccion.add(getLblHorarioValido());
		}
		return panelSeleccion;
	}
	private JPanel getPanelHorario() {
		if (panelHorario == null) {
			panelHorario = new JPanel();
			panelHorario.setLayout(new GridLayout(15, 1, 0, 0));
		}
		return panelHorario;
	}
	private JSpinner getSpinnerInicio() {
		if (spinnerHoraInicio == null) {
			SpinnerDateModel dateModel = new SpinnerDateModel();
			spinnerHoraInicio = new JSpinner(dateModel);
			spinnerHoraInicio.setBounds(91, 70, 122, 43);
	        
	        // Formatear el JSpinner para que muestre solo horas y minutos
	        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinnerHoraInicio, "HH:mm");
	        spinnerHoraInicio.setEditor(timeEditor);
	        spinnerHoraInicio.setValue(new Date()); // Establecer el valor inicial en la hora actual
	       
	        JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) spinnerHoraInicio.getEditor()).getTextField();
	        spinnerTextField.setInputVerifier(new InputVerifier() {
	            @Override
	            public boolean verify(JComponent input) {
	                JFormattedTextField textField = (JFormattedTextField) input;
	                String text = textField.getText();
	                
	                // Intentar parsear la entrada como hora (HH:mm)
	                try {
	                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
	                    dateFormat.setLenient(false); // Evitar la corrección automática de fechas inválidas
	                    dateFormat.parse(text); // Verificar si el texto es válido
	                    return true;
	                } catch (Exception e) {
	                    // Si no es una hora válida, rechazar la entrada
	                    JOptionPane.showMessageDialog(null, "Entrada inválida. Introduce un valor válido de hora de inicio(HH:mm).");
	                    return false;
	                }
	            }
	        });
		}
		return spinnerHoraInicio;
	}
	private JSpinner getSpinnerHoraFin() {
		if (spinnerHoraFin == null) {
			SpinnerDateModel dateModel = new SpinnerDateModel();
			spinnerHoraFin = new JSpinner(dateModel);
			spinnerHoraFin.setBounds(91, 184, 122, 43);
	        
	        // Formatear el JSpinner para que muestre solo horas y minutos
	        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinnerHoraFin, "HH:mm");
	        spinnerHoraFin.setEditor(timeEditor);
	        spinnerHoraFin.setValue(new Date()); // Establecer el valor inicial en la hora actual
	        
	        JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) spinnerHoraFin.getEditor()).getTextField();
	        spinnerTextField.setInputVerifier(new InputVerifier() {
	            @Override
	            public boolean verify(JComponent input) {
	                JFormattedTextField textField = (JFormattedTextField) input;
	                String text = textField.getText();
	                
	                // Intentar parsear la entrada como hora (HH:mm)
	                try {
	                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
	                    dateFormat.setLenient(false); // Evitar la corrección automática de fechas inválidas
	                    dateFormat.parse(text); // Verificar si el texto es válido
	                    return true;
	                } catch (Exception e) {
	                    // Si no es una hora válida, rechazar la entrada
	                    JOptionPane.showMessageDialog(null, "Entrada inválida. Introduce un valor válido de hora de fin(HH:mm).");
	                    return false;
	                }
	            }
	        });
		}
		return spinnerHoraFin;
	}
	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora de Inicio:");
			lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHoraInicio.setBounds(91, 45, 122, 14);
		}
		return lblHoraInicio;
	}
	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora de Fin:");
			lblHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHoraFin.setBounds(91, 159, 122, 14);
		}
		return lblHoraFin;
	}
	private JButton getBtnSiguiente2() {
		if (btnSiguiente2 == null) {
			btnSiguiente2 = new JButton("Siguiente");
			btnSiguiente2.setEnabled(false);
			btnSiguiente2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearVentanaResumen();
				}
			});
			btnSiguiente2.setBounds(226, 584, 89, 23);
		}
		return btnSiguiente2;
	}
	
	public void crearVentanaResumen() {
		try {
			ResumenReserva dialog = new ResumenReserva(this);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JButton getBtnAtras2() {
		if (btnAtras2 == null) {
			btnAtras2 = new JButton("Atrás");
			btnAtras2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnAtras2.setBounds(108, 584, 89, 23);
		}
		return btnAtras2;
	}
	
	private void actualizarPanelHorario() {
	    panelHorario.removeAll(); // Limpiamos el panel antes de actualizar

	    // Suponemos que obtienes las franjas ocupadas del backend
	    Date fechaSeleccionada = vpr.getDateChooser().getDate();// Aquí obtienes la fecha seleccionada por el cliente
	    //TODO quitar quitar quitar
	    //Instalacion inst = (Instalacion)vpr.getComboBoxInstalaciones().getSelectedItem();
//	    String nombreInstalacion = inst.getNombreInstalacion();
//	    Instalacion instalacion = vpr.getReservaShared().buscaInstalacion(nombreInstalacion);
	    Instalacion inst = new Instalacion("Cancha");
	    List<FranjaTiempo> eventosDelDia = vpr.getReservaShared().getEventos(inst, fechaSeleccionada); // Eventos del día en la instalacion seleccionada

	    // Crear 15 intervalos de 1 hora entre las 8:00 y las 22:00
	    LocalTime horaInicio = LocalTime.of(8, 0);
	    LocalTime horaFin = LocalTime.of(22, 0);

	    List<JLabel> labelsHorarios = new ArrayList<>();

	    for (int i = 0; i < 15; i++) {
	        LocalTime intervaloInicio = horaInicio.plusHours(i);
	        LocalTime intervaloFin = intervaloInicio.plusHours(1);

	        // Crear la etiqueta para este intervalo
	        JLabel labelHorario = new JLabel(intervaloInicio + " - " + intervaloFin);
	        labelHorario.setOpaque(true);  // Para permitir el cambio de color de fondo
	        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	        labelHorario.setBorder(border);

	        // Verificar si esta franja está ocupada por reservas o entrenamientos
	        boolean estaReservada = false;
	        boolean esEntrenamiento = false;

	        for (FranjaTiempo evento : eventosDelDia) {
	            if (evento.getHoraInicio().isBefore(intervaloFin) && evento.getHoraFin().isAfter(intervaloInicio)) {
	                // Si el evento es un entrenamiento o una reserva
	                if (evento.getEvento() == "Entrenamiento Equipo") {
	                    esEntrenamiento = true;
	                } else {
	                    estaReservada = true;
	                }
	                break; // No necesitamos seguir buscando si ya encontramos un solapamiento
	            }
	        }

	        // Establecer el color de fondo según el estado
	        if (esEntrenamiento) {
	            labelHorario.setBackground(Color.GRAY); // Azul para entrenamientos
	            labelHorario.setText(labelHorario.getText() + " (Entrenamiento)");
	        } else if (estaReservada) {
	            labelHorario.setBackground(Color.DARK_GRAY); // Rojo para reservas
	            labelHorario.setForeground(Color.WHITE);
	            labelHorario.setText(labelHorario.getText() + " (Reservado)");
	        } else {
	            labelHorario.setBackground(Color.WHITE); // Verde para disponibilidad
	            labelHorario.setText(labelHorario.getText() + " (Disponible)");
	        }

	        // Añadir la etiqueta al panel
	        labelsHorarios.add(labelHorario);
	        panelHorario.add(labelHorario);
	    }

	    panelHorario.revalidate();
	    panelHorario.repaint();
	}
	
	private JButton getBtnValidador() {
		if (btnValidador == null) {
			btnValidador = new JButton("Validar");
			btnValidador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarHorario();
				}
			});
			btnValidador.setBackground(new Color(0, 128, 0));
			btnValidador.setBounds(216, 256, 89, 23);
		}
		return btnValidador;
	}
	
	/**
	 * Sin acabar, pasar de Date a FranjaTiempo
	 */
	private void validarHorario() {
		Date horaInicio = (Date) getSpinnerInicio().getValue();
		Date horaFin = (Date) getSpinnerHoraFin().getValue();
		
		LocalTime inicio = DateToLocalTimeConverter.convertDateToLocalTime(horaInicio);
		LocalTime fin = DateToLocalTimeConverter.convertDateToLocalTime(horaFin);
		FranjaTiempo franja = new FranjaTiempo("Reserva", inicio, fin, vpr.getDateChooser().getDate());
		Instalacion inst = (Instalacion)vpr.getComboBoxInstalaciones().getSelectedItem();
	    String nombreInstalacion = inst.getNombreInstalacion();
	    Instalacion instalacion = vpr.getReservaShared().buscaInstalacion(nombreInstalacion);
		
		if (vpr.getReservaShared().isHorarioValido(instalacion, franja)) {
			getBtnSiguiente2().setEnabled(true);
			getLblHorarioValido().setVisible(true);
			getLblHorarioValido().setText("El horario escogido es válido.");
		} else {
			getBtnSiguiente2().setEnabled(false);
			getLblHorarioValido().setVisible(true);
			getLblHorarioValido().setText("El horario escogido no es válido.");
		}
		
		
		
	}
	private JLabel getLblHorarioValido() {
		if (lblHorarioValido == null) {
			lblHorarioValido = new JLabel("");
			lblHorarioValido.setBounds(91, 291, 200, 14);
			lblHorarioValido.setVisible(false);
		}
		return lblHorarioValido;
	}
}
