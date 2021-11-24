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
import java.sql.SQLException;

public class menuSecretario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuSecretario frame = new menuSecretario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public menuSecretario() {}
	
	/**
	 * Create the frame.
	 */
	public menuSecretario(int pcedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menú Secretario(a)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(184, 11, 132, 16);
		contentPane.add(lblNewLabel);
		
		JButton botonRegresar = new JButton("Cerrar sesion");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage().setVisible(true);
			}
		});
		botonRegresar.setBounds(383, 241, 117, 29);
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
		botonAsignarCita.setBounds(197, 113, 117, 29);
		contentPane.add(botonAsignarCita);
		
		JButton botonCancelarCita = new JButton("Cancelar cita");
		botonCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new cancelarCitaCentroMedico(pcedula).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonCancelarCita.setBounds(197, 62, 117, 29);
		contentPane.add(botonCancelarCita);
		
		JButton botonReportesPaciente = new JButton("Reportes");
		botonReportesPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuReportesSecretario(pcedula).setVisible(true);
			}
		});
		botonReportesPaciente.setBounds(197, 163, 117, 29);
		contentPane.add(botonReportesPaciente);
	}
}
