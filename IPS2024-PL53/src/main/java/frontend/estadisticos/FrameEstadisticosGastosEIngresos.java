package frontend.estadisticos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class FrameEstadisticosGastosEIngresos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnPeriocidad;
	private JPanel pnGrafico;
	private JLabel lbPeriocidad;
	private JComboBox<String> cbPeriocidad;
	private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
	private Component horizontalStrut;
	private JLabel lbFecha;
	private JMonthChooser monthChooser;
	private JYearChooser yearChooser;
	private JButton btMostrarGrafico;

	/**
	 * Create the frame.
	 */
	public FrameEstadisticosGastosEIngresos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 445);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnPeriocidad(), BorderLayout.NORTH);
		contentPane.add(getPnGrafico(), BorderLayout.CENTER);
	}

	public JPanel getPnPeriocidad() {
		if (pnPeriocidad == null) {
			pnPeriocidad = new JPanel();
			pnPeriocidad.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnPeriocidad.setBackground(new Color(255, 255, 255));
			pnPeriocidad.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnPeriocidad.add(getLbPeriocidad());
			pnPeriocidad.add(getCbPeriocidad());
			pnPeriocidad.add(getHorizontalStrut());
			pnPeriocidad.add(getLbFecha());
		}
		return pnPeriocidad;
	}

	public JPanel getPnGrafico() {
		if (pnGrafico == null) {
			pnGrafico = new JPanel();
			pnGrafico.setBackground(new Color(255, 255, 255));
			pnGrafico.setLayout(new BorderLayout(0, 0));

		}
		return pnGrafico;
	}

	private JLabel getLbPeriocidad() {
		if (lbPeriocidad == null) {
			lbPeriocidad = new JLabel("Periocidad:");
			lbPeriocidad.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return lbPeriocidad;
	}

	public JComboBox<String> getCbPeriocidad() {
		if (cbPeriocidad == null) {
			cbPeriocidad = new JComboBox<String>();
			cbPeriocidad.setPreferredSize(new Dimension(120, 22));
			cbPeriocidad.setFont(new Font("Arial", Font.PLAIN, 14));
			model.addElement("");
			model.addElement("Mensual");
			model.addElement("Anual");
			cbPeriocidad.setModel(model);
		}
		return cbPeriocidad;
	}

	private Component getHorizontalStrut() {
		if (horizontalStrut == null) {
			horizontalStrut = Box.createHorizontalStrut(20);
			horizontalStrut.setPreferredSize(new Dimension(40, 0));
		}
		return horizontalStrut;
	}

	public JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("");
			lbFecha.setFont(new Font("Arial", Font.PLAIN, 14));
		}
		return lbFecha;
	}

	public JMonthChooser getMonthChooser() {
		if (monthChooser == null) {
			monthChooser = new JMonthChooser();
			monthChooser.setPreferredSize(new Dimension(140,30));
		}
		return monthChooser;
	}
	
	public JYearChooser getYearChooser() {
		if (yearChooser == null) {
			yearChooser = new JYearChooser();
			yearChooser.setPreferredSize(new Dimension(100,30));
		}
		return yearChooser;
	}
	
	public JButton getBtMostrarGrafico() {
		if (btMostrarGrafico == null) {
			btMostrarGrafico = new JButton("Mostrar Gráfico");
		}
		return btMostrarGrafico;
	}
}
