package controllers;

import model.Usuario;

public class LoginManager {
	
	private static LoginManager instancia;
	private static Usuario usuario;
	
    public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		LoginManager.usuario = usuario;
	}

	private LoginManager() {
    }

    public static LoginManager getInstancia(){
    	if (instancia == null) {
    		instancia = new LoginManager();
    	}
    	return instancia;
    }
    
    
    public Usuario login(String userName, String password) {
        // TODO implement here -> lógica login usuarios    	
    	
    	usuario = new Usuario(userName,password);
    	
    	return usuario;

    }
    
    public void validarPermisos() {
    	// TODO implement here
    }

}
