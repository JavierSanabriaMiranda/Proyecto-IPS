package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import backend.data.Database;
import backend.data.productos.ProductoCRUDImpl;
import frontend.empleados.FrameGestionEmpleados;
import frontend.empleados.horarios.FrameHorariosEmpleados;
import frontend.entradaUI.VentanaPrincipalEntrada;
import frontend.entrevistaUI.VentanaPrincipalEntrevista;
import frontend.equiposUI.VentanaPrincipalEquipos;
import frontend.historialVentas.HistorialVentas;
import frontend.jardineriaUI.VentanaJardineros;
import frontend.merchandisingUI.VentanaPrincipal;
import frontend.noticias.CargarNoticia;
import frontend.noticias.PortalNoticias;
import frontend.reservaUI.VentanaPrincipalReserva;
import shared.gestionHistorial.GestionHistorialShared;
import shared.gestionNoticias.GestionCargarNoticiaShared;
import shared.gestionNoticias.GestionImagenesShared;
import shared.gestionNoticias.GestionPortalNoticiasShared;
import shared.gestionProductos.GestionProductoShared;
import shared.gestionequipos.GestionEquiposShared;
import shared.gestionequipos.GestionPanelEquiposShared;
import shared.gestioninstalaciones.GestionPanelReservaShared;
import shared.gestioninstalaciones.ReservaShared;
import shared.gestionjardineria.GestionPanelJardineriaShared;
import shared.gestionjardineria.JardinerosShared;

public class AplicacionMain {

