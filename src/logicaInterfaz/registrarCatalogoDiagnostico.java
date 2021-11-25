package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import logicanegocios.*;
import logicadao.*;

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
		
	}
	public registrarCatalogoDiagnostico(int pCedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir información al catálogo de diagnóstico");
		lblNewLabel.setBounds(109, 16, 295, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Ingrese el nombre del diagn\u00F3stico:");
		lblNewLabel_4.setBounds(19, 69, 197, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuDoctor(pCedula).setVisible(true);
				
			}
		});
		botonRegresar.setBounds(363, 112, 117, 29);
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
							JOptionPane.showMessageDialog(frame, "ERROR: Ya existe un diagn�stico con ese nombre.");
							campoTextoInformacion.setText("");
							
						} else {
							CatalogoDiagnosticos.crearDiagnostico();
							JOptionPane.showMessageDialog(frame, "Diagn�stico Registrado");
							campoTextoInformacion.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

			}
		});
		
		botonCrearInfoNueva.setBounds(235, 112, 117, 29);
		contentPane.add(botonCrearInfoNueva);
	}
}
