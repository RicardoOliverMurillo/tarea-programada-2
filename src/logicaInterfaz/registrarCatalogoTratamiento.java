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
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import logicanegocios.*;
import logicadao.*;

public class registrarCatalogoTratamiento extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoInformacion;
	daoCatalogoTratamientos diagnosticos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarCatalogoTratamiento frame = new registrarCatalogoTratamiento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public List<String> getDiagnosticosRegistrados() throws SQLException {
		List<CatalogoDiagnosticos> listaDiagnosticos = diagnosticos.getListaDiagnosticos();
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<listaDiagnosticos.size(); i++) {
			registrosCitas.add(listaDiagnosticos.get(i).getNombre());
		}
		return registrosCitas;
	}

	/**
	 * Create the frame.
	 */
	public registrarCatalogoTratamiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir información al catálogo del tratamiento");
		lblNewLabel.setBounds(109, 16, 295, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Ingrese el nombre del tratamiento:");
		lblNewLabel_4.setBounds(19, 123, 197, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(19, 190, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoInformacion = new JTextField();
		campoTextoInformacion.setBounds(224, 118, 313, 26);
		contentPane.add(campoTextoInformacion);
		campoTextoInformacion.setColumns(10);
		
		JButton botonCrearInfoNueva = new JButton("Crear");
		botonCrearInfoNueva.setBounds(434, 190, 117, 29);
		contentPane.add(botonCrearInfoNueva);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione el diagn\u00F3stico asociado al tratamiento");
		lblNewLabel_1.setBounds(19, 54, 248, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(322, 50, 215, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				int contador = 0;
				List<String> diagnosticosRegistrados;
					try {
						diagnosticosRegistrados = getDiagnosticosRegistrados();
						while (diagnosticosRegistrados.size() > contador) {
							comboBox.addItem(diagnosticosRegistrados.get(contador));
							contador +=1;
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton.setBounds(322, 193, 89, 23);
		contentPane.add(btnNewButton);
	}
}
