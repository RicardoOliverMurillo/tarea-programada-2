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

public class registrarPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoCedula;
	private JTextField campoTextoNombre;
	private JTextField campoTextoTipoSangre;
	private JTextField campoTextoNacionalidad;
	private JTextField campoTexto;
	private JTextField campoTextoTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarPaciente frame = new registrarPaciente();
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
	public registrarPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Paciente");
		lblNewLabel.setBounds(367, 19, 165, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cédula:");
		lblNewLabel_1.setBounds(35, 69, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		campoTextoCedula = new JTextField();
		campoTextoCedula.setBounds(164, 64, 247, 26);
		contentPane.add(campoTextoCedula);
		campoTextoCedula.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre completo:");
		lblNewLabel_2.setBounds(35, 107, 117, 16);
		contentPane.add(lblNewLabel_2);
		
		campoTextoNombre = new JTextField();
		campoTextoNombre.setBounds(164, 102, 247, 26);
		contentPane.add(campoTextoNombre);
		campoTextoNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_3.setBounds(35, 154, 136, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de sangre:");
		lblNewLabel_4.setBounds(35, 197, 111, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegistrarVacunas = new JButton("Registrar vacuna");
		botonRegistrarVacunas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonRegistrarVacunas.setBounds(57, 263, 288, 29);
		contentPane.add(botonRegistrarVacunas);
		
		JButton botonCrearPaciente = new JButton("Crear Paciente");
		botonCrearPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				/////VALIDAR CUANDO NO SE ENVIA UN CODIGO FUNCIONARIO SINO NO ABRE LA VENTANA
				new registrarExperienciaEnfermero().setVisible(true);
			}
		});
		botonCrearPaciente.setBounds(608, 263, 208, 29);
		contentPane.add(botonCrearPaciente);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(699, 338, 117, 29);
		contentPane.add(botonRegresar);
		
		JLabel lblNewLabel_5 = new JLabel("Nacionalidad:");
		lblNewLabel_5.setBounds(513, 64, 98, 16);
		contentPane.add(lblNewLabel_5);
		
		campoTextoTipoSangre = new JTextField();
		campoTextoTipoSangre.setBounds(164, 192, 247, 26);
		contentPane.add(campoTextoTipoSangre);
		campoTextoTipoSangre.setColumns(10);
		
		campoTextoNacionalidad = new JTextField();
		campoTextoNacionalidad.setBounds(608, 59, 208, 26);
		contentPane.add(campoTextoNacionalidad);
		campoTextoNacionalidad.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Lugar de residencia:");
		lblNewLabel_6.setBounds(475, 107, 136, 16);
		contentPane.add(lblNewLabel_6);
		
		campoTexto = new JTextField();
		campoTexto.setBounds(608, 102, 208, 26);
		contentPane.add(campoTexto);
		campoTexto.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Teléfono:");
		lblNewLabel_7.setBounds(513, 154, 61, 16);
		contentPane.add(lblNewLabel_7);
		
		campoTextoTelefono = new JTextField();
		campoTextoTelefono.setBounds(608, 149, 208, 26);
		contentPane.add(campoTextoTelefono);
		campoTextoTelefono.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Lista de vacunas aplicadas:");
		lblNewLabel_8.setBounds(433, 197, 178, 16);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboBoxVacunas = new JComboBox();
		comboBoxVacunas.setBounds(608, 193, 208, 27);
		contentPane.add(comboBoxVacunas);
	}
}
