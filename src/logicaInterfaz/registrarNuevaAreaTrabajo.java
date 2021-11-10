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

public class registrarNuevaAreaTrabajo extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoAreaTrabajo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarNuevaAreaTrabajo frame = new registrarNuevaAreaTrabajo();
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
	public registrarNuevaAreaTrabajo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Nueva Área de Trabajo");
		lblNewLabel.setBounds(150, 16, 227, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Nueva Área de Trabajo:");
		lblNewLabel_4.setBounds(19, 69, 227, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(363, 112, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoAreaTrabajo = new JTextField();
		campoTextoAreaTrabajo.setBounds(235, 64, 197, 26);
		contentPane.add(campoTextoAreaTrabajo);
		campoTextoAreaTrabajo.setColumns(10);
		
		JButton botonCrearNuevaAreaTrabajo = new JButton("Crear");
		botonCrearNuevaAreaTrabajo.setBounds(235, 112, 117, 29);
		contentPane.add(botonCrearNuevaAreaTrabajo);
	}
}
