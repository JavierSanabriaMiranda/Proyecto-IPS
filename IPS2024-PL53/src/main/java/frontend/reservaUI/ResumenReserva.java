package frontend.reservaUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.reservas.ClienteReserva;
import backend.service.ventas.reservas.Instalacion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Date;
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
			textAreaResumen.setBounds(41, 67, 467, 80);
			
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
			lblNombreApellidos.setBounds(41, 168, 163, 14);
		}
		return lblNombreApellidos;
	}
	private JTextField getTxtNombreApellidos() {
		if (txtNombreApellidos == null) {
			txtNombreApellidos = new JTextField();
			txtNombreApellidos.getDocument().addDocumentListener(new DocumentListener() {
	            public void insertUpdate(DocumentEvent e) {
	                actualizarBotonReserva();
	            }
	            public void removeUpdate(DocumentEvent e) {
	                actualizarBotonReserva();
	            }
	            public void changedUpdate(DocumentEvent e) {
	                actualizarBotonReserva();
	            }
	        });
			txtNombreApellidos.setBounds(41, 193, 183, 20);
			txtNombreApellidos.setColumns(10);
		}
		return txtNombreApellidos;
	}
	private JLabel getLblNumTarjeta() {
		if (lblNumTarjeta == null) {
			lblNumTarjeta = new JLabel("Número de tarjeta");
			lblNumTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNumTarjeta.setBounds(41, 224, 163, 14);
		}
		return lblNumTarjeta;
	}
	private JTextField getTxtNumTarjeta() {
		if (txtNumTarjeta == null) {
			txtNumTarjeta = new JTextField();
			txtNumTarjeta.getDocument().addDocumentListener(new DocumentListener() {
	            public void insertUpdate(DocumentEvent e) {
	                actualizarBotonReserva();
	            }
	            public void removeUpdate(DocumentEvent e) {
	                actualizarBotonReserva();
	            }
	            public void changedUpdate(DocumentEvent e) {
	                actualizarBotonReserva();
	            }
	        });
			txtNumTarjeta.setBounds(41, 249, 183, 20);
			txtNumTarjeta.setColumns(10);
		}
		return txtNumTarjeta;
	}
	private JButton getBtnReservar() {
		if (btnReservar == null) {
			btnReservar = new JButton("Reservar");
			btnReservar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reservar();
					mostrarMensajeExito();
					cerrarVentanas();
				}
			});
			btnReservar.setEnabled(false);
			btnReservar.setBounds(481, 377, 89, 23);
		}
		return btnReservar;
	}
	
	private void reservar() {
		FranjaTiempo franja = hr.getFranjaReserva();
		Instalacion inst = hr.getInstalacionReserva();
		ClienteReserva cl = new ClienteReserva(getTxtNombreApellidos().getText());
		float precio = hr.getPrecioReserva();
		Date fecha = hr.getDateReserva();
		String dni = getTxtDNI().getText();
		String numTarj = getTxtNumTarjeta().getText();
		
		hr.getVpr().getReservaShared().addReserva(franja, inst, cl, precio, fecha, dni, numTarj);
	}
	
	private static void mostrarMensajeExito() {
        // Usamos JOptionPane para mostrar el mensaje
        JOptionPane.showMessageDialog(null, "Reserva realizada con éxito", 
                                      "Mensaje de Confirmación", 
                                      JOptionPane.INFORMATION_MESSAGE);
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
	private JLabel getLblDNI() {
		if (lblDNI == null) {
			lblDNI = new JLabel("DNI: ");
			lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDNI.setBounds(41, 284, 163, 14);
		}
		return lblDNI;
	}
	private JTextField getTxtDNI() {
		if (txtDNI == null) {
			txtDNI = new JTextField();
			txtDNI.getDocument().addDocumentListener(new DocumentListener() {
	            public void insertUpdate(DocumentEvent e) {
	                actualizarBotonReserva();
	            }
	            public void removeUpdate(DocumentEvent e) {
	                actualizarBotonReserva();
	            }
	            public void changedUpdate(DocumentEvent e) {
	                actualizarBotonReserva();
	            }
	        });
			txtDNI.setColumns(10);
			txtDNI.setBounds(41, 309, 183, 20);
		}
		return txtDNI;
	}
	
	private void actualizarBotonReserva() {
		String dni = getTxtDNI().getText();
	    String nombreApellidos = getTxtNombreApellidos().getText();
	    String numTarjeta = getTxtNumTarjeta().getText();

	    if (!dni.isEmpty() && !nombreApellidos.isEmpty() && !numTarjeta.isEmpty()) {
	        // Si todos los campos tienen valor, habilitar el botón "Reservar"
	        getBtnReservar().setEnabled(true);
	    } else {
	        // Si algún campo está vacío, deshabilitar el botón "Reservar"
	    	getBtnReservar().setEnabled(false);
	    }
	}
	
	private void cerrarVentanas() {
		System.exit(0);
	}
}
