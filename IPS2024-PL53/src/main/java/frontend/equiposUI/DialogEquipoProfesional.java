package frontend.equiposUI;

import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.equipos.Equipo;
import backend.service.equipos.EquipoProfesional;
import backend.service.equipos.NivelEquipoProfesional;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogEquipoProfesional extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelNorte;
	private JPanel panelCentro;
	private ButtonGroup btgEquipos;
	private JRadioButton rdbtnPrimerEquipo;
	private JRadioButton rdbtnEquipoFilial;
	private JPanel panelSur;
	private JButton btnAñadirEquipo;
	private JPanel panelAñadir;
	private JPanel panelEquipo;
	private JButton btnAñadirJugador;
	private JPanel panelCentroAñadir;
	private JPanel panelAñadirJugadores;
	private JLabel lblJugadores;
	private JScrollPane spJugadores;
	private JList<EmpleadoDeportivo>  listJugadores;
	private JPanel panelAñadirEntrenadores;
	private JLabel lblEntrenadores;
	private JScrollPane spEntrenadores;
	private JList<EmpleadoDeportivo>  listEntrenadores;
	private JButton btnEliminarJugador;
	private JPanel panelCentroEquipo;
	private JPanel panelJugadoresEquipo;
	private JLabel lbJugadoresAñadidos;
	private JScrollPane spJugadoresAñadidios;
	private JList<EmpleadoDeportivo>  listJugadoresEquipo;
	private JPanel panelEntrenadoresEquipo;
	private JLabel lblEntrenadoresAñadidos;
	private JScrollPane spEntrenadoresAñadidos;
	private JList<EmpleadoDeportivo>  listEntrenadoresAñadidos;
	private VentanaPrincipalEquipos vpe;
	private JComboBox<Equipo> cbEquiposProfesionales;
	private JLabel lblFilialDe;
	private JButton btnAñadirEntrenador;
	private JButton btnEliminarEntrenador;



	/**
	 * Create the dialog.
	 */
	public DialogEquipoProfesional(VentanaPrincipalEquipos vpe) {
		setTitle("Añadir Equipo Profesional");
		setModal(true);
		this.vpe = vpe;
		setBounds(100, 100, 1060, 679);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		contentPanel.add(getPanelNorte(), BorderLayout.NORTH);
		contentPanel.add(getPanelCentro(), BorderLayout.CENTER);
		contentPanel.add(getPanelSur(), BorderLayout.SOUTH);
		getButtonGroup();
	}

	private Component getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setLayout(new GridLayout(0, 2, 4, 0));
			panelCentro.add(getPanelAñadir());
			panelCentro.add(getPanelEquipo());
		}
		return panelCentro;
	}

	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setBackground(new Color(255, 255, 255));
			panelNorte.setLayout(new GridLayout(1, 0, 0, 0));
			panelNorte.add(getRdbtnPrimerEquipo());
			panelNorte.add(getRdbtnEquipoFilial());
			panelNorte.add(getLblFilialDe());
			panelNorte.add(getCbEquiposProfesionales());
		}
		return panelNorte;
	}
	
	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
			panelSur.setBackground(new Color(255, 255, 255));
			panelSur.setLayout(new BorderLayout(0, 0));
			panelSur.add(getBtnAñadirEquipo());
		}
		return panelSur;
	}
	
	private ButtonGroup getButtonGroup() {
		if (btgEquipos == null) {
			btgEquipos = new ButtonGroup();
			btgEquipos.add(rdbtnPrimerEquipo);
			btgEquipos.add(rdbtnEquipoFilial);
		}
		return btgEquipos;
	}

	private JRadioButton getRdbtnPrimerEquipo() {
		if (rdbtnPrimerEquipo == null) {
			rdbtnPrimerEquipo = new JRadioButton("Primer Equipo");
			rdbtnPrimerEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getCbEquiposProfesionales().setEnabled(false);
					getLblFilialDe().setEnabled(false);
				}
			});
			rdbtnPrimerEquipo.setSelected(true);
			rdbtnPrimerEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnPrimerEquipo.setBackground(new Color(255, 255, 255));
		}
		return rdbtnPrimerEquipo;
	}
	private JRadioButton getRdbtnEquipoFilial() {
		if (rdbtnEquipoFilial == null) {
			rdbtnEquipoFilial = new JRadioButton("Equipo Filial");
			rdbtnEquipoFilial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getCbEquiposProfesionales().setEnabled(true);
					getLblFilialDe().setEnabled(true);
				}
			});
			rdbtnEquipoFilial.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnEquipoFilial.setBackground(new Color(255, 255, 255));
		}
		return rdbtnEquipoFilial;
	}
	
	private JButton getBtnAñadirEquipo() {
		if (btnAñadirEquipo == null) {
			btnAñadirEquipo = new JButton("Añadir Equipo");
			btnAñadirEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (compruebaEquipo())
						confirmarAñadirEquipo();
					else
						mostrarAdvertencia();
				}
			});
			btnAñadirEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAñadirEquipo.setBackground(new Color(255, 255, 255));
		}
		return btnAñadirEquipo;
	}
	
	/**
	 * @return true si el equipo tiene al menos 7 jugadores y al menos 2 entrenadores
	 */
	private boolean compruebaEquipo() {
		// Obtener el modelo de la lista de jugadores y verificar su tamaño
	    DefaultListModel<EmpleadoDeportivo> jugadoresModel = (DefaultListModel<EmpleadoDeportivo>) getListJugadoresEquipo().getModel();
	    if (jugadoresModel.getSize() < 7) {
	        return false;
	    }

	    // Obtener el modelo de la lista de entrenadores y verificar su tamaño
	    DefaultListModel<EmpleadoDeportivo> entrenadoresModel = (DefaultListModel<EmpleadoDeportivo>) getListEntrenadoresAñadidos().getModel();
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
	    		dispose();
	    }
	}


	private void añadeEquipo() {
		List<EmpleadoDeportivo> jugadoresEquipo = extraerJugadoresDesdeJList(getListJugadoresEquipo());
		List<EmpleadoDeportivo> entrenadoresEquipo = extraerJugadoresDesdeJList(getListEntrenadoresAñadidos());
		NivelEquipoProfesional nivel;
		String filialDe = null;
		if (getRdbtnEquipoFilial().isSelected()) {
			nivel = NivelEquipoProfesional.FILIAL;
			filialDe = getPrimerEquipoDelQueEsFilial();
		}
		else
			nivel = NivelEquipoProfesional.PRIMER_EQUIPO;
		vpe.getGestionEquiposShared().añadeEquipoProfesional(jugadoresEquipo, entrenadoresEquipo, nivel, filialDe);
	}
	
	private String getPrimerEquipoDelQueEsFilial() {
		return getCbEquiposProfesionales().getSelectedItem().toString();
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
	
	private JPanel getPanelAñadir() {
		if (panelAñadir == null) {
			panelAñadir = new JPanel();
			panelAñadir.setBackground(new Color(255, 255, 255));
			panelAñadir.setLayout(new BorderLayout(0, 0));
			panelAñadir.add(getPanelCentroAñadir(), BorderLayout.CENTER);
		}
		return panelAñadir;
	}
	private JPanel getPanelEquipo() {
		if (panelEquipo == null) {
			panelEquipo = new JPanel();
			panelEquipo.setBackground(new Color(255, 255, 255));
			panelEquipo.setLayout(new BorderLayout(0, 0));
			panelEquipo.add(getPanelCentroEquipo(), BorderLayout.CENTER);
		}
		return panelEquipo;
	}
	private JButton getBtnAñadirJugador() {
		if (btnAñadirJugador == null) {
			btnAñadirJugador = new JButton("Añadir Jugador");
			btnAñadirJugador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirJugador();
				}
			});
		}
		return btnAñadirJugador;
	}
	
	/**
	 * Añade el jugador seleccionado al equipo
	 */
	private void añadirJugador() {
	    // Obtener el jugador seleccionado de la lista de jugadores
	    EmpleadoDeportivo jugadorSeleccionado = listJugadores.getSelectedValue();
	    
	    if (jugadorSeleccionado != null) {
	        // Obtener el modelo de la lista de jugadores del equipo y de la lista original
	        DefaultListModel<EmpleadoDeportivo> modeloJugadoresEquipo = (DefaultListModel<EmpleadoDeportivo>) listJugadoresEquipo.getModel();
	        DefaultListModel<EmpleadoDeportivo> modeloJugadores = (DefaultListModel<EmpleadoDeportivo>) listJugadores.getModel();
	        
	        // Añadir el jugador seleccionado al modelo de la lista de jugadores del equipo
	        modeloJugadoresEquipo.addElement(jugadorSeleccionado);
	        
	        // Remover el jugador del modelo de la lista de jugadores sin equipo
	        modeloJugadores.removeElement(jugadorSeleccionado);
	    } else {
	        // Si no se seleccionó ningún jugador, mostrar un mensaje de error o advertencia
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un jugador para añadir.");
	    }
	}


	
	private JPanel getPanelCentroAñadir() {
		if (panelCentroAñadir == null) {
			panelCentroAñadir = new JPanel();
			panelCentroAñadir.setLayout(new GridLayout(0, 2, 0, 0));
			panelCentroAñadir.add(getPanelAñadirJugadores());
			panelCentroAñadir.add(getPanelAñadirEntrenadores());
		}
		return panelCentroAñadir;
	}
	private JPanel getPanelAñadirJugadores() {
		if (panelAñadirJugadores == null) {
			panelAñadirJugadores = new JPanel();
			panelAñadirJugadores.setBackground(new Color(255, 255, 255));
			panelAñadirJugadores.setLayout(new BorderLayout(0, 0));
			panelAñadirJugadores.add(getLblJugadores(), BorderLayout.NORTH);
			panelAñadirJugadores.add(getSpJugadores(), BorderLayout.CENTER);
		}
		return panelAñadirJugadores;
	}
	private JLabel getLblJugadores() {
		if (lblJugadores == null) {
			lblJugadores = new JLabel("JUGADORES");
			lblJugadores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblJugadores;
	}
	private JScrollPane getSpJugadores() {
		if (spJugadores == null) {
			spJugadores = new JScrollPane();
			spJugadores.setViewportView(getListJugadores());
			spJugadores.setColumnHeaderView(getBtnAñadirJugador());
		}
		return spJugadores;
	}
	private JList<EmpleadoDeportivo> getListJugadores() {
	    if (listJugadores == null) {
	        listJugadores = new JList<>(new DefaultListModel<>()); // Inicializa con DefaultListModel
	    }

	    DefaultListModel<EmpleadoDeportivo> listModel = (DefaultListModel<EmpleadoDeportivo>) listJugadores.getModel();
	    listModel.clear(); // Limpia el modelo actual
	    List<EmpleadoDeportivo> listaJugadores = vpe.getGestionEquiposShared().getJugadoresSinEquipo();
	    Collections.sort(listaJugadores);
	    listModel.addAll(listaJugadores);

	    return listJugadores;
	}
	
	private JPanel getPanelAñadirEntrenadores() {
		if (panelAñadirEntrenadores == null) {
			panelAñadirEntrenadores = new JPanel();
			panelAñadirEntrenadores.setBackground(new Color(255, 255, 255));
			panelAñadirEntrenadores.setLayout(new BorderLayout(0, 0));
			panelAñadirEntrenadores.add(getLblEntrenadores(), BorderLayout.NORTH);
			panelAñadirEntrenadores.add(getSpEntrenadores(), BorderLayout.CENTER);
		}
		return panelAñadirEntrenadores;
	}
	private JLabel getLblEntrenadores() {
		if (lblEntrenadores == null) {
			lblEntrenadores = new JLabel("ENTRENADORES");
			lblEntrenadores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblEntrenadores;
	}
	private JScrollPane getSpEntrenadores() {
		if (spEntrenadores == null) {
			spEntrenadores = new JScrollPane();
			spEntrenadores.setViewportView(getListEntrenadores());
			spEntrenadores.setColumnHeaderView(getBtnAñadirEntrenador());
		}
		return spEntrenadores;
	}
	private JList<EmpleadoDeportivo> getListEntrenadores() {
	    if (listEntrenadores == null) {
	        listEntrenadores = new JList<>(new DefaultListModel<>()); // Inicializa con DefaultListModel
	    }
	    
	    // Obtener el modelo actual y llenarlo con los entrenadores sin equipo
	    DefaultListModel<EmpleadoDeportivo> listModel = (DefaultListModel<EmpleadoDeportivo>) listEntrenadores.getModel();
	    listModel.clear(); // Limpia el modelo actual
	    List<EmpleadoDeportivo> listaEntrenadores = vpe.getGestionEquiposShared().getEntrenadoresSinEquipo();
		Collections.sort(listaEntrenadores);
		listModel.addAll(listaEntrenadores);
	    
	    return listEntrenadores;
	}
	private JButton getBtnEliminarJugador() {
		if (btnEliminarJugador == null) {
			btnEliminarJugador = new JButton("Eliminar Jugador");
			btnEliminarJugador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarJugador();
				}
			});
		}
		return btnEliminarJugador;
	}
	
	private void eliminarJugador() {
	    // Obtener el jugador seleccionado de la lista de jugadores del equipo
	    EmpleadoDeportivo jugadorSeleccionado = listJugadoresEquipo.getSelectedValue();
	    
	    if (jugadorSeleccionado != null) {
	        // Obtener el modelo de la lista de jugadores del equipo
	        DefaultListModel<EmpleadoDeportivo> modeloJugadoresEquipo = (DefaultListModel<EmpleadoDeportivo>) listJugadoresEquipo.getModel();
	        
	        // Eliminar el jugador seleccionado del modelo
	        modeloJugadoresEquipo.removeElement(jugadorSeleccionado);
	        
	        // También puedes agregarlo nuevamente a la lista de jugadores sin equipo si es necesario
	        DefaultListModel<EmpleadoDeportivo> modeloJugadores = (DefaultListModel<EmpleadoDeportivo>) listJugadores.getModel();
	        modeloJugadores.addElement(jugadorSeleccionado);
	    } else {
	        // Si no se seleccionó ningún jugador, mostrar un mensaje de advertencia
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un jugador para eliminar.");
	    }
	}

	private JPanel getPanelCentroEquipo() {
		if (panelCentroEquipo == null) {
			panelCentroEquipo = new JPanel();
			panelCentroEquipo.setBackground(new Color(255, 255, 255));
			panelCentroEquipo.setLayout(new GridLayout(0, 2, 0, 0));
			panelCentroEquipo.add(getPanelJugadoresEquipo());
			panelCentroEquipo.add(getPanelEntrenadoresEquipo());
		}
		return panelCentroEquipo;
	}
	private JPanel getPanelJugadoresEquipo() {
		if (panelJugadoresEquipo == null) {
			panelJugadoresEquipo = new JPanel();
			panelJugadoresEquipo.setBackground(new Color(255, 255, 255));
			panelJugadoresEquipo.setLayout(new BorderLayout(0, 0));
			panelJugadoresEquipo.add(getLbJugadoresAñadidos(), BorderLayout.NORTH);
			panelJugadoresEquipo.add(getSpJugadoresAñadidios(), BorderLayout.CENTER);
		}
		return panelJugadoresEquipo;
	}
	private JLabel getLbJugadoresAñadidos() {
		if (lbJugadoresAñadidos == null) {
			lbJugadoresAñadidos = new JLabel("JUGADORES AÑADIDOS");
			lbJugadoresAñadidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbJugadoresAñadidos.setBackground(new Color(255, 255, 255));
		}
		return lbJugadoresAñadidos;
	}
	private JScrollPane getSpJugadoresAñadidios() {
		if (spJugadoresAñadidios == null) {
			spJugadoresAñadidios = new JScrollPane();
			spJugadoresAñadidios.setViewportView(getListJugadoresEquipo());
			spJugadoresAñadidios.setColumnHeaderView(getBtnEliminarJugador());
		}
		return spJugadoresAñadidios;
	}
	private JList<EmpleadoDeportivo> getListJugadoresEquipo() {
	    if (listJugadoresEquipo == null) {
	        listJugadoresEquipo = new JList<>(new DefaultListModel<>()); // Inicializa con DefaultListModel
	    }
	    return listJugadoresEquipo;
	}
	private JPanel getPanelEntrenadoresEquipo() {
		if (panelEntrenadoresEquipo == null) {
			panelEntrenadoresEquipo = new JPanel();
			panelEntrenadoresEquipo.setBackground(new Color(255, 255, 255));
			panelEntrenadoresEquipo.setLayout(new BorderLayout(0, 0));
			panelEntrenadoresEquipo.add(getLblEntrenadoresAñadidos(), BorderLayout.NORTH);
			panelEntrenadoresEquipo.add(getSpEntrenadoresAñadidos(), BorderLayout.CENTER);
		}
		return panelEntrenadoresEquipo;
	}
	private JLabel getLblEntrenadoresAñadidos() {
		if (lblEntrenadoresAñadidos == null) {
			lblEntrenadoresAñadidos = new JLabel("ENTRENADORES AÑADIDOS");
			lblEntrenadoresAñadidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblEntrenadoresAñadidos;
	}
	private JScrollPane getSpEntrenadoresAñadidos() {
		if (spEntrenadoresAñadidos == null) {
			spEntrenadoresAñadidos = new JScrollPane();
			spEntrenadoresAñadidos.setViewportView(getListEntrenadoresAñadidos());
			spEntrenadoresAñadidos.setColumnHeaderView(getBtnEliminarEntrenador());
		}
		return spEntrenadoresAñadidos;
	}
	private JList<EmpleadoDeportivo> getListEntrenadoresAñadidos() {
	    if (listEntrenadoresAñadidos == null) {
	        listEntrenadoresAñadidos = new JList<>(new DefaultListModel<>()); // Inicializa con DefaultListModel
	    }
	    return listEntrenadoresAñadidos;
	}
	private JComboBox<Equipo> getCbEquiposProfesionales() {
		if (cbEquiposProfesionales == null) {
			cbEquiposProfesionales = new JComboBox<Equipo>();
		}
		cbEquiposProfesionales.setEnabled(false);
		DefaultComboBoxModel<Equipo> comboBoxModel = new DefaultComboBoxModel<>();
		List<Equipo> listaEquipos = vpe.getGestionEquiposShared().getEquiposProfesionales();
	    for (Equipo equipo : listaEquipos) {
	        comboBoxModel.addElement(equipo);
	    }
	    
	    // Establecer el modelo en el JComboBox
	    cbEquiposProfesionales.setModel(comboBoxModel);
		return cbEquiposProfesionales;
	}
	private JLabel getLblFilialDe() {
		if (lblFilialDe == null) {
			lblFilialDe = new JLabel("Equipo Filial De: ");
			lblFilialDe.setEnabled(false);
		}
		return lblFilialDe;
	}
	private JButton getBtnAñadirEntrenador() {
		if (btnAñadirEntrenador == null) {
			btnAñadirEntrenador = new JButton("Añadir Entrenador");
			btnAñadirEntrenador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirEntrenador();
				}
			});
		}
		return btnAñadirEntrenador;
	}
	
	/**
	 * Añade un jugador a la lista de jugadores
	 */
	private void añadirEntrenador() {
		 // Obtener el entrenador seleccionado de la lista de jugadores
	    EmpleadoDeportivo entrenadorSeleccionado = listEntrenadores.getSelectedValue();
	    
	    if (entrenadorSeleccionado != null) {
	        // Obtener el modelo de la lista de entrenador del equipo y de la lista original
	        DefaultListModel<EmpleadoDeportivo> modeloEntrenadoresEquipo = (DefaultListModel<EmpleadoDeportivo>) listEntrenadoresAñadidos.getModel();
	        DefaultListModel<EmpleadoDeportivo> modeloEntrenadores = (DefaultListModel<EmpleadoDeportivo>) listEntrenadores.getModel();
	        
	        // Añadir el jugador seleccionado al modelo de la lista de entrenadores del equipo
	        modeloEntrenadoresEquipo.addElement(entrenadorSeleccionado);
	        
	        // Remover el jugador del modelo de la lista de entrenadores sin equipo
	        modeloEntrenadores.removeElement(entrenadorSeleccionado);
	    } else {
	        // Si no se seleccionó ningún jugador, mostrar un mensaje de error o advertencia
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un entrenador para añadir.");
	    }
	}
	
	private JButton getBtnEliminarEntrenador() {
		if (btnEliminarEntrenador == null) {
			btnEliminarEntrenador = new JButton("Eliminar Entrenador");
			btnEliminarEntrenador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarEntrenador();
				}
			});
		}
		return btnEliminarEntrenador;
	}
	
	private void eliminarEntrenador() {
	    // Obtener el entrenador seleccionado de la lista de entrenadores añadidos
	    EmpleadoDeportivo entrenadorSeleccionado = listEntrenadoresAñadidos.getSelectedValue();
	    
	    if (entrenadorSeleccionado != null) {
	        // Obtener el modelo de la lista de entrenadores añadidos
	        DefaultListModel<EmpleadoDeportivo> modeloEntrenadoresAñadidos = (DefaultListModel<EmpleadoDeportivo>) listEntrenadoresAñadidos.getModel();
	        
	        // Remover el entrenador seleccionado del modelo
	        modeloEntrenadoresAñadidos.removeElement(entrenadorSeleccionado);
	        
	        // También puedes agregarlo nuevamente a la lista de entrenadores sin equipo si es necesario
	        DefaultListModel<EmpleadoDeportivo> modeloEntrenadores = (DefaultListModel<EmpleadoDeportivo>) listEntrenadores.getModel();
	        modeloEntrenadores.addElement(entrenadorSeleccionado);
	    } else {
	        // Si no se seleccionó ningún entrenador, mostrar un mensaje de advertencia
	        JOptionPane.showMessageDialog(null, "Por favor, seleccione un entrenador para eliminar.");
	    }
	}

}
