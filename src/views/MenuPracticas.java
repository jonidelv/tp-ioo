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

import controllers.PracticasManager;
import dto.PracticaDTO;



public class MenuPracticas extends JFrame {

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
					MenuPracticas frame = new MenuPracticas();
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
	public MenuPracticas() {
		setTitle("Practicas");
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
					"Codigo", "Nombre","Horas","Habilitada"
				});
		
		List<PracticaDTO> practicas = PracticasManager.getInstancia().getPracticasSimples();
		if(ArrayUtils.isNotEmpty(practicas.toArray())){
			for (PracticaDTO p:practicas){
				List<String> list = new ArrayList<String>();
				list.add(String.valueOf(p.codigo));
				list.add(p.nombre);
				list.add(String.valueOf(p.cantidadHorasResultados));
				list.add(String.valueOf(p.enabled));
				model.addRow(list.toArray());
			}
			
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
				VistaNuevoPractica.main(null);
				setVisible(false);
				  
			}
		});
		btnAgregar.setBounds(410, 39, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(table.getSelectionModel().isSelectionEmpty()){
				    JOptionPane.showMessageDialog(new JFrame(), "Seleccion un practica de la lista para borrar", "Practicas", JOptionPane.ERROR_MESSAGE);	
				} else {
					//TODO completar codigo borrar practica
					
				}
				
				
			}
		});
		btnEliminar.setBounds(519, 77, 97, 25);
		contentPane.add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectionModel().isSelectionEmpty()){
					JOptionPane.showMessageDialog(new JFrame(), "Seleccion un practica de la lista para editar", "Practicas",JOptionPane.ERROR_MESSAGE);				
				} else {				
					VistaNuevoPractica nuevaVista = new VistaNuevoPractica();
					nuevaVista.editarPractica(table.getValueAt(table.getSelectedRow(), 0).toString());
					nuevaVista.setVisible(true);
					setVisible(false);
				}
				
			}
		});
		btnEditar.setBounds(410, 77, 97, 25);
		contentPane.add(btnEditar);
		
		
		
	}
}
