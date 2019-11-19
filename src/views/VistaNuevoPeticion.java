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

import controllers.PeticionesManager;
import controllers.SucursalesManager;
import dto.SucursalDTO;
import model.Peticion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;

public class VistaNuevoPeticion extends JFrame {

	private JPanel contentPane;
	private static Peticion peticion;
	private JTextField textField_obraSocial;
	private JTextField textField_dniPaciente;
	private JComboBox comboBox_sucursal;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNuevoPeticion frame = new VistaNuevoPeticion();
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
	public VistaNuevoPeticion() {
		setTitle("Peticiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoPeticion = new JLabel("Informacion de la peticion");
		lblNuevoPeticion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevoPeticion.setBounds(52, 13, 203, 25);
		contentPane.add(lblNuevoPeticion);
		
		textField_obraSocial = new JTextField();
		textField_obraSocial.setBounds(136, 125, 116, 22);
		contentPane.add(textField_obraSocial);
		textField_obraSocial.setColumns(10);
		
		JLabel lbId = new JLabel("DNI paciente");
		lbId.setBounds(52, 92, 85, 16);
		contentPane.add(lbId);

		JLabel lblDireccion = new JLabel("Obra social");
		lblDireccion.setBounds(52, 128, 85, 16);
		contentPane.add(lblDireccion);
		
		textField_dniPaciente = new JTextField();
		textField_dniPaciente.setBounds(136, 89, 116, 22);
		contentPane.add(textField_dniPaciente);
		textField_dniPaciente.setColumns(10);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(52, 167, 56, 16);
		contentPane.add(lblSucursal);
		
		List<SucursalDTO> sucursales = SucursalesManager.getInstancia().getSucursalesSimples();
		List<String> direccionSucursales = new ArrayList<String>();
		for (SucursalDTO suc:sucursales)
			direccionSucursales.add(suc.direccion);
		
		this.comboBox_sucursal = new JComboBox();
		comboBox_sucursal.setModel(new DefaultComboBoxModel(direccionSucursales.toArray()));
		comboBox_sucursal.setBounds(136, 164, 119, 22);
		contentPane.add(comboBox_sucursal);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPeticiones back = new MenuPeticiones();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		btn_cancelar.setBounds(546, 488, 97, 25);
		contentPane.add(btn_cancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idSucursal = "";
				for (SucursalDTO suc : sucursales){
					if (suc.direccion == comboBox_sucursal.getSelectedItem()){
						idSucursal = Integer.toString(suc.num);
					}
				}
					
				PeticionesManager.getInstancia().addPeticion(textField_dniPaciente.getText(),textField_obraSocial.getText(),idSucursal);
				MenuPeticiones back = new MenuPeticiones();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnGuardar.setBounds(432, 488, 97, 25);
		contentPane.add(btnGuardar);
		
	}
}