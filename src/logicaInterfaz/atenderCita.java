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

public class atenderCita extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atenderCita frame = new atenderCita();
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
	public atenderCita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atención de cita");
		lblNewLabel.setBounds(133, 18, 117, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Cita a atender:");
		lblNewLabel_4.setBounds(19, 69, 167, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(248, 289, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonHospitalizacion = new JButton("Realizar hospitalización");
		botonHospitalizacion.setBounds(6, 207, 180, 29);
		contentPane.add(botonHospitalizacion);
		
		JComboBox comboBoxCitas = new JComboBox();
		comboBoxCitas.setBounds(198, 65, 167, 27);
		contentPane.add(comboBoxCitas);
		
		JButton botonDiagnostico = new JButton("Realizar diagnóstico");
		botonDiagnostico.setBounds(6, 125, 167, 29);
		contentPane.add(botonDiagnostico);
		
		JButton botonTratamiento = new JButton("Realizar tratamiento");
		botonTratamiento.setBounds(6, 166, 150, 29);
		contentPane.add(botonTratamiento);
	}
}
