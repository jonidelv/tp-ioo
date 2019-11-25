package controllers;
import model.Paciente;
import model.Usuario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class UsuariosManager {
	
	private List<Usuario> usuarios;
	private static UsuariosManager instancia;
	private Usuario usuarioActivo;
	
	private UsuariosManager (){
		recuperarUsuariosGuardados();
		
//		this.usuarios = new ArrayList<Usuario>();
//		this.usuarios.add(new Usuario("admin", "admin@ejemplo.com", "admin", "Administrador", "Admin"));
//		this.usuarios.add(new Usuario("usuario01", "usuario1@ejemplo.com", "Pa$$word", "Ejemplo 1", "Recepcionista"));
//		this.usuarios.add(new Usuario("usuario02", "usuario2@ejemplo.com", "Pa$$word", "Ejemplo 2", "Laboratorista"));
//		this.guardarUsuarios();
	}

	public static UsuariosManager getInstancia(){
    	if (instancia == null) {
    		instancia = new UsuariosManager()	;
    	}
    	return instancia;
    }
    
	public List<Usuario> getUsuarios (){
		return this.usuarios;
	}
	
	public String getRoleUsuarioActivo() {
		return this.usuarioActivo.getRole();
	}
	
	private void recuperarUsuariosGuardados() {
		java.lang.reflect.Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
		try (FileReader reader = new FileReader("usuarios.json")) {
			this.usuarios = new Gson().fromJson(reader , listType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void guardarUsuarios(){
		try (Writer writer = new FileWriter("usuarios.json")) {
		    Gson gson = new GsonBuilder().create();
		    gson.toJson(this.usuarios, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public void cargarDatos(String userName, String email, String password, String nombre, String role) {
		boolean existing = false;
		for(Usuario u : usuarios) {
			if (u.getUserName().equals(userName)) {
				u.setNombre(userName);
				u.setEmail(email);
				u.setPassword(password);
				u.setNombre(nombre);
				u.setRole(role);
				existing = true;
			}
		}
		
		if (!existing){
			usuarios.add(new Usuario(userName, email, password, nombre, role));	
		}
		guardarUsuarios();

	}

	public Usuario getUsuario(String userName) {	
		for(Usuario u : usuarios) {
			if (u.getUserName() == userName) {
				return u;
		}
	}
		return null;
		
	}

	public void eliminarUsuario(String username) {
		int ind = 0;
		int target = -1;
		for (Usuario usuario : this.usuarios){
			if (usuario.getUserName() == username) {
				target = ind;
			}
			ind++;
		}
		if (target != -1){ this.usuarios.remove(target); }
		guardarUsuarios();
		
	}

	public boolean login(String userName, String password) {
		for (Usuario usuario : usuarios){
			if (usuario.getUserName().equals(userName) && usuario.getPassword().equals(password)){
				this.usuarioActivo = usuario;
				return true;
			}
		}
		return false;
		
	}
		
		

}