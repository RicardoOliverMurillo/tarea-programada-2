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

public class registrarVacuna extends JFrame {

	private JPanel contentPane;
	private JTextField campoTextoNombreVacuna;
	private JTextField campoTextoFarmaceutica;
	private JTextField campoTextoLote;

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
		lblNewLabel_4.setBounds(32, 69, 227, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(248, 276, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonRegistrarVacuna = new JButton("Registrar");
		botonRegistrarVacuna.setBounds(70, 276, 117, 29);
		contentPane.add(botonRegistrarVacuna);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la vacuna:");
		lblNewLabel_1.setBounds(32, 115, 145, 16);
		contentPane.add(lblNewLabel_1);
		
		campoTextoNombreVacuna = new JTextField();
		campoTextoNombreVacuna.setBounds(189, 110, 176, 26);
		contentPane.add(campoTextoNombreVacuna);
		campoTextoNombreVacuna.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Farmacéutica:");
		lblNewLabel_2.setBounds(32, 166, 95, 16);
		contentPane.add(lblNewLabel_2);
		
		campoTextoFarmaceutica = new JTextField();
		campoTextoFarmaceutica.setBounds(189, 161, 176, 26);
		contentPane.add(campoTextoFarmaceutica);
		campoTextoFarmaceutica.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Número de lote:");
		lblNewLabel_3.setBounds(32, 222, 107, 16);
		contentPane.add(lblNewLabel_3);
		
		campoTextoLote = new JTextField();
		campoTextoLote.setBounds(189, 217, 176, 26);
		contentPane.add(campoTextoLote);
		campoTextoLote.setColumns(10);
	}
}
