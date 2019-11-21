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

import controllers.PacientesManager;
import dto.PacienteDTO;



public class MenuPacientes extends JFrame {

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
					MenuPacientes frame = new MenuPacientes();
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
	public MenuPacientes() {
		setTitle("Pacientes");
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
		
		DefaultTableModel model = new DefaultTableModel(new Object[][] {
				},
				new String[] {
					"DNI", "Nombre"
				});
		
		List<PacienteDTO> pacientes = PacientesManager.getInstancia().getPacientesSimples();
		for (PacienteDTO p:pacientes){
				List<String> list = new ArrayList<String>();
				list.add(String.valueOf(p.dni));
				list.add(p.nombre);
				model.addRow(list.toArray());
		}
		

	
		table = new JTable();
		table.setModel(model);
		table.setBounds(68, 174, 529, 271);
		contentPane.add(table);		
				
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(40, 126, 557, 319);
	    getContentPane().add(scrollPane);
		
		textField_search = new JTextField();
		textField_search.setBounds(40, 91, 320, 22);
		contentPane.add(textField_search);
		textField_search.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(40, 62, 56, 16);
		contentPane.add(lblDni);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VistaNuevoPaciente.main(null);
				setVisible(false);
				  
			}
		});
		btnAgregar.setBounds(410, 39, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(table.getSelectionModel().isSelectionEmpty()){
				    JOptionPane.showMessageDialog(new JFrame(), "Seleccion un paciente de la lista para borrar", "Pacientes", JOptionPane.ERROR_MESSAGE);	
				} else {
					if (PacientesManager.getInstancia().eliminarPaciente(Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString()))){
						setVisible(false);
						main(null);
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "No se puede borrar el paciente seleccionado\nporque tiene peticiones", "Pacientes", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
				
			}
		});
		btnEliminar.setBounds(519, 77, 97, 25);
		contentPane.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectionModel().isSelectionEmpty()){
					JOptionPane.showMessageDialog(new JFrame(), "Seleccion un paciente de la lista para editar", "Pacientes",JOptionPane.ERROR_MESSAGE);				
				} else {				
					VistaNuevoPaciente nuevaVista = new VistaNuevoPaciente();
					nuevaVista.editarPaciente(table.getValueAt(table.getSelectedRow(), 0).toString());
					nuevaVista.setVisible(true);
					setVisible(false);
				}
				
			}
		});
		btnEditar.setBounds(410, 77, 97, 25);
		contentPane.add(btnEditar);
		
		JButton btn_peticiones = new JButton("Peticiones");
		btn_peticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectionModel().isSelectionEmpty()){
					JOptionPane.showMessageDialog(new JFrame(),
							"Seleccion un paciente de la lista para ver sus peticiones",
							"Pacientes",JOptionPane.ERROR_MESSAGE);				
				} else {
					MenuPeticiones nuevaVista = new MenuPeticiones();
					
					nuevaVista.main(null);
					nuevaVista.getPeticionesPaciente(Integer.parseInt(
							table.getValueAt(table.getSelectedRow(), 0).toString()) );
					setVisible(false);
				}
			}
		});
		
		btn_peticiones.setBounds(519, 39, 97, 25);
		contentPane.add(btn_peticiones);
		
		
		
	}
}
