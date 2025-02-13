package frontend.merchandisingUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
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
	private JButton btnPrevious2;
	private JButton btnNext2;
	private JPanel pnInfo2;
	private JPanel pn2;
	private JPanel pn3;
	private JPanel pnInfo3;
	private JPanel pnBts3;
	private JButton btnFinish;
	private JScrollPane scrollPaneResumen;
	private JLabel lbResumen;
	private JTable tableResumenPedido;
	private DefaultTableModel tableModelResumen;
	private JLabel lbCorreo;
	private JTextField tfCorreo;
	private JPanel pnDatos;
	private JPanel pnCorreo;
	private JPanel pnNombre;
	private JLabel lbNombre;
	private JTextField tfNombre;
	private JPanel pnDNI;
	private JLabel lbDNI;
	private JTextField tfDNI;
	private JPanel pnDomicilio;
	private JLabel lbDomicilio;
	private JTextField tfDomicilio;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setMinimumSize(new Dimension(900, 1000));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/productos/logo.jpg")));
		setTitle("Tienda Oficial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 1000);
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
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/productos/logo.jpg")));
		}
		return lbLogo;
	}
	
	public JPanel getPnContents() {
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
	
	public JPanel getPnProductos() {
		if(pnProductos == null) {
			pnProductos = new JPanel();
			pnProductos.setBackground(Color.WHITE);
			pnProductos.setLayout(new GridLayout(0, 1, 0, 3));
		}
		return pnProductos;
	}

	public JPanel getPnInfo1() {
		if (pnInfo1 == null) {
			pnInfo1 = new JPanel();
			pnInfo1.setBackground(Color.WHITE);
			pnInfo1.setLayout(new BorderLayout(0, 0));
			pnInfo1.add(getPnBts1(), BorderLayout.SOUTH);
			pnInfo1.add(getPnOrder(), BorderLayout.CENTER);

		}
		return pnInfo1;
	}

	public JTabbedPane getPnOrder() {
	    if (pnOrder == null) {
	        pnOrder = new JTabbedPane(JTabbedPane.TOP);
	        pnOrder.setBackground(Color.WHITE);  // Fondo blanco de la pestaña
	        pnOrder.setFont(new Font("Arial", Font.PLAIN, 14));  // Cambiar la fuente de las pestañas
	        pnOrder.setBorder(new LineBorder(Color.ORANGE, 2));  // Añadir borde alrededor del JTabbedPane
	        
	        // Añadir la pestaña "Carrito" con el JTextArea envuelto en un JScrollPane
	        pnOrder.addTab("Carrito", null, getCarritoTextArea(), "Productos en el carrito");
	    }
	    return pnOrder;
	}

	public JTextArea getCarritoTextArea() {
	    if (taCarrito == null) {
	        taCarrito = new JTextArea();
	        taCarrito.setEditable(false);  // Desactivar la edición
	        taCarrito.setBackground(new Color(245, 245, 245));  // Fondo gris claro
	        taCarrito.setForeground(Color.BLACK);  // Texto en negro
	        taCarrito.setFont(new Font("Arial", Font.PLAIN, 12));  // Cambiar la fuente
	        taCarrito.setBorder(new LineBorder(Color.BLACK, 1));  // Añadir un borde fino negro
	        taCarrito.setPreferredSize(new java.awt.Dimension(100, 100));
	    }
	    return taCarrito;
	}


	public JPanel getPnBts1() {
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

	public JTextField getTxtPrice() {
		if (txtPrice == null) {
			txtPrice = new JTextField();
			txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
			txtPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
			txtPrice.setEditable(false);
			txtPrice.setColumns(10);
		}
		return txtPrice;
	}

	public JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancelar");
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnCancel.setForeground(Color.WHITE);
			btnCancel.setBackground(Color.RED);
		}
		return btnCancel;
	}

	public JButton getBtnNext1() {
		if (btnNext1 == null) {
			btnNext1 = new JButton("Siguiente");
			btnNext1.setForeground(Color.WHITE);
			btnNext1.setEnabled(false);
			btnNext1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNext1.setBackground(new Color(50, 205, 50));
		}
		return btnNext1;
	}

	public JButton getBtnPrevious2() {
		if (btnPrevious2 == null) {
			btnPrevious2 = new JButton("Anterior");
			btnPrevious2.setForeground(Color.WHITE);
			btnPrevious2.setMnemonic('A');
			btnPrevious2.setBackground(new Color(50, 205, 50));
			btnPrevious2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnPrevious2;
	}
	
	public JButton getBtnNext2() {
		if (btnNext2 == null) {
			btnNext2 = new JButton("Siguiente");
			btnNext2.setForeground(Color.WHITE);
			btnNext2.setBackground(new Color(50, 205, 50));
			btnNext2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnNext2;
	}
	
	public JPanel getPnInfo2() {
		if (pnInfo2 == null) {
			pnInfo2 = new JPanel();
			pnInfo2.setBackground(Color.WHITE);
			pnInfo2.setLayout(new GridLayout(0, 3, 10, 0));
			pnInfo2.add(getBtnPrevious2());
			pnInfo2.add(getBtnNext2());
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

	public JButton getBtTodos() {
		if(btTodos == null) {
			btTodos = new JButton("Todos");
			btTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
			btTodos.setForeground(Color.ORANGE);
			btTodos.setBackground(Color.BLACK);
			btTodos.setMnemonic('T');
		}
		return btTodos;
	}
	
	public JButton getBtEquipaciones() {
		if(btEquipaciones == null) {
			btEquipaciones = new JButton("Equipaciones");
			btEquipaciones.setFont(new Font("Tahoma", Font.BOLD, 12));
			btEquipaciones.setForeground(Color.ORANGE);
			btEquipaciones.setBackground(Color.BLACK);
			btEquipaciones.setMnemonic('E');
		}
		return btEquipaciones;
	}
	
	public JButton getBtModaTextil() {
		if(btModaTextil == null) {
			btModaTextil = new JButton("Moda Textil");
			btModaTextil.setFont(new Font("Tahoma", Font.BOLD, 12));;
			btModaTextil.setForeground(Color.ORANGE);
			btModaTextil.setBackground(Color.BLACK);
			btModaTextil.setMnemonic('M');
		}
		return btModaTextil;
	}
	
	public JButton getBtAccesorios() {
		if(btAccesorios == null) {
			btAccesorios = new JButton("Accesorios");
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
	        pn2.add(getPnInfo2(), BorderLayout.SOUTH);
	        pn2.add(getScrollPaneResumen(), BorderLayout.CENTER);
	    }
	    return pn2;
	}	

	private JPanel getPn3() {
	    if (pn3 == null) {
	        pn3 = new JPanel();
	        pn3.setBackground(Color.WHITE);
	        pn3.setLayout(new BorderLayout(0, 60));
	        pn3.add(getPnInfo3(), BorderLayout.SOUTH);
	        pn3.add(getPnDatos(), BorderLayout.CENTER);
	    }
	    return pn3;
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

	public JButton getBtnFinish() {
		if (btnFinish == null) {
			btnFinish = new JButton("Confirmar");
			btnFinish.setEnabled(false);
			btnFinish.setForeground(Color.WHITE);
			btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnFinish.setBackground(new Color(50, 205, 50));
		}
		return btnFinish;
	}
	
	private JScrollPane getScrollPaneResumen() {
		if (scrollPaneResumen == null) {
			scrollPaneResumen = new JScrollPane();
			scrollPaneResumen.setViewportView(getTableResumenPedido());
	        scrollPaneResumen.setColumnHeaderView(getLbResumen());
		}
		return scrollPaneResumen;
	}
	
	public JTable getTableResumenPedido() {
	    if (tableResumenPedido == null) {
	        String[] columnNames = {"Producto", "Cantidad", "Precio Unitario", "Total"};
	        tableModelResumen = new DefaultTableModel(columnNames, 0);
	        tableResumenPedido = new JTable(tableModelResumen);
	        tableResumenPedido.setFillsViewportHeight(true);
	        tableResumenPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        tableResumenPedido.setRowHeight(25);
	        tableResumenPedido.setFocusable(false);
	        tableResumenPedido.setRowSelectionAllowed(false);
	        tableResumenPedido.setColumnSelectionAllowed(false);
	        tableResumenPedido.setCellSelectionEnabled(false);
	        tableResumenPedido.getTableHeader().setReorderingAllowed(false); // Deshabilitar reordenamiento de columnas
	        tableResumenPedido.getTableHeader().setResizingAllowed(false);   // Deshabilitar redimensionamiento de columnas
	        tableResumenPedido.setEnabled(false); // Desactivar completamente la tabla
	    }
	    return tableResumenPedido;
	}
	
	private JLabel getLbResumen() {
		if (lbResumen == null) {
			lbResumen = new JLabel("Resumen del Pedido:");
			lbResumen.setBackground(Color.WHITE);
			lbResumen.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lbResumen;
	}
	
	public DefaultTableModel getTableModel() {
		return tableModelResumen;
	}

	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Datos del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnDatos.setBackground(Color.WHITE);
			pnDatos.setLayout(new GridLayout(4, 1, 0, 60));
			pnDatos.add(getPnNombre());
			pnDatos.add(getPnDNI());
			pnDatos.add(getPnDomicilio());
			pnDatos.add(getPnCorreo());
		}
		return pnDatos;
	}
	
	private JPanel getPnNombre() {
		if (pnNombre == null) {
			pnNombre = new JPanel();
			pnNombre.setBackground(new Color(255, 255, 255));
			pnNombre.setLayout(new BorderLayout(0, 0));
			pnNombre.add(getLblNombre(), BorderLayout.CENTER);
			pnNombre.add(getTfNombre(), BorderLayout.SOUTH);
		}
		return pnNombre;
	}
	
	private JLabel getLblNombre() {
        if (lbNombre == null) {
        	lbNombre = new JLabel("Introduzca su nombre:");
        	lbNombre.setBackground(new Color(255, 255, 255));
        	lbNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
        }
        return lbNombre;
    }

    public JTextField getTfNombre() {
        if (tfNombre == null) {
        	tfNombre = new JTextField();
        	tfNombre.setColumns(20);
        	tfNombre.setPreferredSize(new Dimension(300,30));
        	tfNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        return tfNombre;
    }
    
    private JPanel getPnDNI() {
		if (pnDNI == null) {
			pnDNI = new JPanel();
			pnDNI.setBackground(new Color(255, 255, 255));
			pnDNI.setLayout(new BorderLayout(0, 0));
			pnDNI.add(getLblDNI(), BorderLayout.CENTER);
			pnDNI.add(getTfDNI(), BorderLayout.SOUTH);
		}
		return pnDNI;
	}
	
	private JLabel getLblDNI() {
        if (lbDNI == null) {
        	lbDNI = new JLabel("Introduzca su DNI:");
        	lbDNI.setBackground(new Color(255, 255, 255));
            lbDNI.setFont(new Font("Tahoma", Font.BOLD, 12));
        }
        return lbDNI;
    }

    public JTextField getTfDNI() {
        if (tfDNI == null) {
        	tfDNI = new JTextField();
        	tfDNI.setColumns(20);
        	tfDNI.setPreferredSize(new Dimension(300,30));
        	tfDNI.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        return tfDNI;
    }
    
    private JPanel getPnDomicilio() {
		if (pnDomicilio == null) {
			pnDomicilio = new JPanel();
			pnDomicilio.setBackground(new Color(255, 255, 255));
			pnDomicilio.setLayout(new BorderLayout(0, 0));
			pnDomicilio.add(getLblDomicilio(), BorderLayout.CENTER);
			pnDomicilio.add(getTfDomicilio(), BorderLayout.SOUTH);
		}
		return pnDomicilio;
	}
	
	private JLabel getLblDomicilio() {
        if (lbDomicilio == null) {
        	lbDomicilio = new JLabel("Introduzca su Domicio:(Calle, Piso, Ciudad, Codigo Postal )");
        	lbDomicilio.setBackground(new Color(255, 255, 255));
        	lbDomicilio.setFont(new Font("Tahoma", Font.BOLD, 12));
        }
        return lbDomicilio;
    }

    public JTextField getTfDomicilio() {
        if (tfDomicilio == null) {
        	tfDomicilio = new JTextField();
        	tfDomicilio.setColumns(20);
        	tfDomicilio.setPreferredSize(new Dimension(300,30));
        	tfDomicilio.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        return tfDomicilio;
    }
	
	private JPanel getPnCorreo() {
		if (pnCorreo == null) {
			pnCorreo = new JPanel();
			pnCorreo.setBackground(new Color(255, 255, 255));
			pnCorreo.setLayout(new BorderLayout(0, 0));
			pnCorreo.add(getLblCorreo(), BorderLayout.CENTER);
			pnCorreo.add(getTfCorreo(), BorderLayout.SOUTH);
		}
		return pnCorreo;
	}
	
	private JLabel getLblCorreo() {
        if (lbCorreo == null) {
            lbCorreo = new JLabel("Correo electrónico:");
            lbCorreo.setBackground(new Color(255, 255, 255));
            lbCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
        }
        return lbCorreo;
    }

    public JTextField getTfCorreo() {
        if (tfCorreo == null) {
            tfCorreo = new JTextField();
            tfCorreo.setColumns(20);
            tfCorreo.setPreferredSize(new Dimension(300,30));
            tfCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
        return tfCorreo;
    }
}
