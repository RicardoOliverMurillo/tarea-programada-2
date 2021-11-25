package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import java.awt.event.ActionEvent;

public class realizarCita extends JFrame {

	private JPanel contentPane;
	Cita cita = new Cita();
	daoLOGCitas LOG = new daoLOGCitas();
	LOGCitas bitacora;
	String fechaCita;
	String EstadoMedico = "RealizadaPorElMedico";
	String idUsuarioReturned;
	String idCita;
	String idInSession;
	String idInSessionCita;
	private JTextField campoTextoCedula;
	//List<Cita> citas = cita.getCitasRegistradas(1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					realizarCita frame = new realizarCita();
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
	
	public realizarCita() {
		
	}
	
	public realizarCita(int pcedula) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Realizar cita");
		lblNewLabel.setBounds(182, 6, 89, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Citas disponibles:");
		lblNewLabel_4.setBounds(21, 109, 126, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuDoctor(pcedula).setVisible(true);
			}
		});
		botonRegresar.setBounds(296, 144, 117, 29);
		contentPane.add(botonRegresar);
		
		JComboBox comboBoxCitas = new JComboBox();
		comboBoxCitas.setBounds(172, 105, 135, 27);
		contentPane.add(comboBoxCitas);
		
		JButton botonRealizarCita = new JButton("Realizar cita");
		botonRealizarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				int contador = 0;
				String cedula = campoTextoCedula.getText();
				if ((campoTextoCedula.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete los campos del formulario");
				}else {
					fechaCita = comboBoxCitas.getSelectedItem().toString().toString();
					idCita = LOG.getIDcita(fechaCita);
					bitacora = new LOGCitas (EstadoMedico, String.valueOf(pcedula), idCita);
					bitacora.logRealizarCitaDR();
					cita.realizarCitaCentroMedico(comboBoxCitas.getSelectedItem().toString());
					dispose();
					new registrarDiagnostico(idCita,String.valueOf(pcedula),cedula).setVisible(true);
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
				}
				
				
			}
		});
		botonRealizarCita.setBounds(167, 144, 117, 29);
		contentPane.add(botonRealizarCita);
		
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
