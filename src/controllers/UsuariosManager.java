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
	
	// agregar usuarios prueba
   	
	private static UsuariosManager instancia;
	
	private UsuariosManager (){
		
		recuperarUsuariosGuardados();
		//this.usuarios = new ArrayList<Usuario>();
		//agregar usuarios prueba
		//this.usuarios.add(new Usuario("usuario01", "usuario1@ejemplo.com", "Pa$$word", "Ejemplo 1", "Recepcion"));
		//this.usuarios.add(new Usuario("usuario02", "usuario2@ejemplo.com", "Pa$$word", "Ejemplo 2", "Laboratorio"));
		//this.guardarUsuarios();
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
			if (u.getUserName() == userName) {
				u.editUsuario(userName, email, password, nombre, role);
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
		
		

}