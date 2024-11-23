package frontend.menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import backend.data.Database;
import backend.data.productos.ProductoCRUDImpl;
import backend.service.usuarios.TipoUsuario;
import backend.service.usuarios.Usuario;
import backend.util.log.LogManager;
import frontend.SwingUtil;
import frontend.abonos.VentanaAbonos;
import frontend.campaniaaccionistas.FrameCreacionCampaniaAccionistas;
import frontend.campaniaaccionistas.FrameParticiparEnCampaniaAccionistas;
import frontend.empleados.FrameGestionEmpleados;
import frontend.empleados.horarios.FrameHorariosEmpleados;
import frontend.entradaUI.VentanaPrincipalEntrada;
import frontend.entradaUI.abonados.VentanaInicioAbonados;
import frontend.entrevistaUI.VentanaSeleccionarJugadorFranjasEntrevistas;
import frontend.entrevistaUI.franja.VentanaSeleccionFranjaEntrevista;
import frontend.equiposUI.VentanaPrincipalEquipos;
import frontend.equiposUI.horarios.VentanaHorarioEquipos;
import frontend.equiposUI.partidos.VentanaPartidos;
import frontend.estadisticos.FrameEstadisticosGastosEIngresos;
import frontend.historialVentas.HistorialVentas;
import frontend.jardineriaUI.VentanaJardineros;
import frontend.login.FrameLogIn;
import frontend.merchandisingUI.VentanaPrincipal;
import frontend.noticias.CargarNoticia;
import frontend.noticias.PortalNoticias;
import frontend.portalAccionistas.PortalAccionistas;
import frontend.reservaUI.VentanaPrincipalReserva;
import shared.gestionAbonos.GestionVentaAbonos;
import shared.gestionAcciones.GestionPortalAccionistasShared;
import shared.gestionHistorial.GestionHistorialShared;
import shared.gestionNoticias.GestionCargarNoticiaShared;
import shared.gestionNoticias.GestionImagenesShared;
import shared.gestionNoticias.GestionPortalNoticiasShared;
import shared.gestionProductos.GestionProductoShared;
import shared.gestioncampania.GestionFrameCrearCampaniaShared;
import shared.gestioncampania.GestionFrameParticiparCampania;
import shared.gestionempleados.GestionFrameEmpleadosShared;
import shared.gestionentrada.GestionEntradaShared;
import shared.gestionentrada.abonados.GestionEntradasAbonadosShared;
import shared.gestionentrada.abonados.GestionPanelEntradasAbonadosShared;
import shared.gestionequipos.GestionEquiposShared;
import shared.gestionequipos.GestionPanelEquiposShared;
import shared.gestionequipos.horarios.GestionPanelHorarioEquiposShared;
import shared.gestionequipos.horarios.HorariosEntrenamientosShared;
import shared.gestionequipos.partidos.GestionPanelPartidosShared;
import shared.gestionequipos.partidos.GestionPartidosShared;
import shared.gestionestadisticos.GestionFrameEstadisticosGastosEIngresosShared;
import shared.gestionhorarios.GestionFrameHorariosShared;
import shared.gestioninstalaciones.GestionPanelReservaShared;
import shared.gestioninstalaciones.ReservaShared;
import shared.gestionjardineria.GestionPanelJardineriaShared;
import shared.gestionjardineria.JardinerosShared;
import shared.gestionlogin.GestionFrameLogInShared;
import javax.swing.JLabel;
import java.awt.Font;


public class AplicacionMain {

    private JFrame frmAplicacionBurgosFc;
    // Si el usuario está a null significa que no se ha 
    // iniciado sesión, sino que se ha entrado sin logearse
    private Usuario usuario;
    
