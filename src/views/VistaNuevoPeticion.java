package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.PeticionesManager;
import controllers.PracticasManager;
import controllers.SucursalesManager;
import dto.SucursalDTO;
import model.Peticion;
import model.Practica;
import model.PracticaPedida;

public class VistaNuevoPeticion extends JFrame {

	private JPanel contentPane;
	private static Peticion peticion;
	private JTextField textField_obraSocial;
	private JTextField textField_dniPaciente;
	private JComboBox comboBox_sucursal;
	private JList list_practicasPedidas;
	private JTextField textField_Id;
	

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
		textField_obraSocial.setBounds(136, 149, 116, 22);
		contentPane.add(textField_obraSocial);
		textField_obraSocial.setColumns(10);
		
		JLabel lbId = new JLabel("DNI paciente");
		lbId.setBounds(52, 116, 85, 16);
		contentPane.add(lbId);

		JLabel lblDireccion = new JLabel("Obra social");
		lblDireccion.setBounds(52, 152, 85, 16);
		contentPane.add(lblDireccion);
		
		textField_dniPaciente = new JTextField();
		textField_dniPaciente.setBounds(136, 113, 116, 22);
		contentPane.add(textField_dniPaciente);
		textField_dniPaciente.setColumns(10);
		
		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setBounds(52, 191, 56, 16);
		contentPane.add(lblSucursal);
		
		List<SucursalDTO> sucursales = SucursalesManager.getInstancia().getSucursalesSimples();
		List<String> direccionSucursales = new ArrayList<String>();
		for (SucursalDTO suc:sucursales)
			direccionSucursales.add(suc.direccion);
		
		this.comboBox_sucursal = new JComboBox();
		comboBox_sucursal.setModel(new DefaultComboBoxModel(direccionSucursales.toArray()));
		comboBox_sucursal.setBounds(136, 188, 119, 22);
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
				List<PracticaPedida> pedidas = new ArrayList<PracticaPedida>();
						
				for (Object ppo : ((DefaultListModel) list_practicasPedidas.getModel()).toArray() ){
					PracticaPedida pp = (PracticaPedida) ppo;
					String str = Objects.toString(pp.getResultado());
					pp.setResultado(str);
					if (str.equals("null")) { pp.setResultado("");}
					pedidas.add((PracticaPedida) pp);
				}
				
				PeticionesManager.getInstancia().guardarPeticion(Integer.parseInt(textField_Id.getText()),Integer.parseInt(textField_dniPaciente.getText()),textField_obraSocial.getText(),idSucursal,pedidas);
				MenuPeticiones back = new MenuPeticiones();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnGuardar.setBounds(432, 488, 97, 25);
		contentPane.add(btnGuardar);
				
		this.list_practicasPedidas = new JList();
		this.list_practicasPedidas.setModel(new DefaultListModel<PracticaPedida>());
		list_practicasPedidas.setBounds(93, 268, 253, 213);
		contentPane.add(list_practicasPedidas);
		
		JLabel lblPracticas = new JLabel("Practicas");
		lblPracticas.setBounds(63, 239, 56, 16);
		contentPane.add(lblPracticas);
		
		JLabel lblAgregarPracticas = new JLabel("Agregar practicas");
		lblAgregarPracticas.setBounds(358, 269, 131, 16);
		contentPane.add(lblAgregarPracticas);
		
		List<Practica> practicas = PracticasManager.getInstancia().getPracticas();
		JComboBox comboBox_practicas = new JComboBox(practicas.toArray());
		comboBox_practicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel model = (DefaultListModel) list_practicasPedidas.getModel();
				model.addElement(new PracticaPedida((Practica)comboBox_practicas.getSelectedItem(), null ));
				list_practicasPedidas.setModel(model);
			}
		});
		comboBox_practicas.setBounds(358, 298, 131, 25);
		contentPane.add(comboBox_practicas);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(93, 81, 24, 16);
		contentPane.add(lblId);
		
		textField_Id = new JTextField();
		textField_Id.setEditable(false);
		textField_Id.setBounds(136, 78, 116, 22);
		contentPane.add(textField_Id);
		textField_Id.setColumns(10);
	
		textField_Id.setText(String.valueOf(PeticionesManager.getInstancia().generateId()));
		
		
	}

	public void editarPeticion(String cod) {
		Peticion peticion = PeticionesManager.getInstancia().getPeticion(Integer.parseInt(cod));
		textField_Id.setText(cod);
		textField_obraSocial.setText(peticion.getObraSocial());
		textField_dniPaciente.setText(String.valueOf(peticion.getPaciente().getDni()));
		comboBox_sucursal.setSelectedItem(peticion.getSucursal().getDireccion());
		
		List<PracticaPedida> practicasPedidas = PeticionesManager.getInstancia().getPracticasPedidas(Integer.parseInt(cod));
		if (!practicasPedidas.isEmpty()) {
			DefaultListModel model = new DefaultListModel<PracticaPedida>();
			for (PracticaPedida pra:practicasPedidas)
				model.addElement(pra);
			this.list_practicasPedidas.setModel(model);
		}
		
		
	}
}