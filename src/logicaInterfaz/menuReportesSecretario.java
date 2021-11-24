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

public class menuReportesSecretario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuReportesSecretario frame = new menuReportesSecretario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public menuReportesSecretario() {}

	/**
	 * Create the frame.
	 */
	public menuReportesSecretario(int pcedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reportes Secretario(a)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 39, 379, 16);
		contentPane.add(lblNewLabel);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuSecretario(pcedula).setVisible(true);
			}
		});
		botonRegresar.setBounds(272, 207, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonCitas = new JButton("Citas registradas en el sistema");
		botonCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new reporteCitasSecretario(pcedula).setVisible(true);
			}
		});
		botonCitas.setBounds(59, 88, 285, 29);
		contentPane.add(botonCitas);
		
		JButton botonHospitalizacion = new JButton("Hospitalizaciones registradas en el sistema");
		botonHospitalizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new reporteHospitalizacionesSecretario(pcedula).setVisible(true);
			}
		});
		botonHospitalizacion.setBounds(59, 146, 285, 29);
		contentPane.add(botonHospitalizacion);
	}
}
