package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;

import logicanegocios.Cita;
import logicanegocios.Paciente;

import com.github.lgooddatepicker.components.TimePicker;

public class registrarCita extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoObservacion;
	private JTextField campoTextoEspecialidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarCita frame = new registrarCita();
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
	public registrarCita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Cita");
		lblNewLabel.setBounds(191, 22, 69, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Especialidad:");
		lblNewLabel_1.setBounds(35, 69, 88, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha:");
		lblNewLabel_2.setBounds(35, 107, 40, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hora:");
		lblNewLabel_3.setBounds(35, 154, 40, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Observacion:");
		lblNewLabel_4.setBounds(35, 197, 88, 16);
		contentPane.add(lblNewLabel_4);
		
		TimePicker horaCita = new TimePicker();
		horaCita.setBounds(164, 148, 177, 29);
		contentPane.add(horaCita);
		
		JDateChooser fechaCita = new JDateChooser();
		fechaCita.setBounds(164, 112, 159, 26);
		contentPane.add(fechaCita);
		
		JButton botonRegistrarCita = new JButton("Registrar Cita");
		botonRegistrarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				Cita cita;
				String especialidad = campoTextoEspecialidad.getText();
				SimpleDateFormat  dFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fecha = dFormat.format(fechaCita.getDate());
				String hora = horaCita.getText();
				String observacion = campoTextoObservacion.getText();
				
				if ((campoTextoEspecialidad.getText().equals("")) || (campoTextoObservacion.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					cita = new Cita("Registrada",especialidad, fecha, hora, observacion, 1144442);
					cita.crearCita();
					JOptionPane.showMessageDialog(frame, "Cita registrada");
					campoTextoEspecialidad.setText("");
					campoTextoObservacion.setText("");
				}	
		
			}
		});
		botonRegistrarCita.setBounds(35, 301, 149, 29);
		contentPane.add(botonRegistrarCita);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(294, 301, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoObservacion = new JTextField();
		campoTextoObservacion.setBounds(164, 192, 247, 77);
		contentPane.add(campoTextoObservacion);
		campoTextoObservacion.setColumns(10);
		
		campoTextoEspecialidad = new JTextField();
		campoTextoEspecialidad.setBounds(164, 64, 177, 26);
		contentPane.add(campoTextoEspecialidad);
		campoTextoEspecialidad.setColumns(10);
	}
}
