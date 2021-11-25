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
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class menuDoctor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuDoctor frame = new menuDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public menuDoctor() {}
	
	/**
	 * Create the frame.
	 */
	public menuDoctor(int pcedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Doctor(a)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(259, 22, 181, 16);
		contentPane.add(lblNewLabel);
		
		JButton botonRegresar = new JButton("Cerrar sesion");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage().setVisible(true);
			}
		});
		botonRegresar.setBounds(512, 338, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonAsignarCita = new JButton("Asignar cita");
		botonAsignarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new asignarCita(pcedula).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonAsignarCita.setBounds(292, 119, 117, 29);
		contentPane.add(botonAsignarCita);
		
		JButton botonCancelarCita = new JButton("Cancelar cita");
		botonCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					new cancelarCitaCentroMedico(String.valueOf(pcedula)).setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonCancelarCita.setBounds(292, 79, 117, 29);
		contentPane.add(botonCancelarCita);
		
		JButton botonReportesPaciente = new JButton("Reportes");
		botonReportesPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuReportesDoctor(pcedula).setVisible(true);
			}
		});
		botonReportesPaciente.setBounds(292, 239, 117, 29);
		contentPane.add(botonReportesPaciente);
		
		JButton botonAtenderCita = new JButton("Atender cita");
		botonAtenderCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new realizarCita(pcedula).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonAtenderCita.setBounds(292, 159, 117, 29);
		contentPane.add(botonAtenderCita);
		
		JButton botonVacuna = new JButton("Aplicar vacuna");
		botonVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarVacuna(pcedula).setVisible(true);
			}
		});
		botonVacuna.setBounds(292, 199, 117, 29);
		contentPane.add(botonVacuna);
		
		JButton btnNewButton = new JButton("Registrar Diagn\u00F3sticos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarCatalogoDiagnostico(pcedula).setVisible(true);
			}
		});
		btnNewButton.setBounds(280, 283, 148, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrar Tratamientos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarCatalogoTratamiento(pcedula).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(280, 317, 148, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registrar Seguimientos de Hospitalizaciones");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarSeguimientoHospitalizacion(pcedula).setVisible(true);
			}
		});
		btnNewButton_2.setBounds(194, 351, 289, 23);
		contentPane.add(btnNewButton_2);
	}
}
