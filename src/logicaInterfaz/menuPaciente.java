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

public class menuPaciente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPaciente frame = new menuPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public menuPaciente() {};

	/**
	 * Create the frame.
	 */
	public menuPaciente(int pcedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Paciente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(226, 11, 148, 16);
		contentPane.add(lblNewLabel);
		
		JButton botonRegresar = new JButton("Cerrar sesion");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage().setVisible(true);
			}
		});
		botonRegresar.setBounds(470, 322, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonSolicitarCita = new JButton("Solicitar cita");
		botonSolicitarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarCita(pcedula).setVisible(true);
			}
		});
		botonSolicitarCita.setBounds(237, 74, 117, 29);
		contentPane.add(botonSolicitarCita);
		
		JButton botonCancelarCita = new JButton("Cancelar cita");
		botonCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new cancelarCita(pcedula).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonCancelarCita.setBounds(237, 132, 117, 29);
		contentPane.add(botonCancelarCita);
		
		JButton botonReportesPaciente = new JButton("Reportes");
		botonReportesPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuReportesPaciente(pcedula).setVisible(true);
			}
		});
		botonReportesPaciente.setBounds(237, 188, 117, 29);
		contentPane.add(botonReportesPaciente);
	}
}
