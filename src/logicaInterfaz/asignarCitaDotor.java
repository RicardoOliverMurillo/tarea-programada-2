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

public class asignarCitaDotor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					asignarCitaDotor frame = new asignarCitaDotor();
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
	public asignarCitaDotor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Asignar cita");
		lblNewLabel.setBounds(145, 18, 89, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Modificar cita cancelada:");
		lblNewLabel_4.setBounds(19, 69, 167, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(248, 114, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonModificarCita = new JButton("Modificar cita");
		botonModificarCita.setBounds(33, 114, 117, 29);
		contentPane.add(botonModificarCita);
		
		JComboBox comboBoxCitas = new JComboBox();
		comboBoxCitas.setBounds(198, 65, 167, 27);
		contentPane.add(comboBoxCitas);
	}
}
