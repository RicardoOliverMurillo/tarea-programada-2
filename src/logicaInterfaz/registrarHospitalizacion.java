package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import logicadao.*;
import logicanegocios.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class registrarHospitalizacion extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoNombre;
	CatalogoDiagnosticos objCatalogoDiagnoticos = new CatalogoDiagnosticos();
	CentroAtencion objCatalogoDiagnoticos2 = new CentroAtencion();
	AreasTrabajo objCatalogoDiagnoticos3 = new AreasTrabajo();
	String idDiagnostico;
	String idAreaTrabajo;
	String idCentroAtencion;
	Cita citaVerificacion;
	daoCatalogoDiagnostico daoCatalogoDiagnostico = new daoCatalogoDiagnostico();
	logicadao.daoAreasTrabajo daoAreasTrabajo = new daoAreasTrabajo();
	logicadao.daoCentroAtencion daoCentroAtencion = new daoCentroAtencion();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarHospitalizacion frame = new registrarHospitalizacion();
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
	
	public List<String> getDiagnosticosRegistrados() throws SQLException {
		List<CatalogoDiagnosticos> diagnosticos = objCatalogoDiagnoticos.getDiagnosticosRegistrados();
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<diagnosticos.size(); i++) {
			registrosCitas.add(diagnosticos.get(i).getNombre());
		}
		return registrosCitas;
	}
	
	public List<String> getCentrosAtencionRegistrados() throws SQLException {
		List<CentroAtencion> diagnosticos = objCatalogoDiagnoticos2.getCentrosDeAtencionRegistrados();
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<diagnosticos.size(); i++) {
			registrosCitas.add(diagnosticos.get(i).getNombre());
		}
		return registrosCitas;
	}
	
	public List<String> getAreasHospital() throws SQLException {
		List<AreasTrabajo> diagnosticos = objCatalogoDiagnoticos3.getAreasTrabajo();
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<diagnosticos.size(); i++) {
			registrosCitas.add(diagnosticos.get(i).getNombre());
		}
		return registrosCitas;
	}
	
	
	public registrarHospitalizacion() {
		
	}
	public registrarHospitalizacion(String pCedula, String pIDcita, String cedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Hospitalización del Paciente");
		lblNewLabel.setBounds(131, 22, 220, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Centro de atención:");
		lblNewLabel_1.setBounds(35, 69, 135, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Identificación del paciente:");
		lblNewLabel_2.setBounds(35, 107, 179, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre del paciente:");
		lblNewLabel_3.setBounds(35, 154, 142, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Diagnóstico:");
		lblNewLabel_4.setBounds(35, 197, 88, 16);
		contentPane.add(lblNewLabel_4);
		
		JDateChooser fechaInicio = new JDateChooser();
		fechaInicio.setBounds(192, 245, 46, 14);
		contentPane.add(fechaInicio);
		
		JDateChooser fechaFinalizacion = new JDateChooser();
		fechaFinalizacion.setBounds(192, 284, 46, 14);
		contentPane.add(fechaFinalizacion);
		
		
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(10, 476, 117, 29);
		contentPane.add(botonRegresar);
		
		JComboBox comboBoxCentroAtencion = new JComboBox();
		comboBoxCentroAtencion.setBounds(192, 65, 159, 27);
		contentPane.add(comboBoxCentroAtencion);
		
		campoTextoNombre = new JTextField();
		campoTextoNombre.setBounds(192, 149, 161, 26);
		contentPane.add(campoTextoNombre);
		campoTextoNombre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de inicio:");
		lblNewLabel_5.setBounds(35, 244, 111, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha final:");
		lblNewLabel_6.setBounds(35, 283, 88, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Especialidad/servicio:");
		lblNewLabel_7.setBounds(35, 327, 149, 16);
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBoxEspecialidad = new JComboBox();
		comboBoxEspecialidad.setBounds(196, 323, 155, 27);
		contentPane.add(comboBoxEspecialidad);
		
		JLabel lblNewLabel_8 = new JLabel("El paciente ser\u00E1 hospitalizado bajo la autorizaci\u00F3n del funcionario en sesi\u00F3n. ");
		lblNewLabel_8.setBounds(10, 384, 392, 16);
		contentPane.add(lblNewLabel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(192, 194, 171, 22);
		contentPane.add(comboBox);
		
		
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				int contador = 0;
				List<String> diagnosticosRegistrados;
				try {
					diagnosticosRegistrados = getDiagnosticosRegistrados();
						while (diagnosticosRegistrados.size() > contador) {
							comboBox.addItem(diagnosticosRegistrados.get(contador));
							contador +=1;
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				JFrame frame2 = new JFrame();
				int contador2 = 0;
				
				List<String> diagnosticosRegistrados2;
				try {
					diagnosticosRegistrados2 = getCentrosAtencionRegistrados();
						while (diagnosticosRegistrados2.size() > contador2) {
							comboBoxCentroAtencion.addItem(diagnosticosRegistrados2.get(contador2));
							contador2 +=1;
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				JFrame frame3 = new JFrame();
				int contador3 = 0;
				
				List<String> diagnosticosRegistrados3;
				try {
					diagnosticosRegistrados3 = getAreasHospital();
						while (diagnosticosRegistrados3.size() > contador3) {
							comboBoxEspecialidad.addItem(diagnosticosRegistrados3.get(contador3));
							contador3 +=1;
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
		});
		btnNewButton.setBounds(365, 66, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton botonRegistrarCita = new JButton("Registrar Hospitalización");
		botonRegistrarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				String nombreCentroAtencion, idPaciente, nombrePaciente, nombreDiagnostico, nombreEspecialidad, idFuncionario;
				
				
				
				//Fechas
				SimpleDateFormat  dFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fechaInicio2 = dFormat.format(fechaInicio.getDate());
				SimpleDateFormat  dFormat2 = new SimpleDateFormat("dd-MM-yyyy");
				String fechaFianlizacion2 = dFormat.format(fechaFinalizacion.getDate());
				
				//Get de los texts
				
				nombreCentroAtencion = comboBoxCentroAtencion.getSelectedItem().toString().toString();
				nombrePaciente = campoTextoNombre.getText();
				nombreDiagnostico = comboBox.getSelectedItem().toString().toString();
				nombreEspecialidad = comboBoxEspecialidad.getSelectedItem().toString().toString();
				
				//Getting ids based in info of names
				idDiagnostico = daoCatalogoDiagnostico.getIdDiagnostico(nombreDiagnostico);
				idAreaTrabajo = daoAreasTrabajo.getIdAreasTrabajo(nombreEspecialidad);
				idCentroAtencion = daoCentroAtencion.getIdCentroAtencion(nombreCentroAtencion);
				
				logicanegocios.registrarHospitalizacion registrarHospitalizacion;
				
				citaVerificacion = new Cita(cedula);
				
				registrarHospitalizacion= new logicanegocios.registrarHospitalizacion(idCentroAtencion,cedula,nombrePaciente,idDiagnostico,fechaInicio2,fechaFianlizacion2,idAreaTrabajo,String.valueOf(pCedula));
				
				System.out.println("ID de la cita: " + pIDcita);
				System.out.println("ID del paciente: " + cedula);
				
				
				registrarHospitalizacion.crearRegistrarHospitalizacion();
					
				
			}
		});
		botonRegistrarCita.setBounds(257, 476, 197, 29);
		contentPane.add(botonRegistrarCita);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(149, 479, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Se toma la identificaci\u00F3n del paciente atendido.");
		lblNewLabel_9.setBounds(189, 108, 293, 14);
		contentPane.add(lblNewLabel_9);
		
		
		
		
		
	}
}
