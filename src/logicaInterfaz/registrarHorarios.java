package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicanegocios.Cita;
import logicanegocios.Funcionario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.github.lgooddatepicker.components.TimePicker;

public class registrarHorarios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarHorarios frame = new registrarHorarios();
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
	public registrarHorarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Horarios para Citas");
		lblNewLabel.setBounds(116, 16, 190, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registre los dias para las citas:");
		lblNewLabel_1.setBounds(35, 69, 201, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Registre la hora para las citas:");
		lblNewLabel_2.setBounds(35, 107, 195, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarFuncionario().setVisible(true);
			}
		});
		botonRegresar.setBounds(257, 161, 117, 29);
		contentPane.add(botonRegresar);
		
		JDateChooser fechaCita = new JDateChooser();
		fechaCita.setBounds(236, 69, 95, 26);
		contentPane.add(fechaCita);
		
		TimePicker horaCita = new TimePicker();
		horaCita.setBounds(234, 101, 127, 29);
		contentPane.add(horaCita);
		
		JButton botonRegistrarHorario = new JButton("Registrar horario");
		botonRegistrarHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				Cita cita;
				SimpleDateFormat  dFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				String fecha = dFormat.format(fechaCita.getDate());
				String hora = horaCita.getText();
				cita = new Cita(fecha, hora);
				
				///////////////////////Datos de la fecha actual
				Date fechaActual = new Date();
				String fecha2 = dFormat.format(fechaActual);	
				try {
					Date fechaActual2 = dFormat.parse(fecha2);
					Date fechaHorario = dFormat.parse(fecha);
					
					if (fechaHorario.compareTo(fechaActual2) > 0) {
						if (cita.verificarHorario()) {
							JOptionPane.showMessageDialog(frame, "Horario existente");
						}else {
							cita.crearHorario();
							JOptionPane.showMessageDialog(frame, "Nuevo Horario Creado");
						}
						
					}else if (fechaHorario.compareTo(fechaActual2) < 0){
						JOptionPane.showMessageDialog(frame, "El horario ya caduco.");

						
					}else if (fechaHorario.compareTo(fechaActual2) == 0) {
						if (cita.verificarHorario()) {
							JOptionPane.showMessageDialog(frame, "Horario existente");
						}else {
							cita.crearHorario();
							JOptionPane.showMessageDialog(frame, "Nuevo Horario Creado");
						}
					}
				} catch (ParseException | HeadlessException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				///////////////////////Datos de la fecha actual
							
			}
		});
		botonRegistrarHorario.setBounds(35, 161, 159, 29);
		contentPane.add(botonRegistrarHorario);
	}
}
