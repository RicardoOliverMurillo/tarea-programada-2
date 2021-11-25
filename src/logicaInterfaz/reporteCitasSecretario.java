package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import logicaMensajeria.*;
import logicanegocios.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;

public class reporteCitasSecretario extends JFrame {

	private JPanel contentPane;
	private List<Cita> citasinfo = new ArrayList();
	private JTable table;
	private DefaultTableModel model;
	private Object[] rowData;
	private Documento documento = new Documento();
	private ArrayList<String> headersReportes = new ArrayList<String>();


	/**
	 * Launch the application.
	 */
	
	private void loadHeaders() {
		headersReportes.add("Cedula");
		headersReportes.add("Especialidad");
		headersReportes.add("Estado");
		headersReportes.add("Fecha");
		headersReportes.add("Observación");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reporteCitasSecretario frame = new reporteCitasSecretario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private ArrayList<String> getPacientesNombre() {
		ArrayList nombre = new ArrayList();
		ArrayList<Paciente> paciente = new Paciente().getPacientes();
		for(int i= 0; i<paciente.size();i++) {
			nombre.add(paciente.get(i).getCedula());
		}
		return nombre;
	}
	
	private ArrayList<String> getEspecialidad() {
		ArrayList<String> especialidad = new AreasTrabajo().getNombreAreasTrabajo();
		return especialidad;
	}
	
	public reporteCitasSecretario() {}

	public reporteCitasSecretario(int pcedula) {
		
		loadHeaders();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label labelTitulo = new Label("Citas registradas en el sistema");
		labelTitulo.setAlignment(Label.CENTER);
		labelTitulo.setFont(new Font("Dialog", Font.BOLD, 15));
		labelTitulo.setBounds(10, 10, 643, 38);
		contentPane.add(labelTitulo);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuReportesSecretario(pcedula).setVisible(true);
				System.out.println(pcedula);
			}
		});
		botonRegresar.setBounds(531, 422, 117, 29);
		contentPane.add(botonRegresar);
		
		Label labelFechas = new Label("Fechas: ");
		labelFechas.setBounds(20, 100, 59, 21);
		contentPane.add(labelFechas);
		
		JDateChooser fechaRango1= new JDateChooser();
		fechaRango1.setBounds(94, 100, 265, 26);
		contentPane.add(fechaRango1);
		
		JDateChooser fechaRango1_1 = new JDateChooser();
		fechaRango1_1.setBounds(406, 100, 247, 26);
		contentPane.add(fechaRango1_1);
		
		Label labelEstado = new Label("Estados: ");
		labelEstado.setBounds(20, 140, 59, 21);
		contentPane.add(labelEstado);
		
		JComboBox cbEstados = new JComboBox();
		cbEstados.setModel(new DefaultComboBoxModel(new String[] {"", "Registrada", "Asignada", "Cancelada por paciente","Cancelada por hospital"}));
		cbEstados.setBounds(94, 140, 179, 21);
		contentPane.add(cbEstados);
		
		Label labelEstado_1 = new Label("Especialidad");
		labelEstado_1.setBounds(318, 140, 82, 21);
		contentPane.add(labelEstado_1);
		
		JComboBox cbEspecialidad = new JComboBox();
		cbEspecialidad.insertItemAt(null, 0);
		for(int i=0; i<getEspecialidad().size();i++) {
			cbEspecialidad.insertItemAt(getEspecialidad().get(i),i+1);
		}
		
		cbEspecialidad.setBounds(406, 140, 247, 21);
		contentPane.add(cbEspecialidad);
		
		Label labelEstado_2 = new Label("Nombre paciente: ");
		labelEstado_2.setBounds(20, 180, 111, 21);
		contentPane.add(labelEstado_2);
		
		JComboBox cbPacienteNom = new JComboBox();
		cbPacienteNom.insertItemAt(null, 0);
		for(int i=0; i<getPacientesNombre().size();i++) {
			cbPacienteNom.insertItemAt(getPacientesNombre().get(i),i+1);
		}
		cbPacienteNom.setBounds(137, 180, 346, 21);
		contentPane.add(cbPacienteNom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 227, 633, 185);
		contentPane.add(scrollPane);
				
		model = new DefaultTableModel();
		table = new JTable();
		rowData = new Object[]{"Cedula", "Especialidad", "Estado", "Fecha", "Hora", "Observacion"};
		table.setModel(model);
		model.setColumnIdentifiers(rowData);
		scrollPane.setViewportView(table);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date d1 = fechaRango1.getDate();
				java.util.Date d2 = fechaRango1_1.getDate();
				
				if((d1!=null) && (d2!=null)){
					if(cbEstados.getSelectedItem()!=""|| cbEspecialidad.getSelectedItem()!=null||cbPacienteNom.getSelectedItem()!=null) {
						JOptionPane.showMessageDialog(null, "No se puede hacer consulta con multiples opciones selecionadas");
					}else{
						citasinfo = new Cita().getCitasFechaDoctor(d1, d2);
						setRowValues();
					}
				}else if(cbEstados.getSelectedItem()!="") {
					if( d1!=null || d2!=null ||cbEspecialidad.getSelectedItem()!=null||cbPacienteNom.getSelectedItem()!=null) {
						JOptionPane.showMessageDialog(null, "No se puede hacer consulta con multiples opciones selecionadas");
					}else {
						citasinfo = new Cita().getCitasEstado(cbEstados.getSelectedItem().toString());
						setRowValues();
						}
				}else if(cbEspecialidad.getSelectedItem()!=null) {
					if( d1!=null || d2!=null ||cbEstados.getSelectedItem()!=""||cbPacienteNom.getSelectedItem()!=null) {
						JOptionPane.showMessageDialog(null, "No se puede hacer consulta con multiples opciones selecionadas");
					}else {
						citasinfo = new Cita().getCitasEspecialidad(cbEspecialidad.getSelectedItem().toString());
						setRowValues();					}
				}else if(cbPacienteNom.getSelectedItem()!=null){
					if( d1!=null | d2!=null |cbEstados.getSelectedItem()!=""|cbEspecialidad.getSelectedItem()!=null) {
						JOptionPane.showMessageDialog(null, "No se puede hacer consulta con multiples opciones selecionadas");
					}else {
						citasinfo = new Cita().getCitasPaciente(Integer.parseInt(cbPacienteNom.getSelectedItem().toString()));
						setRowValues();	
						}
				}else{
					citasinfo = new Cita().getCitas();
					setRowValues();	
				}
			}
		});
		
		btnBuscar.setBounds(542, 172, 111, 29);
		contentPane.add(btnBuscar);
				
		JButton btnGenerarCSV = new JButton("Generar CSV");
		btnGenerarCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(citasinfo.size()>0) {
					documento.dataCitasCSV(citasinfo);
					JOptionPane.showMessageDialog(null, "El CSV se genero con exito");
				}else{
					JOptionPane.showMessageDialog(null, "No se posee los datos requeridos");
				}
			}
		});
		btnGenerarCSV.setHorizontalAlignment(SwingConstants.RIGHT);
		btnGenerarCSV.setBounds(10, 64, 111, 21);
		contentPane.add(btnGenerarCSV);
		
		JButton btnGenerarHtml = new JButton("Generar HTML");
		btnGenerarHtml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(citasinfo.size()>0) {
					documento.htmlFormat(new Documento().rowsContentCitas(citasinfo), headersReportes, "ReporteCitas");
					JOptionPane.showMessageDialog(null, "El HTML se genero con exito");
				}else{
					JOptionPane.showMessageDialog(null, "No se posee los datos requeridos");
				}
			}
		});
		btnGenerarHtml.setHorizontalAlignment(SwingConstants.RIGHT);
		btnGenerarHtml.setBounds(131, 64, 122, 21);
		contentPane.add(btnGenerarHtml);
		
		JButton btnGenerarPdf = new JButton("Generar PDF");
		btnGenerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(citasinfo.size()>0) {
					documento.generateCitasPDF(citasinfo, headersReportes, "ReporteCitas");
					JOptionPane.showMessageDialog(null, "El PDF se genero con exito");
				}else{
					JOptionPane.showMessageDialog(null, "No se posee los datos requeridos");
				}
			}
		});
		btnGenerarPdf.setBounds(263, 64, 117, 21);
		contentPane.add(btnGenerarPdf);
		
		JButton btnLimpiarFiltros = new JButton("Limpiar Filtros");
		btnLimpiarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fechaRango1.setDate(null); 
				fechaRango1_1.setDate(null); 
				cbEstados.setSelectedIndex(0);
				cbEspecialidad.setSelectedIndex(0);
				cbPacienteNom.setSelectedIndex(0);
				model.setRowCount(0);
			}
		});
		btnLimpiarFiltros.setBounds(406, 422, 115, 29);
		contentPane.add(btnLimpiarFiltros);
	}
	
	private void setRowValues() {
		model.setRowCount(0);
		for(int i=0; i< citasinfo.size();i++) {
			rowData[0]= citasinfo.get(i).getCedula();
			rowData[1]= citasinfo.get(i).getEspecialidad();
			rowData[2]= citasinfo.get(i).getEstado();
			rowData[3]= citasinfo.get(i).getFecha();
			rowData[4]= citasinfo.get(i).getHora();
			rowData[5]= citasinfo.get(i).getObservacion();
			model.addRow(rowData);
		}
	}
}
	
