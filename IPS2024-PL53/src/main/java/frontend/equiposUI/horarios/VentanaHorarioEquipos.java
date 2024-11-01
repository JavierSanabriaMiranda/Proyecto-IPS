package frontend.equiposUI.horarios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class VentanaHorarioEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnSelecionContent;
	private JPanel pnHorarioContent;
	private JPanel pnSeleccionHorario;
	private JPanel pnSeleccionEquipo;
	private JComboBox cbEntrenadores;
	private JLabel lblEntrenadores;
	private JLabel lblEquipo;
	private JComboBox cbEquipos;
	private JLabel lblFecha;
	private JDateChooser dateChooser;
	private JButton btnHorario;
	private JLabel lblSeleccionHoras;
	private JSpinner spHoraInicio;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JSpinner spHoraFin;
	private JButton btnAtras;
	private JButton btnAñadirEntrenamiento;


	/**
	 * Create the frame.
	 */
	public VentanaHorarioEquipos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 710);
		this.setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		contentPane.add(getPnSelecionContent());
		contentPane.add(getPnHorarioContent());
	}

	private JPanel getPnSelecionContent() {
		if (pnSelecionContent == null) {
			pnSelecionContent = new JPanel();
			pnSelecionContent.setLayout(new GridLayout(2, 0, 0, 0));
			pnSelecionContent.add(getPnSeleccionEquipo());
			pnSelecionContent.add(getPnSeleccionHorario());
		}
		return pnSelecionContent;
	}
	private JPanel getPnHorarioContent() {
		if (pnHorarioContent == null) {
			pnHorarioContent = new JPanel();
			pnHorarioContent.setBackground(new Color(255, 255, 255));
		}
		return pnHorarioContent;
	}
	private JPanel getPnSeleccionHorario() {
		if (pnSeleccionHorario == null) {
			pnSeleccionHorario = new JPanel();
			pnSeleccionHorario.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnSeleccionHorario.setBackground(new Color(255, 255, 255));
			pnSeleccionHorario.setLayout(null);
			pnSeleccionHorario.add(getLblSeleccionHoras());
			pnSeleccionHorario.add(getSpHoraInicio());
			pnSeleccionHorario.add(getLblHoraInicio());
			pnSeleccionHorario.add(getLblHoraFin());
			pnSeleccionHorario.add(getSpHoraFin());
			pnSeleccionHorario.add(getBtnAtras());
			pnSeleccionHorario.add(getBtnAñadirEntrenamiento());
		}
		return pnSeleccionHorario;
	}
	private JPanel getPnSeleccionEquipo() {
		if (pnSeleccionEquipo == null) {
			pnSeleccionEquipo = new JPanel();
			pnSeleccionEquipo.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnSeleccionEquipo.setBackground(new Color(255, 255, 255));
			pnSeleccionEquipo.setLayout(null);
			pnSeleccionEquipo.add(getCbEntrenadores());
			pnSeleccionEquipo.add(getLblEntrenadores());
			pnSeleccionEquipo.add(getLblEquipo());
			pnSeleccionEquipo.add(getCbEquipos());
			pnSeleccionEquipo.add(getLblFecha());
			pnSeleccionEquipo.add(getDateChooser());
			pnSeleccionEquipo.add(getBtnHorario());
		}
		return pnSeleccionEquipo;
	}
	private JComboBox getCbEntrenadores() {
		if (cbEntrenadores == null) {
			cbEntrenadores = new JComboBox();
			cbEntrenadores.setBounds(34, 39, 278, 22);
		}
		return cbEntrenadores;
	}
	private JLabel getLblEntrenadores() {
		if (lblEntrenadores == null) {
			lblEntrenadores = new JLabel("Seleccione el Entrenador: ");
			lblEntrenadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEntrenadores.setBounds(34, 11, 168, 17);
		}
		return lblEntrenadores;
	}
	private JLabel getLblEquipo() {
		if (lblEquipo == null) {
			lblEquipo = new JLabel("Seleccione el Equipo: ");
			lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEquipo.setBounds(34, 72, 168, 17);
		}
		return lblEquipo;
	}
	private JComboBox getCbEquipos() {
		if (cbEquipos == null) {
			cbEquipos = new JComboBox();
			cbEquipos.setBounds(34, 100, 278, 22);
		}
		return cbEquipos;
	}
	private JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Seleccione la Fecha: ");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFecha.setBounds(34, 138, 168, 17);
		}
		return lblFecha;
	}
	
	public JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBackground(new Color(255, 255, 255));
	        dateChooser.setDateFormatString("dd/MM/yyyy");
	        Calendar cal = Calendar.getInstance();
	        Date hoy = cal.getTime();
	        dateChooser.setMinSelectableDate(hoy); // No permite seleccionar fechas anteriores a hoy
	        dateChooser.getDateEditor().setEnabled(false);
	        dateChooser.getDateEditor().getUiComponent().setBackground(Color.WHITE); // Fondo deshabilitado
	        dateChooser.getDateEditor().getUiComponent().setForeground(Color.BLUE); // Color del texto
	        ((JTextField) dateChooser.getDateEditor().getUiComponent()).setDisabledTextColor(Color.BLACK); // Texto cuando está deshabilitado
	        dateChooser.setSize(148, 57);
	        dateChooser.setLocation(34, 180);
	        dateChooser.setDate(null);
		}
		return dateChooser;
	}
	private JButton getBtnHorario() {
		if (btnHorario == null) {
			btnHorario = new JButton("Ver Horario");
			btnHorario.setBounds(268, 291, 107, 29);
		}
		return btnHorario;
	}
	private JLabel getLblSeleccionHoras() {
		if (lblSeleccionHoras == null) {
			lblSeleccionHoras = new JLabel("Seleccione el Horario: ");
			lblSeleccionHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSeleccionHoras.setBounds(23, 26, 187, 19);
		}
		return lblSeleccionHoras;
	}
	private JSpinner getSpHoraInicio() {
		if (spHoraInicio == null) {
			spHoraInicio = new JSpinner();
			spHoraInicio.setBounds(127, 97, 109, 38);
		}
		return spHoraInicio;
	}
	private JLabel getLblHoraInicio() {
		if (lblHoraInicio == null) {
			lblHoraInicio = new JLabel("Hora de Inicio:");
			lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHoraInicio.setBounds(49, 67, 187, 19);
		}
		return lblHoraInicio;
	}
	private JLabel getLblHoraFin() {
		if (lblHoraFin == null) {
			lblHoraFin = new JLabel("Hora de Fin:");
			lblHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHoraFin.setBounds(49, 171, 187, 19);
		}
		return lblHoraFin;
	}
	private JSpinner getSpHoraFin() {
		if (spHoraFin == null) {
			spHoraFin = new JSpinner();
			spHoraFin.setBounds(127, 201, 109, 38);
		}
		return spHoraFin;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atrás");
			btnAtras.setBounds(23, 297, 89, 23);
		}
		return btnAtras;
	}
	private JButton getBtnAñadirEntrenamiento() {
		if (btnAñadirEntrenamiento == null) {
			btnAñadirEntrenamiento = new JButton("Añadir Entrenamiento");
			btnAñadirEntrenamiento.setBounds(220, 297, 155, 23);
		}
		return btnAñadirEntrenamiento;
	}
}
