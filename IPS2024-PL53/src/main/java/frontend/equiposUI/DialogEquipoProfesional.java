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
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.Collections;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;

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
	private JList<EmpleadoDeportivo> listJugadores;
	private JPanel panelAñadirEntrenadores;
	private JLabel lblEntrenadores;
	private JScrollPane spEntrenadores;
	private JList<EmpleadoDeportivo> listEntrenadores;
	private JButton btnEliminarJugador;
	private JPanel panelCentroEquipo;
	private JPanel panelJugadoresEquipo;
	private JLabel lbJugadoresAñadidos;
	private JScrollPane spJugadoresAñadidios;
	private JList<EmpleadoDeportivo> listJugadoresEquipo;
	private JPanel panelEntrenadoresEquipo;
	private JLabel lblEntrenadoresAñadidos;
	private JScrollPane spEntrenadoresAñadidos;
	private JList<EmpleadoDeportivo> listEntrenadoresAñadidos;
	private VentanaPrincipalEquipos vpe;
	private JComboBox<Equipo> cbEquiposProfesionales;
	private JLabel lblFilialDe;
	private JButton btnAñadirEntrenador;
	private JButton btnEliminarEntrenador;

	public VentanaPrincipalEquipos getVpe() {
		return vpe;
	}

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

	public JRadioButton getRdbtnPrimerEquipo() {
		if (rdbtnPrimerEquipo == null) {
			rdbtnPrimerEquipo = new JRadioButton("Primer Equipo");
			rdbtnPrimerEquipo.setSelected(true);
			rdbtnPrimerEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnPrimerEquipo.setBackground(new Color(255, 255, 255));
		}
		return rdbtnPrimerEquipo;
	}

	public JRadioButton getRdbtnEquipoFilial() {
		if (rdbtnEquipoFilial == null) {
			rdbtnEquipoFilial = new JRadioButton("Equipo Filial");
			rdbtnEquipoFilial.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnEquipoFilial.setBackground(new Color(255, 255, 255));
		}
		return rdbtnEquipoFilial;
	}

	public JButton getBtnAñadirEquipo() {
		if (btnAñadirEquipo == null) {
			btnAñadirEquipo = new JButton("Añadir Equipo");
			btnAñadirEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAñadirEquipo.setBackground(new Color(255, 255, 255));
		}
		return btnAñadirEquipo;
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

	public JButton getBtnAñadirJugador() {
		if (btnAñadirJugador == null) {
			btnAñadirJugador = new JButton("Añadir Jugador");
		}
		return btnAñadirJugador;
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

	public JList<EmpleadoDeportivo> getListJugadores() {
		if (listJugadores == null) {
			listJugadores = new JList<>(new DefaultListModel<>()); // Inicializa con DefaultListModel
			DefaultListModel<EmpleadoDeportivo> listModel = (DefaultListModel<EmpleadoDeportivo>) listJugadores.getModel();
			listModel.clear(); // Limpia el modelo actual
			List<EmpleadoDeportivo> listaJugadores = vpe.getGestionEquiposShared().getJugadoresSinEquipo();
			Collections.sort(listaJugadores);
			listModel.addAll(listaJugadores);
			listJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
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

	public JList<EmpleadoDeportivo> getListEntrenadores() {
		if (listEntrenadores == null) {
			listEntrenadores = new JList<>(new DefaultListModel<>()); // Inicializa con DefaultListModel
			// Obtener el modelo actual y llenarlo con los entrenadores sin equipo
			DefaultListModel<EmpleadoDeportivo> listModel = (DefaultListModel<EmpleadoDeportivo>) listEntrenadores
					.getModel();
			listModel.clear(); // Limpia el modelo actual
			List<EmpleadoDeportivo> listaEntrenadores = vpe.getGestionEquiposShared().getEntrenadoresSinEquipo();
			Collections.sort(listaEntrenadores);
			listModel.addAll(listaEntrenadores);
		}
		return listEntrenadores;
	}

	public JButton getBtnEliminarJugador() {
		if (btnEliminarJugador == null) {
			btnEliminarJugador = new JButton("Eliminar Jugador");
		}
		return btnEliminarJugador;
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

	public JList<EmpleadoDeportivo> getListJugadoresEquipo() {
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

	public JList<EmpleadoDeportivo> getListEntrenadoresAñadidos() {
		if (listEntrenadoresAñadidos == null) {
			listEntrenadoresAñadidos = new JList<>(new DefaultListModel<>()); // Inicializa con DefaultListModel
		}
		return listEntrenadoresAñadidos;
	}

	public JComboBox<Equipo> getCbEquiposProfesionales() {
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

	public JLabel getLblFilialDe() {
		if (lblFilialDe == null) {
			lblFilialDe = new JLabel("Equipo Filial De: ");
			lblFilialDe.setEnabled(false);
		}
		return lblFilialDe;
	}

	public JButton getBtnAñadirEntrenador() {
		if (btnAñadirEntrenador == null) {
			btnAñadirEntrenador = new JButton("Añadir Entrenador");
		}
		return btnAñadirEntrenador;
	}

	public JButton getBtnEliminarEntrenador() {
		if (btnEliminarEntrenador == null) {
			btnEliminarEntrenador = new JButton("Eliminar Entrenador");

		}
		return btnEliminarEntrenador;
	}

}
