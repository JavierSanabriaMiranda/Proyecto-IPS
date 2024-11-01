package shared.gestioncampania;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import backend.service.ventas.campanaAccionistas.Accionista;
import frontend.SwingUtil;
import frontend.campaniaaccionistas.FrameParticiparEnCampaniaAccionistas;
import frontend.campaniaaccionistas.FrameRegistrarNuevoAccionista;

public class GestionFrameParticiparCampania {

	private FrameParticiparEnCampaniaAccionistas view;
	private FrameRegistrarNuevoAccionista viewRegistro;
	private GestionCampaniaShared gesCam = new GestionCampaniaShared();

	public GestionFrameParticiparCampania(FrameParticiparEnCampaniaAccionistas view) {
		this.view = view;
	}

	public void initController() {
		view.getBtInfo().addActionListener(e -> SwingUtil.exceptionWrapper(() -> darInfoFuncionamientoCampania()));
		view.getBtSalir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cerrarVentana()));
		view.getSpAcciones().addChangeListener(e -> SwingUtil.exceptionWrapper(() -> actualizarPrecio()));
		view.getBtComprar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprarAcciones()));
	}

	public void cargarCampaniaEnCurso() {
		boolean cargarCampania = gesCam.cargarCampaniaEnCurso();
		// Si hay una campaña ya en curso
		if (cargarCampania)
			unirseACampania();
		else {
			JOptionPane.showMessageDialog(null, "Ninguna campaña se encuentra abierta actualmente",
					"No existe campaña abierta", JOptionPane.INFORMATION_MESSAGE);
			cerrarVentana();
		}
	}

	private void unirseACampania() {
		String dni = obtenerDniCliente();
		// Si el cliente ha cancelado la operación
		if (dni == null) {
			cerrarVentana();
		} else {
			accederACampania(dni);
		}
	}

	private void accederACampania(String dni) {
		boolean esAccionista = gesCam.esAccionista(dni);

		int fase = gesCam.getFaseCampania();
		switch (fase) {
		case 1:
		case 2:
			if (!esAccionista)
				informarDeNoAccesoACliente(fase);
			else {
				accederComoAccionista();
			}
			break;
		case 3:
			if (esAccionista)
				accederComoAccionista();
			else
				inicializarPanel();
			break;
		default:
			throw new IllegalStateException(
					"La campaña está en la fase " + fase + " que no se " + "encuentra dentro de lo esperado");
		}
	}

	private void accederComoAccionista() {
		// Comprobamos si el acceso a la campaña por parte del accionista ya está
		// registrado en la BDD
		// (Si ya habia accedido con anterioridad) y en caso de que no, lo registramos
		gesCam.registrarAccionista();
		if (gesCam.isLimiteFase1Superado()) {
			JOptionPane.showMessageDialog(view,
					"Usted ha superado el límite de acciones para esta fase, "
							+ "espere a que se avance a la siguiente fase para seguir comprando",
					"Límite " + "de acciones para Fase 1 Superado", JOptionPane.INFORMATION_MESSAGE);
			cerrarVentana();
		}
		else
			inicializarPanel();
	}

	private void inicializarPanel() {
		int fase = gesCam.getFaseCampania();

		mostrarFase(fase);
		mostrarAccionesRestantesCampania();

		switch (fase) {
		case 1:
			mostrarLimiteAcciones();
			break;
		case 2:
		case 3:
			view.getLbLimiteAcciones().setVisible(false);
			break;
		default:
			throw new IllegalStateException(
					"La campaña está en la fase " + fase + " que no se " + "encuentra dentro de lo esperado");
		}
		ponerLimiteSpinner(fase);
		view.getSpAcciones().setValue(1);
		actualizarPrecio();
		view.setVisible(true);
	}

	private void actualizarPrecio() {
		int numAccionesAComprar = (int) view.getSpAcciones().getValue();
		double precioUnaAccion = gesCam.getPrecioAcciones();
		double precioTotal = numAccionesAComprar * precioUnaAccion;

		String texto = "Precio total:";
		view.getLbPrecio().setText(String.format("%s %.2f\u20AC", texto, precioTotal));
	}

	private void ponerLimiteSpinner(int fase) {
		SpinnerNumberModel model;
		int limite;
		switch (fase) {
		case 1:
			limite = gesCam.getAccionesInicialesAccionista() - gesCam.getNumAccionesCompradasAccionista();
			model = new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(limite),
					Integer.valueOf(1));
			break;
		case 2:
		case 3:
			limite = gesCam.getAccionesRestantesCampania();
			model = new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(limite),
					Integer.valueOf(1));
			break;
		default:
			throw new IllegalStateException(
					"La campaña está en la fase " + fase + " que no se " + "encuentra dentro de lo esperado");
		}

		view.getSpAcciones().setModel(model);
	}

	private void mostrarLimiteAcciones() {
		int accionesLimite = gesCam.getAccionesInicialesAccionista() - gesCam.getNumAccionesCompradasAccionista();

		String texto = "Su limite de acciones para esta fase es de: ";
		view.getLbLimiteAcciones().setText(texto + accionesLimite);
	}

	private void mostrarAccionesRestantesCampania() {
		int accionesRestantes = gesCam.getAccionesRestantesCampania();

		String texto = "Acciones Restantes de la Campaña: ";
		view.getLbAccionesRestantesCampania().setText(texto + accionesRestantes);
	}

	private void mostrarFase(int fase) {
		String texto = "Fase Actual: ";
		view.getLbFase().setText(texto + fase);
	}

	private void informarDeNoAccesoACliente(int fase) {
		JOptionPane.showMessageDialog(null,
				"La campaña se encuentra aún en la fase " + fase + " para "
						+ "acceder sin ser accionista, deberá esperar a la fase 3",
				"Acceso no permitido", JOptionPane.INFORMATION_MESSAGE);
		cerrarVentana();
	}

	/**
	 * Crea un JOptionPane para que el usuario introduzca su DNI
	 * 
	 * @return dni introducido por el cliente o null en caso de que haya cancelado
	 *         la operación
	 */
	private String obtenerDniCliente() {
		// Crear el JTextField
		JTextField textField = new JTextField();

		// Opciones de los botones
		Object[] options = { "Aceptar", "Cancelar" };

		// Mostrar el JOptionPane con el JTextField y las opciones de botones
		int option = JOptionPane.showOptionDialog(null, new Object[] { "Introduzca su DNI", textField },
				"Acceso a Campaña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		if (option == JOptionPane.OK_OPTION) {
			return textField.getText();
		}
		return null;
	}

	private void cerrarVentana() {
		view.setVisible(true);

		view.dispose();
	}

	private void darInfoFuncionamientoCampania() {
		String info = "El funcionamiento de la campaña es el siguiente:\n";
		info += "	- Fase 1: Solo pueden acceder accionistas y como máximo podrán comprar\n";
		info += "	el número de acciones que tenían al realizar su primer ingreso\n";
		info += "	- Fase 2: Solo pueden acceder accionistas y podrán comprar acciones\n";
		info += "	hasta que se agoten las fijadas para la campaña\n";
		info += "	- Fase 3: Pueden acceder clientes no accionistas y se podrán comprar acciones\n";
		info += "	hasta que se agoten las fijadas para la campaña\n";
		JOptionPane.showMessageDialog(view, info, "Funcionamiento de las Campañas", JOptionPane.INFORMATION_MESSAGE);
	}

	private void comprarAcciones() {
		Accionista acc = gesCam.getAccionista();
		// Si es un cliente no accionista (se deben registrar sus datos para hacerlo
		// accionista)
		if (acc == null)
			registrarDatosNuevoAccionista();
		else
			realizarCompra();
	}

	private void realizarCompra() {
		int numAcciones = (int) view.getSpAcciones().getValue();
		gesCam.comprarAcciones(numAcciones);

		JOptionPane.showMessageDialog(view, "¡Felicidades! Ha comprado un total de " + numAcciones + " acciones",
				"Confirmación de compra", JOptionPane.INFORMATION_MESSAGE);
		view.dispose();
	}

	/**
	 * Método que crea un frame de registro de accionista que recoge los datos de
	 * este para registrarlo
	 */
	private void registrarDatosNuevoAccionista() {
		viewRegistro = new FrameRegistrarNuevoAccionista();
		initControllerRegistroAccionista();

		view.setVisible(false);
		viewRegistro.setVisible(true);
	}

	private void initControllerRegistroAccionista() {
		viewRegistro.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cerrarVentanaRegistro()));
		viewRegistro.getBtAceptar()
				.addActionListener(e -> SwingUtil.exceptionWrapper(() -> registrarNuevoAccionista()));
	}

	private void registrarNuevoAccionista() {
		comprobarDatosCorrectosRegistro();
	}

	private void comprobarDatosCorrectosRegistro() {
		String nombre = viewRegistro.getTxNombre().getText();
		if (nombre.isBlank())
			JOptionPane.showMessageDialog(viewRegistro, "Se deben rellenar todos los campos", "Error en registro",
					JOptionPane.ERROR_MESSAGE);
		else {
			registrarNuevoAccionistaEnBDD(nombre);
		}
	}

	private void registrarNuevoAccionistaEnBDD(String nombre) {
		gesCam.registrarClienteComoNuevoAccionista(nombre);
		JOptionPane.showMessageDialog(viewRegistro, "Se ha registrado correctamente como accionista",
				"Registro Completado", JOptionPane.INFORMATION_MESSAGE);
		cerrarVentanaRegistro();
		realizarCompra();
	}

	private void cerrarVentanaRegistro() {
		view.setVisible(true);
		viewRegistro.dispose();
	}

}
