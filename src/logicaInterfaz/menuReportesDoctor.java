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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuReportesDoctor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuReportesDoctor frame = new menuReportesDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public menuReportesDoctor() {}

	/**
	 * Create the frame.
	 */
	public menuReportesDoctor(int pcedula) {
		//int pcedula=9;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reportes Doctor(a)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 409, 16);
		contentPane.add(lblNewLabel);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuDoctor(pcedula).setVisible(true);
			}
		});
		botonRegresar.setBounds(302, 320, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonCitas = new JButton("Citas registradas en el sistema");
		botonCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new reporteCitasDoctor(pcedula).setVisible(true);
			}
		});
		botonCitas.setBounds(85, 36, 285, 29);
		contentPane.add(botonCitas);
		
		JButton botonHospitalizacion = new JButton("Hospitalizaciones registradas en el sistema");
		botonHospitalizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new reporteHospitalizacionesSecretario(pcedula).setVisible(true);
			}
		});
		botonHospitalizacion.setBounds(85, 269, 285, 29);
		contentPane.add(botonHospitalizacion);
		
		JButton btnDiagnsticosAsociadosA = new JButton("Diagn\u00F3sticos asociados a un paciente");
		btnDiagnsticosAsociadosA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new reporteDiagnosticoDoctor(pcedula).setVisible(true);
			}
		});
		btnDiagnsticosAsociadosA.setBounds(85, 75, 285, 29);
		contentPane.add(btnDiagnsticosAsociadosA);
		
		JButton btnTratamientoAsociadoA = new JButton("Tratamiento  asociado a  un  paciente");
		btnTratamientoAsociadoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new reporteTratamientoDoctor(pcedula).setVisible(true);
			}
		});
		btnTratamientoAsociadoA.setBounds(85, 113, 285, 29);
		contentPane.add(btnTratamientoAsociadoA);
		
		JButton btnCantidadDeCitas = new JButton("Cantidad  de  citas  registradas  en  el  sistema\r\n");
		btnCantidadDeCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new reporteCantCitasDoctor(pcedula).setVisible(true);
			}
		});
		btnCantidadDeCitas.setBounds(85, 152, 285, 29);
		contentPane.add(btnCantidadDeCitas);
		
		JButton btnCantidadDeDiagnsticos = new JButton("Cantidad de diagn\u00F3sticos\r\n");
		btnCantidadDeDiagnsticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new reporteCantDiagnosticoDoctor(pcedula).setVisible(true);
			}
		});
		btnCantidadDeDiagnsticos.setBounds(85, 191, 285, 29);
		contentPane.add(btnCantidadDeDiagnsticos);
		
		JButton btnCantidadDeTratamientos = new JButton("Cantidad de tratamientos");
		btnCantidadDeTratamientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new reporteCantCitasDoctor(pcedula).setVisible(true);
			}
		});
		btnCantidadDeTratamientos.setBounds(85, 230, 285, 29);
		contentPane.add(btnCantidadDeTratamientos);
	}
}
