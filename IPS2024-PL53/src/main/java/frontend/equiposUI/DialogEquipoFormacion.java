package frontend.equiposUI;

import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;

public class DialogEquipoFormacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panelNorte;
	private JPanel panelCentro;
	private ButtonGroup btgEquipos;
	private JPanel panelSur;
	private JButton btnAñadirEquipo;
	private JPanel panelAñadir;
	private JPanel panelEquipo;
	private JButton btnAñadir;
	private JPanel panelCentroAñadir;
	private JPanel panelAñadirJugadores;
	private JLabel lblJugadores;
	private JScrollPane spJugadores;
	private JList listJugadores;
	private JPanel panelAñadirEntrenadores;
	private JLabel lblEntrenadores;
	private JScrollPane spEntrenadores;
	private JList listEntrenadores;
	private JButton btnEliminar;
	private JPanel panelCentroEquipo;
	private JPanel panelJugadoresEquipo;
	private JLabel lbJugadoresAñadidos;
	private JScrollPane spJugadoresAñadidios;
	private JList listJugadoresEquipo;
	private JPanel panelEntrenadoresEquipo;
	private JLabel lblEntrenadoresAñadidos;
	private JScrollPane spEntrenadoresAñadidos;
	private JList listEntrenadoresAñadidos;
	private JComboBox cbCategoria;
	private JLabel lblCategoria;
	private VentanaPrincipalEquipos vpe;



	/**
	 * Create the dialog.
	 */
	public DialogEquipoFormacion(VentanaPrincipalEquipos vpe) {
		setTitle("Añadir Equipo en Formación");
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
			panelNorte.setLayout(new BorderLayout(0, 0));
			panelNorte.add(getCbCategoria());
			panelNorte.add(getLblCategoria(), BorderLayout.WEST);
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
		}
		return btgEquipos;
	}
	
	private JButton getBtnAñadirEquipo() {
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
			panelAñadir.add(getBtnAñadir(), BorderLayout.NORTH);
			panelAñadir.add(getPanelCentroAñadir(), BorderLayout.CENTER);
		}
		return panelAñadir;
	}
	private JPanel getPanelEquipo() {
		if (panelEquipo == null) {
			panelEquipo = new JPanel();
			panelEquipo.setBackground(new Color(255, 255, 255));
			panelEquipo.setLayout(new BorderLayout(0, 0));
			panelEquipo.add(getBtnEliminar(), BorderLayout.NORTH);
			panelEquipo.add(getPanelCentroEquipo(), BorderLayout.CENTER);
		}
		return panelEquipo;
	}
	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("Añadir");
		}
		return btnAñadir;
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
		}
		return spJugadores;
	}
	private JList getListJugadores() {
		if (listJugadores == null) {
			listJugadores = new JList();
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
		}
		return spEntrenadores;
	}
	private JList getListEntrenadores() {
		if (listEntrenadores == null) {
			listEntrenadores = new JList();
		}
		return listEntrenadores;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
		}
		return btnEliminar;
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
		}
		return spJugadoresAñadidios;
	}
	private JList getListJugadoresEquipo() {
		if (listJugadoresEquipo == null) {
			listJugadoresEquipo = new JList();
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
		}
		return spEntrenadoresAñadidos;
	}
	private JList getListEntrenadoresAñadidos() {
		if (listEntrenadoresAñadidos == null) {
			listEntrenadoresAñadidos = new JList();
		}
		return listEntrenadoresAñadidos;
	}
	private JComboBox getCbCategoria() {
		if (cbCategoria == null) {
			cbCategoria = new JComboBox();
		}
		return cbCategoria;
	}
	private JLabel getLblCategoria() {
		if (lblCategoria == null) {
			lblCategoria = new JLabel("Categoria: ");
			lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblCategoria;
	}
}
