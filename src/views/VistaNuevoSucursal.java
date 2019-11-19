package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.SucursalesManager;
import controllers.UsuariosManager;
import dto.SucursalDTO;
import model.Sucursal;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;

public class VistaNuevoSucursal extends JFrame {

	private JPanel contentPane;
	private static Sucursal sucursal;
	private JTextField textField_num;
	private JTextField textField_direccion;
	private JComboBox comboBox_responsableTecnico;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNuevoSucursal frame = new VistaNuevoSucursal();
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
	public VistaNuevoSucursal() {
		setTitle("Sucursales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoSucursal = new JLabel("Informacion de la sucursal");
		lblNuevoSucursal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevoSucursal.setBounds(52, 13, 203, 25);
		contentPane.add(lblNuevoSucursal);
		
		
		textField_num = new JTextField();
		textField_num.setBounds(136, 90, 116, 22);
		contentPane.add(textField_num);
		textField_num.setColumns(10);
		
		textField_direccion = new JTextField();
		textField_direccion.setBounds(136, 125, 116, 22);
		contentPane.add(textField_direccion);
		textField_direccion.setColumns(10);
		
		JLabel lblNum = new JLabel("Numero");
		lblNum.setBounds(68, 93, 56, 16);
		contentPane.add(lblNum);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(68, 128, 56, 16);
		contentPane.add(lblDireccion);
		
		List<Usuario> usuarios = UsuariosManager.getInstancia().getUsuarios();

		this.comboBox_responsableTecnico = new JComboBox();
		comboBox_responsableTecnico.setModel(new DefaultComboBoxModel(usuarios.toArray()));
		comboBox_responsableTecnico.setBounds(136, 160, 116, 22);
		contentPane.add(comboBox_responsableTecnico);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuSucursales back = new MenuSucursales();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		btn_cancelar.setBounds(546, 488, 97, 25);
		contentPane.add(btn_cancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SucursalesManager.getInstancia().cargarDatos(Integer.parseInt(textField_num.getText()),textField_direccion.getText(),(Usuario)comboBox_responsableTecnico.getSelectedItem()); //mapear campos manualmente
				MenuSucursales back = new MenuSucursales();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnGuardar.setBounds(432, 488, 97, 25);
		contentPane.add(btnGuardar);
		
		JLabel lblNewLabel = new JLabel("Responsable tecnico");
		lblNewLabel.setBounds(12, 167, 112, 16);
		contentPane.add(lblNewLabel);
		
	}

	public void editarSucursal(String num) {
		// TODO Auto-generated method stub
		sucursal = SucursalesManager.getInstancia().getSucursal(num);
		textField_num.setText(String.valueOf(sucursal.getNum()));
		textField_direccion.setText(sucursal.getDireccion());
		this.comboBox_responsableTecnico.setSelectedItem(sucursal.responsableTecnico);

		
		//),textField_nombre.getText(),textField_direccion.getText(),textField_sexo.getText(),Integer.parseInt(textField_edad.getText()));
		
	}
}