    private Map<TipoUsuario, ConfiguradorDeMenu> configuradoresMenu = Map.of(
    		TipoUsuario.NO_USUARIO, new ConfiguradorDeMenuNoUsuario(),
    		TipoUsuario.ACCIONISTA, new ConfiguradorDeMenuAccionista(),
    		TipoUsuario.GERENTE, new ConfiguradorDeMenuGerente(),
    		TipoUsuario.VENDEDOR_ENTRADAS_ABONOS, new ConfiguradorDeMenuVendedorAbonos(),
    		TipoUsuario.EMPLEADO_TIENDA, new ConfiguradorDeMenuEmpleadoTienda(),
    		TipoUsuario.ENCARGADO_TIENDA, new ConfiguradorDeMenuEncargadoTienda(),
    		TipoUsuario.GESTOR_INSTALACIONES, new ConfiguradorDeMenuGestorInstalaciones(),
    		TipoUsuario.ENTRENADOR, new ConfiguradorDeMenuEntrenador(),
    		TipoUsuario.DIRECTOR_COMUNICACIONES, new ConfiguradorDeMenuDirectorComunicaciones()
    	);  
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                new AplicacionMain();
            } catch (Exception e) {
            	e.printStackTrace();
            }
        });
    }

    public AplicacionMain() {
    	inicializarLogIn();
    }
    
    /**
     * Recibe un usuario el cual puede ser null (si se ha entrado sin iniciar sesión) y se 
     * inicializa el menú para dicho usuario
     * @param usuario
     */
    public void iniciarSesion(Usuario usuario) {
    	this.usuario = usuario;
    	initialize();
    }

    /**
     * @wbp.parser.entryPoint
         */
    private void initialize() {
        frmAplicacionBurgosFc = new JFrame();
        
        frmAplicacionBurgosFc.setResizable(false);
        frmAplicacionBurgosFc.getContentPane().setBackground(Color.WHITE);
        frmAplicacionBurgosFc.setTitle("Aplicacion Burgos FC");
        frmAplicacionBurgosFc.setIconImage(Toolkit.getDefaultToolkit().getImage(AplicacionMain.class.getResource("/img/productos/logo.jpg")));
        frmAplicacionBurgosFc.setBounds(100, 100, 700, 250);
        frmAplicacionBurgosFc.setLocationRelativeTo(null);
        configurarCierreAplicacionMain(frmAplicacionBurgosFc);

		//Boton para inicializar base de datos
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.setBounds(2, 112, 247, 33);
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionImagenesShared gis = new GestionImagenesShared();
				gis.eliminarArchivosCarpeta();
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		frmAplicacionBurgosFc.getContentPane().setLayout(null);
		frmAplicacionBurgosFc.getContentPane().add(btnInicializarBaseDeDatos);

		//Boton para cargar los datos iniciales
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.setBounds(2, 147, 247, 33);
		btnCargarDatosIniciales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			@Override
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frmAplicacionBurgosFc.getContentPane().add(btnCargarDatosIniciales);
		
		JLabel lbBienvenida = new JLabel("Bienvenido/a ");
		if (usuario != null)
			lbBienvenida.setText("Bienvenido/a " + usuario.getNombreUsuario());
		lbBienvenida.setFont(new Font("Arial", Font.BOLD, 24));
		lbBienvenida.setBounds(10, 11, 419, 50);
		frmAplicacionBurgosFc.getContentPane().add(lbBienvenida);
		
		
		// Añadir label del rol
		if (usuario != null) {
			JLabel lbRol = new JLabel(usuario.getTipoUsuario().toString());
			lbRol.setFont(new Font("Arial", Font.PLAIN, 18));
			lbRol.setBounds(10, 56, 253, 23);
			frmAplicacionBurgosFc.getContentPane().add(lbRol);
		}
		
		JButton btCerrarSesion = new JButton("Cerrar Sesión");
		btCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 12));
		btCerrarSesion.setBounds(553, 11, 123, 23);
		btCerrarSesion.addActionListener(e -> SwingUtil.exceptionWrapper(() -> cerrarSesion()));
		
		frmAplicacionBurgosFc.getContentPane().add(btCerrarSesion);		
		
        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();
        frmAplicacionBurgosFc.setJMenuBar(menuBar);

        inicializarMenuParaUsuario();
        try {
        	if (usuario != null)
        		LogManager.initialize(usuario.getNombreUsuario());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }



	/**
     * Inicializa y configura el menú para el tipo de usuario que ha iniciado sesión
     * @param menu a inicializar
     */
	private void inicializarMenuParaUsuario() {
		if (usuario == null)
			configuradoresMenu.get(TipoUsuario.NO_USUARIO).configurarMenu(frmAplicacionBurgosFc, this);
		else if (configuradoresMenu.containsKey(usuario.getTipoUsuario())) {
			configuradoresMenu.get(usuario.getTipoUsuario()).configurarMenu(frmAplicacionBurgosFc, this);
		}
			
		frmAplicacionBurgosFc.setVisible(true);
	}

	void inicializarGestionEmpleados() {
        FrameGestionEmpleados frame = new FrameGestionEmpleados();
        GestionFrameEmpleadosShared gfe = new GestionFrameEmpleadosShared(frame);
        gfe.initController();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    void inicializarHorariosEmpleados() {
        FrameHorariosEmpleados frame = new FrameHorariosEmpleados();
        GestionFrameHorariosShared gfh = new GestionFrameHorariosShared(frame);
        gfh.initController();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    void inicializarMerchandising() {
        VentanaPrincipal frame = new VentanaPrincipal();
        GestionProductoShared gps = new GestionProductoShared(new ProductoCRUDImpl(), frame);
        gps.initController();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    void inicializarEntradas() {
        VentanaPrincipalEntrada frame = new VentanaPrincipalEntrada();
        GestionEntradaShared ges = new GestionEntradaShared(frame);
        ges.initController();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    void inicializarReservas() {
        ReservaShared reservaShared = new ReservaShared();
        VentanaPrincipalReserva frame = new VentanaPrincipalReserva(reservaShared);
        GestionPanelReservaShared gprs = new GestionPanelReservaShared(frame);
        gprs.initController();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    void inicializarGestionEquipos() {
        GestionEquiposShared ges = new GestionEquiposShared();
        VentanaPrincipalEquipos frame = new VentanaPrincipalEquipos(ges);
        GestionPanelEquiposShared gpes = new GestionPanelEquiposShared(frame);
        gpes.initControllers();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    void inicializarGestionCrearFranjasEntrevistas() {
        VentanaSeleccionarJugadorFranjasEntrevistas frame = new VentanaSeleccionarJugadorFranjasEntrevistas();
        configurarCierreVentana(frame);
        frame.setVisible(true);
    }
    
    void inicializarGestionCrearEntrevistas() {
    	VentanaSeleccionFranjaEntrevista frame = new VentanaSeleccionFranjaEntrevista();
    	configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    void inicializarHistorialDeVentas() {
        HistorialVentas window = new HistorialVentas();
        GestionHistorialShared ghs = new GestionHistorialShared(window);
        ghs.initController();
        configurarCierreVentana(window);
        window.setVisible(true);
    }
    
    void inicializarCargarNoticias() {
    	CargarNoticia frame = new CargarNoticia();
    	GestionCargarNoticiaShared gcns = new GestionCargarNoticiaShared(frame);
    	gcns.initController();
    	configurarCierreVentana(frame);
		frame.setVisible(true);
	}

    void inicializarJardineria() {
    	JardinerosShared js = new JardinerosShared();
    	VentanaJardineros frame = new VentanaJardineros(js);
    	GestionPanelJardineriaShared gpjs = new GestionPanelJardineriaShared(frame);
    	gpjs.initController();
    	configurarCierreVentana(frame);
        frame.setVisible(true);
    }

    void inicializarPortalNoticias() {
    	PortalNoticias frame = new PortalNoticias();
    	GestionPortalNoticiasShared gpns = new GestionPortalNoticiasShared(frame);
    	gpns.initController();
    	configurarCierreVentana(frame);
		frame.setVisible(true);
    }

    void inicializarHorarioEquipos() {
    	HorariosEntrenamientosShared hes = new HorariosEntrenamientosShared(this.usuario);
    	VentanaHorarioEquipos frame = new VentanaHorarioEquipos(hes);
    	GestionPanelHorarioEquiposShared gpes = new GestionPanelHorarioEquiposShared(frame);
    	gpes.initControllers();
    	configurarCierreVentana(frame);
    	frame.setVisible(true);
    	gpes.comprobarUsuarioEntrenadorTieneEquipo();
    }

    void inicializarPortalAccionistas() {
    	PortalAccionistas frame = new PortalAccionistas();
    	GestionPortalAccionistasShared gpns = new GestionPortalAccionistasShared(frame, this.usuario);
    	gpns.initController();
    	configurarCierreVentana(frame);
		frame.setVisible(true);
    }

    void inicializarCrearCampania() {
    	FrameCreacionCampaniaAccionistas frame = new FrameCreacionCampaniaAccionistas();
    	GestionFrameCrearCampaniaShared gfcv = new GestionFrameCrearCampaniaShared(frame);
    	gfcv.initController();
    	configurarCierreVentana(frame);
    	frame.setVisible(true);
    	gfcv.cargarCampaniaEnCurso();
    }

    void inicializarParticiparEnCampania() {
    	FrameParticiparEnCampaniaAccionistas frame = new FrameParticiparEnCampaniaAccionistas();
    	GestionFrameParticiparCampania gfpc = new GestionFrameParticiparCampania(frame, this.usuario);
    	configurarCierreVentana(frame);
    	gfpc.initController();
    	gfpc.cargarCampaniaEnCurso();
    }
    
    void inicializarAbonos() {
    	VentanaAbonos frame = new VentanaAbonos();
    	GestionVentaAbonos gva = new GestionVentaAbonos(frame);
    	gva.initController();
    	configurarCierreVentana(frame);
    	frame.setVisible(true);
    }

    void inicializarCreacionPartidos() {
    	GestionPartidosShared gps = new GestionPartidosShared();
    	VentanaPartidos frame = new VentanaPartidos(gps);
    	GestionPanelPartidosShared gpps = new GestionPanelPartidosShared(frame);
    	configurarCierreVentana(frame);
    	gpps.initController();
    	configurarCierreVentana(frame);
    	frame.setVisible(true);
    }

    void inicializarEntradasEspecialesAbonados() {
    	GestionEntradasAbonadosShared geas = new GestionEntradasAbonadosShared();
    	VentanaInicioAbonados frame = new VentanaInicioAbonados(geas);
    	GestionPanelEntradasAbonadosShared gpeas = new GestionPanelEntradasAbonadosShared(frame);
    	configurarCierreVentana(frame);
    	gpeas.initController();
    	configurarCierreVentana(frame);
    	frame.setVisible(true);
    }
    
    void inicializarEstadisticosEconomicos() {
    	FrameEstadisticosGastosEIngresos frame = new FrameEstadisticosGastosEIngresos();
    	GestionFrameEstadisticosGastosEIngresosShared gfegei = new GestionFrameEstadisticosGastosEIngresosShared(frame);
    	configurarCierreVentana(frame);
    	gfegei.initController();
    	frame.setVisible(true);
    }
    
    private void inicializarLogIn() {
    	FrameLogIn frame = new FrameLogIn();
    	GestionFrameLogInShared gestLogIn = new GestionFrameLogInShared(frame, this);
    	gestLogIn.initController();
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
    
    private void configurarCierreAplicacionMain(JFrame frmAplicacionBurgosFc) {
    	frmAplicacionBurgosFc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frmAplicacionBurgosFc.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                SwingUtilities.invokeLater(() -> LogManager.close());
            }
        });
    }
    
    private void cerrarSesion() {
		this.usuario = null;
		frmAplicacionBurgosFc.dispose();
		inicializarLogIn();
		LogManager.close();
	}

}
