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
import model.Peticion;
import model.Sucursal;
import model.Usuario;

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