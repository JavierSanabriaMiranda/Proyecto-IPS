package frontend.merchandisingUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import backend.model.Producto;
import backend.service.ventas.merchandising.VentaMerchandising;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	VentaMerchandising ventaMerchandising;
	private JPanel contentPane;
	private JPanel pnLogo;
	private JLabel lbLogo;
	private JPanel pnContents;
	private JPanel pn1;
	private JScrollPane pnProducts;
	private JPanel pnProductos;
	private JPanel pnFilters;
	private JButton btTodos;
	private JButton btEquipaciones;
	private JButton btModaTextil;
	private JButton btAccesorios;
	private JPanel pnInfo1;
	private JPanel pnBts1;
	private JTextField txtPrice;
	private JButton btnCancel;
	private JButton btnNext1;
	private JTabbedPane pnOrder;
	private JTextArea taCarrito;
	private JPanel pnBts2;
	private JButton btnPrevious2;
	private JButton btnNext2;
	private JPanel pnInfo2;
	private JPanel pn2;
	private JPanel pnForm;
	private JPanel pnDatos;
	private JLabel lbNombreApellidos;
	private JLabel lbCalle;
	private JLabel lbCiudad;
	private JLabel lbCP;
	private JLabel lbInformacionAd;
	private JTextField tfNombre;
	private JTextField tfCalle;
	private JTextField tfCiudad;
	private JTextField tfCP;
	private JTextArea taInformacionAd;
	private JPanel pnPago;
	private JLabel lbTarjeta;
	private JLabel lbTitular;
	private JLabel lbFechaCaducidad;
	private JLabel lbCVV;
	private JTextField tfTarjeta;
	private JTextField tfTitular;
	private JTextField tfFecha;
	private JTextField tfCVV;
	private JPanel pn3;
	private JPanel pnConfirmacion;
	private JPanel pnInfo3;
	private JLabel lblAdvise;
	private JLabel lbOk;
	private JPanel pnBts3;
	private JButton btnFinish;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(VentaMerchandising ventaMerchandising) {
		setMinimumSize(new Dimension(900, 1000));
		this.ventaMerchandising = ventaMerchandising;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.jpg")));
		setTitle("Tienda Oficial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 900);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnLogo(), BorderLayout.NORTH);
		contentPane.add(getPnContents(), BorderLayout.CENTER);
	}

	private JPanel getPnLogo() {
		if (pnLogo == null) {
			pnLogo = new JPanel();
			pnLogo.setBackground(Color.WHITE);
			pnLogo.setLayout(new GridLayout(1, 0, 0, 0));
			pnLogo.add(getLbLogo());
		}
		return pnLogo;
	}
	
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("Tienda Oficial");
			lbLogo.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lbLogo.setForeground(Color.BLACK);
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.jpg")));
		}
		return lbLogo;
	}
	
	private JPanel getPnContents() {
		if (pnContents == null) {
			pnContents = new JPanel();
			pnContents.setLayout(new CardLayout(0, 0));
			pnContents.add(getPn1(), "pn1");
			pnContents.add(getPn2(), "pn2");
			pnContents.add(getPn3(), "pn3");
		}
		return pnContents;
	}

	

	private JPanel getPn1() {
		if (pn1 == null) {
			pn1 = new JPanel();
			pn1.setBackground(Color.WHITE);
			pn1.setLayout(new BorderLayout(0, 0));
			pn1.add(getPnProducts(), BorderLayout.CENTER);
			pn1.add(getPnInfo1(), BorderLayout.SOUTH);
			pn1.add(getPnFilters(), BorderLayout.WEST);
		}
		return pn1;
	}
	
	private JScrollPane getPnProducts() {
	    if (pnProducts == null) {
	        pnProducts = new JScrollPane();
	        pnProducts.setBorder(new LineBorder(Color.ORANGE, 4));
	        pnProducts.setBackground(Color.WHITE);
	        pnProducts.setViewportView(getPnProductos());  // Corregir la manera de agregar el panel
	    }
	    return pnProducts;
	}
	
	private JPanel getPnProductos() {
		if(pnProductos == null) {
			pnProductos = new JPanel();
			pnProductos.setBackground(Color.WHITE);
			pnProductos.setLayout(new GridLayout(0, 1, 0, 3));
			createProductPanels(ventaMerchandising.getMenuProducts());
		}
		return pnProductos;
	}

	private void createProductPanels(Producto[] productos) {
	    // Limpiar el panel de productos
	    getPnProductos().removeAll();  // Limpiar el panel de productos, no el JScrollPane

	    // Generar y agregar los productos al panel
	    for (Producto producto : productos) {
	        getPnProductos().add(new PanelProducto(producto, this));
	    }

	    // Refrescar la vista para que Swing actualice correctamente
	    getPnProductos().revalidate();
	    getPnProductos().repaint();
	}

	
	private JPanel getPnInfo1() {
		if (pnInfo1 == null) {
			pnInfo1 = new JPanel();
			pnInfo1.setBackground(Color.WHITE);
			pnInfo1.setLayout(new BorderLayout(0, 0));
			pnInfo1.add(getPnBts1(), BorderLayout.SOUTH);
			pnInfo1.add(getPnOrder(), BorderLayout.CENTER);

		}
		return pnInfo1;
	}

	private JTabbedPane getPnOrder() {
	    if (pnOrder == null) {
	        pnOrder = new JTabbedPane(JTabbedPane.TOP);
	        pnOrder.setBackground(Color.WHITE);  // Fondo blanco de la pesta�a
	        pnOrder.setFont(new Font("Arial", Font.PLAIN, 14));  // Cambiar la fuente de las pesta�as
	        pnOrder.setBorder(new LineBorder(Color.ORANGE, 2));  // A�adir borde alrededor del JTabbedPane
	        
	        // A�adir la pesta�a "Carrito" con el JTextArea envuelto en un JScrollPane
	        pnOrder.addTab("Carrito", null, getCarritoTextArea(), "Productos en el carrito");
	    }
	    return pnOrder;
	}

	private JTextArea getCarritoTextArea() {
	    if (taCarrito == null) {
	        taCarrito = new JTextArea();
	        taCarrito.setEditable(false);  // Desactivar la edici�n
	        taCarrito.setBackground(SystemColor.controlHighlight);  // Fondo gris claro
	        taCarrito.setForeground(Color.BLACK);  // Texto en negro
	        taCarrito.setFont(new Font("Arial", Font.PLAIN, 12));  // Cambiar la fuente
	        taCarrito.setBorder(new LineBorder(Color.BLACK, 1));  // A�adir un borde fino negro
	        taCarrito.setPreferredSize(new java.awt.Dimension(100, 100));
	    }
	    return taCarrito;
	}


	private JPanel getPnBts1() {
		if (pnBts1 == null) {
			pnBts1 = new JPanel();
			pnBts1.setBackground(Color.WHITE);
			pnBts1.setLayout(new GridLayout(1, 3, 0, 0));
			pnBts1.add(getTxtPrice());
			pnBts1.add(getBtnCancel());
			pnBts1.add(getBtnNext1());
		}
		return pnBts1;
	}

	private JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
			txtPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtPrice.setEditable(false);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					initialize();
				}
			});
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnCancel.setForeground(Color.WHITE);
			btnCancel.setBackground(Color.RED);
		}
		return btnCancel;
	}

	private JButton getBtnNext1() {
		if (btnNext1 == null) {
			btnNext1 = new JButton("Siguiente");
			btnNext1.setForeground(Color.WHITE);
			btnNext1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showPn2();
				}
			});
			btnNext1.setEnabled(false);
			btnNext1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNext1.setBackground(new Color(50, 205, 50));
		}
		return btnNext1;
	}
	
	private void showPn2() {
		getPnInfo2().add(getPnOrder());
		getPnBts2().add(getTxtPrice(), 0);
		((CardLayout) getPnContents().getLayout()).show(getPnContents(), "pn2");
	}

	private JPanel getPnBts2() {
		if (pnBts2 == null) {
			pnBts2 = new JPanel();
			pnBts2.setBackground(Color.WHITE);
			pnBts2.setLayout(new GridLayout(1, 3, 0, 0));
			pnBts2.add(getBtnPrevious2());
			pnBts2.add(getBtnNext2());
		}
		return pnBts2;
	}

	private JButton getBtnPrevious2() {
		if (btnPrevious2 == null) {
			btnPrevious2 = new JButton("Anterior");
			btnPrevious2.setForeground(Color.WHITE);
			btnPrevious2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showPn1();
				}
			});
			btnPrevious2.setMnemonic('A');
			btnPrevious2.setBackground(new Color(50, 205, 50));
			btnPrevious2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnPrevious2;
	}
	
	private JButton getBtnNext2() {
		if (btnNext2 == null) {
			btnNext2 = new JButton("Siguiente");
			btnNext2.setForeground(Color.WHITE);
			btnNext2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					showPn3();
				}
			});
			btnNext2.setBackground(new Color(50, 205, 50));
			btnNext2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnNext2;
	}
	
	private void showPn3() {
		((CardLayout) getPnContents().getLayout()).show(getPnContents(), "pn3");
		
	}

	private JPanel getPnInfo2() {
		if (pnInfo2 == null) {
			pnInfo2 = new JPanel();
			pnInfo2.setBackground(Color.WHITE);
			pnInfo2.setLayout(new BorderLayout(0, 0));
			pnInfo2.add(getPnBts2(), BorderLayout.SOUTH);
		}
		return pnInfo2;
	}

	private JPanel getPnFilters() {
		if (pnFilters == null) {
			pnFilters = new JPanel();
			pnFilters.setLayout(new GridLayout(0, 1, 0, 0));
			pnFilters.add(getBtTodos());
			pnFilters.add(getBtEquipaciones());
			pnFilters.add(getBtModaTextil());
			pnFilters.add(getBtAccesorios());
		}
		return pnFilters;
	}

	private JButton getBtTodos() {
		if(btTodos == null) {
			btTodos = new JButton("Todos");
			btTodos.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					createProductPanels(ventaMerchandising.filter(""));
				}
			});
			btTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
			btTodos.setForeground(Color.ORANGE);
			btTodos.setBackground(Color.BLACK);
			btTodos.setMnemonic('T');
		}
		return btTodos;
	}
	
	private JButton getBtEquipaciones() {
		if(btEquipaciones == null) {
			btEquipaciones = new JButton("Equipaciones");
			btEquipaciones.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					createProductPanels(ventaMerchandising.filter("equipacion"));
				}
			});
			btEquipaciones.setFont(new Font("Tahoma", Font.BOLD, 12));
			btEquipaciones.setForeground(Color.ORANGE);
			btEquipaciones.setBackground(Color.BLACK);
			btEquipaciones.setMnemonic('E');
		}
		return btEquipaciones;
	}
	
	private JButton getBtModaTextil() {
		if(btModaTextil == null) {
			btModaTextil = new JButton("Moda Textil");
			btModaTextil.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					createProductPanels(ventaMerchandising.filter("moda textil"));
				}
			});
			btModaTextil.setFont(new Font("Tahoma", Font.BOLD, 12));;
			btModaTextil.setForeground(Color.ORANGE);
			btModaTextil.setBackground(Color.BLACK);
			btModaTextil.setMnemonic('M');
		}
		return btModaTextil;
	}
	
	private JButton getBtAccesorios() {
		if(btAccesorios == null) {
			btAccesorios = new JButton("Accesorios");
			btAccesorios.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					createProductPanels(ventaMerchandising.filter("accesorio"));
				}
			});
			btAccesorios.setFont(new Font("Tahoma", Font.BOLD, 12));
			btAccesorios.setForeground(Color.ORANGE);
			btAccesorios.setBackground(Color.BLACK);
			btAccesorios.setMnemonic('A');
		}
		return btAccesorios;
	}

	private JPanel getPn2() {
	    if (pn2 == null) {
	        pn2 = new JPanel();
	        pn2.setBackground(Color.WHITE);
	        pn2.setLayout(new BorderLayout(0, 0));
	        pn2.add(getPnForm(), BorderLayout.CENTER);
	        pn2.add(getPnInfo2(), BorderLayout.SOUTH);
	    }
	    return pn2;
	}

	private JPanel getPnForm() {
	    if (pnForm == null) {
	        pnForm = new JPanel();
	        pnForm.setBorder(new LineBorder(Color.ORANGE, 4));
	        pnForm.setBackground(Color.WHITE);
	        pnForm.setLayout(new GridBagLayout()); // Usar GridBagLayout
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL; // Llenar horizontalmente
	        gbc.anchor = GridBagConstraints.WEST; // Alinear al lado izquierdo
	        gbc.weightx = 1.0;
	        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado alrededor de los componentes

	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        pnForm.add(getPnDatos(), gbc);

	        gbc.gridy = 1;
	        pnForm.add(getPnPago(), gbc);
	    }
	    return pnForm;
	}

	private JPanel getPnDatos() {
	    if (pnDatos == null) {
	        pnDatos = new JPanel();
	        pnDatos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), 
	                        "Informacion de Envio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	        pnDatos.setBackground(Color.WHITE);
	        pnDatos.setLayout(new GridBagLayout()); // Usar GridBagLayout
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(5, 5, 5, 5);

	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        pnDatos.add(getLbNombreApellidos(), gbc);

	        gbc.gridx = 1;
	        gbc.weightx = 12.0;
	        gbc.gridwidth = 12; 
	        pnDatos.add(getTfNombre(), gbc);

	        gbc.gridx = 0;
	        gbc.gridy++;
	        gbc.weightx = 1.0; // Restablecer el peso horizontal
	        gbc.gridwidth = 1; // Restablecer el ancho de columna
	        pnDatos.add(getLbCalle(), gbc);

	        gbc.gridx = 1;
	        pnDatos.add(getTfCalle(), gbc);

	        gbc.gridx = 0;
	        gbc.gridy++;
	        pnDatos.add(getLbCiudad(), gbc);

	        gbc.gridx = 1;
	        pnDatos.add(getTfCiudad(), gbc);

	        gbc.gridx = 0;
	        gbc.gridy++;
	        pnDatos.add(getLbCP(), gbc);

	        gbc.gridx = 1;
	        pnDatos.add(getTfCP(), gbc);

	        gbc.gridx = 0;
	        gbc.gridy++;
	        gbc.gridwidth = 2;
	        pnDatos.add(getLbInformacionAd(), gbc);

	        gbc.gridy++;
	        pnDatos.add(getTaInformacionAd(), gbc);
	    }
	    return pnDatos;
	}


	private JPanel getPnPago() {
	    if (pnPago == null) {
	        pnPago = new JPanel();
	        pnPago.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Pago",
	                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	        pnPago.setBackground(Color.WHITE);
	        pnPago.setLayout(new GridBagLayout()); // Usar GridBagLayout
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(5, 5, 5, 5);

	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        pnPago.add(getLbTarjeta(), gbc);

	        gbc.gridx = 1;
	        gbc.weightx = 15.0;//Poner el peso en horizontal
	        gbc.gridwidth = 15;//Poner el ancho
	        pnPago.add(getTfTarjeta(), gbc);

	        gbc.gridx = 0;
	        gbc.gridy++;
	        gbc.weightx = 1.0; // Restablecer el peso horizontal
	        gbc.gridwidth = 1; // Restablecer el ancho de columna
	        pnPago.add(getLbTitular(), gbc);

	        gbc.gridx = 1;
	        pnPago.add(getTfTitular(), gbc);

	        gbc.gridx = 0;
	        gbc.gridy++;
	        pnPago.add(getLbFechaCaducidad(), gbc);

	        gbc.gridx = 1;
	        pnPago.add(getTfFecha(), gbc);

	        gbc.gridx = 0;
	        gbc.gridy++;
	        pnPago.add(getLbCVV(), gbc);

	        gbc.gridx = 1;
	        pnPago.add(getTfCVV(), gbc);
	    }
	    return pnPago;
	}


	private void initialize() {
		ventaMerchandising.iniciar();

		getTxtPrice().setText("");
		getCarritoTextArea().setText("");
		getBtnNext1().setEnabled(false);
		createProductPanels(ventaMerchandising.filter(""));

		showPn1();	
	}

	private void showPn1() {
		getPnInfo1().add(getPnOrder());
		getPnBts1().add(getTxtPrice(), 0);
		((CardLayout) getPnContents().getLayout()).show(getPnContents(), "pn1");
	}
	
	private JLabel getLbNombreApellidos() {
		if (lbNombreApellidos == null) {
			lbNombreApellidos = new JLabel("Nombre y Apellidos:");
			lbNombreApellidos.setBackground(Color.WHITE);
			lbNombreApellidos.setBounds(10, 40, 113, 24);
		}
		return lbNombreApellidos;
	}
	private JLabel getLbCalle() {
		if (lbCalle == null) {
			lbCalle = new JLabel("Calle:");
			lbCalle.setBounds(10, 75, 113, 24);
		}
		return lbCalle;
	}
	private JLabel getLbCiudad() {
		if (lbCiudad == null) {
			lbCiudad = new JLabel("Ciudad:");
			lbCiudad.setBounds(10, 110, 89, 26);
		}
		return lbCiudad;
	}
	private JLabel getLbCP() {
		if (lbCP == null) {
			lbCP = new JLabel("Codigo Postal:");
			lbCP.setBounds(10, 147, 89, 14);
		}
		return lbCP;
	}
	private JLabel getLbInformacionAd() {
		if (lbInformacionAd == null) {
			lbInformacionAd = new JLabel("Informacion Adicional:");
			lbInformacionAd.setBounds(10, 185, 113, 14);
		}
		return lbInformacionAd;
	}
	private JTextField getTfNombre() {
		if (tfNombre == null) {
			tfNombre = new JTextField();
			tfNombre.setBounds(151, 36, 383, 26);
			tfNombre.setColumns(10);
		}
		return tfNombre;
	}
	private JTextField getTfCalle() {
		if (tfCalle == null) {
			tfCalle = new JTextField();
			tfCalle.setBounds(151, 77, 383, 25);
			tfCalle.setColumns(10);
		}
		return tfCalle;
	}
	private JTextField getTfCiudad() {
		if (tfCiudad == null) {
			tfCiudad = new JTextField();
			tfCiudad.setBounds(151, 113, 383, 23);
			tfCiudad.setColumns(10);
		}
		return tfCiudad;
	}
	private JTextField getTfCP() {
		if (tfCP == null) {
			tfCP = new JTextField();
			tfCP.setBounds(151, 147, 383, 22);
			tfCP.setColumns(10);
		}
		return tfCP;
	}
	private JTextArea getTaInformacionAd() {
		if (taInformacionAd == null) {
			taInformacionAd = new JTextArea();
			taInformacionAd.setBounds(151, 180, 383, 33);
		}
		return taInformacionAd;
	}
	private JLabel getLbTarjeta() {
		if (lbTarjeta == null) {
			lbTarjeta = new JLabel("Numero de Tarjeta:");
			lbTarjeta.setBounds(10, 35, 118, 14);
		}
		return lbTarjeta;
	}
	private JLabel getLbTitular() {
		if (lbTitular == null) {
			lbTitular = new JLabel("Titular:");
			lbTitular.setBounds(10, 66, 46, 14);
		}
		return lbTitular;
	}
	private JLabel getLbFechaCaducidad() {
		if (lbFechaCaducidad == null) {
			lbFechaCaducidad = new JLabel("Fecha de Caducidad:");
			lbFechaCaducidad.setBounds(10, 103, 105, 14);
		}
		return lbFechaCaducidad;
	}
	private JLabel getLbCVV() {
		if (lbCVV == null) {
			lbCVV = new JLabel("CVV:");
			lbCVV.setBounds(10, 142, 46, 14);
		}
		return lbCVV;
	}
	private JTextField getTfTarjeta() {
		if (tfTarjeta == null) {
			tfTarjeta = new JTextField();
			tfTarjeta.setBounds(149, 23, 382, 26);
			tfTarjeta.setColumns(10);
		}
		return tfTarjeta;
	}
	private JTextField getTfTitular() {
		if (tfTitular == null) {
			tfTitular = new JTextField();
			tfTitular.setBounds(149, 60, 382, 25);
			tfTitular.setColumns(10);
		}
		return tfTitular;
	}
	private JTextField getTfFecha() {
		if (tfFecha == null) {
			tfFecha = new JTextField();
			tfFecha.setBounds(149, 96, 382, 28);
			tfFecha.setColumns(10);
		}
		return tfFecha;
	}
	private JTextField getTfCVV() {
		if (tfCVV == null) {
			tfCVV = new JTextField();
			tfCVV.setBounds(149, 135, 382, 29);
			tfCVV.setColumns(10);
		}
		return tfCVV;
	}
	
	private JPanel getPn3() {
	    if (pn3 == null) {
	        pn3 = new JPanel();
	        pn3.setBackground(Color.WHITE);
	        pn3.setLayout(new BorderLayout(0, 0));
	        pn3.add(getPnConfirmation(), BorderLayout.CENTER);
	        pn3.add(getPnInfo3(), BorderLayout.SOUTH);
	    }
	    return pn3;
	}

	private JPanel getPnConfirmation() {
	    if (pnConfirmacion == null) {
	        pnConfirmacion = new JPanel();
	        pnConfirmacion.setBorder(new LineBorder(Color.ORANGE, 4));
	        pnConfirmacion.setBackground(Color.WHITE);
	        pnConfirmacion.setLayout(new GridBagLayout()); // Usar GridBagLayout
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado alrededor de los componentes
	        gbc.anchor = GridBagConstraints.CENTER; // Centrar los componentes
	        gbc.weightx = 0.0; // No expandir horizontalmente
	        gbc.weighty = 1.0;

	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        pnConfirmacion.add(getLbOk(), gbc);

	        gbc.gridx = 1; // Mover a la siguiente columna
	        gbc.insets = new Insets(10, 5, 10, 10); // Reducir el espaciado entre lbOk y lblAdvise
	        pnConfirmacion.add(getLblAdvise(), gbc);
	    }
	    return pnConfirmacion;
	}

	private JLabel getLblAdvise() {
	    if (lblAdvise == null) {
	        lblAdvise = new JLabel();
	        lblAdvise.setText("Gracias por confiar en nosotros!");
	        lblAdvise.setFont(new Font("Tahoma", Font.BOLD, 28));
	    }
	    return lblAdvise;
	}

	private JLabel getLbOk() {
	    if (lbOk == null) {
	        lbOk = new JLabel("");
	        lbOk.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ok.png")));
	    }
	    return lbOk;
	}



	private JPanel getPnInfo3() {
		if (pnInfo3 == null) {
			pnInfo3 = new JPanel();
			pnInfo3.setBackground(Color.WHITE);
			pnInfo3.setLayout(new BorderLayout(0, 0));
			pnInfo3.add(getPnBts3(), BorderLayout.SOUTH);
		}
		return pnInfo3;
	}

	private JPanel getPnBts3() {
		if (pnBts3 == null) {
			pnBts3 = new JPanel();
			pnBts3.setBackground(Color.WHITE);
			pnBts3.setLayout(new GridLayout(1, 3, 0, 0));
			pnBts3.add(getBtnFinish());
		}
		return pnBts3;
	}

	private JButton getBtnFinish() {
		if (btnFinish == null) {
			btnFinish = new JButton("Confirmar");
			btnFinish.setForeground(Color.WHITE);
			btnFinish.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					finish();
				}
			});
			btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnFinish.setBackground(new Color(50, 205, 50));
		}
		return btnFinish;
	}
	
	private void finish() {
		ventaMerchandising.saveOrder();
		initialize();
	}
	
	// M�todo para a�adir texto al carrito
    public void ponerTextoCarrito(String texto) {
        taCarrito.setText(texto);
    }
    
    public void ponerTextoPrecio(String texto) {
    	getTxtPrice().setText("Total: " + texto);
    }
    
    public VentaMerchandising getMerchandising() {
    	return this.ventaMerchandising;
    }

	public void mostarSiguiente(boolean b) {
		getBtnNext1().setEnabled(b);
	}
}
