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

public class registrarCatalogoTratamiento extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoInformacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarCatalogoTratamiento frame = new registrarCatalogoTratamiento();
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
	public registrarCatalogoTratamiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir información al catálogo del tratamiento");
		lblNewLabel.setBounds(109, 16, 295, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Información del tratamiento:");
		lblNewLabel_4.setBounds(19, 69, 197, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(363, 112, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoInformacion = new JTextField();
		campoTextoInformacion.setBounds(228, 64, 197, 26);
		contentPane.add(campoTextoInformacion);
		campoTextoInformacion.setColumns(10);
		
		JButton botonCrearInfoNueva = new JButton("Crear");
		botonCrearInfoNueva.setBounds(235, 112, 117, 29);
		contentPane.add(botonCrearInfoNueva);
	}
}
