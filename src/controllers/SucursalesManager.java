package controllers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import dto.SucursalDTO;
import model.Paciente;
import model.Sucursal;
import model.Usuario;

public class SucursalesManager {
	
	private List<Sucursal> sucursales;
	
	private static SucursalesManager instancia;
	
	private SucursalesManager (){
		recuperarSucursalesGuardadas();
		
//		this.sucursales = new ArrayList<Sucursal>();
//		Usuario rt1 = UsuariosManager.getInstancia().getUsuario("usuario01");
//		Usuario rt2 = UsuariosManager.getInstancia().getUsuario("usuario02");
//		this.sucursales.add(new Sucursal(001,"Av 9 de Julio",rt1));
//		this.sucursales.add(new Sucursal(002,"Lima 555",rt2));
//		guardarSucursales();
	}

	public static SucursalesManager getInstancia(){
    	if (instancia == null) {
    		instancia = new SucursalesManager()	;
    	}
    	return instancia;
    }
    
	private void recuperarSucursalesGuardadas() {
		Gson gson = new Gson();
		java.lang.reflect.Type listType = new TypeToken<ArrayList<Sucursal>>(){}.getType();
		try (FileReader reader = new FileReader("sucursales.json")) {
			this.sucursales = new Gson().fromJson(reader , listType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void guardarSucursales(){
		try (Writer writer = new FileWriter("sucursales.json")) {
		    Gson gson = new GsonBuilder().create();
		    gson.toJson(this.sucursales, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public void cargarDatos(int num, String direccion, Usuario rt) {
		boolean existing = false;
		for(Sucursal suc : sucursales) {
			if (suc.getNum() == num) {
				suc.editSucursal(num, direccion, rt);
				existing = true;
			}
		}
		
		if (!existing){
			sucursales.add(new Sucursal(num,direccion,rt));	
		}
		guardarSucursales();
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

	public void eliminarSucursal(int id) {
		int ind = 0;
		int vic = -1;
		for (Sucursal suc : this.sucursales){
			if (suc.getNum() == id) {
				vic = ind;
			}
			ind++;
		}		
		if(vic != -1) { this.sucursales.remove(vic); }
		guardarSucursales();
	}
		
		
		

}