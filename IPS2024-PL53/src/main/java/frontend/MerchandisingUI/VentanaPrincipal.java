package frontend.MerchandisingUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame{
	private JPanel pnCentro;
	private JPanel pnFiltro;
	private JButton btTodos;
	private JButton btEquipaciones;
	private JButton btModa;
	private JButton btAccesorios;
	public VentanaPrincipal() {
		setTitle("Tienda Oficial");
		getContentPane().add(getPnCentro(), BorderLayout.CENTER);
		getContentPane().add(getPnFiltro(), BorderLayout.WEST);
	}

	
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
		}
		return pnCentro;
	}
	private JPanel getPnFiltro() {
		if (pnFiltro == null) {
			pnFiltro = new JPanel();
			pnFiltro.setLayout(new GridLayout(4, 1, 0, 0));
			pnFiltro.add(getBtTodos());
			pnFiltro.add(getBtEquipaciones());
			pnFiltro.add(getBtModa());
			pnFiltro.add(getBtAccesorios());
		}
		return pnFiltro;
	}
	private JButton getBtTodos() {
		if (btTodos == null) {
			btTodos = new JButton("Todos");
		}
		return btTodos;
	}
	private JButton getBtEquipaciones() {
		if (btEquipaciones == null) {
			btEquipaciones = new JButton("Equipaciones");
		}
		return btEquipaciones;
	}
	private JButton getBtModa() {
		if (btModa == null) {
			btModa = new JButton("Moda");
		}
		return btModa;
	}
	private JButton getBtAccesorios() {
		if (btAccesorios == null) {
			btAccesorios = new JButton("Accesorios");
		}
		return btAccesorios;
	}
}
