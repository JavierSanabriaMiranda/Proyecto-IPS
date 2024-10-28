package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import backend.data.productos.ProductoCRUDImpl;
import frontend.campaniaaccionistas.FrameCreacionCampaniaAccionistas;
import frontend.campaniaaccionistas.FrameParticiparEnCampaniaAccionistas;
import frontend.empleados.FrameGestionEmpleados;
import frontend.empleados.horarios.FrameHorariosEmpleados;
import frontend.entradaUI.VentanaPrincipalEntrada;
import frontend.entrevistaUI.VentanaPrincipalEntrevista;
import frontend.equiposUI.VentanaPrincipalEquipos;
import frontend.historialVentas.HistorialVentas;
import frontend.merchandisingUI.VentanaPrincipal;
import frontend.noticias.CargarNoticia;
import frontend.reservaUI.VentanaPrincipalReserva;
import shared.gestionHistorial.GestionHistorialShared;
import shared.gestionNoticias.GestionCargarNoticiaShared;
import shared.gestionProductos.GestionProductoShared;
import shared.gestioncampania.GestionFrameCrearCampaniaShared;
import shared.gestioncampania.GestionFrameParticiparCampania;
import shared.gestionempleados.GestionFrameEmpleadosShared;
import shared.gestionequipos.GestionEquiposShared;
import shared.gestionhorarios.GestionFrameHorariosShared;
import shared.gestioninstalaciones.ReservaShared;

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
        frmAplicacionBurgosFc.setBounds(100, 100, 700, 250);
        frmAplicacionBurgosFc.setLocationRelativeTo(null);
        frmAplicacionBurgosFc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        
     // Menú "Historial de Ventas"
        JMenu noticiasMenu = new JMenu("Noticias");
        menuBar.add(noticiasMenu);

        // Opción "Ver Historial de Ventas"
        JMenuItem cargarNoticias = new JMenuItem("Crear Noticia");
        cargarNoticias.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarCargarNoticias();
        });
        noticiasMenu.add(cargarNoticias);
        
        // Menú "Accionistas"
        JMenu accionistasMenu = new JMenu("Accionistas");
        menuBar.add(accionistasMenu);

        // Opción "Ver Historial de Ventas"
        JMenuItem crearCampania = new JMenuItem("Crear Campaña de Accionistas");
        crearCampania.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarCrearCampania();
        });
        accionistasMenu.add(crearCampania);
        
        JMenuItem accederCampania = new JMenuItem("Acceder a Campaña de Accionistas");
        accederCampania.addActionListener(e -> {
            frmAplicacionBurgosFc.setVisible(false);
            inicializarParticiparEnACampania();
        });
        accionistasMenu.add(accederCampania);
    }

	private void inicializarGestionEmpleados() {
        FrameGestionEmpleados frame = new FrameGestionEmpleados();
        GestionFrameEmpleadosShared gfe = new GestionFrameEmpleadosShared(frame);
        gfe.initController();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    private void inicializarHorariosEmpleados() {
        FrameHorariosEmpleados frame = new FrameHorariosEmpleados();
        GestionFrameHorariosShared gfh = new GestionFrameHorariosShared(frame);
        gfh.initController();
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
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    private void inicializarGestionEquipos() {
        GestionEquiposShared ges = new GestionEquiposShared();
        VentanaPrincipalEquipos frame = new VentanaPrincipalEquipos(ges);
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
    
    private void inicializarCrearCampania() {
    	FrameCreacionCampaniaAccionistas frame = new FrameCreacionCampaniaAccionistas();
    	GestionFrameCrearCampaniaShared gfcv = new GestionFrameCrearCampaniaShared(frame);
    	gfcv.initController();
    	configurarCierreVentana(frame);
    	frame.setVisible(true);
    	gfcv.cargarCampaniaEnCurso();
    }
    
    private void inicializarParticiparEnACampania() {
    	FrameParticiparEnCampaniaAccionistas frame = new FrameParticiparEnCampaniaAccionistas();
    	GestionFrameParticiparCampania gfpc = new GestionFrameParticiparCampania(frame);
    	configurarCierreVentana(frame);
    	
    	gfpc.cargarCampaniaEnCurso();
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