    private JFrame frmAplicacionBurgosFc;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                AplicacionMain window = new AplicacionMain();
                window.frmAplicacionBurgosFc.setVisible(true);
            } catch (Exception e) {
            	e.printStackTrace();
            }
        });
    }

    public AplicacionMain() {
        initialize();
    }

    private void initialize() {
        frmAplicacionBurgosFc = new JFrame();
        frmAplicacionBurgosFc.setResizable(false);
        frmAplicacionBurgosFc.getContentPane().setBackground(Color.WHITE);
        frmAplicacionBurgosFc.setTitle("Aplicacion Burgos FC");
        frmAplicacionBurgosFc.setIconImage(Toolkit.getDefaultToolkit().getImage(AplicacionMain.class.getResource("/img/productos/logo.jpg")));
        frmAplicacionBurgosFc.setBounds(100, 100, 550, 250);
        frmAplicacionBurgosFc.setLocationRelativeTo(null);
        frmAplicacionBurgosFc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAplicacionBurgosFc.getContentPane().setLayout(new BoxLayout(frmAplicacionBurgosFc.getContentPane(), BoxLayout.Y_AXIS));

		//Boton para inicializar base de datos
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionImagenesShared gis = new GestionImagenesShared();
				gis.eliminarArchivosCarpeta();
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		frmAplicacionBurgosFc.getContentPane().add(btnInicializarBaseDeDatos);

		//Boton para cargar los datos iniciales
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			@Override
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frmAplicacionBurgosFc.getContentPane().add(btnCargarDatosIniciales);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();
        frmAplicacionBurgosFc.setJMenuBar(menuBar);

        // Menú "Gestión"
        JMenu gestionMenu = new JMenu("Gestión de Empleados");
        menuBar.add(gestionMenu);

        // Opción "Gestionar empleados"
        JMenuItem gestionEmpleados = new JMenuItem("Gestionar Empleados");
        gestionEmpleados.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarGestionEmpleados();
        });
        gestionMenu.add(gestionEmpleados);

        // Opción "Asignar horarios"
        JMenuItem asignarHorarios = new JMenuItem("Asignar Horarios");
        asignarHorarios.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarHorariosEmpleados();
        });
        gestionMenu.add(asignarHorarios);

        // Menú "Ventas"
        JMenu ventasMenu = new JMenu("Ventas");
        menuBar.add(ventasMenu);

        // Opción "Ventas de Merchandising"
        JMenuItem ventasMerchandising = new JMenuItem("Compra de Merchandising");
        ventasMerchandising.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarMerchandising();
        });
        ventasMenu.add(ventasMerchandising);

        // Opción "Ventas de Entradas"
        JMenuItem ventasEntradas = new JMenuItem("Compra de Entradas");
        ventasEntradas.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarEntradas();
        });
        ventasMenu.add(ventasEntradas);

        // Opción "Reservar instalaciones"
        JMenuItem reservasInstalaciones = new JMenuItem("Reservar Instalaciones");
        reservasInstalaciones.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarReservas();
        });
        ventasMenu.add(reservasInstalaciones);

        // Menú "Equipos"
        JMenu equiposMenu = new JMenu("Añadir Equipos");
        menuBar.add(equiposMenu);

        // Opción "Añadir equipos"
        JMenuItem anadirEquipos = new JMenuItem("Añadir Equipos");
        anadirEquipos.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarGestionEquipos();
        });
        equiposMenu.add(anadirEquipos);

        // Menú "Entrevistas"
        JMenu entrevistasMenu = new JMenu("Entrevistas");
        menuBar.add(entrevistasMenu);

        // Opción "Crear Entrevistas"
        JMenuItem crearEntrevistas = new JMenuItem("Crear Entrevistas");
        crearEntrevistas.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarGestionEntrevistas();
        });
        entrevistasMenu.add(crearEntrevistas);

        // Menú "Historial de Ventas"
        JMenu historialMenu = new JMenu("Historial de Ventas");
        menuBar.add(historialMenu);

        // Opción "Ver Historial de Ventas"
        JMenuItem historialVentas = new JMenuItem("Ver Historial de Ventas");
        historialVentas.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarHistorialDeVentas();
        });
        historialMenu.add(historialVentas);
        
     // Menú "Noticias"
        JMenu noticiasMenu = new JMenu("Noticias");
        menuBar.add(noticiasMenu);

        // Opción "Cargar Noticias"
        JMenuItem cargarNoticias = new JMenuItem("Crear Noticia");
        cargarNoticias.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarCargarNoticias();
        });
        noticiasMenu.add(cargarNoticias);

        JMenuItem horarioJardineros = new JMenuItem("Horarios Jardinería");
        horarioJardineros.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarJardineria();
        });
        gestionMenu.add(horarioJardineros);



     // Opción "Ver Portal Noticias"
        JMenuItem portalNoticias = new JMenuItem("Portal de Noticias");
        portalNoticias.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarPortalNoticias();
        });
        noticiasMenu.add(portalNoticias);
    }

	private void inicializarGestionEmpleados() {
        FrameGestionEmpleados frame = new FrameGestionEmpleados();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    private void inicializarHorariosEmpleados() {
        FrameHorariosEmpleados frame = new FrameHorariosEmpleados();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    private void inicializarMerchandising() {
        VentanaPrincipal frame = new VentanaPrincipal();
        GestionProductoShared gps = new GestionProductoShared(new ProductoCRUDImpl(), frame);
        gps.initController();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    private void inicializarEntradas() {
        VentanaPrincipalEntrada frame = new VentanaPrincipalEntrada();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    private void inicializarReservas() {
        ReservaShared reservaShared = new ReservaShared();
        VentanaPrincipalReserva frame = new VentanaPrincipalReserva(reservaShared);
        GestionPanelReservaShared gprs = new GestionPanelReservaShared(frame);
        gprs.initController();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    private void inicializarGestionEquipos() {
        GestionEquiposShared ges = new GestionEquiposShared();
        VentanaPrincipalEquipos frame = new VentanaPrincipalEquipos(ges);
        GestionPanelEquiposShared gpes = new GestionPanelEquiposShared(frame);
        gpes.initControllers();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    private void inicializarGestionEntrevistas() {
        VentanaPrincipalEntrevista frame = new VentanaPrincipalEntrevista();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    private void inicializarHistorialDeVentas() {
        HistorialVentas window = new HistorialVentas();
        GestionHistorialShared ghs = new GestionHistorialShared(window);
        ghs.initController();
        configurarCierreVentana(window);
        window.setVisible(true);
    }
    
    private void inicializarCargarNoticias() {
    	CargarNoticia frame = new CargarNoticia();
    	GestionCargarNoticiaShared gcns = new GestionCargarNoticiaShared(frame);
    	gcns.initController();
    	configurarCierreVentana(frame);
		frame.setVisible(true);
	}

    private void inicializarJardineria() {
    	JardinerosShared js = new JardinerosShared();
    	VentanaJardineros frame = new VentanaJardineros(js);
    	GestionPanelJardineriaShared gpjs = new GestionPanelJardineriaShared(frame);
    	gpjs.initController();
    	configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    private void inicializarPortalNoticias() {
    	PortalNoticias frame = new PortalNoticias();
    	GestionPortalNoticiasShared gpns = new GestionPortalNoticiasShared(frame);
    	gpns.initController();
    	configurarCierreVentana(frame);
		frame.setVisible(true);
    }

    // Método para configurar el comportamiento al cerrar ventanas
    private void configurarCierreVentana(JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                SwingUtilities.invokeLater(() -> frmAplicacionBurgosFc.setVisible(true));
            }
        });
    }
}
