package frontend.reservaUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResumenReserva extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textAreaResumen;
	private JTextPane textPaneResumen;
	private JLabel lblResumen;
	private JLabel lblNombreApellidos;
	private JTextField txtNombreApellidos;
	private JLabel lblNumTarjeta;
	private JTextField txtNumTarjeta;
	private JButton btnReservar;
	private JButton btnAtras3;
	private HorarioReserva hr;
	

	/**
	 * Create the dialog.
	 */
	public ResumenReserva(HorarioReserva hr) {
		this.hr = hr;
		setModal(true);
		setTitle("ResumenReserva");
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 594, 448);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		contentPanel.add(getLblResumen());
		contentPanel.add(getTextAreaResumen());
		contentPanel.add(getTextPaneResumen());
		contentPanel.add(getLblNombreApellidos());
		contentPanel.add(getTxtNombreApellidos());
		contentPanel.add(getLblNumTarjeta());
		contentPanel.add(getTxtNumTarjeta());
		contentPanel.add(getBtnReservar());
		contentPanel.add(getBtnAtras3());
	}
	
	public HorarioReserva getHr() {
		return hr;
	}
	
	private JLabel getLblResumen() {
		if(lblResumen == null) {
			lblResumen = new JLabel("Resumen de su reserva: ");
			lblResumen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblResumen.setLabelFor(getTextAreaResumen());
			lblResumen.setBounds(41, 36, 222, 20);
			contentPanel.add(lblResumen);
		}
		return lblResumen;
	}
	
	
	private JTextArea getTextAreaResumen() {
		if (textAreaResumen == null) {
			textAreaResumen = new JTextArea();
			textAreaResumen.setEditable(false);
			textAreaResumen.setBounds(41, 67, 467, 80);
		}
		return textAreaResumen;
	}
	private JTextPane getTextPaneResumen() {
		if (textPaneResumen == null) {
			textPaneResumen = new JTextPane();
			textPaneResumen.setEditable(false);
			textPaneResumen.setBounds(41, 67, 467, 80);
		}
		return textPaneResumen;
	}
	private JLabel getLblNombreApellidos() {
		if (lblNombreApellidos == null) {
			lblNombreApellidos = new JLabel("Nombre y Apellidos");
			lblNombreApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNombreApellidos.setBounds(41, 168, 163, 14);
		}
		return lblNombreApellidos;
	}
	private JTextField getTxtNombreApellidos() {
		if (txtNombreApellidos == null) {
			txtNombreApellidos = new JTextField();
			txtNombreApellidos.setBounds(41, 193, 183, 20);
			txtNombreApellidos.setColumns(10);
		}
		return txtNombreApellidos;
	}
	private JLabel getLblNumTarjeta() {
		if (lblNumTarjeta == null) {
			lblNumTarjeta = new JLabel("Número de tarjeta");
			lblNumTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNumTarjeta.setBounds(41, 244, 163, 14);
		}
		return lblNumTarjeta;
	}
	private JTextField getTxtNumTarjeta() {
		if (txtNumTarjeta == null) {
			txtNumTarjeta = new JTextField();
			txtNumTarjeta.setBounds(41, 269, 183, 20);
			txtNumTarjeta.setColumns(10);
		}
		return txtNumTarjeta;
	}
	private JButton getBtnReservar() {
		if (btnReservar == null) {
			btnReservar = new JButton("Reservar");
			btnReservar.setBounds(481, 377, 89, 23);
		}
		return btnReservar;
	}
	private JButton getBtnAtras3() {
		if (btnAtras3 == null) {
			btnAtras3 = new JButton("Atrás");
			btnAtras3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnAtras3.setBounds(10, 377, 89, 23);
		}
		return btnAtras3;
	}

	
}
