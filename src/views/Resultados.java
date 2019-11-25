package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controllers.PeticionesManager;
import model.CriterioNumerico;
import model.Practica;
import model.PracticaPedida;
import tableModel.ResultadosTableModel;

public class Resultados extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ResultadosTableModel model;

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
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(24, 28, 373, 183);
		List<PracticaPedida> listaPrueba = new ArrayList<PracticaPedida>();
		listaPrueba.add(new PracticaPedida((new Practica("A00001","Glucosa en sangre",4,(new CriterioNumerico(100,1000)),(new CriterioNumerico(0,100)))),""));
		table.setModel(new ResultadosTableModel(listaPrueba));
		contentPane.add(table);
		
		JButton btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(323, 224, 97, 25);
		contentPane.add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPeticiones back = new MenuPeticiones();
				back.setVisible(true);
				setVisible(false);
			}
		});
		btn_cancelar.setBounds(209, 224, 97, 25);
		contentPane.add(btn_cancelar);
	}

	public void cargarResultados(String idPeticion) {
		ArrayList<PracticaPedida> practicasPedidas = PeticionesManager.getInstancia().getPeticion(Integer.parseInt(idPeticion)).getPracticasPedidas();
		model = new ResultadosTableModel(practicasPedidas);
		table.setModel(model);
		
	}
}
