package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registrarExperienciaEnfermero extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarExperienciaEnfermero frame = new registrarExperienciaEnfermero();
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
	public registrarExperienciaEnfermero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Experiencia Enfermero");
		lblNewLabel.setBounds(83, 17, 207, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("¿Ha tenido otras personas a cargo?");
		lblNewLabel_1.setBounds(35, 69, 226, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("¿Ha dado capacitaciones a pacientes?");
		lblNewLabel_2.setBounds(35, 107, 248, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton botonRegistrarEnfermero = new JButton("Registrar enfermero");
		botonRegistrarEnfermero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonRegistrarEnfermero.setBounds(35, 161, 159, 29);
		contentPane.add(botonRegistrarEnfermero);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarFuncionario().setVisible(true);
			}
		});
		botonRegresar.setBounds(257, 161, 117, 29);
		contentPane.add(botonRegresar);
		
		JComboBox comboBoxCargo = new JComboBox();
		comboBoxCargo.setBounds(295, 65, 79, 27);
		contentPane.add(comboBoxCargo);
		
		JComboBox comboBoxCapacitaciones = new JComboBox();
		comboBoxCapacitaciones.setBounds(295, 103, 79, 27);
		contentPane.add(comboBoxCapacitaciones);
		
		comboBoxCargo.addItem("Si");
		comboBoxCargo.addItem("No");
		comboBoxCapacitaciones.addItem("Si");
		comboBoxCapacitaciones.addItem("No");
	}
}
