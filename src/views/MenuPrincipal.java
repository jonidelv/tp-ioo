package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.UsuariosManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Menu laboratorio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox_opciones = new JComboBox();
		comboBox_opciones.setToolTipText("");
		switch (UsuariosManager.getInstancia().getRoleUsuarioActivo()) {
			case "Admin":
				comboBox_opciones.setModel(new DefaultComboBoxModel(new String[] {"Usuarios", "Sucursales", "Pacientes", "Practicas","Peticiones"}));
				break;
			case "Recepcionista":
				comboBox_opciones.setModel(new DefaultComboBoxModel(new String[] {"Pacientes","Peticiones"}));
				break;
			case "Laboratorista":
				comboBox_opciones.setModel(new DefaultComboBoxModel(new String[] {"Peticiones"}));
				break;
		}
		
		comboBox_opciones.setBounds(29, 37, 342, 22);
		contentPane.add(comboBox_opciones);
		
		JButton btn_ok = new JButton("Aceptar");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				switch(comboBox_opciones.getSelectedItem().toString()) {
				  case "Pacientes":
					  MenuPacientes.main(null);
					  setVisible(false);
				    break;
				  case "Sucursales":
					  MenuSucursales.main(null);
					  setVisible(false);
				    break;
				  case "Practicas":
					  MenuPracticas.main(null);
					  setVisible(false);
					    break;
				  case "Usuarios":
					  MenuUsuarios.main(null);
					  setVisible(false);
					    break;
				  case "Peticiones":
					  MenuPeticiones.main(null);
					  setVisible(false);
					    break;

				}
				
				
				
			}
		});
		btn_ok.setBounds(363, 211, 97, 25);
		contentPane.add(btn_ok);
		
		
		
		
	}
}
