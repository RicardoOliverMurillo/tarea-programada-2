package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicanegocios.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class registrarInformacionAdicionalDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoCodigo;
	private JTextField campoTextoEspecialidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarInformacionAdicionalDoctor frame = new registrarInformacionAdicionalDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public registrarInformacionAdicionalDoctor() {};

	/**
	 * Create the frame.
	 */
	public registrarInformacionAdicionalDoctor(int pcedula, String pnombre, String ptipo, String pfecha, String area) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Información Adicional del Doctor");
		lblNewLabel.setBounds(88, 24, 280, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Especialidad estudiada:");
		lblNewLabel_4.setBounds(42, 127, 160, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarFuncionario().setVisible(true);
			}
		});
		botonRegresar.setBounds(251, 175, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonRegistrarEspecialidad = new JButton("Registrar doctor");
		botonRegistrarEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				Funcionario funcionario;
				String codigoDoctor = campoTextoCodigo.getText();
				String especialidad = campoTextoEspecialidad.getText();
				funcionario = new Funcionario(pcedula, pnombre, ptipo, pfecha, area, Integer.parseInt(codigoDoctor),especialidad);
				try {
					if(funcionario.verificarCodigoDoctor(Integer.parseInt(codigoDoctor))) {
						JOptionPane.showMessageDialog(frame, "Codigo de doctor existente");
					}else {
						funcionario.crearDoctor();
						JOptionPane.showMessageDialog(frame, "Doctor registrado");
					}
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonRegistrarEspecialidad.setBounds(26, 175, 160, 29);
		contentPane.add(botonRegistrarEspecialidad);
		
		JComboBox comboBoxEspecialidad = new JComboBox();
		comboBoxEspecialidad.setBounds(232, 99, 136, 27);
		contentPane.add(comboBoxEspecialidad);
		
		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setBounds(42, 66, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		campoTextoCodigo = new JTextField();
		campoTextoCodigo.setBounds(238, 61, 130, 26);
		contentPane.add(campoTextoCodigo);
		campoTextoCodigo.setColumns(10);
		
		campoTextoEspecialidad = new JTextField();
		campoTextoEspecialidad.setBounds(224, 122, 170, 26);
		contentPane.add(campoTextoEspecialidad);
		campoTextoEspecialidad.setColumns(10);
	}
}
