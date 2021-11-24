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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;

import logicadao.daoLOGCitas;
import logicanegocios.Cita;
import logicanegocios.LOGCitas;
import logicanegocios.Paciente;

import logicaMensajeria.*;

import com.github.lgooddatepicker.components.TimePicker;

public class registrarCita extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoObservacion;
	private JTextField campoTextoEspecialidad;
	daoLOGCitas LOG = new daoLOGCitas();
	LOGCitas bitacora;
	String fechaCita;
	String EstadoMedico = "RegistradaPorElPaciente";
	String idUsuarioReturned;
	String idCita;
	String idInSession;
	String idInSessionCita;
	Cita cita = new Cita();
	CorreoElectronico CorreoElectronico = new CorreoElectronico();
	SMS SMS = new SMS();
	private JTextField textField;
	private JTextField textField_1;

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
	
	
	
	public List<String> getCitasHorario() {
		List<Cita> citas = cita.getCitasHorarios();
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<citas.size(); i++) {
			registrosCitas.add(citas.get(i).getFecha());
		}
		return registrosCitas;
	}
	
	public List<String> getHorasHorario(String pfecha) {
		List<Cita> citas = cita.getCitasHoras(pfecha);
		List<String> horasCitas = new ArrayList();
		for (int i = 0; i<citas.size(); i++) {
			horasCitas.add(citas.get(i).getFecha());
		}
		return horasCitas;
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public registrarCita() {
		
	}
	public registrarCita(int pcedula) {
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
		
		JComboBox comboBoxHora = new JComboBox();
		comboBoxHora.setBounds(162, 150, 179, 27);
		contentPane.add(comboBoxHora);
		
		textField = new JTextField();
		textField.setBounds(162, 293, 209, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 321, 209, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBoxFecha = new JComboBox(getCitasHorario().toArray());
		comboBoxFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List <String> horasCitas = null;
				int cantidad = 0;
				
				comboBoxHora.removeAllItems();
				horasCitas = getHorasHorario(comboBoxFecha.getSelectedItem().toString());
				while (horasCitas.size() != cantidad) {
					comboBoxHora.addItem(horasCitas.get(cantidad));
					cantidad +=1;
				}
			}
		});
		comboBoxFecha.setBounds(162, 103, 179, 27);
		contentPane.add(comboBoxFecha);

		
		JButton botonRegistrarCita = new JButton("Registrar Cita");
		botonRegistrarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				Cita cita;
				int contador = 0;
				
				String correolecronico = textField.getText();
				String numerotelefono = textField_1.getText();
				
				String especialidad = campoTextoEspecialidad.getText();
				String observacion = campoTextoObservacion.getText();
				String fecha = comboBoxFecha.getSelectedItem().toString();
				String hora = comboBoxHora.getSelectedItem().toString();
				
				String mensajeUsuario = "Cita resgistrada: " + fecha;
				
				if ((campoTextoEspecialidad.getText().equals("")) || (campoTextoObservacion.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					cita = new Cita("Registrada",especialidad, fecha, hora, observacion, pcedula);
					cita.crearCita();
					
					CorreoElectronico.enviarCorreoElectronico(correolecronico,mensajeUsuario);
					//SMS.enviarSMS(mensajeUsuario, numerotelefono);
					
					fechaCita = comboBoxFecha.getSelectedItem().toString().toString();
					idCita = LOG.getIDcita(fechaCita);
					bitacora = new LOGCitas (EstadoMedico, String.valueOf(pcedula), idCita);
					bitacora.logRealizarCitaDR();
					cita.eliminarHorario();
					JOptionPane.showMessageDialog(frame, "Cita registrada");
					campoTextoEspecialidad.setText("");
					campoTextoObservacion.setText("");
					comboBoxFecha.setModel(new DefaultComboBoxModel(getCitasHorario().toArray()));
				}	
			}
		});
		botonRegistrarCita.setBounds(10, 358, 149, 29);
		contentPane.add(botonRegistrarCita);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(294, 358, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoObservacion = new JTextField();
		campoTextoObservacion.setBounds(164, 192, 247, 77);
		contentPane.add(campoTextoObservacion);
		campoTextoObservacion.setColumns(10);
		
		campoTextoEspecialidad = new JTextField();
		campoTextoEspecialidad.setBounds(164, 64, 177, 26);
		contentPane.add(campoTextoEspecialidad);
		campoTextoEspecialidad.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Correo electr\u00F3nico:");
		lblNewLabel_5.setBounds(35, 296, 124, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono celular");
		lblNewLabel_6.setBounds(35, 321, 94, 14);
		contentPane.add(lblNewLabel_6);
		
		
	}
}
