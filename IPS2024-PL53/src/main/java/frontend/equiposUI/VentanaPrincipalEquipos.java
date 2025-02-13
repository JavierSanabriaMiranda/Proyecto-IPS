package frontend.equiposUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import shared.gestionequipos.GestionEquiposShared;

public class VentanaPrincipalEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAñadirEquipo;
	private JButton btnEquipoProfesional;
	private JButton btnEquipoFormacion;
	private GestionEquiposShared ges;

	public VentanaPrincipalEquipos(GestionEquiposShared ges) {
		this.ges = ges;
		setTitle("Añadir Equipo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 407);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		contentPane.add(getLblAñadirEquipo());
		contentPane.add(getBtnEquipoProfesional());
		contentPane.add(getBtnEquipoFormacion());
	}

	public GestionEquiposShared getGestionEquiposShared() {
		return ges;
	}

	private JLabel getLblAñadirEquipo() {
		if (lblAñadirEquipo == null) {
			lblAñadirEquipo = new JLabel("AÑADIR EQUIPO");
			lblAñadirEquipo.setFont(new Font("Tahoma", Font.PLAIN, 27));
			lblAñadirEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAñadirEquipo;
	}

	public JButton getBtnEquipoProfesional() {
		if (btnEquipoProfesional == null) {
			btnEquipoProfesional = new JButton("Equipo Profesional");

			btnEquipoProfesional.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnEquipoProfesional;
	}

	public JButton getBtnEquipoFormacion() {
		if (btnEquipoFormacion == null) {
			btnEquipoFormacion = new JButton("Equipo en Formación");

			btnEquipoFormacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnEquipoFormacion;
	}

}
