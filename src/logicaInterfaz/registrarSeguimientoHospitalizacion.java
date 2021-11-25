package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import logicadao.daoCatalogoTratamientos;
import logicanegocios.*;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class registrarSeguimientoHospitalizacion extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoObservacion;
	private JTextField textField;
	logicanegocios.registrarHospitalizacion objRegistrarHospitalizacion = new logicanegocios.registrarHospitalizacion();
	logicanegocios.registrarHospitalizacion objRegistrarHospitalizacion2 = new logicanegocios.registrarHospitalizacion();
	
	String idTratamiento;
	daoCatalogoTratamientos daoCatalogoTratamientos = new daoCatalogoTratamientos();
	
	CatalogoTratamientos objCatalogoTratamientos = new CatalogoTratamientos();
	
	String resultado = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarSeguimientoHospitalizacion frame = new registrarSeguimientoHospitalizacion();
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
	
	public List<String> getHospitalizaciones(String pCedula) throws SQLException {
		List<logicanegocios.registrarHospitalizacion> diagnosticos = objRegistrarHospitalizacion.getHospitalizacionesRegistradas(Integer.parseInt(pCedula));
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<diagnosticos.size(); i++) {
			//System.out.println(diagnosticos.get(i).getDiagnostico());
			registrosCitas.add(diagnosticos.get(i).getFechaInicio());
		}
		//System.out.println(registrosCitas);
		return registrosCitas;
	}
	
	public List<String> getHospitalizacionesDiagnostico(String pCedula) throws SQLException {
		List<logicanegocios.registrarHospitalizacion> diagnosticos = objRegistrarHospitalizacion.getHospitalizacionesRegistradasDiagnostico(Integer.parseInt(pCedula));
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<diagnosticos.size(); i++) {
			//System.out.println(diagnosticos.get(i).getDiagnostico());
			registrosCitas.add(diagnosticos.get(i).getFechaInicio());
		}
		//System.out.println(registrosCitas);
		return registrosCitas;
	}
	
	
	
	public List<String> getHospitalizacionesX(String pFechaInicio) throws SQLException {
		List<logicanegocios.registrarHospitalizacion> diagnosticos = objRegistrarHospitalizacion2.getIDHospitalizacion(pFechaInicio);
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<diagnosticos.size(); i++) {
			registrosCitas.add(diagnosticos.get(i).getFechaInicio());
		}
		return registrosCitas;
	}
	
	public registrarSeguimientoHospitalizacion() {}
	
	public registrarSeguimientoHospitalizacion(int pCedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seguimiento del Paciente");
		lblNewLabel.setBounds(142, 6, 166, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cédula paciente:");
		lblNewLabel_1.setBounds(35, 53, 117, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de seguimiento:");
		lblNewLabel_2.setBounds(35, 167, 149, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Funcionario responsable:");
		lblNewLabel_3.setBounds(35, 228, 166, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Observación:");
		lblNewLabel_4.setBounds(39, 383, 88, 16);
		contentPane.add(lblNewLabel_4);
		
		
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuDoctor(pCedula).setVisible(true);
			}
		});
		botonRegresar.setBounds(35, 441, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoObservacion = new JTextField();
		campoTextoObservacion.setBounds(186, 353, 247, 77);
		contentPane.add(campoTextoObservacion);
		campoTextoObservacion.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tratamiento asociado:");
		lblNewLabel_5.setBounds(35, 307, 149, 16);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBoxTratamiento = new JComboBox();
		comboBoxTratamiento.setBounds(216, 296, 159, 27);
		contentPane.add(comboBoxTratamiento);
		
		textField = new JTextField();
		textField.setBounds(147, 51, 161, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JDateChooser fechaSeguimiento = new JDateChooser();
		fechaSeguimiento.setBounds(159, 168, 46, 14);
		contentPane.add(fechaSeguimiento);
		
		JLabel lblNewLabel_6 = new JLabel("Se tomar\u00E1 como responsable al funcionario en sesi\u00F3n.");
		lblNewLabel_6.setBounds(197, 229, 269, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("El presente seguimiento se realiza para la hospitalizaci\u00F3n m\u00E1s reciente. ");
		lblNewLabel_7.setBounds(114, 112, 511, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				JFrame frame = new JFrame();
				int contador = 0;
				List<String> diagnosticosRegistrados;
				try {
					diagnosticosRegistrados = getHospitalizaciones(textField.getText());
						while (diagnosticosRegistrados.size() > contador) {
							resultado = diagnosticosRegistrados.get(contador);
							System.out.println("ID de la Hospitalizacion: " + resultado);
							contador +=1;
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				String resultado2 = null;
				
				JFrame frame2 = new JFrame();
				int contador2 = 0;
				List<String> diagnosticosRegistrados2;
				try {
					diagnosticosRegistrados2 = getHospitalizacionesDiagnostico(textField.getText());
						while (diagnosticosRegistrados2.size() > contador2) {
							resultado2 = diagnosticosRegistrados2.get(contador2);
							System.out.println("ID del diagnostico de la hospitalizacion: " + resultado2);
							contador2 +=1;
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				JFrame frame3 = new JFrame();
				int contador3 = 0;
				List<String> tratamientosRegistrados;
				List<CatalogoTratamientos> diagnosticos = objCatalogoTratamientos.getTratamientosRegistrados(resultado2);
				List<String> registrosCitas = new ArrayList();
				for (int i = 0; i<diagnosticos.size(); i++) {
					registrosCitas.add(diagnosticos.get(i).getNombre());
				}
				try {
					tratamientosRegistrados = registrosCitas;
						while (tratamientosRegistrados.size() > contador3) {
							comboBoxTratamiento.addItem(tratamientosRegistrados.get(contador3));
							contador3 +=1;
						}
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
		btnNewButton.setBounds(322, 50, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton botonRegistrarCita = new JButton("Registrar");
		botonRegistrarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat  dFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fecha = dFormat.format(fechaSeguimiento.getDate());
				
				idTratamiento = daoCatalogoTratamientos.getIdTratamiento(comboBoxTratamiento.getSelectedItem().toString().toString());
				
			
				logicanegocios.RegistrarSeguimientoHospitalizaciones seguimientoHospitalizacion = new logicanegocios.RegistrarSeguimientoHospitalizaciones(resultado, fecha, Integer.toString(pCedula),  campoTextoObservacion.getText(),  idTratamiento);
				seguimientoHospitalizacion.crearRegistrarHospitalizacion();
				dispose();
				new menuDoctor(pCedula).setVisible(true);
				
				
				
				
				
				
			}
		});
		botonRegistrarCita.setBounds(343, 441, 149, 29);
		contentPane.add(botonRegistrarCita);
		
		
		
	}
}
