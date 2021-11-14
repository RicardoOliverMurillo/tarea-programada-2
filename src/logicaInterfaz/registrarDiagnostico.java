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

public class registrarDiagnostico extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoObservacion;

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

	/**
	 * Create the frame.
	 */
	public registrarDiagnostico() {
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
		
		JButton botonRegistrarDiagnostico = new JButton("Registrar Diagnóstico");
		botonRegistrarDiagnostico.setBounds(35, 301, 171, 29);
		contentPane.add(botonRegistrarDiagnostico);
		
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
	}
}
