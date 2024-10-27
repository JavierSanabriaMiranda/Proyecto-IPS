package shared.gestionjardineria;

import javax.swing.JOptionPane;

import frontend.SwingUtil;
import frontend.jardineriaUI.HorarioJardineria;
import frontend.jardineriaUI.VentanaJardineros;

public class GestionPanelJardineriaShared {
	private VentanaJardineros view;
	private HorarioJardineria diagJar;

	public GestionPanelJardineriaShared(VentanaJardineros view) {
		this.view = view;
	}

	public VentanaJardineros getView() {
		return view;
	}

	public HorarioJardineria getDiagJar() {
		return diagJar;
	}

	public void initController() {
		view.getBtnSiguiente().addActionListener(e -> SwingUtil.exceptionWrapper(() -> actionSiguiente()));
	}

	private void actionSiguiente() {
		if (compruebaSeleccion()) {
			creaHorarioJardineria();
		}
	}

	public boolean compruebaSeleccion() {
	    // Verificar si se ha seleccionado un empleado en la lista de jardineros
	    if (view.getListJardineros().getSelectedValue() == null) {
	        JOptionPane.showMessageDialog(view, "Debe seleccionar un empleado de la lista.", 
	                                      "Advertencia", JOptionPane.WARNING_MESSAGE);
	        return false;
	    }
	    
	    // Verificar si se ha seleccionado una instalación en el comboBox
	    if (view.getCbInstalaciones().getSelectedItem() == null) {
	        JOptionPane.showMessageDialog(view, "Debe seleccionar una instalación.", 
	                                      "Advertencia", JOptionPane.WARNING_MESSAGE);
	        return false;
	    }
	    
	    // Verificar si se ha seleccionado una fecha en el dateChooser
	    if (view.getDateChooser().getDate() == null) {
	        JOptionPane.showMessageDialog(view, "Debe seleccionar un día.", 
	                                      "Advertencia", JOptionPane.WARNING_MESSAGE);
	        return false;
	    }
	    
	    return true;
	}
	
	private void creaHorarioJardineria() {
		try {
			HorarioJardineria dialog = new HorarioJardineria(view);
			this.diagJar = dialog;
			initControllersHorario();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initControllersHorario() {
		
		
	}
	
	//---------------------------METODOS PARA LA VENTANA DE HORARIO JARDINERIA--------------------------
	
	

}
