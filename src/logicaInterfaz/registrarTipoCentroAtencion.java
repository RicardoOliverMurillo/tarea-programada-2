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

public class registrarTipoCentroAtencion extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoTipoCentroAtencion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarTipoCentroAtencion frame = new registrarTipoCentroAtencion();
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
	public registrarTipoCentroAtencion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Tipo de Centro de Atención");
		lblNewLabel.setBounds(125, 16, 227, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Nuevo tipo de centro de atención:");
		lblNewLabel_4.setBounds(43, 69, 227, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(363, 112, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoTipoCentroAtencion = new JTextField();
		campoTextoTipoCentroAtencion.setBounds(283, 64, 197, 26);
		contentPane.add(campoTextoTipoCentroAtencion);
		campoTextoTipoCentroAtencion.setColumns(10);
		
		JButton botonCrearNuevoCentroAtencion = new JButton("Crear");
		botonCrearNuevoCentroAtencion.setBounds(235, 112, 117, 29);
		contentPane.add(botonCrearNuevoCentroAtencion);
	}
}
