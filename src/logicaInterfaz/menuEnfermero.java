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

public class menuEnfermero extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuEnfermero frame = new menuEnfermero();
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
	public menuEnfermero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menú Enfermero(a)");
		lblNewLabel.setBounds(197, 17, 126, 16);
		contentPane.add(lblNewLabel);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(383, 241, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonAsignarCita = new JButton("Asignar cita");
		botonAsignarCita.setBounds(197, 102, 117, 29);
		contentPane.add(botonAsignarCita);
		
		JButton botonCancelarCita = new JButton("Cancelar cita");
		botonCancelarCita.setBounds(197, 61, 117, 29);
		contentPane.add(botonCancelarCita);
		
		JButton botonReportesPaciente = new JButton("Reportes");
		botonReportesPaciente.setBounds(197, 183, 117, 29);
		contentPane.add(botonReportesPaciente);
		
		JButton botonAtenderCita = new JButton("Atender cita");
		botonAtenderCita.setBounds(197, 142, 117, 29);
		contentPane.add(botonAtenderCita);
	}
}
