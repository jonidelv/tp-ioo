package model;
import java.util.*;

import controllers.LoginManager;


public class Sucursal {
	

	public int num;
	public String direccion;
	public Usuario responsableTecnico;
	public List<Peticion> peticiones;
	
	public Sucursal(int num, String direccion, Usuario rt){
		this.num = num;
		this.direccion = direccion;
		this.responsableTecnico = rt;
		this.peticiones = new ArrayList<Peticion>();
		
	}
	
	public void editSucursal (int num, String dir, Usuario rt) {
		this.num = num;
		this.direccion = dir;
		this.responsableTecnico = rt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Usuario getResponsableTecnico() {
		return responsableTecnico;
	}

	public void setResponsableTecnico(Usuario responsableTecnico) {
		this.responsableTecnico = responsableTecnico;
	}

	public List<Peticion> getPeticiones() {
		return peticiones;
	}

	public void setPeticiones(List<Peticion> peticiones) {
		this.peticiones = peticiones;
	}

	   
	public void addSucursal() {
			// TODO implement here
	}
	
	public void removeSucursal() {
	       // TODO implement here
	}
	
	public void editSucursal() {
	    // TODO implement here
	}

	public void tienePeticiones() {
	    // TODO implement here
	}

	
	
	
}
