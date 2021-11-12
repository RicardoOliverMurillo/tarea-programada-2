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

public class menuReportesPaciente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuReportesPaciente frame = new menuReportesPaciente();
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
	public menuReportesPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reportes Paciente");
		lblNewLabel.setBounds(197, 18, 117, 16);
		contentPane.add(lblNewLabel);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(384, 240, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonCitas = new JButton("Citas asociadas al paciente");
		botonCitas.setBounds(144, 63, 214, 29);
		contentPane.add(botonCitas);
		
		JButton botonDiagnostico = new JButton("Diagnósticos asociados al paciente");
		botonDiagnostico.setBounds(123, 104, 266, 29);
		contentPane.add(botonDiagnostico);
		
		JButton botonTratamientos = new JButton("Tratamientos asociados al paciente");
		botonTratamientos.setBounds(133, 145, 248, 29);
		contentPane.add(botonTratamientos);
		
		JButton botonHospitalizacion = new JButton("Hospitalizaciones asociados al paciente");
		botonHospitalizacion.setBounds(114, 186, 295, 29);
		contentPane.add(botonHospitalizacion);
	}
}
