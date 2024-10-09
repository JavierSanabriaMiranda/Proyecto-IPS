package frontend.reservaUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import backend.service.ventas.reservas.Instalacion;
import shared.gestioninstalaciones.ReservaShared;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaPrincipalReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelReserva;
	private JLabel lblInstalacion;
	private JComboBox<Instalacion> comboBoxInstalaciones;
	private JLabel lblDiaReserva;
	private JDateChooser dateChooser;
	private JButton btnSiguiente1;
	private JButton btnAtras1;
	private ReservaShared reservaShared;
	private Date fechaSeleccionada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaShared reservaShared = new ReservaShared();
					VentanaPrincipalReserva frame = new VentanaPrincipalReserva(reservaShared);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaPrincipalReserva(ReservaShared rs) {
		iniciarVentana(rs);
	}
	
	public ReservaShared getReservaShared() {
		return reservaShared;
	}

	private void iniciarVentana(ReservaShared rs) {
		this.reservaShared = rs;
		setTitle("Reserva de Instalación");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 462);
		this.setLocationRelativeTo(null);
		panelReserva = new JPanel();
		panelReserva.setBackground(new Color(255, 255, 255));
		panelReserva.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelReserva);
		
		panelReserva.setLayout(null);
		panelReserva.add(getLblInstalacion());
		panelReserva.add(getLblDiaReserva());
		panelReserva.add(getComboBoxInstalaciones());
		panelReserva.add(getDateChooser());
        panelReserva.add(getBtnSiguiente1());
        panelReserva.add(getBtnAtras1());
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
	        dateChooser.setLocation(79, 188);
	        dateChooser.addPropertyChangeListener("date", evt -> {
	            actualizarBotonSiguiente();
	        });
		}
		return dateChooser;
	}

	public Date getFechaSeleccionada() {
		return this.fechaSeleccionada;
	}

	public JComboBox<Instalacion> getComboBoxInstalaciones() {
	    if (comboBoxInstalaciones == null) {
	        comboBoxInstalaciones = new JComboBox<>();
	        lblInstalacion.setLabelFor(comboBoxInstalaciones);
	        comboBoxInstalaciones.setBounds(79, 94, 205, 32);
	        comboBoxInstalaciones.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                actualizarBotonSiguiente();
	            }
	        });

	        // Crear el modelo basado en la lista de instalaciones
	        DefaultComboBoxModel<Instalacion> model = new DefaultComboBoxModel<>();
	        List<Instalacion> instalaciones = getReservaShared().cargaInstalaciones();
	        for (Instalacion instalacion : instalaciones) {
	            model.addElement(instalacion);  // Añadir cada instalación al modelo
	        }
	         
	        // Establecer el modelo en el comboBox
	        comboBoxInstalaciones.setModel(model);
	    }
	    return comboBoxInstalaciones;
	}

	public void setComboBoxInstalaciones(JComboBox<Instalacion> comboBoxInstalaciones) {
		this.comboBoxInstalaciones = comboBoxInstalaciones;
	}

	public JLabel getLblInstalacion() {
		if (lblInstalacion == null) {
			lblInstalacion = new JLabel("Seleccione la Instalación: ");
			lblInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblInstalacion.setBounds(79, 58, 205, 25);
		}
		return lblInstalacion;
	}

	public JLabel getLblDiaReserva() {
		if (lblDiaReserva == null) {
			lblDiaReserva = new JLabel("Seleccione el día de su reserva:");
			lblDiaReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDiaReserva.setBounds(79, 137, 205, 25);
		}
		return lblDiaReserva;
	}

	public JPanel getPanelReserva() {
		return panelReserva;
	}
	
	public JButton getBtnSiguiente1() {
		if (btnSiguiente1 == null) {
			btnSiguiente1 = new JButton("Siguiente");
			btnSiguiente1.setEnabled(false);
	        btnSiguiente1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		crearVentanaHorario();
	        	}
	        });
	        btnSiguiente1.setMnemonic('g');
	        btnSiguiente1.setBounds(471, 389, 105, 25);
		}
		return btnSiguiente1;
	}
	
	private void actualizarBotonSiguiente() {
	    // Habilitar el botón solo si hay una instalación seleccionada y una fecha seleccionada
	    boolean isInstalacionSelected = comboBoxInstalaciones.getSelectedItem() != null;
	    boolean isFechaSelected = dateChooser.getDate() != null;
	    if (isFechaSelected) {
	    	Date fecha = dateChooser.getDate(); //Este getDate me devuelve null
	    	Calendar cal = Calendar.getInstance();
	    	cal.setTime(fecha);
	    	this.fechaSeleccionada = cal.getTime();
	    }
	    btnSiguiente1.setEnabled(isInstalacionSelected && isFechaSelected);
	}
	
	

	private void crearVentanaHorario() {
		try {
			HorarioReserva dialog = new HorarioReserva(this);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JButton getBtnAtras1() {
		if (btnAtras1 == null) {
			btnAtras1 = new JButton("Atras");
			btnAtras1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnAtras1.setBounds(10, 390, 89, 23);
		}
		return btnAtras1;
	}

	
}
