package shared.gestionempleados;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import backend.service.empleados.Empleado;
import frontend.SwingUtil;
import frontend.empleados.FrameGestionEmpleados;
import frontend.empleados.PanelAddEmpleados;
import frontend.empleados.PanelModEmpleados;
import frontend.empleados.PanelRemEmpleados;

public class GestionFrameEmpleadosShared {

	GestionEmpleadosShared gesEmp;
	FrameGestionEmpleados view;
	PanelAddEmpleados pnAdd;
	PanelModEmpleados pnMod;
	PanelRemEmpleados pnRem;
	
	public GestionFrameEmpleadosShared(FrameGestionEmpleados view) {
		this.view = view;
		this.gesEmp = view.getGesEmp();
		this.pnAdd = view.getPanelAddEmpleados();
		this.pnMod = view.getPanelModEmpleados();
		this.pnRem = view.getPanelRemEmpleados();
	}
	
	public void initController() {
		view.getBtAtras().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cerrarVentana()));
		view.getBtnAddEmp().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
											seleccionarMenu(view.getBtnAddEmp().getActionCommand())));
		view.getBtnModEmp().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
											seleccionarMenu(view.getBtnModEmp().getActionCommand())));
		view.getBtnRemEmp().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
											seleccionarMenu(view.getBtnRemEmp().getActionCommand())));
		
		pnAdd.getBtAdd().addActionListener(e -> SwingUtil.exceptionWrapper(() -> addEmpleado()));
		pnAdd.getCbTipoEmpleado().addActionListener(e -> SwingUtil.exceptionWrapper(() -> 
																	establecerComboPuesto()));
		
		pnMod.getListEmpleados().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtil.exceptionWrapper(() -> rellenarDatosEmpleado());
            }
        });
		pnMod.getBtMod().addActionListener(e -> SwingUtil.exceptionWrapper(() -> modEmpleado()));
		
		pnRem.getBtEliminar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> iniciarEliminarEmpleado()));
		pnRem.getListEmpleados().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtil.exceptionWrapper(() -> mostrarEmpleado());
            }
        });
	}

	private void cerrarVentana() {
		view.dispose();
	}
	
	
	private void seleccionarMenu(String menu) {
		switch (menu) {
		case "addEmpleado":
			mostrarMenuAdd();
			break;
		case "modEmpleado":
			mostrarMenuMod();
			break;
		case "remEmpleado":
			mostrarMenuRem();
			break;
		default:
			throw new IllegalArgumentException("El código " + menu + " no es un panel válido");
		}
	}
	
	
	private void mostrarMenuAdd() {
		inicializarPanelAdd();;
		((CardLayout) view.getPnDatos().getLayout()).show(view.getPnDatos(), "addEmpleado");
	}

	private void mostrarMenuMod() {
		inicializarPanelMod();
		((CardLayout) view.getPnDatos().getLayout()).show(view.getPnDatos(), "modEmpleado");
	}

	private void mostrarMenuRem() {
		inicializarPanelRem();
		((CardLayout) view.getPnDatos().getLayout()).show(view.getPnDatos(), "remEmpleado");		
	}
	
	// --------------------------------- METODOS PANEL ADD EMPLEADOS ----------------------------------------
	
	
	// Establece los valores del comboBox de Puestos de Trabajo en función del tipo
	// de Empleado seleccionado
	private void establecerComboPuesto() {
		// Rellenamos el combo en función de los valores del tipo de empleado
		DefaultComboBoxModel<PuestoEmpleado> model = new DefaultComboBoxModel<>();
		if (pnAdd.getCbTipoEmpleado().getSelectedIndex() == 0) {
			model.addElement(PuestoEmpleado.ENTRENADOR);
			model.addElement(PuestoEmpleado.JUGADOR);
		} else if (pnAdd.getCbTipoEmpleado().getSelectedIndex() == 1) {
			model = new DefaultComboBoxModel<>(PuestoEmpleado.values());
			model.removeElement(PuestoEmpleado.ENTRENADOR);
			model.removeElement(PuestoEmpleado.JUGADOR);
		}

		pnAdd.getCbPuesto().setModel(model);
	}
	
	/**
	 * Comprueba si se puede añadir un empleado nuevo con los datos proporcionados y
	 * en ese caso lo añade
	 */
	private void addEmpleado() {
		if (camposCorrectosAdd()) {
			String nombre = pnAdd.getTxNombre().getText();
			String apellido = pnAdd.getTxApellido().getText();
			String dni = pnAdd.getTxDNI().getText();
			String telefono = pnAdd.getTxTelefono().getText();
			Date nacimiento = pnAdd.getClNacimiento().getDate();
			double salario = Double.parseDouble(pnAdd.getTxSalario().getText());
			
			// Redondeamos el salario a 2 decimales
			salario = Math.round(salario * 100.0) / 100.0;
			TipoEmpleado tipo = (TipoEmpleado) pnAdd.getCbTipoEmpleado().getSelectedItem();
			PuestoEmpleado puesto = (PuestoEmpleado) pnAdd.getCbPuesto().getSelectedItem();
			
			gesEmp.addEmpleado(nombre, apellido, dni, telefono, nacimiento, salario, tipo, puesto);
			JOptionPane.showMessageDialog(pnAdd, "Se ha registrado al empleado correctamente", "Confirmación de Registro de Empleado", 
					JOptionPane.INFORMATION_MESSAGE);
			inicializarPanelAdd();
		}

	}

	private boolean camposCorrectosAdd() {
		// Se comprueba que los campos no están vacíos
		if (pnAdd.getTxNombre().getText().isBlank() || pnAdd.getTxApellido().getText().isBlank() || 
				pnAdd.getTxDNI().getText().isBlank() || pnAdd.getTxSalario().getText().isBlank() || 
				pnAdd.getTxTelefono().getText().isBlank() || pnAdd.getClNacimiento().getDate() == null) {
			
			JOptionPane.showMessageDialog(pnAdd, "Se deben rellenar todos los campos",
					"Error en Registro de Empleado", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// Si no es jugador de futbol y es menor de edad
		if (!pnAdd.getCbPuesto().getSelectedItem().equals(PuestoEmpleado.JUGADOR) &&  
				!esMayorEdad(pnAdd.getClNacimiento().getDate())) {
			
			JOptionPane.showMessageDialog(pnAdd, "Solo los jugadores pueden ser menores de edad",
					"Error en Registro de Empleado", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	

	
	private void inicializarPanelAdd() {
		pnAdd.getTxNombre().setText("");
		pnAdd.getTxApellido().setText("");
		pnAdd.getTxDNI().setText("");
		pnAdd.getTxTelefono().setText("");
		pnAdd.getTxSalario().setText("");
		pnAdd.getClNacimiento().setDate(null);
		pnAdd.getCbTipoEmpleado().setSelectedIndex(0);
		pnAdd.getCbPuesto().setSelectedIndex(0);
	}
	
	// --------------------------------- METODOS PANEL MOD EMPLEADOS ----------------------------------------
	
	private void rellenarDatosEmpleado() {
		// Si hay un empleado seleccionado
		if (!pnMod.getListEmpleados().isSelectionEmpty()) {
			Empleado emp = pnMod.getListEmpleados().getSelectedValue();
			pnMod.getTxNombre().setText(emp.getNombre());
			pnMod.getTxApellido().setText(emp.getApellido());
			pnMod.getTxDNI().setText(emp.getDNI());
			pnMod.getTxTelefono().setText(emp.getTelefono());
			pnMod.getTxSalario().setText(emp.getSalarioAnual() + "");
			pnMod.getClFechaNac().setDate(emp.getFechaNac());
		}
	}
	
	private void modEmpleado() {
		if (camposCorrectosMod()) {
			if (!pnMod.getListEmpleados().isSelectionEmpty()) {
				String id = pnMod.getListEmpleados().getSelectedValue().getIDEmpleado();
				String nombre = pnMod.getTxNombre().getText();
				String apellido = pnMod.getTxApellido().getText();
				String dni = pnMod.getTxDNI().getText();
				String telefono = pnMod.getTxTelefono().getText();
				Date nacimiento = pnMod.getClFechaNac().getDate();
				double salario = Double.parseDouble(pnMod.getTxSalario().getText());
				
				// Redondeamos el salario a 2 decimales
				salario = Math.round(salario * 100.0) / 100.0;
				
				gesEmp.modEmpleado(id, nombre, apellido, dni, telefono, nacimiento, salario);
				JOptionPane.showMessageDialog(pnMod, "Se ha modificado al empleado correctamente", "Confirmación de Modificación de Empleado", 
						JOptionPane.INFORMATION_MESSAGE);
				inicializarPanelMod();
			}
			else {
				JOptionPane.showMessageDialog(pnMod, "Se debe seleccionar un empleado a modificar","Error en Modificación de Empleado", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
	
	private boolean camposCorrectosMod() {
		// Se comprueba que los campos no están vacíos
		if (pnMod.getTxNombre().getText().isBlank() || pnMod.getTxApellido().getText().isBlank() 
				|| pnMod.getTxDNI().getText().isBlank() || pnMod.getTxSalario().getText().isBlank() 
				|| pnMod.getTxTelefono().getText().isBlank() || pnMod.getClFechaNac().getDate() == null) {
			JOptionPane.showMessageDialog(pnMod, "Se deben rellenar todos los campos","Error en Modificación de Empleado", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// Si no es jugador de futbol y se intenta cambiar su fecha a menor de edad
		if (!pnMod.getListEmpleados().getSelectedValue().getPuesto().equals(PuestoEmpleado.JUGADOR) && 
				!esMayorEdad(pnMod.getClFechaNac().getDate())) {
			JOptionPane.showMessageDialog(pnMod, "Solo los jugadores pueden ser menores de edad","Error en Modificación de Empleado", JOptionPane.ERROR_MESSAGE);
			return false;
		}
			
		return true;
	}
	
	private boolean esMayorEdad(Date fecha) {
        // Convierte la fecha de tipo Date a LocalDate
        LocalDate fechaLocal = new java.sql.Date(fecha.getTime()).toLocalDate();
        
        // Obtiene la fecha actual
        LocalDate fechaActual = LocalDate.now();
        
        // Calcula la diferencia de años
        Period periodo = Period.between(fechaLocal, fechaActual);

        return periodo.getYears() >= 18;
	}
	
	
	
	private void inicializarPanelMod() {
		pnMod.getTxNombre().setText("");
		pnMod.getTxApellido().setText("");
		pnMod.getTxDNI().setText("");
		pnMod.getTxTelefono().setText("");
		pnMod.getTxSalario().setText("");
		pnMod.getClFechaNac().setDate(null);
		pnMod.getListEmpleados().clearSelection();
		
		// Limpia la lista y añade los empleados ordenados
		pnMod.getModeloList().clear();
		List<Empleado> empleados = gesEmp.getEmpleadosFromGestor();
		Collections.sort(empleados);
		pnMod.getModeloList().addAll(empleados);
	}
	
	// --------------------------------- METODOS PANEL REM EMPLEADOS ----------------------------------------
	
	private void iniciarEliminarEmpleado() {
		if (pedirConfirmacion() == JOptionPane.YES_OPTION) {
			eliminarEmpleado();
		}
	}
	
	private int pedirConfirmacion() {
		return JOptionPane.showConfirmDialog(pnRem, "¿Está seguro de que desea eliminar este empleado?", 
				"Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
	}
	
	private void eliminarEmpleado() {
		gesEmp.eliminarEmpleado(pnRem.getListEmpleados().getSelectedValue());
		JOptionPane.showMessageDialog(pnRem, "Se ha eliminado al empleado correctamente", "Confirmación de Eliminación de Empleado", 
				JOptionPane.INFORMATION_MESSAGE);
		inicializarPanelRem();
	}
	
	private void inicializarPanelRem() {
		pnRem.getBtEliminar().setEnabled(false);
		pnRem.getListEmpleados().clearSelection();
		pnRem.getTxDatos().setText("");
		
		// Limpia la lista y añade los empleados ordenados
		pnRem.getModeloList().clear();
		List<Empleado> empleados = gesEmp.getEmpleadosFromGestor();
		Collections.sort(empleados);
		pnRem.getModeloList().addAll(empleados);

	}
	
	private void mostrarEmpleado() {
		if(!pnRem.getListEmpleados().isSelectionEmpty()) {
			mostrarInfoEmpleado(pnRem.getListEmpleados().getSelectedValue());
			pnRem.getBtEliminar().setEnabled(true);
		}
	}
	
	private void mostrarInfoEmpleado(Empleado emp) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("ID de Empleado: " + emp.getIDEmpleado() + "\n");
		sb.append("Nombre: " + emp.getNombre() + "\n");
		sb.append("Apellido: " + emp.getApellido() + "\n");
		sb.append("DNI: " + emp.getDNI() + "\n");
		sb.append("Teléfono: " + emp.getTelefono() + "\n");
		sb.append("Fecha de Nacimiento: " + emp.getFechaNac() + "\n");
		sb.append("Puesto: " + emp.getPuesto().toString().toUpperCase() + "\n");
		
		pnRem.getTxDatos().setText(sb.toString());
	}
}
