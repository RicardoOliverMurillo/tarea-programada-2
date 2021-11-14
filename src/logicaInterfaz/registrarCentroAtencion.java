package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicanegocios.CentroAtencion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class registrarCentroAtencion extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoNombre;
	private JTextField campoTextoUbicacion;
	private JTextField campoTextoCantidadPacientes;
	private JTextField campoTextoTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarCentroAtencion frame = new registrarCentroAtencion();
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
	public registrarCentroAtencion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear Centro de Atención");
		lblNewLabel.setBounds(115, 17, 165, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(36, 54, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		campoTextoNombre = new JTextField();
		campoTextoNombre.setBounds(115, 49, 247, 26);
		contentPane.add(campoTextoNombre);
		campoTextoNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ubicación:");
		lblNewLabel_2.setBounds(36, 94, 81, 16);
		contentPane.add(lblNewLabel_2);
		
		campoTextoUbicacion = new JTextField();
		campoTextoUbicacion.setBounds(115, 87, 247, 26);
		contentPane.add(campoTextoUbicacion);
		campoTextoUbicacion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Catidad máxima de pacientes:");
		lblNewLabel_3.setBounds(36, 137, 198, 16);
		contentPane.add(lblNewLabel_3);
		
		campoTextoCantidadPacientes = new JTextField();
		campoTextoCantidadPacientes.setBounds(234, 132, 130, 26);
		contentPane.add(campoTextoCantidadPacientes);
		campoTextoCantidadPacientes.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de centro de atención:");
		lblNewLabel_4.setBounds(36, 182, 172, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonCrearCentroAtencion = new JButton("Crear Centro de Atención");
		botonCrearCentroAtencion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				CentroAtencion centroAtencion;
				String nombre = campoTextoNombre.getText();
				String ubicacion = campoTextoUbicacion.getText();
				String capacidad = campoTextoCantidadPacientes.getText();
				String tipoCentro = campoTextoTipo.getText();
				centroAtencion = new CentroAtencion(nombre, ubicacion, Integer.parseInt(capacidad), tipoCentro);

				if ((campoTextoNombre.getText().equals("")) || (campoTextoUbicacion.getText().equals(""))
						|| (campoTextoTipo.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					try {
						if (centroAtencion.verificarCentroAtencion(nombre, ubicacion)) {
							JOptionPane.showMessageDialog(frame, "Hay un centro de atencion igual");
							campoTextoNombre.setText("");
							campoTextoUbicacion.setText("");
							campoTextoCantidadPacientes.setText("");
							campoTextoTipo.setText("");
						} else {
							centroAtencion.crearCentroAtencion();
							JOptionPane.showMessageDialog(frame, "Centro de atencion registrado");
							campoTextoNombre.setText("");
							campoTextoUbicacion.setText("");
							campoTextoCantidadPacientes.setText("");
							campoTextoTipo.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

			}
		});
		botonCrearCentroAtencion.setBounds(20, 225, 208, 29);
		contentPane.add(botonCrearCentroAtencion);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(256, 225, 117, 29);
		contentPane.add(botonRegresar);
		
		campoTextoTipo = new JTextField();
		campoTextoTipo.setBounds(232, 177, 130, 26);
		contentPane.add(campoTextoTipo);
		campoTextoTipo.setColumns(10);
	}
}
