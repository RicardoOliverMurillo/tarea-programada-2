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
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import logicanegocios.Paciente;
import logicanegocios.Vacuna;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class registrarVacuna extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoNombre;
	private JTextField campoTextoFarmaceutica;
	private JTextField campoTextoLote;
	private JTextField campoTextoCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarVacuna frame = new registrarVacuna();
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
	
	public registrarVacuna() {
		
	}
	
	public registrarVacuna(int pcedula) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar vacuna al paciente");
		lblNewLabel.setBounds(115, 23, 183, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de aplicación:");
		lblNewLabel_4.setBounds(32, 114, 127, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuDoctor(pcedula).setVisible(true);
			}
		});
		botonRegresar.setBounds(248, 314, 117, 29);
		contentPane.add(botonRegresar);
		
		JDateChooser fechaAplicacion = new JDateChooser();
		fechaAplicacion.setBounds(190, 114, 175, 26);
		contentPane.add(fechaAplicacion);
		
		JButton botonRegistrarVacuna = new JButton("Registrar Vacuna");
		botonRegistrarVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				Vacuna vacuna;
				Paciente paciente;
				SimpleDateFormat  dFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fecha = dFormat.format(fechaAplicacion.getDate());	
				String cedula = campoTextoCedula.getText();
				String nombre = campoTextoNombre.getText();
				String farmaceutica = campoTextoFarmaceutica.getText();
				String lote = campoTextoLote.getText();
				
				if ((campoTextoCedula.getText().equals("")) || (campoTextoNombre.getText().equals("")) || (campoTextoFarmaceutica.getText().equals("")) || (campoTextoLote.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					vacuna = new Vacuna(fecha,nombre,farmaceutica,Integer.parseInt(lote),Integer.parseInt(cedula));
					paciente = new Paciente(Integer.parseInt(cedula));
					try {
						if (paciente.verificarPaciente()) {
							vacuna.crearVacuna();
							JOptionPane.showMessageDialog(frame, "Se registro la vacuna");
							campoTextoCedula.setText("");
							campoTextoNombre.setText("");
							campoTextoNombre.setText("");
							campoTextoFarmaceutica.setText("");
							campoTextoLote.setText("");
						} else {
							JOptionPane.showMessageDialog(frame, "No existe un paciente con esa cedula");
							campoTextoCedula.setText("");
							campoTextoNombre.setText("");
							campoTextoNombre.setText("");
							campoTextoFarmaceutica.setText("");
							campoTextoLote.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}		
			}
		});
		botonRegistrarVacuna.setBounds(56, 314, 149, 29);
		contentPane.add(botonRegistrarVacuna);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la vacuna:");
		lblNewLabel_1.setBounds(32, 163, 145, 16);
		contentPane.add(lblNewLabel_1);
		
		campoTextoNombre = new JTextField();
		campoTextoNombre.setBounds(189, 158, 176, 26);
		contentPane.add(campoTextoNombre);
		campoTextoNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Farmacéutica:");
		lblNewLabel_2.setBounds(32, 214, 95, 16);
		contentPane.add(lblNewLabel_2);
		
		campoTextoFarmaceutica = new JTextField();
		campoTextoFarmaceutica.setBounds(189, 209, 176, 26);
		contentPane.add(campoTextoFarmaceutica);
		campoTextoFarmaceutica.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Número de lote:");
		lblNewLabel_3.setBounds(32, 269, 107, 16);
		contentPane.add(lblNewLabel_3);
		
		campoTextoLote = new JTextField();
		campoTextoLote.setBounds(190, 264, 176, 26);
		contentPane.add(campoTextoLote);
		campoTextoLote.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Cedula:");
		lblNewLabel_4_1.setBounds(32, 68, 127, 16);
		contentPane.add(lblNewLabel_4_1);
		
		campoTextoCedula = new JTextField();
		campoTextoCedula.setBounds(190, 63, 175, 26);
		contentPane.add(campoTextoCedula);
		campoTextoCedula.setColumns(10);
	}
}
