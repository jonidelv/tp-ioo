package views;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.PeticionesManager;
import model.Peticion;
import model.PracticaPedida;
import tableModel.ResultadosTableModel;

public class Resultados extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultados frame = new Resultados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param idPeticion 
	 */
	public Resultados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(24, 28, 373, 183);
		contentPane.add(table);
		
		JButton btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(323, 224, 97, 25);
		contentPane.add(btn_aceptar);
	}

	public void cargarResultados(String idPeticion) {
		Peticion peticion = PeticionesManager.getInstancia().getPeticion(Integer.parseInt(idPeticion));
		table.setModel(new ResultadosTableModel(peticion.getPracticasPedidas()));
		
	}
}
