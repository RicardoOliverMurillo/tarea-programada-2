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

public class registrarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoCedula;
	private JTextField campoTextoNombre;

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
		setBounds(100, 100, 822, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Funcionario");
		lblNewLabel.setBounds(367, 19, 165, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cédula:");
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
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de ingreso a la institución:");
		lblNewLabel_4.setBounds(35, 197, 208, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonCrearAreaTrabajo = new JButton("Crear nueva área de trabajo");
		botonCrearAreaTrabajo.setBounds(35, 301, 288, 29);
		contentPane.add(botonCrearAreaTrabajo);
		
		JButton botonCrearFuncionario = new JButton("Crear Funcionario");
		botonCrearFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				/////VALIDAR CUANDO NO SE ENVIA UN CODIGO FUNCIONARIO SINO NO ABRE LA VENTANA
				new registrarExperienciaEnfermero().setVisible(true);
			}
		});
		botonCrearFuncionario.setBounds(608, 301, 208, 29);
		contentPane.add(botonCrearFuncionario);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(699, 370, 117, 29);
		contentPane.add(botonRegresar);
		
		JComboBox comboBoxTipoFuncionario = new JComboBox();
		comboBoxTipoFuncionario.setBounds(174, 150, 165, 27);
		contentPane.add(comboBoxTipoFuncionario);
		
		JLabel lblNewLabel_5 = new JLabel("Área de trabajo:");
		lblNewLabel_5.setBounds(35, 255, 111, 16);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBoxAreaTrabajo = new JComboBox();
		comboBoxAreaTrabajo.setBounds(164, 251, 165, 27);
		contentPane.add(comboBoxAreaTrabajo);
		
		JButton botonEditarAreaTrabajo = new JButton("Editar una área de trabajo específica");
		botonEditarAreaTrabajo.setBounds(321, 301, 288, 29);
		contentPane.add(botonEditarAreaTrabajo);
	}
}
