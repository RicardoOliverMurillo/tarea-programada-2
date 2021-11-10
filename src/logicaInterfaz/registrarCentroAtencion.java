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

public class registrarCentroAtencion extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoNombre;
	private JTextField campoTextoUbicacion;
	private JTextField campoTextoCantidadPacientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarCentroAtencion frame = new registrarCentroAtencion();
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
	public registrarCentroAtencion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Centro de Atención");
		lblNewLabel.setBounds(330, 18, 165, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(35, 69, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		campoTextoNombre = new JTextField();
		campoTextoNombre.setBounds(115, 64, 247, 26);
		contentPane.add(campoTextoNombre);
		campoTextoNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ubicación:");
		lblNewLabel_2.setBounds(35, 107, 81, 16);
		contentPane.add(lblNewLabel_2);
		
		campoTextoUbicacion = new JTextField();
		campoTextoUbicacion.setBounds(115, 102, 247, 26);
		contentPane.add(campoTextoUbicacion);
		campoTextoUbicacion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Catidad máxima de pacientes:");
		lblNewLabel_3.setBounds(35, 147, 198, 16);
		contentPane.add(lblNewLabel_3);
		
		campoTextoCantidadPacientes = new JTextField();
		campoTextoCantidadPacientes.setBounds(283, 142, 130, 26);
		contentPane.add(campoTextoCantidadPacientes);
		campoTextoCantidadPacientes.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de centro de atención:");
		lblNewLabel_4.setBounds(35, 188, 172, 16);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBoxTipoCentroAtencion = new JComboBox();
		comboBoxTipoCentroAtencion.setBounds(283, 184, 168, 27);
		contentPane.add(comboBoxTipoCentroAtencion);
		
		JButton botonCrearTipoCentroAtencion = new JButton("Crear nuevo tipo de centro de atención");
		botonCrearTipoCentroAtencion.setBounds(35, 258, 288, 29);
		contentPane.add(botonCrearTipoCentroAtencion);
		
		JButton botonCrearCentroAtencion = new JButton("Crear Centro de Atención");
		botonCrearCentroAtencion.setBounds(349, 258, 208, 29);
		contentPane.add(botonCrearCentroAtencion);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(600, 258, 117, 29);
		contentPane.add(botonRegresar);
	}
}
