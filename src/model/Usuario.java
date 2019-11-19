package model;
import java.util.*;

public class Usuario {
	
    private String userName;
    private String email;
    private String password;
    private String nombre;
    private String role;
    
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


    public Usuario (String userName, String password) {
    	this.userName = userName;
    	this.password = password;
    	
    };
    
    public Usuario (String userName, String email, String password, String nombre, String role) {
    	this.userName = userName;
    	this.password = password;
    	this.email = email;
    	this.nombre = nombre;
    	this.role = role;
    	
    };
    
    public void editUsuario (String userName, String email, String password, String nombre, String role) {
    	this.userName = userName;
    	this.password = password;
    	this.email = email;
    	this.nombre = nombre;
    	this.role = role;
    	
    };
    
    public String toString(){
    	return this.userName;
    }
    
}