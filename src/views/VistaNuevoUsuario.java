package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.UsuariosManager;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VistaNuevoUsuario extends JFrame {

	private JPanel contentPane;
	private static Usuario usuario;
	private JTextField textField_userName;
	private JTextField textField_email;
	private JTextField textField_password;
	private JTextField textField_nombre;
	private JComboBox comboBox_role;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNuevoUsuario frame = new VistaNuevoUsuario();
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
	public VistaNuevoUsuario() {
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoUsuario = new JLabel("Informacion del usuario");
		lblNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevoUsuario.setBounds(52, 13, 203, 25);
		contentPane.add(lblNuevoUsuario);
		
		
		textField_userName = new JTextField();
		textField_userName.setBounds(136, 90, 116, 22);
		contentPane.add(textField_userName);
		textField_userName.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setBounds(136, 131, 116, 22);
		contentPane.add(textField_email);
		textField_email.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setBounds(136, 171, 116, 22);
		contentPane.add(textField_password);
		textField_password.setColumns(10);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(136, 211, 116, 22);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		JLabel lblDni = new JLabel("Usuario");
		lblDni.setBounds(52, 93, 72, 16);
		contentPane.add(lblDni);
		
		JLabel lblNombre = new JLabel("Email");
		lblNombre.setBounds(52, 134, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Contraseña");
		lblDireccion.setBounds(52, 174, 56, 16);
		contentPane.add(lblDireccion);
		
		JLabel lblSexo = new JLabel("Nombre");
		lblSexo.setBounds(52, 214, 56, 16);
		contentPane.add(lblSexo);
		
		JLabel lblEdad = new JLabel("Role");
		lblEdad.setBounds(52, 256, 56, 16);
		contentPane.add(lblEdad);
		
		this.comboBox_role = new JComboBox();
		comboBox_role.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Laboratorista", "Recepcionista"}));
		comboBox_role.setBounds(136, 253, 109, 22);
		contentPane.add(comboBox_role);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuUsuarios back = new MenuUsuarios();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		btn_cancelar.setBounds(546, 488, 97, 25);
		contentPane.add(btn_cancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuariosManager.getInstancia().cargarDatos(textField_userName.getText(),textField_email.getText(),textField_password.getText(),textField_nombre.getText(),comboBox_role.getSelectedItem().toString());
				MenuUsuarios back = new MenuUsuarios();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnGuardar.setBounds(432, 488, 97, 25);
		contentPane.add(btnGuardar);
		
	}

	public void editarUsuario(String userName) {
		usuario = UsuariosManager.getInstancia().getUsuario(userName);
		textField_userName.setText(usuario.getUserName());
		textField_email.setText(usuario.getEmail());
		textField_password.setText(usuario.getPassword());
		textField_nombre.setText(usuario.getNombre());
		
		for (int i=0; i<this.comboBox_role.getModel().getSize(); i++)
		{
		    if (comboBox_role.getItemAt(i).toString().equals(usuario.getRole()))
		    {
		        comboBox_role.setSelectedIndex(i);
		        break;
		    }
		}
		
				
	}
}
