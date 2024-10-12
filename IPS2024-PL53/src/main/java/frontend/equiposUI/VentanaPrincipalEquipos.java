package frontend.equiposUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JButton;

public class VentanaPrincipalEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAñadirEquipo;
	private JButton btnEquipoProfesional;
	private JButton btnEquipoFormacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalEquipos frame = new VentanaPrincipalEquipos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalEquipos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		contentPane.add(getLblAñadirEquipo());
		contentPane.add(getBtnEquipoProfesional());
		contentPane.add(getBtnEquipoFormacion());
	}

	private JLabel getLblAñadirEquipo() {
		if (lblAñadirEquipo == null) {
			lblAñadirEquipo = new JLabel("AÑADIR EQUIPO");
			lblAñadirEquipo.setFont(new Font("Tahoma", Font.PLAIN, 27));
			lblAñadirEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAñadirEquipo;
	}
	private JButton getBtnEquipoProfesional() {
		if (btnEquipoProfesional == null) {
			btnEquipoProfesional = new JButton("Equipo Profesional");
			btnEquipoProfesional.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnEquipoProfesional;
	}
	private JButton getBtnEquipoFormacion() {
		if (btnEquipoFormacion == null) {
			btnEquipoFormacion = new JButton("Equipo en Formación");
			btnEquipoFormacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnEquipoFormacion;
	}
}
