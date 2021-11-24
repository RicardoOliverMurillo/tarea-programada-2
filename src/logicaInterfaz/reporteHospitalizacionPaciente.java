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
import javax.swing.JTable;
import javax.swing.JScrollPane;

import logicaMensajeria.*;
import logicanegocios.*;

public class reporteHospitalizacionPaciente extends JFrame {

	private JPanel contentPane;
	private JTable tablaReporteHospitalizacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reporteHospitalizacionPaciente frame = new reporteHospitalizacionPaciente();
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
	public reporteHospitalizacionPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte Hospitalizaciones ");
		lblNewLabel.setBounds(282, 19, 168, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Filtrado por:");
		lblNewLabel_4.setBounds(19, 69, 126, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(599, 316, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonFiltrar = new JButton("Filtrar");
		botonFiltrar.setBounds(350, 64, 117, 29);
		contentPane.add(botonFiltrar);
		
		JComboBox comboBoxCitas = new JComboBox();
		comboBoxCitas.setBounds(172, 65, 135, 27);
		contentPane.add(comboBoxCitas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 266, 641, -100);
		contentPane.add(scrollPane);
		
		tablaReporteHospitalizacion = new JTable();
		scrollPane.setViewportView(tablaReporteHospitalizacion);
	}
}
