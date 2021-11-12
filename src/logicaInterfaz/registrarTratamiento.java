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

public class registrarTratamiento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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

	/**
	 * Create the frame.
	 */
	public registrarTratamiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Tratamiento");
		lblNewLabel.setBounds(133, 23, 146, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Diagnóstico:");
		lblNewLabel_1.setBounds(35, 69, 88, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tratamiento:");
		lblNewLabel_2.setBounds(35, 107, 88, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Dosis:");
		lblNewLabel_4.setBounds(35, 157, 88, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegistrarDiagnostico = new JButton("Registrar Tratamiento");
		botonRegistrarDiagnostico.setBounds(35, 264, 171, 29);
		contentPane.add(botonRegistrarDiagnostico);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(262, 264, 117, 29);
		contentPane.add(botonRegresar);
		
		JComboBox comboBoxCatalogoDiagnostico = new JComboBox();
		comboBoxCatalogoDiagnostico.setBounds(135, 65, 159, 27);
		contentPane.add(comboBoxCatalogoDiagnostico);
		
		JComboBox comboBoxNivel = new JComboBox();
		comboBoxNivel.setBounds(135, 103, 159, 27);
		contentPane.add(comboBoxNivel);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de tratamiento:");
		lblNewLabel_3.setBounds(35, 202, 140, 16);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(135, 152, 159, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBoxTipoTratamiento = new JComboBox();
		comboBoxTipoTratamiento.setBounds(179, 198, 140, 27);
		contentPane.add(comboBoxTipoTratamiento);
	}
}
