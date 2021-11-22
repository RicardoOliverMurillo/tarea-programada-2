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

import logicanegocios.CentroAtencion;
import logicanegocios.Funcionario;


public class registrarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoCedula;
	private JTextField campoTextoNombre;
	private JTextField campoTextoAreaTrabajo;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarFuncionario frame = new registrarFuncionario();
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
	public registrarFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Funcionario");
		lblNewLabel.setBounds(367, 19, 165, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula:");
		lblNewLabel_1.setBounds(35, 69, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		campoTextoCedula = new JTextField();
		campoTextoCedula.setBounds(115, 64, 247, 26);
		contentPane.add(campoTextoCedula);
		campoTextoCedula.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre completo:");
		lblNewLabel_2.setBounds(35, 107, 117, 16);
		contentPane.add(lblNewLabel_2);
		
		campoTextoNombre = new JTextField();
		campoTextoNombre.setBounds(164, 102, 247, 26);
		contentPane.add(campoTextoNombre);
		campoTextoNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de funcionario:");
		lblNewLabel_3.setBounds(35, 154, 136, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de ingreso a la institucion:");
		lblNewLabel_4.setBounds(35, 197, 208, 16);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBoxTipoFuncionario = new JComboBox();
		comboBoxTipoFuncionario.addItem("Doctor");
		comboBoxTipoFuncionario.addItem("Enfermero");
		comboBoxTipoFuncionario.addItem("Secretario");
		comboBoxTipoFuncionario.setBounds(174, 150, 165, 27);
		contentPane.add(comboBoxTipoFuncionario);
		
		JDateChooser fechaIngreso = new JDateChooser();
		fechaIngreso.setBounds(255, 197, 156, 26);
		contentPane.add(fechaIngreso);
		
		JButton botonCrearFuncionario = new JButton("Crear Funcionario");
		botonCrearFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame();
				Funcionario funcionario;
				String cedula = campoTextoCedula.getText();
				String nombre = campoTextoNombre.getText();
				String tipo = comboBoxTipoFuncionario.getSelectedItem().toString();
				SimpleDateFormat  dFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fecha = dFormat.format(fechaIngreso.getDate());
				
				if ((campoTextoCedula.getText().equals("")) || (campoTextoNombre.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					
					funcionario = new Funcionario(Integer.parseInt(cedula), nombre, tipo, fecha);
					
					if (comboBoxTipoFuncionario.getSelectedItem().toString().equals("Enfermero")) {
						try {
							if (funcionario.verificarFuncionario(Integer.parseInt(cedula))) {
								JOptionPane.showMessageDialog(frame, "Cedula existente");
								campoTextoCedula.setText("");
								campoTextoNombre.setText("");
							} else {
								dispose();
								new registrarExperienciaEnfermero(Integer.parseInt(cedula),nombre,tipo,fecha).setVisible(true);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
					
					
					
					else if(comboBoxTipoFuncionario.getSelectedItem().toString().equals("Doctor")) {
						try {
							if (funcionario.verificarFuncionario(Integer.parseInt(cedula))) {
								JOptionPane.showMessageDialog(frame, "Cedula existente");
								campoTextoCedula.setText("");
								campoTextoNombre.setText("");
							} else {
								dispose();
								new registrarInformacionAdicionalDoctor().setVisible(true);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						
						
						
					}else if(comboBoxTipoFuncionario.getSelectedItem().toString().equals("Secretario")) {
						
						if ((campoTextoCedula.getText().equals("")) || (campoTextoNombre.getText().equals(""))) {
							JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
						} else {
							funcionario = new Funcionario(Integer.parseInt(cedula), nombre, tipo, fecha);

							try {
								if (funcionario.verificarFuncionario(Integer.parseInt(cedula))) {
									JOptionPane.showMessageDialog(frame, "Cedula existente");
									campoTextoCedula.setText("");
									campoTextoNombre.setText("");
								} else {
									funcionario.crearSecretario();
									JOptionPane.showMessageDialog(frame, "Funcionario registrado");
									campoTextoCedula.setText("");
									campoTextoNombre.setText("");
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
				}	
				
				
				
				
			}
		});
		botonCrearFuncionario.setBounds(313, 352, 147, 29);
		contentPane.add(botonCrearFuncionario);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(729, 398, 117, 29);
		contentPane.add(botonRegresar);
		
		JLabel lblNewLabel_5 = new JLabel("Area de trabajo:");
		lblNewLabel_5.setBounds(35, 255, 111, 16);
		contentPane.add(lblNewLabel_5);
		
		JButton botonEditarAreaTrabajo = new JButton("Editar una Area de trabajo especifica");
		botonEditarAreaTrabajo.setBounds(51, 352, 252, 29);
		contentPane.add(botonEditarAreaTrabajo);
		
		campoTextoAreaTrabajo = new JTextField();
		campoTextoAreaTrabajo.setBounds(155, 250, 147, 26);
		contentPane.add(campoTextoAreaTrabajo);
		campoTextoAreaTrabajo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Contrasenna temporal");
		lblNewLabel_6.setBounds(470, 70, 111, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(591, 67, 208, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrearCuenta.setBounds(478, 352, 117, 29);
		contentPane.add(btnCrearCuenta);
	}
}
