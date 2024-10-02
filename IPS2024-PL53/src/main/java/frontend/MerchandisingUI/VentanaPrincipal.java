package frontend.MerchandisingUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame{
	public VentanaPrincipal() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		JPanel panelFiltro = new JPanel();
		getContentPane().add(panelFiltro, BorderLayout.WEST);
	}

	private static final long serialVersionUID = 1L;
	
}
