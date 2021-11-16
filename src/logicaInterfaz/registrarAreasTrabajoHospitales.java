package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicanegocios.AreasTrabajo;
import logicanegocios.CentroAtencion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class registrarAreasTrabajoHospitales extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarAreasTrabajoHospitales frame = new registrarAreasTrabajoHospitales();
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
	public registrarAreasTrabajoHospitales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar \u00C1reas de Trabajo");
		lblNewLabel.setBounds(133, 23, 146, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setBounds(35, 69, 88, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(35, 262, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();
				CentroAtencion centroAtencion;
				String nombre = textField.getText();
				
				AreasTrabajo AreasTrabajo = new AreasTrabajo(nombre);

				if ((textField.getText().equals("")) || (textField.getText().equals(""))
						|| (textField.getText().equals(""))) {
					JOptionPane.showMessageDialog(frame, "Complete todos los campos del formulario");
				} else {
					try {
						if (AreasTrabajo.verificarAreasTrabajo(nombre)) {
							JOptionPane.showMessageDialog(frame, "ERROR: Ya existe un área de trabajo con ese nombre.");
							textField.setText("");
							
						} else {
							AreasTrabajo.crearAreasTrabajo();
							JOptionPane.showMessageDialog(frame, "Área de Trabajo Registrada");
							textField.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

			}
		});
		btnNewButton.setBounds(267, 265, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(91, 67, 240, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
