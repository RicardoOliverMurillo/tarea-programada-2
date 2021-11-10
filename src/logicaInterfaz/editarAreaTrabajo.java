package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class editarAreaTrabajo extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editarAreaTrabajo frame = new editarAreaTrabajo();
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
	public editarAreaTrabajo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Área de Trabajo");
		lblNewLabel.setBounds(172, 17, 143, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Escoja una Área de Trabajo:");
		lblNewLabel_4.setBounds(19, 69, 227, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(419, 166, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonEditarAreaTrabajo = new JButton("Editar");
		botonEditarAreaTrabajo.setBounds(293, 166, 117, 29);
		contentPane.add(botonEditarAreaTrabajo);
		
		JComboBox comboBoxAreaTrabajo = new JComboBox();
		comboBoxAreaTrabajo.setBounds(235, 65, 135, 27);
		contentPane.add(comboBoxAreaTrabajo);
		
		JLabel lblNewLabel_1 = new JLabel("Establezca un nuevo nombre al área de trabajo:");
		lblNewLabel_1.setBounds(19, 117, 303, 16);
		contentPane.add(lblNewLabel_1);
		
		campoTextoNombre = new JTextField();
		campoTextoNombre.setBounds(326, 112, 184, 26);
		contentPane.add(campoTextoNombre);
		campoTextoNombre.setColumns(10);
	}
}
