package shared.gestioncampania;

import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backend.data.campaniaaccionistas.CampaniaDTO;
import backend.data.campaniaaccionistas.DtoAssembler;
import frontend.campaniaaccionistas.FrameParticiparEnCampaniaAccionistas;

public class GestionFrameParticiparCampania {
	
	private FrameParticiparEnCampaniaAccionistas view;
	private GestionCampaniaShared gesCam = new GestionCampaniaShared();

	public GestionFrameParticiparCampania(FrameParticiparEnCampaniaAccionistas view) {
		this.view = view;
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
		} 
		else {
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
				accederComoAccionista(fase);
			}
				
			break;
		case 3:
			
			break;
		default:
			throw new IllegalStateException("La campaña está en la fase " + fase + " que no se "
					+ "encuentra dentro de lo esperado");
		}
			
	}

	private void accederComoAccionista(int fase) {
		// Comprobamos si el acceso a la campaña por parte del accionista ya está registrado en la BDD
		// (Si ya habia accedido con anterioridad) y en caso de que no, lo registramos
		gesCam.registrarAccionista();
			
	}

	private void informarDeNoAccesoACliente(int fase) {
		JOptionPane.showMessageDialog(null, "La campaña se encuentra aún en la fase " + 1 + "para "
				+ "acceder sin ser accionista, deberá esperar a la fase 3", "Acceso no permitido", 
				JOptionPane.INFORMATION_MESSAGE);
		cerrarVentana();
	}

	/**
	 * Crea un JOptionPane para que el usuario introduzca su DNI
	 * 
	 * @return dni introducido por el cliente o null en caso de que haya cancelado la operación
	 */
	private String obtenerDniCliente() {
		// Crear el JTextField
        JTextField textField = new JTextField();

        // Opciones de los botones
        Object[] options = {"Aceptar", "Cancelar"};

        // Mostrar el JOptionPane con el JTextField y las opciones de botones
        int option = JOptionPane.showOptionDialog(
                null,
                new Object[]{"Introduzca su DNI", textField},
                "Acceso a Campaña",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );
        
        if (option == JOptionPane.OK_OPTION) {
        	return textField.getText();
        }
        return null;
	}
	
	private void cerrarVentana() {
		view.setVisible(true);
		view.dispose();
	}

}
