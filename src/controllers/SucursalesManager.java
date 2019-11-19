package controllers;

import model.Sucursal;
import java.util.*;
import javax.swing.JTextField;

import dto.SucursalDTO;

public class SucursalesManager {
	
	private List<Sucursal> sucursales;
	
	private static SucursalesManager instancia;
	
	private SucursalesManager (){
		
		this.sucursales = new ArrayList<Sucursal>();
		//agregar sucursales prueba
		this.sucursales.add(new Sucursal(001,"Calle falsa 1234"));
		this.sucursales.add(new Sucursal(002,"Aca a la vuelta"));
	}

	public static SucursalesManager getInstancia(){
    	if (instancia == null) {
    		instancia = new SucursalesManager()	;
    	}
    	return instancia;
    }
    

    public void removeSucursal() {
        // TODO implement here
    }

	public void cargarDatos(int num, String direccion) {
		boolean existing = false;
		for(Sucursal suc : sucursales) {
			if (suc.getNum() == num) {
				suc.editSucursal(num, direccion);
				existing = true;
			}
		}
		
		if (!existing){
			sucursales.add(new Sucursal(num,direccion));	
		}
	

	}

	public Sucursal getSucursal(String id) {
		int idInt = Integer.parseInt(id);		
		for(Sucursal suc : sucursales) {
			if (suc.getNum() == idInt) {
				return suc;
		}
	}
		return null;
		
	}

	public ArrayList<SucursalDTO> getSucursalesSimples() {
		ArrayList<SucursalDTO> sucursalesDTO = new ArrayList<SucursalDTO>();
		
		for (Sucursal suc : sucursales) {
			sucursalesDTO.add(new SucursalDTO(
					suc.getNum(),
					suc.getDireccion(),
					suc.getResponsableTecnico()));			
		}	
		return sucursalesDTO;
	}
		
		
		

}