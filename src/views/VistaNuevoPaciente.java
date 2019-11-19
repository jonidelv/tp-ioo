package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.PacientesManager;
import model.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class VistaNuevoPaciente extends JFrame {

	private JPanel contentPane;
	private static Paciente paciente;
	private JTextField textField_dni;
	private JTextField textField_nombre;
	private JTextField textField_direccion;
	private JComboBox comboBox_sexo;
	private JTextField textField_edad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNuevoPaciente frame = new VistaNuevoPaciente();
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
	public VistaNuevoPaciente() {
		setTitle("Pacientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoPaciente = new JLabel("Informacion del paciente");
		lblNuevoPaciente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevoPaciente.setBounds(52, 13, 203, 25);
		contentPane.add(lblNuevoPaciente);
		
		
		textField_dni = new JTextField();
		textField_dni.setBounds(136, 90, 116, 22);
		contentPane.add(textField_dni);
		textField_dni.setColumns(10);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(136, 131, 116, 22);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_direccion = new JTextField();
		textField_direccion.setBounds(136, 171, 116, 22);
		contentPane.add(textField_direccion);
		textField_direccion.setColumns(10);
		
		textField_edad = new JTextField();
		textField_edad.setBounds(136, 253, 116, 22);
		contentPane.add(textField_edad);
		textField_edad.setColumns(10);
		
		this.comboBox_sexo = new JComboBox();
		comboBox_sexo.setModel(new DefaultComboBoxModel(new String[] {"Hombre","Mujer","Otro"}));
		comboBox_sexo.setBounds(136, 211, 116, 22);
		contentPane.add(comboBox_sexo);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(68, 93, 56, 16);
		contentPane.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(52, 134, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(52, 174, 56, 16);
		contentPane.add(lblDireccion);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(52, 214, 56, 16);
		contentPane.add(lblSexo);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(52, 256, 56, 16);
		contentPane.add(lblEdad);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPacientes back = new MenuPacientes();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		btn_cancelar.setBounds(546, 488, 97, 25);
		contentPane.add(btn_cancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PacientesManager.getInstancia().cargarDatos(Integer.parseInt(textField_dni.getText()),textField_nombre.getText(),textField_direccion.getText(),comboBox_sexo.getSelectedItem().toString(),Integer.parseInt(textField_edad.getText())); //mapear campos manualmente
				MenuPacientes back = new MenuPacientes();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnGuardar.setBounds(432, 488, 97, 25);
		contentPane.add(btnGuardar);
		
	}

	public void editarPaciente(String dni) {
		// TODO Auto-generated method stub
		paciente = PacientesManager.getInstancia().getPaciente(dni);
		textField_dni.setText(String.valueOf(paciente.getDni()));
		textField_nombre.setText(paciente.getNombre());
		textField_direccion.setText(paciente.getDomicilio());
		textField_edad.setText(String.valueOf(paciente.getEdad()));
		
		for (int i=0; i<this.comboBox_sexo.getModel().getSize(); i++)
		{
		    if (comboBox_sexo.getItemAt(i).toString().equals(paciente.getSexo()))
		    {
		        comboBox_sexo.setSelectedIndex(i);
		        break;
		    }
		}
		
	}
}
