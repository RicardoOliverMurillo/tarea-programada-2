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

public class registrarCita extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoObservacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarCita frame = new registrarCita();
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
	public registrarCita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Cita");
		lblNewLabel.setBounds(191, 22, 69, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Especialidad:");
		lblNewLabel_1.setBounds(35, 69, 88, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setBounds(35, 107, 40, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hora:");
		lblNewLabel_3.setBounds(35, 154, 40, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Observación:");
		lblNewLabel_4.setBounds(35, 197, 88, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegistrarCita = new JButton("Registrar Cita");
		botonRegistrarCita.setBounds(35, 301, 149, 29);
		contentPane.add(botonRegistrarCita);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(294, 301, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoObservacion = new JTextField();
		campoTextoObservacion.setBounds(164, 192, 247, 77);
		contentPane.add(campoTextoObservacion);
		campoTextoObservacion.setColumns(10);
		
		JComboBox comboBoxEspecialidad = new JComboBox();
		comboBoxEspecialidad.setBounds(164, 65, 159, 27);
		contentPane.add(comboBoxEspecialidad);
	}
}
