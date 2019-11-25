package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.UsuariosManager;

public class Inicio extends JFrame {

	private JFrame frmLogin;
	private JTextField textField_UserName;
	private JTextField textField_Password;
	private JLabel lblPassword;
	private JLabel label_LoginResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		textField_UserName = new JTextField();
		textField_UserName.setBounds(165, 52, 116, 22);
		frmLogin.getContentPane().add(textField_UserName);
		textField_UserName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(60, 55, 93, 19);
		frmLogin.getContentPane().add(lblUsername);
		
		textField_Password = new JTextField();
		textField_Password.setBounds(165, 87, 116, 22);
		frmLogin.getContentPane().add(textField_Password);
		textField_Password.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(60, 93, 93, 16);
		frmLogin.getContentPane().add(lblPassword);
		
		label_LoginResult = new JLabel("");
		label_LoginResult.setBounds(87, 158, 268, 16);
		frmLogin.getContentPane().add(label_LoginResult);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String userName = textField_UserName.getText();
				String password = textField_Password.getText();

				if (UsuariosManager.getInstancia().login(userName,password)){
				 	setVisible(false);
				 	MenuPrincipal.main(null);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Los datos ingresados son incorrectos", "Login",JOptionPane.ERROR_MESSAGE);
				}
				
			}


		});
		btnLogin.setBounds(308, 198, 97, 25);
		frmLogin.getContentPane().add(btnLogin);
		

	}
}
