package logicaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class reporteCitasSecretario extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reporteCitasSecretario frame = new reporteCitasSecretario();
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
	public reporteCitasSecretario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label labelTitulo = new Label("Citas registradas en el sistema");
		labelTitulo.setAlignment(Label.CENTER);
		labelTitulo.setFont(new Font("Dialog", Font.BOLD, 15));
		labelTitulo.setBounds(10, 10, 643, 38);
		contentPane.add(labelTitulo);
		
		JButton botonRegresar = new JButton("Regresar");
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new menuReportesSecretario().setVisible(true);
			}
		});
		botonRegresar.setBounds(531, 422, 117, 29);
		contentPane.add(botonRegresar);
		
		Label labelFechas = new Label("Fechas: ");
		labelFechas.setBounds(20, 100, 59, 21);
		contentPane.add(labelFechas);
		
		JDateChooser fechaRango1= new JDateChooser();
		fechaRango1.setBounds(94, 100, 265, 26);
		contentPane.add(fechaRango1);
		
		JDateChooser fechaRango1_1 = new JDateChooser();
		fechaRango1_1.setBounds(406, 100, 247, 26);
		contentPane.add(fechaRango1_1);
		
		Label labelEstado = new Label("Estados: ");
		labelEstado.setBounds(20, 140, 59, 21);
		contentPane.add(labelEstado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Registrada", "Asignada", "Cancelada", ""}));
		comboBox.setBounds(94, 140, 179, 21);
		contentPane.add(comboBox);
		
		Label labelEstado_1 = new Label("Especialidad");
		labelEstado_1.setBounds(318, 140, 82, 21);
		contentPane.add(labelEstado_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(406, 140, 247, 21);
		contentPane.add(comboBox_1);
		
		Label labelEstado_2 = new Label("Nombre paciente: ");
		labelEstado_2.setBounds(20, 180, 111, 21);
		contentPane.add(labelEstado_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(137, 180, 346, 21);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(542, 172, 111, 29);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBounds(20, 401, 633, -144);
		contentPane.add(table);
		
		JLabel label_3 = new JLabel("");
		
		JLabel label_4 = new JLabel("");
		
		JLabel label_5 = new JLabel("");
		
		JLabel label_6 = new JLabel("");
		
		JLabel label_7 = new JLabel("");
		
		JLabel label_8 = new JLabel("");
		
		JLabel label_9 = new JLabel("");
	}
}
