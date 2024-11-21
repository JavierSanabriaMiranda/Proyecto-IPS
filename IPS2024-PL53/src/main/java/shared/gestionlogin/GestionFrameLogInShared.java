package shared.gestionlogin;

import java.util.Optional;

import javax.swing.JOptionPane;

import backend.service.usuarios.Usuario;
import frontend.SwingUtil;
import frontend.login.FrameLogIn;
import frontend.menu.AplicacionMain;
import util.CifradorDePassword;

public class GestionFrameLogInShared {

	private AplicacionMain app;
	private FrameLogIn view;
	private GestionLogInShared gesLogIn = new GestionLogInShared();
	
	
	public GestionFrameLogInShared(FrameLogIn view, AplicacionMain app) {
		if (view == null)
			throw new IllegalArgumentException("El frame no puede ser null");
		if (app == null)
			throw new IllegalArgumentException("La aplicación de inicio no puede ser null");
		this.view = view;
		this.app = app;
	}
	
	public void initController() {
		view.getBtLogIn().addActionListener(e -> SwingUtil.exceptionWrapper(() -> comprobarDatosLogIn()));
		view.getBtEntrarSinLogIn().addActionListener(e -> SwingUtil.exceptionWrapper(() -> iniciarSesion(null)));
	}

	/**
	 * Comprueba los credenciales introducidos en el Log In y si son incorrectos le notifica 
	 * al usuario el error, en caso de ser correctos inicia sesión y le hace llegar el usuario
	 * a la AplicacionMain
	 */
	private void comprobarDatosLogIn() {
		String nombreUsuario = view.getTxNombreUsuario().getText();
		char[] password = view.getPasswordField().getPassword();
		if (nombreUsuario.isBlank() || password.length == 0) {
			JOptionPane.showMessageDialog(view, "Se deben rellenar todos los campos", "Error en Log In",
					JOptionPane.ERROR_MESSAGE);
		}
		else {
			String passwordCifrada = CifradorDePassword.cifrarPassword(password);
			Optional<Usuario> optUsuario = gesLogIn.getUsuarioPorNombreYPassword(nombreUsuario, passwordCifrada);
			if (optUsuario.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Nombre de usuario o contraseña incorrecto", "Error en Log In",
						JOptionPane.ERROR_MESSAGE);
			} else {
				Usuario usuario = optUsuario.get();
				iniciarSesion(usuario);
			}
		}
	}
	

	/**
	 * Llama al método iniciarSesion de la app pasandole el usuario recibido como parámetro 
	 * el cual puede ser un usuario (si se ha iniciado sesión satisfactoriamente) o null si se ha
	 * decidido entrar sin iniciar sesión. 
	 * Posteriormente se cierra la ventana de Log In
	 */
	private void iniciarSesion(Usuario usuario) {
		app.iniciarSesion(usuario);
		view.dispose();
	}

}
