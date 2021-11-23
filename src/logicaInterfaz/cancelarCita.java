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

import logicanegocios.Cita;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cancelarCita extends JFrame {

	private JPanel contentPane;
	Cita cita = new Cita();
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
	
	public cancelarCita() {};
	
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
	public cancelarCita(int pcedula) throws SQLException {
		System.out.println(pcedula);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 232);
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
		botonRegresar.setBounds(182, 114, 117, 29);
		contentPane.add(botonRegresar);
		
		JComboBox comboBoxCitas = new JComboBox(getCitasRegistradas(pcedula).toArray());
		comboBoxCitas.setBounds(172, 65, 135, 27);
		contentPane.add(comboBoxCitas);
		
		JButton botonCancelarCita = new JButton("Cancelar cita");
		botonCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				int contador = 0;
				String fechaCita = comboBoxCitas.getSelectedItem().toString();
				SimpleDateFormat formatoDate = new SimpleDateFormat("dd-MM-yyyy");
				Date fecha = new Date();
				String fecha2 = formatoDate.format(fecha);
				

				try {
					Date fechaCancelarCita = formatoDate.parse(fechaCita);
					Date fechaActual = formatoDate.parse(fecha2);
					if (fechaCancelarCita.compareTo(fechaActual) > 0) {
						JOptionPane.showMessageDialog(frame, "La cita a cancelar ocurre despues");
						
					}else if (fechaCancelarCita.compareTo(fechaActual) < 0){
						cita.cancelarCitaPaciente(fechaCita);
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
						JOptionPane.showMessageDialog(frame, "La cita a cancelar ocurre en el mismo dia");
					}
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

//				cita.cancelarCitaPaciente(fechaCita);
//				JOptionPane.showMessageDialog(frame, "Cita cancelada por el paciente");
//				comboBoxCitas.removeAllItems();
//				try {
//					while (getCitasRegistradas().size() > contador) {
//						comboBoxCitas.addItem(getCitasRegistradas().get(contador));
//						contador +=1;
//					}
//				} catch (SQLException e2) {
//					// TODO Auto-generated catch block
//					e2.printStackTrace();
//				}
			}
		});
		botonCancelarCita.setBounds(19, 114, 117, 29);
		contentPane.add(botonCancelarCita);
	}
}
