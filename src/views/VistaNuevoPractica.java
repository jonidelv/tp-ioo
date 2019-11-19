package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.PracticasManager;
import model.Practica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class VistaNuevoPractica extends JFrame {

	private JPanel contentPane;
	private static Practica practica;
	private JTextField textField_codigo;
	private JTextField textField_nombre;
	private JTextField textField_hs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaNuevoPractica frame = new VistaNuevoPractica();
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
	public VistaNuevoPractica() {
		setTitle("Practicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoPractica = new JLabel("Informacion del practica");
		lblNuevoPractica.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevoPractica.setBounds(52, 13, 203, 25);
		contentPane.add(lblNuevoPractica);
		
		
		textField_codigo = new JTextField();
		textField_codigo.setBounds(136, 90, 116, 22);
		contentPane.add(textField_codigo);
		textField_codigo.setColumns(10);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(136, 131, 116, 22);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_hs = new JTextField();
		textField_hs.setBounds(136, 171, 116, 22);
		contentPane.add(textField_hs);
		textField_hs.setColumns(10);
		
		JLabel lblCodigo = new JLabel("DNI");
		lblCodigo.setBounds(68, 93, 56, 16);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(52, 134, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblCantHoras = new JLabel("Horas");
		lblCantHoras.setBounds(52, 174, 56, 16);
		contentPane.add(lblCantHoras);
		
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPracticas back = new MenuPracticas();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		btn_cancelar.setBounds(546, 488, 97, 25);
		contentPane.add(btn_cancelar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PracticasManager.getInstancia().cargarDatos(textField_codigo.getText(),textField_nombre.getText(),Integer.parseInt(textField_hs.getText()));
				MenuPracticas back = new MenuPracticas();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnGuardar.setBounds(432, 488, 97, 25);
		contentPane.add(btnGuardar);
		
	}

	public void editarPractica(String codigo) {
		// TODO Auto-generated method stub
		practica = PracticasManager.getInstancia().getPractica(codigo);
		textField_codigo.setText(practica.getCodigo());
		textField_nombre.setText(practica.getNombre());
		textField_hs.setText(String.valueOf(practica.getCantidadHorasResultados()));
		
		
		//),textField_nombre.getText(),textField_direccion.getText(),textField_sexo.getText(),Integer.parseInt(textField_edad.getText()));
		
	}
}
