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

public class registrarTratamiento extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoObservacion;
	CatalogoTratamientos objCatalogoTratamientos = new CatalogoTratamientos();
	String idTratamiento;
	daoCatalogoTratamientos daoCatalogoTratamientos = new daoCatalogoTratamientos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarTratamiento frame = new registrarTratamiento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public registrarTratamiento() {
		
	}
	
	

	/**
	 * Create the frame.
	 */
	public registrarTratamiento(String pIdCita, String pIdDiagnostico,String pCedula, String cedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Tratamientos:");
		lblNewLabel.setBounds(158, 24, 117, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione el tratamiento:");
		lblNewLabel_1.setBounds(10, 69, 171, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de tratamiento:");
		lblNewLabel_2.setBounds(10, 136, 177, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Dosis:");
		lblNewLabel_4.setBounds(39, 240, 88, 16);
		contentPane.add(lblNewLabel_4);
		

		
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(10, 308, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoObservacion = new JTextField();
		campoTextoObservacion.setBounds(177, 190, 247, 77);
		contentPane.add(campoTextoObservacion);
		campoTextoObservacion.setColumns(10);
		
		JComboBox comboBoxCatalogo = new JComboBox();
		comboBoxCatalogo.setBounds(166, 64, 159, 27);
		contentPane.add(comboBoxCatalogo);
		
		JComboBox comboBoxNivel = new JComboBox();
		comboBoxNivel.setBounds(284, 131, 101, 27);
		contentPane.add(comboBoxNivel);
		comboBoxNivel.addItem("Medicamento");
		comboBoxNivel.addItem("Cirugia");
		comboBoxNivel.addItem("Curacion");
		comboBoxNivel.addItem("Sutura");
		comboBoxNivel.addItem("Radiografia");
		comboBoxNivel.addItem("Ultrasonido");
		comboBoxNivel.addItem("Otro");
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				int contador = 0;
				List<String> tratamientosRegistrados;
				List<CatalogoTratamientos> diagnosticos = objCatalogoTratamientos.getTratamientosRegistrados(pIdDiagnostico);
				List<String> registrosCitas = new ArrayList();
				for (int i = 0; i<diagnosticos.size(); i++) {
					registrosCitas.add(diagnosticos.get(i).getNombre());
				}
				try {
					tratamientosRegistrados = registrosCitas;
						while (tratamientosRegistrados.size() > contador) {
							comboBoxCatalogo.addItem(tratamientosRegistrados.get(contador));
							contador +=1;
						}
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(335, 66, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton botonRegistrarDiagnostico = new JButton("Registrar Tratamiento");
		botonRegistrarDiagnostico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				RegistrarTratamiento RegistrarTratamiento;
				
				String nombreTratamiento = comboBoxCatalogo.getSelectedItem().toString().toString();
				String nivel = comboBoxNivel.getSelectedItem().toString().toString();
				String obervaciones = campoTextoObservacion.getText();
				
				idTratamiento = daoCatalogoTratamientos.getIdTratamiento(nombreTratamiento);
				System.out.println("Nombre del tratamiento: " + nombreTratamiento);
				System.out.println("ID del tratamiento: " + idTratamiento);
				
				RegistrarTratamiento = new RegistrarTratamiento(idTratamiento,pIdCita,obervaciones,nivel);

				if (campoTextoObservacion.getText().equals(""))  {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					RegistrarTratamiento.crearRegistrarDiagnostico();
					campoTextoObservacion.setText("");
					dispose();
					new registrarHospitalizacion(String.valueOf(pCedula),String.valueOf(pIdCita),cedula).setVisible(true);
					
				}
			}
		});
		botonRegistrarDiagnostico.setBounds(253, 308, 171, 29);
		contentPane.add(botonRegistrarDiagnostico);

	}
	
	
}
