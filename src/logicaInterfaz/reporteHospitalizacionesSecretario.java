package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import logicaMensajeria.*;
import logicanegocios.*;

public class reporteHospitalizacionesSecretario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reporteHospitalizacionesSecretario frame = new reporteHospitalizacionesSecretario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public reporteHospitalizacionesSecretario() {}

	/**
	 * Create the frame.
	 */
	public reporteHospitalizacionesSecretario(int pcedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuReportesSecretario().setVisible(true);
			}
		});
		contentPane.setLayout(null);
		botonRegresar.setBounds(692, 397, 91, 31);
		contentPane.add(botonRegresar);
		
		JLabel lblNewLabel = new JLabel("Hospitalizaciones registradas en el sistema");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 10, 783, 31);
		contentPane.add(lblNewLabel);
	}
}
