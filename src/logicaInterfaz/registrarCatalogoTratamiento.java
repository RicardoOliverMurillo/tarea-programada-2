package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicanegocios.*;
import logicadao.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class registrarCatalogoTratamiento extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoInformacion;
	CatalogoDiagnosticos objCatalogoDiagnoticos = new CatalogoDiagnosticos();
	daoCatalogoDiagnostico daoCatalogoDiagnostico = new daoCatalogoDiagnostico();
	String idDiagnostico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarCatalogoTratamiento frame = new registrarCatalogoTratamiento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public List<String> getDiagnosticosRegistrados() throws SQLException {
		List<CatalogoDiagnosticos> diagnosticos = objCatalogoDiagnoticos.getDiagnosticosRegistrados();
		List<String> registrosCitas = new ArrayList();
		for (int i = 0; i<diagnosticos.size(); i++) {
			registrosCitas.add(diagnosticos.get(i).getNombre());
		}
		return registrosCitas;
	}
	


	/**
	 * Create the frame.
	 */
	public registrarCatalogoTratamiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir información al catálogo del tratamiento");
		lblNewLabel.setBounds(109, 16, 295, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Ingrese el nombre del tratamiento: ");
		lblNewLabel_4.setBounds(10, 123, 197, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(19, 172, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoInformacion = new JTextField();
		campoTextoInformacion.setBounds(234, 118, 197, 26);
		contentPane.add(campoTextoInformacion);
		campoTextoInformacion.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(222, 66, 209, 22);
		contentPane.add(comboBox);
		
		JButton botonCrearInfoNueva = new JButton("Crear");
		botonCrearInfoNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				CatalogoTratamientos CatalogoTratamientos;
				String nombre = campoTextoInformacion.getText();
				String nombreDiagnosticoAsociado = comboBox.getSelectedItem().toString().toString();
				idDiagnostico = daoCatalogoDiagnostico.getIdDiagnostico(nombreDiagnosticoAsociado);
				System.out.println("Nombre del diagnostico: " + nombreDiagnosticoAsociado);
				System.out.println("ID del diagnostico: " + idDiagnostico);
				
				CatalogoTratamientos = new CatalogoTratamientos(nombre,idDiagnostico);

				if ((campoTextoInformacion.getText().equals("")) || (campoTextoInformacion.getText().equals(""))
						|| (campoTextoInformacion.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					CatalogoTratamientos.crearTratamiento();
					JOptionPane.showMessageDialog(frame, "Tratamiento Registrado");
					campoTextoInformacion.setText("");
					
				}
			}
		});
		botonCrearInfoNueva.setBounds(456, 172, 117, 29);
		contentPane.add(botonCrearInfoNueva);
		
		
		
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
											
			}
		});
		btnNewButton.setBounds(456, 64, 109, 26);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione el diagn\u00F3stico asociado:");
		lblNewLabel_1.setBounds(10, 70, 178, 14);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
