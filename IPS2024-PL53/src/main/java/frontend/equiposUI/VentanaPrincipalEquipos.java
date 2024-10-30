package frontend.equiposUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

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
	private JButton getBtnEquipoProfesional() {
		if (btnEquipoProfesional == null) {
			btnEquipoProfesional = new JButton("Equipo Profesional");
			btnEquipoProfesional.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					creaVentanaEquipoProfesional();
				}

			});
			btnEquipoProfesional.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnEquipoProfesional;
	}
	

	private void creaVentanaEquipoProfesional() {
		try {
			DialogEquipoProfesional dialog = new DialogEquipoProfesional(this);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private JButton getBtnEquipoFormacion() {
		if (btnEquipoFormacion == null) {
			btnEquipoFormacion = new JButton("Equipo en Formación");
			btnEquipoFormacion.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					creaVentanaEquipoFormacion();
				}
			});
			btnEquipoFormacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnEquipoFormacion;
	}
	

	private void creaVentanaEquipoFormacion() {
		try {
			DialogEquipoFormacion dialog = new DialogEquipoFormacion(this);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
