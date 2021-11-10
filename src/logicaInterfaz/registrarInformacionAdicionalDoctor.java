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

public class registrarInformacionAdicionalDoctor extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public registrarInformacionAdicionalDoctor() {
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
		lblNewLabel_4.setBounds(43, 69, 160, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(232, 119, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonRegistrarEspecialidad = new JButton("Registrar");
		botonRegistrarEspecialidad.setBounds(68, 119, 117, 29);
		contentPane.add(botonRegistrarEspecialidad);
		
		JComboBox comboBoxEspecialidad = new JComboBox();
		comboBoxEspecialidad.setBounds(232, 65, 136, 27);
		contentPane.add(comboBoxEspecialidad);
	}
}
