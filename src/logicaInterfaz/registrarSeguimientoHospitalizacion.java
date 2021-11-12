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

public class registrarSeguimientoHospitalizacion extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoObservacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarSeguimientoHospitalizacion frame = new registrarSeguimientoHospitalizacion();
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
	public registrarSeguimientoHospitalizacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seguimiento del Paciente");
		lblNewLabel.setBounds(142, 6, 166, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cédula paciente:");
		lblNewLabel_1.setBounds(35, 53, 117, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de seguimiento:");
		lblNewLabel_2.setBounds(35, 98, 149, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Funcionario responsable:");
		lblNewLabel_3.setBounds(35, 154, 166, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Observación:");
		lblNewLabel_4.setBounds(35, 269, 88, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegistrarCita = new JButton("Registrar Cita");
		botonRegistrarCita.setBounds(35, 360, 149, 29);
		contentPane.add(botonRegistrarCita);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(294, 360, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoObservacion = new JTextField();
		campoTextoObservacion.setBounds(164, 269, 247, 77);
		contentPane.add(campoTextoObservacion);
		campoTextoObservacion.setColumns(10);
		
		JComboBox comboBoxCedula = new JComboBox();
		comboBoxCedula.setBounds(163, 49, 159, 27);
		contentPane.add(comboBoxCedula);
		
		JComboBox comboBoxFuncionario = new JComboBox();
		comboBoxFuncionario.setBounds(213, 150, 159, 27);
		contentPane.add(comboBoxFuncionario);
		
		JLabel lblNewLabel_5 = new JLabel("Tratamiento asociado:");
		lblNewLabel_5.setBounds(35, 210, 149, 16);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBoxTratamiento = new JComboBox();
		comboBoxTratamiento.setBounds(213, 210, 159, 27);
		contentPane.add(comboBoxTratamiento);
	}
}
