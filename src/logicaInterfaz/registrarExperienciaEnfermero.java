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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registrarExperienciaEnfermero extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarExperienciaEnfermero frame = new registrarExperienciaEnfermero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public registrarExperienciaEnfermero() {
		
	}
	/**
	 * Create the frame.
	 */
	public registrarExperienciaEnfermero(String codigoFuncionario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Experiencia Enfermero");
		lblNewLabel.setBounds(218, 17, 200, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("¿Ha tenido otras personas a su cargo?");
		lblNewLabel_4.setBounds(43, 69, 255, 16);
		contentPane.add(lblNewLabel_4);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.setBounds(518, 180, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonRegistrarExperiencia = new JButton("Registrar");
		botonRegistrarExperiencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jFrame = new JFrame();
				JOptionPane.showMessageDialog(jFrame, codigoFuncionario);
			}
		});
		botonRegistrarExperiencia.setBounds(389, 180, 117, 29);
		contentPane.add(botonRegistrarExperiencia);
		
		JComboBox comboBoxExperienciaCargo = new JComboBox();
		comboBoxExperienciaCargo.setBounds(310, 65, 74, 27);
		contentPane.add(comboBoxExperienciaCargo);
		
		JLabel lblNewLabel_1 = new JLabel("¿Ha tenido experiencia dando capacitaciones a pacientes?");
		lblNewLabel_1.setBounds(43, 113, 368, 16);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBoxExperienciaCapacitacion = new JComboBox();
		comboBoxExperienciaCapacitacion.setBounds(424, 109, 74, 27);
		contentPane.add(comboBoxExperienciaCapacitacion);
	}
}
