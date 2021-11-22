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
import javax.swing.SwingConstants;
import java.awt.Font;

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
		setBounds(100, 100, 577, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reportes Paciente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(197, 18, 161, 16);
		contentPane.add(lblNewLabel);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(418, 269, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonCitas = new JButton("Citas asociadas al paciente");
		botonCitas.setBounds(144, 63, 245, 29);
		contentPane.add(botonCitas);
		
		JButton botonDiagnostico = new JButton("Diagnósticos asociados al paciente");
		botonDiagnostico.setBounds(144, 105, 245, 29);
		contentPane.add(botonDiagnostico);
		
		JButton botonTratamientos = new JButton("Tratamientos asociados al paciente");
		botonTratamientos.setBounds(144, 146, 245, 29);
		contentPane.add(botonTratamientos);
		
		JButton botonHospitalizacion = new JButton("Hospitalizaciones asociados al paciente");
		botonHospitalizacion.setBounds(144, 186, 245, 29);
		contentPane.add(botonHospitalizacion);
	}
}
