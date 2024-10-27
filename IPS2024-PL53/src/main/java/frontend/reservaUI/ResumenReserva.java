package frontend.reservaUI;

import java.awt.BorderLayout;
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
	private JLabel lblDNI;
	private JTextField txtDNI;
	

	/**
	 * Create the dialog.
	 */
	public ResumenReserva(HorarioReserva hr) {
		this.hr = hr;
		setModal(true);
		setTitle("ResumenReserva");
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 633, 488);
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
		contentPanel.add(getLblDNI());
		contentPanel.add(getTxtDNI());
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
			textAreaResumen.setBounds(41, 67, 467, 121);
			
			 StringBuilder sb = new StringBuilder();
		        sb.append("- Día: ").append(hr.getFranjaReserva().getFecha()).append("\n");
		        sb.append("- Hora Inicio: ").append(hr.getFranjaReserva().getHoraInicio()).append("\n");
		        sb.append("- Hora Fin: ").append(hr.getFranjaReserva().getHoraFin()).append("\n");
		        sb.append("- Instalación: ").append(hr.getInstalacionReserva()).append("\n");
		        sb.append("- Precio: ").append(hr.getPrecioReserva()).append(" €\n");
		    textAreaResumen.setText(sb.toString());
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
			lblNombreApellidos.setBounds(41, 199, 163, 14);
		}
		return lblNombreApellidos;
	}
	public JTextField getTxtNombreApellidos() {
		if (txtNombreApellidos == null) {
			txtNombreApellidos = new JTextField();
			txtNombreApellidos.setBounds(41, 224, 183, 30);
			txtNombreApellidos.setColumns(10);
		}
		return txtNombreApellidos;
	}
	private JLabel getLblNumTarjeta() {
		if (lblNumTarjeta == null) {
			lblNumTarjeta = new JLabel("Número de tarjeta");
			lblNumTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNumTarjeta.setBounds(41, 255, 163, 14);
		}
		return lblNumTarjeta;
	}
	public JTextField getTxtNumTarjeta() {
		if (txtNumTarjeta == null) {
			txtNumTarjeta = new JTextField();
			txtNumTarjeta.setBounds(41, 280, 183, 30);
			txtNumTarjeta.setColumns(10);
		}
		return txtNumTarjeta;
	}
	public JButton getBtnReservar() {
		if (btnReservar == null) {
			btnReservar = new JButton("Reservar");
			btnReservar.setEnabled(false);
			btnReservar.setBounds(520, 417, 89, 23);
		}
		return btnReservar;
	}
	
	public JButton getBtnAtras3() {
		if (btnAtras3 == null) {
			btnAtras3 = new JButton("Atrás");
			btnAtras3.setBounds(10, 417, 89, 23);
		}
		return btnAtras3;
	}
	private JLabel getLblDNI() {
		if (lblDNI == null) {
			lblDNI = new JLabel("DNI: ");
			lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDNI.setBounds(41, 321, 163, 14);
		}
		return lblDNI;
	}
	public JTextField getTxtDNI() {
		if (txtDNI == null) {
			txtDNI = new JTextField();
			txtDNI.setColumns(10);
			txtDNI.setBounds(41, 346, 183, 28);
		}
		return txtDNI;
	}
	
	
}
