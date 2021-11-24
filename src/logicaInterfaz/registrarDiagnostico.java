package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicanegocios.*;
import logicadao.*;

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

public class registrarDiagnostico extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoObservacion;
	CatalogoDiagnosticos objCatalogoDiagnoticos = new CatalogoDiagnosticos();
	String idDiagnostico;
	daoCatalogoDiagnostico daoCatalogoDiagnostico = new daoCatalogoDiagnostico();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarDiagnostico frame = new registrarDiagnostico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public List<String> getDiagnosticosRegistrados() throws SQLException {
		List<CatalogoDiagnosticos> diagnosticos = objCatalogoDiagnoticos.getDiagnosticosRegistrados();
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<diagnosticos.size(); i++) {
			registrosCitas.add(diagnosticos.get(i).getNombre());
		}
		return registrosCitas;
	}
	
	public registrarDiagnostico() {
		
	}

	/**
	 * Create the frame.
	 */
	public registrarDiagnostico(String pIdCita, String pcedula, String cedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Diagnóstico");
		lblNewLabel.setBounds(158, 24, 117, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Diagnóstico:");
		lblNewLabel_1.setBounds(35, 69, 171, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nivel:");
		lblNewLabel_2.setBounds(35, 107, 40, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Observación:");
		lblNewLabel_4.setBounds(35, 157, 88, 16);
		contentPane.add(lblNewLabel_4);
		

		
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(294, 301, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoObservacion = new JTextField();
		campoTextoObservacion.setBounds(135, 157, 247, 77);
		contentPane.add(campoTextoObservacion);
		campoTextoObservacion.setColumns(10);
		
		JComboBox comboBoxCatalogo = new JComboBox();
		comboBoxCatalogo.setBounds(119, 65, 159, 27);
		contentPane.add(comboBoxCatalogo);
		
		JComboBox comboBoxNivel = new JComboBox();
		comboBoxNivel.setBounds(119, 103, 101, 27);
		contentPane.add(comboBoxNivel);
		comboBoxNivel.addItem("Leve");
		comboBoxNivel.addItem("Grave");
		comboBoxNivel.addItem("Muy grave");
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				int contador = 0;
				List<String> diagnosticosRegistrados;
				try {
					diagnosticosRegistrados = getDiagnosticosRegistrados();
						while (diagnosticosRegistrados.size() > contador) {
							comboBoxCatalogo.addItem(diagnosticosRegistrados.get(contador));
							contador +=1;
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(313, 66, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton botonRegistrarDiagnostico = new JButton("Registrar Diagnóstico");
		botonRegistrarDiagnostico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				RegistrarDiagnostico RegistrarDiagnostico;
				
				String nombreDiagnostico = comboBoxCatalogo.getSelectedItem().toString().toString();
				String nivel = comboBoxNivel.getSelectedItem().toString().toString();
				String obervaciones = campoTextoObservacion.getText();
				
				idDiagnostico = daoCatalogoDiagnostico.getIdDiagnostico(nombreDiagnostico);
				System.out.println("Nombre del diagnostico: " + nombreDiagnostico);
				System.out.println("ID del diagnostico: " + idDiagnostico);
				
				RegistrarDiagnostico = new RegistrarDiagnostico(idDiagnostico,pIdCita,nivel,obervaciones);

				if (campoTextoObservacion.getText().equals(""))  {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					RegistrarDiagnostico.crearRegistrarDiagnostico();
					dispose();
					new registrarTratamiento(pIdCita,idDiagnostico,String.valueOf(pcedula),cedula).setVisible(true);
					campoTextoObservacion.setText("");
					
				}
			}
		});
		botonRegistrarDiagnostico.setBounds(35, 301, 171, 29);
		contentPane.add(botonRegistrarDiagnostico);

	}
}
