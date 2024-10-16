package frontend.entrevistaUI.franja;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.service.entrevistas.FranjaEntrevista;
import shared.gestionentrevista.GestionEntrevistaShared;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCreacionEntrevista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private GestionEntrevistaShared ges;
	private JScrollPane scpFranjas;
	private JLabel lbFranjas;
	private JList<FranjaEntrevista> listFranjas;
	
	private DefaultListModel<FranjaEntrevista> modeloListaFranjas;
	
	private JLabel lbMedio;
	private JTextField txMedio;
	private JButton btCrearEntrevista;
	private JButton btSeleccionarFranja;
	

	/**
	 * Create the frame.
	 */
	public VentanaCreacionEntrevista(GestionEntrevistaShared ges) {
		setResizable(false);
		setTitle("Entrevistas: Creacion de entrevista");
		this.ges = ges;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScpFranjas());
		contentPane.add(getLbFranjas());
		contentPane.add(getLbMedio());
		contentPane.add(getTxMedio());
		contentPane.add(getBtCrearEntrevista());
		contentPane.add(getBtSeleccionarFranja());
	}

	private JScrollPane getScpFranjas() {
		if (scpFranjas == null) {
			scpFranjas = new JScrollPane();
			scpFranjas.setBounds(17, 49, 463, 198);
			scpFranjas.setViewportView(getListFranjas());
		}
		return scpFranjas;
	}
	private JLabel getLbFranjas() {
		if (lbFranjas == null) {
			lbFranjas = new JLabel("Seleccione una franja:");
			lbFranjas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbFranjas.setBounds(17, 10, 189, 29);
		}
		return lbFranjas;
	}
	private JList<FranjaEntrevista> getListFranjas() {
		if (listFranjas == null) {
			modeloListaFranjas = new DefaultListModel<>();
			listFranjas = new JList<FranjaEntrevista>(modeloListaFranjas);
			listFranjas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getBtCrearEntrevista().setVisible(true);
				}
			});
			listFranjas.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cargarModelo();
		}
		return listFranjas;
	}
	
	private void cargarModelo() {
		List<FranjaEntrevista> franjas = ges.getFranjasEntrevista();
		modeloListaFranjas.addAll(franjas);
	}
	
	private JLabel getLbMedio() {
		if (lbMedio == null) {
			lbMedio = new JLabel("Escriba el medio de comunicación:");
			lbMedio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbMedio.setBounds(17, 275, 231, 29);
		}
		return lbMedio;
	}
	private JTextField getTxMedio() {
		if (txMedio == null) {
			txMedio = new JTextField();
			txMedio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txMedio.setBounds(247, 275, 246, 29);
			txMedio.setColumns(10);
		}
		return txMedio;
	}
	private JButton getBtCrearEntrevista() {
		if (btCrearEntrevista == null) {
			btCrearEntrevista = new JButton("Crear entrevista");
			btCrearEntrevista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearEntrevista();
				}
			});
			btCrearEntrevista.setEnabled(false);
			btCrearEntrevista.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btCrearEntrevista.setBounds(466, 327, 153, 40);
		}
		return btCrearEntrevista;
	}
	
	private void crearEntrevista() {
		if (this.getTxMedio().getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "El medio no puede estar vacio.");
		} else {
			ges.crearEntrevista(this.getListFranjas().getSelectedValue(), this.getTxMedio().getText());
			JOptionPane.showMessageDialog(null, "La entrevista se ha creado correctamente.");
		}
	}
	
	private JButton getBtSeleccionarFranja() {
		if (btSeleccionarFranja == null) {
			btSeleccionarFranja = new JButton("Seleccionar franja");
			btSeleccionarFranja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seleccionarFranja();
				}
			});
			btSeleccionarFranja.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btSeleccionarFranja.setBounds(494, 212, 125, 35);
		}
		return btSeleccionarFranja;
	}
	
	private void seleccionarFranja() {
		if (this.getListFranjas().getSelectedIndex() != -1) {
			this.getBtCrearEntrevista().setEnabled(true);
		}
	}
}
