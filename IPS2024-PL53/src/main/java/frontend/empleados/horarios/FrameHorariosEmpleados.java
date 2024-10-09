package frontend.empleados.horarios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.service.empleados.EmpleadoNoDeportivo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FrameHorariosEmpleados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnEmpleados;
	private JScrollPane scEmpleados;
	private JList<EmpleadoNoDeportivo> listEmpleados;
	private JLabel lbEmpleados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameHorariosEmpleados frame = new FrameHorariosEmpleados();
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
	public FrameHorariosEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnEmpleados(), BorderLayout.WEST);
	}

	private JPanel getPnEmpleados() {
		if (pnEmpleados == null) {
			pnEmpleados = new JPanel();
			pnEmpleados.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			pnEmpleados.setBackground(new Color(255, 255, 255));
			pnEmpleados.setLayout(new BorderLayout(0, 0));
			pnEmpleados.add(getScEmpleados(), BorderLayout.CENTER);
			getScEmpleados().setViewportView(getListEmpleados());
			pnEmpleados.setPreferredSize(new Dimension(400, Integer.MAX_VALUE));
			pnEmpleados.add(getLbEmpleados(), BorderLayout.NORTH);
		}
		return pnEmpleados;
	}
	private JScrollPane getScEmpleados() {
		if (scEmpleados == null) {
			scEmpleados = new JScrollPane();
		}
		return scEmpleados;
	}
	private JList<EmpleadoNoDeportivo> getListEmpleados() {
		if (listEmpleados == null) {
			listEmpleados = new JList<EmpleadoNoDeportivo>();
			listEmpleados.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return listEmpleados;
	}
	private JLabel getLbEmpleados() {
		if (lbEmpleados == null) {
			lbEmpleados = new JLabel("Empleados");
			lbEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
			lbEmpleados.setFont(new Font("Arial", Font.PLAIN, 20));
			lbEmpleados.setBackground(new Color(255, 255, 255));
		}
		return lbEmpleados;
	}
}
