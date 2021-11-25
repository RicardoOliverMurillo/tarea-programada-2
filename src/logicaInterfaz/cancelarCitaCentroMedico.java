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
import logicanegocios.*;
import logicanegocios.*;
import logicaMensajeria.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cancelarCitaCentroMedico extends JFrame {

	private JPanel contentPane;
	Cita cita = new Cita();
	daoLOGCitas LOG = new daoLOGCitas();
	private JTextField campoTextoCedula;
	LOGCitas bitacora;
	String fechaCita;
	String EstadoMedico = "CanceladaPorCentroMedico";
	String idUsuarioReturned;
	String idCita;
	String idInSession;
	String idInSessionCita;
	private JTextField textField;
	private JTextField textField_1;
	
	CorreoElectronico CorreoElectronico = new CorreoElectronico();
	SMS SMS = new SMS();
	
	//List<Cita> citas = cita.getCitasRegistradas(1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancelarCitaCentroMedico frame = new cancelarCitaCentroMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public List<String> getCitasRegistradas(int pcedula) throws SQLException {
		List<Cita> citas = cita.getCitasRegistradas(pcedula);
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
	
	public cancelarCitaCentroMedico() throws SQLException {
		
	}
	public cancelarCitaCentroMedico(String pCedula) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cancelar cita");
		lblNewLabel.setBounds(161, 16, 89, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Citas disponibles:");
		lblNewLabel_4.setBounds(21, 109, 126, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuDoctor(Integer.parseInt(pCedula)).setVisible(true);
			}
		});
		botonRegresar.setBounds(296, 144, 117, 29);
		contentPane.add(botonRegresar);
		
		JComboBox comboBoxCitas = new JComboBox();
		comboBoxCitas.setBounds(172, 105, 135, 27);
		contentPane.add(comboBoxCitas);
		
		JLabel lblNewLabel_1 = new JLabel("Correo electr\u00F3nico:");
		lblNewLabel_1.setBounds(21, 214, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numero telefono:");
		lblNewLabel_2.setBounds(21, 239, 103, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(164, 211, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 236, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton botonCancelarCita = new JButton("Cancelar cita");
		botonCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				int contador = 0;
				String cedula = campoTextoCedula.getText();
				String fechaCita = comboBoxCitas.getSelectedItem().toString();
				SimpleDateFormat formatoDate = new SimpleDateFormat("dd-MM-yyyy");
				
				Date fecha = new Date();
				String fecha2 = formatoDate.format(fecha);
				
				String mensajeUsuario = "Cita resgistrada: " + fecha;
				
				String correolecronico = textField.getText();
				String numerotelefono = textField_1.getText();

				

				
				try {
					Date fechaCancelarCita = formatoDate.parse(fechaCita);
					Date fechaActual = formatoDate.parse(fecha2);
			    
					if (fechaCancelarCita.compareTo(fechaActual) > 0) {
						cita.cancelarCitaCentroMedico(comboBoxCitas.getSelectedItem().toString());
						idCita = LOG.getIDcita(fechaCita);
						bitacora = new LOGCitas (EstadoMedico, String.valueOf(pCedula), idCita);
						bitacora.logRealizarCitaDR();
						CorreoElectronico.enviarCorreoElectronico(correolecronico,mensajeUsuario);
						//SMS.enviarSMS(mensajeUsuario, numerotelefono);
						JOptionPane.showMessageDialog(frame, "Cita cancelada por el centro medico");
						comboBoxCitas.removeAllItems();
						try {
							while (getCitasRegistradas(Integer.parseInt(cedula)).size() > contador) {
								comboBoxCitas.addItem(getCitasRegistradas(Integer.parseInt(cedula)).get(contador));
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
		botonCancelarCita.setBounds(167, 144, 117, 29);
		contentPane.add(botonCancelarCita);
		
		JLabel lblNewLabel_4_1 = new JLabel("Cedula:");
		lblNewLabel_4_1.setBounds(21, 66, 126, 16);
		contentPane.add(lblNewLabel_4_1);
		
		campoTextoCedula = new JTextField();
		campoTextoCedula.setBounds(177, 57, 130, 26);
		contentPane.add(campoTextoCedula);
		campoTextoCedula.setColumns(10);
		
		JButton botonBuscar = new JButton("Buscar citas");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				int contador = 0;
				String cedula =  campoTextoCedula.getText();
				List<String> citasRegistradas;
				if ((campoTextoCedula.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					try {
						citasRegistradas = getCitasRegistradas(Integer.parseInt(cedula));
						while (citasRegistradas.size() > contador) {
							comboBoxCitas.addItem(citasRegistradas.get(contador));
							contador +=1;
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}							
			}
		});
		botonBuscar.setBounds(21, 144, 117, 29);
		contentPane.add(botonBuscar);
		
		
	}
	
}

