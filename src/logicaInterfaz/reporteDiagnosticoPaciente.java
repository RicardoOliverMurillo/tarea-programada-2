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

public class reporteDiagnosticoPaciente extends JFrame {

	private JPanel contentPane;
	private List<List<String>> infoDiagnostico = new ArrayList();
	private JTable table;
	private DefaultTableModel model;
	private Object[] rowData;
	private Documento documento = new Documento();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reporteDiagnosticoPaciente frame = new reporteDiagnosticoPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private List<String> getNombreDiagnostico() {
		List<CatalogoDiagnosticos> diagnostico = new CatalogoDiagnosticos().getDiagnosticosRegistrados();
		List<String> nombreDiagnostico = new ArrayList();
		for(int i=0; i<diagnostico.size();i++) {
			nombreDiagnostico.add(diagnostico.get(i).getNombre());
		}
		return nombreDiagnostico;
	}
	
	public reporteDiagnosticoPaciente() {}

	public reporteDiagnosticoPaciente(int pcedula) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label labelTitulo = new Label("Diagnostico asociado a un paciente\r\n");
		labelTitulo.setAlignment(Label.CENTER);
		labelTitulo.setFont(new Font("Dialog", Font.BOLD, 15));
		labelTitulo.setBounds(10, 10, 643, 38);
		contentPane.add(labelTitulo);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuReportesPaciente(pcedula).setVisible(true);
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
		
		Label labelNivel = new Label("Nivel:");
		labelNivel.setBounds(20, 140, 59, 21);
		contentPane.add(labelNivel);
		
		JComboBox cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(new String[] {"", "Leve", "Grave", "Muy grave"}));
		cbNivel.setBounds(94, 140, 179, 21);
		contentPane.add(cbNivel);
		
		Label labelEstado_1 = new Label("Nombre:");
		labelEstado_1.setBounds(318, 140, 82, 21);
		contentPane.add(labelEstado_1);
		
		JComboBox cbNombre = new JComboBox();
		cbNombre.insertItemAt(null, 0);
		for(int i=0; i<getNombreDiagnostico().size();i++) {
			cbNombre.insertItemAt(getNombreDiagnostico().get(i),i+1);
		}
		
		cbNombre.setBounds(406, 140, 247, 21);
		contentPane.add(cbNombre);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 211, 633, 201);
		contentPane.add(scrollPane);
				
		model = new DefaultTableModel();
		table = new JTable();
		rowData = new Object[]{"ID Diagnostico", "Nombre", "Nivel", "Observaciones", "Cedula Paciente", "Fecha"};
		table.setModel(model);
		model.setColumnIdentifiers(rowData);
		scrollPane.setViewportView(table);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date d1 = fechaRango1.getDate();
				java.util.Date d2 = fechaRango1_1.getDate();
				
				if((d1!=null) && (d2!=null)){
					if(cbNivel.getSelectedItem()!=""|| cbNombre.getSelectedItem()!=null) {
						JOptionPane.showMessageDialog(null, "No se puede hacer consulta con multiples opciones selecionadas");
					}else{
						infoDiagnostico = new RegistrarDiagnostico().getDiagnosticosFecha(d1, d2,pcedula);
						setRowValues();
					}
				}else if(cbNivel.getSelectedItem()!="") {
					if( d1!=null || d2!=null ||cbNombre.getSelectedItem()!=null) {
						JOptionPane.showMessageDialog(null, "No se puede hacer consulta con multiples opciones selecionadas");
					}else {
						infoDiagnostico = new RegistrarDiagnostico().getNivelDiagnostico(cbNivel.getSelectedItem().toString(),pcedula);
						setRowValues();
						}
				}else if(cbNombre.getSelectedItem()!=null) {
					if( d1!=null || d2!=null ||cbNivel.getSelectedItem()!="") {
						JOptionPane.showMessageDialog(null, "No se puede hacer consulta con multiples opciones selecionadas");
					}else {
						infoDiagnostico =  new RegistrarDiagnostico().getNombrelDiagnostico(cbNombre.getSelectedItem().toString(),pcedula);
						setRowValues();					}
				}else{
					infoDiagnostico = new RegistrarDiagnostico().getDiagnostico(pcedula);
					setRowValues();	
				}
			}
		});
		
		btnBuscar.setBounds(542, 172, 111, 29);
		contentPane.add(btnBuscar);
				
		JButton btnGenerarCSV = new JButton("Generar CSV");
		btnGenerarCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(infoDiagnostico.size()>0) {
					String[] header = {"ID Diagnostico", "Nombre", "Nivel", "Observaciones","Cedula Paciente", "Fecha"};
					documento.dataCSV(infoDiagnostico, header, "reporteDiagnosticos");
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
				if(infoDiagnostico.size()>0) {
					ArrayList<String> header = new ArrayList<String>();
					header.add("ID Diagnostico");
					header.add("Nombre");
					header.add("Nivel");
					header.add("Observaciones");
					header.add("Cedula Paciente");
					header.add("Fecha");
					documento.htmlFormat(new Documento().rowsContentData(infoDiagnostico), header, "ReporteDiagnosticos");
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
				if(infoDiagnostico.size()>0) {
					ArrayList<String> header = new ArrayList<String>();
					header.add("ID Diagnostico");
					header.add("Nombre");
					header.add("Nivel");
					header.add("Observaciones");
					header.add("Cedula Paciente");
					header.add("Fecha");
					documento.generateDataPDF(infoDiagnostico, header, "ReporteDiagnosticos");
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
				cbNivel.setSelectedIndex(0);
				cbNombre.setSelectedIndex(0);
				model.setRowCount(0);
			}
		});
		btnLimpiarFiltros.setBounds(406, 422, 115, 29);
		contentPane.add(btnLimpiarFiltros);
	}
	private void setRowValues() {
		model.setRowCount(0);
		for(int i=0; i< infoDiagnostico.size();i++) {
			rowData[0]= infoDiagnostico.get(i).get(0);
			rowData[1]= infoDiagnostico.get(i).get(1);
			rowData[2]= infoDiagnostico.get(i).get(2);
			rowData[3]= infoDiagnostico.get(i).get(3);
			rowData[4]= infoDiagnostico.get(i).get(4);
			rowData[5]= infoDiagnostico.get(i).get(5);
			model.addRow(rowData);
		}
	}
}
	
