package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicaInterfaz.registrarExperienciaEnfermero;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registrarHospitalizacion extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoIdentificacion;
	private JTextField campoTextoNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarHospitalizacion frame = new registrarHospitalizacion();
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
	public registrarHospitalizacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Hospitalización del Paciente");
		lblNewLabel.setBounds(131, 22, 220, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Centro de atención:");
		lblNewLabel_1.setBounds(35, 69, 135, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Identificación del paciente:");
		lblNewLabel_2.setBounds(35, 107, 179, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre del paciente:");
		lblNewLabel_3.setBounds(35, 154, 142, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Diagnóstico:");
		lblNewLabel_4.setBounds(35, 197, 88, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegistrarCita = new JButton("Registrar Hospitalización");
		botonRegistrarCita.setBounds(17, 471, 197, 29);
		contentPane.add(botonRegistrarCita);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(301, 471, 117, 29);
		contentPane.add(botonRegresar);
		
		JComboBox comboBoxCentroAtencion = new JComboBox();
		comboBoxCentroAtencion.setBounds(192, 65, 159, 27);
		contentPane.add(comboBoxCentroAtencion);
		
		campoTextoIdentificacion = new JTextField();
		campoTextoIdentificacion.setBounds(221, 102, 142, 26);
		contentPane.add(campoTextoIdentificacion);
		campoTextoIdentificacion.setColumns(10);
		
		campoTextoNombre = new JTextField();
		campoTextoNombre.setBounds(196, 149, 167, 26);
		contentPane.add(campoTextoNombre);
		campoTextoNombre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de inicio:");
		lblNewLabel_5.setBounds(35, 244, 111, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha final:");
		lblNewLabel_6.setBounds(35, 283, 88, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Especialidad/servicio:");
		lblNewLabel_7.setBounds(35, 327, 149, 16);
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBoxEspecialidad = new JComboBox();
		comboBoxEspecialidad.setBounds(196, 323, 155, 27);
		contentPane.add(comboBoxEspecialidad);
		
		JLabel lblNewLabel_8 = new JLabel("Funcionario:");
		lblNewLabel_8.setBounds(35, 385, 88, 16);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboBoxFuncionario = new JComboBox();
		comboBoxFuncionario.setBounds(162, 381, 159, 27);
		contentPane.add(comboBoxFuncionario);
	}
}
