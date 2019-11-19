package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.ArrayUtils;

import controllers.PeticionesManager;
import dto.PeticionDTO;


public class MenuPeticiones extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPeticiones frame = new MenuPeticiones();
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
	public MenuPeticiones() {
		setTitle("Peticiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal back = new MenuPrincipal();
				back.setVisible(true);
				setVisible(false);
				
			}
		});
		btn_cancelar.setBounds(546, 488, 97, 25);
		contentPane.add(btn_cancelar);
		
		table = new JTable();
		table.setBounds(68, 174, 529, 271);
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {
				},
				new String[] {
					"Id","Paciente","Obra social","Fecha ingreso","Finalizado"
				});
		
		
		List<PeticionDTO> peticiones = PeticionesManager.getInstancia().getPeticionesSimples();
		if(ArrayUtils.isNotEmpty(peticiones.toArray())){
			for (PeticionDTO pet:peticiones){
				List<String> list = new ArrayList<String>();
				list.add(String.valueOf(pet.id));
				list.add(pet.paciente.getNombre());
				list.add(pet.obraSocial);
				list.add(pet.fechaCarga.toString());
				list.add(String.valueOf(pet.finalizado));
				model.addRow(list.toArray());
			}				
		}
		table.setModel(model);	
		contentPane.add(table);
				
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(40, 126, 557, 319);
	    getContentPane().add(scrollPane);
		
		textField_search = new JTextField();
		textField_search.setBounds(40, 91, 320, 22);
		contentPane.add(textField_search);
		textField_search.setColumns(10);
		
		JLabel lblDni = new JLabel("Numero de peticion:");
		lblDni.setBounds(40, 62, 205, 16);
		contentPane.add(lblDni);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VistaNuevoPeticion.main(null);
				setVisible(false);
				  
			}
		});
		btnAgregar.setBounds(410, 39, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(table.getSelectionModel().isSelectionEmpty()){
				    JOptionPane.showMessageDialog(new JFrame(), "Seleccion un paciente de la lista para borrar", "Peticiones", JOptionPane.ERROR_MESSAGE);	
				} else {
					//TODO completar codigo borrar paciente
					
				}
				
				
			}
		});
		btnEliminar.setBounds(519, 77, 97, 25);
		contentPane.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectionModel().isSelectionEmpty()){
					JOptionPane.showMessageDialog(new JFrame(), "Seleccion un paciente de la lista para editar", "Peticiones",JOptionPane.ERROR_MESSAGE);				
				} else {				
					//VistaNuevoPeticion nuevaVista = new VistaNuevoPeticion();
					//nuevaVista.editarPeticion(table.getValueAt(table.getSelectedRow(), 0).toString());
					//nuevaVista.setVisible(true);
					//setVisible(false);
				}
				
			}
		});
		btnEditar.setBounds(410, 77, 97, 25);
		contentPane.add(btnEditar);
		
		
		
	}

	public void getPeticionesPaciente(String dni) {
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
		new String[] {
			"Id","Paciente","Obra social","Fecha ingreso","Finalizado"
		});

		List<PeticionDTO> peticiones = PeticionesManager.getInstancia().getPeticionesSimples();
		if(ArrayUtils.isNotEmpty(peticiones.toArray())){
			for (PeticionDTO pet:peticiones){
				if (pet.paciente.getDni() == Integer.parseInt(dni)) {
					List<String> list = new ArrayList<String>();
					list.add(String.valueOf(pet.id));
					list.add(pet.paciente.getNombre());
					list.add(pet.obraSocial);
					list.add(pet.fechaCarga.toString());
					model.addRow(list.toArray());
				}
			}
		}
		table.setModel(model);
		model.fireTableChanged(null);
	}

}
