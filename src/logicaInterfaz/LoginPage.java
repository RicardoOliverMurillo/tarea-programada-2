package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicanegocios.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField userTextField;
	private JPasswordField passwordField;
	
	public Usuario userSession = new Usuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void renderPage(String rol, int pcedula) {
		if(rol.equals("paciente")) {
			dispose();
			new menuPaciente(pcedula).setVisible(true);
		} else if (rol.equals("doctor")) {
			dispose();
			new menuDoctor(pcedula).setVisible(true);
		} else if (rol.equals("secretaria")) {
			dispose();
			new menuSecretario(pcedula).setVisible(true);
		} else if (rol.equals("enfermero")) {
			dispose();
			new menuEnfermero().setVisible(true);
		} else if (rol.equals("administrador")) {
			dispose();
			new menuAdministrador().setVisible(true);
			
		}
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userTextField = new JTextField();
		userTextField.setBounds(181, 60, 165, 20);
		contentPane.add(userTextField);
		userTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(102, 63, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(79, 94, 81, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(181, 91, 165, 20);
		contentPane.add(passwordField);
		
		final JCheckBox showPass = new JCheckBox("Mostrar contrase\u00F1a");
		showPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showPass.isSelected()) {
					passwordField.setEchoChar((char)0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});
		showPass.setBounds(181, 118, 165, 23);
		contentPane.add(showPass);
		
		JButton loginBtn = new JButton("Iniciar Sesi\u00F3n");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario tempUser = new Usuario();
				
				tempUser.setCedula(Integer.parseInt(userTextField.getText()));
				if(passwordField.getPassword() == null) {
					passwordField.setText("");
				}else {
					tempUser.setContrasenna(String.valueOf(passwordField.getPassword()));
				}
				
				userSession = tempUser.login(tempUser);
				
				if(userSession.getCedula() == 0) {					
					JOptionPane.showMessageDialog(null, "Usuario no registrado");
				} 
				
				if(userSession.getContrasenna().equals(String.valueOf(passwordField.getPassword()))) {
					renderPage(userSession.getRol(),userSession.getCedula());
				} else {
					 JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrectos");
				}
				
				
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		loginBtn.setBounds(157, 171, 121, 23);
		contentPane.add(loginBtn);
	}
}
