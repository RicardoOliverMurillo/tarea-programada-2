package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import logicanegocios.Funcionario;
import logicanegocios.Paciente;

public class registrarPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoCedula;
	private JTextField campoTextoNombre;
	private JTextField campoTextoNacionalidad;
	private JTextField campoTextoLugarResidencia;
	private JTextField campoTextoTelefono;
	private JTextField campoTextoOtroTelefono;
	private JTextField tempPassTextField;

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
		setBounds(100, 100, 869, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Paciente");
		lblNewLabel.setBounds(367, 19, 165, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula:");
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
		
		JComboBox comboBoxTipoSangre = new JComboBox();
		comboBoxTipoSangre.addItem("AB+");
		comboBoxTipoSangre.addItem("AB");
		comboBoxTipoSangre.addItem("A+");
		comboBoxTipoSangre.addItem("A-");
		comboBoxTipoSangre.addItem("B+");
		comboBoxTipoSangre.addItem("B-");
		comboBoxTipoSangre.addItem("O+");
		comboBoxTipoSangre.addItem("O-");
		comboBoxTipoSangre.setBounds(164, 193, 165, 27);
		contentPane.add(comboBoxTipoSangre);
		
		JDateChooser fechaNacimiento = new JDateChooser();
		fechaNacimiento.setBounds(164, 154, 247, 26);
		contentPane.add(fechaNacimiento);
		
		JButton botonCrearPaciente = new JButton("Crear Paciente");
		botonCrearPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				Paciente paciente; 
				String cedula = campoTextoCedula.getText();
				String nombre = campoTextoNombre.getText();
				SimpleDateFormat  dFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fecha = dFormat.format(fechaNacimiento.getDate());
				String tipoSangre = comboBoxTipoSangre.getSelectedItem().toString();
				String nacionalidad = campoTextoNacionalidad.getText();
				String residencia = campoTextoLugarResidencia.getText();
				String telefono = campoTextoTelefono.getText();
				
				if ((campoTextoCedula.getText().equals("")) || (campoTextoNombre.getText().equals("")) || (campoTextoNacionalidad.getText().equals("")) || (campoTextoLugarResidencia.getText().equals("")) || (campoTextoTelefono.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					paciente = new Paciente(Integer.parseInt(cedula), nombre, fecha, tipoSangre, nacionalidad,residencia,Integer.parseInt(telefono));
					try {
						if (paciente.verificarPaciente()) {
							JOptionPane.showMessageDialog(frame, "Cedula existente");
							campoTextoTelefono.setText("");
							campoTextoNombre.setText("");
							campoTextoNacionalidad.setText("");
							campoTextoLugarResidencia.setText("");
						} else {
							paciente.crearPaciente();
							paciente.crearPacienteTelefono();
							JOptionPane.showMessageDialog(frame, "Paciente registrado");
							campoTextoTelefono.setText("");
							campoTextoNombre.setText("");
							campoTextoNacionalidad.setText("");
							campoTextoLugarResidencia.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}		
			}
		});
		botonCrearPaciente.setBounds(692, 263, 124, 29);
		contentPane.add(botonCrearPaciente);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuAdministrador().setVisible(true);
			}
		});
		botonRegresar.setBounds(699, 338, 117, 29);
		contentPane.add(botonRegresar);
		
		JLabel lblNewLabel_5 = new JLabel("Nacionalidad:");
		lblNewLabel_5.setBounds(513, 64, 98, 16);
		contentPane.add(lblNewLabel_5);
		
		campoTextoNacionalidad = new JTextField();
		campoTextoNacionalidad.setBounds(608, 59, 208, 26);
		contentPane.add(campoTextoNacionalidad);
		campoTextoNacionalidad.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Lugar de residencia:");
		lblNewLabel_6.setBounds(475, 107, 136, 16);
		contentPane.add(lblNewLabel_6);
		
		campoTextoLugarResidencia = new JTextField();
		campoTextoLugarResidencia.setBounds(608, 102, 208, 26);
		contentPane.add(campoTextoLugarResidencia);
		campoTextoLugarResidencia.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Telefono:");
		lblNewLabel_7.setBounds(513, 154, 61, 16);
		contentPane.add(lblNewLabel_7);
		
		campoTextoTelefono = new JTextField();
		campoTextoTelefono.setBounds(608, 149, 208, 26);
		contentPane.add(campoTextoTelefono);
		campoTextoTelefono.setColumns(10);
		
		JButton btnRegistrarOtroTelefno = new JButton("Registrar otro telefono");
		btnRegistrarOtroTelefno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				Paciente paciente; 
				String cedula = campoTextoCedula.getText();
				String telefono = campoTextoOtroTelefono.getText();
				
				if (campoTextoCedula.getText().equals("") || (campoTextoOtroTelefono.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete los campos del formulario");
				} else {
					paciente = new Paciente(Integer.parseInt(cedula), Integer.parseInt(telefono));
					try {
						if (paciente.verificarNumero()) {
							JOptionPane.showMessageDialog(frame, "Telefono existente en el usuario");
						} else {
							paciente.crearPacienteTelefono();
							JOptionPane.showMessageDialog(frame, "Nueva telefono agregado");
							campoTextoTelefono.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}	
			}
		});
		btnRegistrarOtroTelefno.setBounds(183, 327, 209, 29);
		contentPane.add(btnRegistrarOtroTelefno);
		
		campoTextoOtroTelefono = new JTextField();
		campoTextoOtroTelefono.setBounds(35, 327, 136, 26);
		contentPane.add(campoTextoOtroTelefono);
		campoTextoOtroTelefono.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Contrasenna temporal:");
		lblNewLabel_9.setBounds(458, 198, 117, 14);
		contentPane.add(lblNewLabel_9);
		
		tempPassTextField = new JTextField();
		tempPassTextField.setBounds(608, 195, 208, 20);
		contentPane.add(tempPassTextField);
		tempPassTextField.setColumns(10);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setBounds(577, 263, 98, 29);
		contentPane.add(btnCrearCuenta);
		
		
	}
}
