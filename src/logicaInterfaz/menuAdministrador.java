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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuAdministrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuAdministrador frame = new menuAdministrador();
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
	public menuAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu administrador");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(224, 11, 140, 16);
		contentPane.add(lblNewLabel);
		
		JButton botonRegresar = new JButton("Cerrar sesion");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginPage().setVisible(true);
			}
		});
		botonRegresar.setBounds(475, 246, 117, 29);
		contentPane.add(botonRegresar);
		
		JButton botonCrearCentro = new JButton("Crear centro de atencion");
		botonCrearCentro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarCentroAtencion().setVisible(true);
			}
		});
		botonCrearCentro.setBounds(204, 76, 186, 29);
		contentPane.add(botonCrearCentro);
		
		JButton registrarHorariosBtn = new JButton("Agregar horarios");
		registrarHorariosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarHorarios().setVisible(true);
			}
		});
		registrarHorariosBtn.setBounds(204, 116, 186, 23);
		contentPane.add(registrarHorariosBtn);
		
		JButton btnRegistrarFuncionario = new JButton("Registrar funcionario");
		btnRegistrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarFuncionario().setVisible(true);
			}
		});
		
		btnRegistrarFuncionario.setBounds(204, 150, 186, 23);
		contentPane.add(btnRegistrarFuncionario);
		
		JButton btnRegistrarPaciente = new JButton("Registrar paciente");
		btnRegistrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarPaciente().setVisible(true);
			}
		});
		btnRegistrarPaciente.setBounds(204, 184, 186, 23);
		contentPane.add(btnRegistrarPaciente);
		
		JButton btnNewButton = new JButton("Registrar Especialidades");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registrarAreasTrabajoHospitales().setVisible(true);
			}
		});
		btnNewButton.setBounds(204, 228, 186, 23);
		contentPane.add(btnNewButton);
	}
}
