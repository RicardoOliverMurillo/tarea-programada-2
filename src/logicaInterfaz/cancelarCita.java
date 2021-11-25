package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicadao.daoLOGCitas;
import logicanegocios.Cita;
import logicanegocios.LOGCitas;
import logicaMensajeria.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cancelarCita extends JFrame {

	private JPanel contentPane;
	daoLOGCitas LOG = new daoLOGCitas();
	LOGCitas bitacora;
	String fechaCita;
	String EstadoMedico = "CanceladaPorElPaciente";
	String idUsuarioReturned;
	String idCita;
	String idInSession;
	String idInSessionCita;
	Cita cita = new Cita();
	CorreoElectronico CorreoElectronico = new CorreoElectronico();
	SMS SMS = new SMS();
	private JTextField textField;
	private JTextField textField_1;
	//List<Cita> citas = cita.getCitasRegistradas(1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancelarCita frame = new cancelarCita();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public List<String> getCitasRegistradas(int cedula) throws SQLException {
		List<Cita> citas = cita.getCitasRegistradas(cedula);
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<citas.size(); i++) {
			registrosCitas.add(citas.get(i).getFecha());
		}
		return registrosCitas;
	}
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public cancelarCita() throws SQLException {
		
	}
	
	public cancelarCita(int pcedula) throws SQLException {
		System.out.println(pcedula);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cancelar cita");
		lblNewLabel.setBounds(127, 29, 89, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Citas disponibles:");
		lblNewLabel_4.setBounds(19, 69, 126, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuDoctor(pcedula).setVisible(true);
			}
		});
		botonRegresar.setBounds(182, 114, 117, 29);
		contentPane.add(botonRegresar);
		
		JComboBox comboBoxCitas = new JComboBox(getCitasRegistradas(pcedula).toArray());
		comboBoxCitas.setBounds(172, 65, 135, 27);
		contentPane.add(comboBoxCitas);
		
		JLabel lblNewLabel_1 = new JLabel("Correo electr\u00F3nico:");
		lblNewLabel_1.setBounds(19, 167, 117, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(192, 164, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de telefono:");
		lblNewLabel_2.setBounds(19, 205, 117, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 202, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton botonCancelarCita = new JButton("Cancelar cita");
		botonCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				int contador = 0;
				
				String fechaCita = comboBoxCitas.getSelectedItem().toString();
				SimpleDateFormat formatoDate = new SimpleDateFormat("dd-MM-yyyy");
				
				String correolecronico = textField.getText();
				String numerotelefono = textField_1.getText();
				
				
				
				Date fecha = new Date();
				String fecha2 = formatoDate.format(fecha);	
				
				String mensajeUsuario = "Cita cancelada: " + fechaCita;

				try {
					Date fechaCancelarCita = formatoDate.parse(fechaCita);
					Date fechaActual = formatoDate.parse(fecha2);
			    
					if (fechaCancelarCita.compareTo(fechaActual) > 0) {
						cita.cancelarCitaPaciente(fechaCita);
						CorreoElectronico.enviarCorreoElectronico(correolecronico,mensajeUsuario);
						//SMS.enviarSMS(mensajeUsuario, numerotelefono);
						idCita = LOG.getIDcita(fechaCita);
						bitacora = new LOGCitas (EstadoMedico, String.valueOf(pcedula), idCita);
						bitacora.logRealizarCitaDR();
						JOptionPane.showMessageDialog(frame, "Cita cancelada por el paciente");
						comboBoxCitas.removeAllItems();
						try {
							while (getCitasRegistradas(pcedula).size() > contador) {
								comboBoxCitas.addItem(getCitasRegistradas(pcedula).get(contador));
								contador +=1;
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
					}else if (fechaCancelarCita.compareTo(fechaActual) == 0) {
						JOptionPane.showMessageDialog(frame, "La cita a cancelar ocurre en el mismo dia, no se puede cancelar");
					}
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonCancelarCita.setBounds(19, 114, 117, 29);
		contentPane.add(botonCancelarCita);
		
		
	}
}
