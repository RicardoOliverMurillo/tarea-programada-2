package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicanegocios.CatalogoDiagnosticos;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class registrarCatalogoDiagnostico extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoInformacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarCatalogoDiagnostico frame = new registrarCatalogoDiagnostico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public registrarCatalogoDiagnostico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A帽adir informaci贸n al cat谩logo de diagn贸stico");
		lblNewLabel.setBounds(109, 16, 295, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Informaci贸n del diagn贸stico:");
		lblNewLabel_4.setBounds(19, 69, 197, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(19, 115, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoInformacion = new JTextField();
		campoTextoInformacion.setBounds(228, 64, 197, 26);
		contentPane.add(campoTextoInformacion);
		campoTextoInformacion.setColumns(10);
		
		JButton botonCrearInfoNueva = new JButton("Crear");
		botonCrearInfoNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				CatalogoDiagnosticos CatalogoDiagnosticos;
				String nombre = campoTextoInformacion.getText();
				
				CatalogoDiagnosticos = new CatalogoDiagnosticos(nombre);
			

				if ((campoTextoInformacion.getText().equals("")) || (campoTextoInformacion.getText().equals(""))
						|| (campoTextoInformacion.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					try {
						if (CatalogoDiagnosticos.verificarDiagnostico(nombre)) {
							JOptionPane.showMessageDialog(frame, "ERROR: Ya existe un diagn髎tico con ese nombre.");
							campoTextoInformacion.setText("");
							
						} else {
							CatalogoDiagnosticos.crearDiagnostico();
							JOptionPane.showMessageDialog(frame, "Diagn髎tico Registrado");
							campoTextoInformacion.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

			}
		});
		botonCrearInfoNueva.setBounds(361, 115, 117, 29);
		contentPane.add(botonCrearInfoNueva);
	}
}
