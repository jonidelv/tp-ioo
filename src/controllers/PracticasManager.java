package controllers;
import model.Practica;
import java.util.*;
import javax.swing.JTextField;

import dto.PracticaDTO;

public class PracticasManager {
	
	private List<Practica> practicas;
	
	// agregar practicas prueba
   	
	private static PracticasManager instancia;
	
	private PracticasManager (){
		
		this.practicas = new ArrayList<Practica>();
		//agregar practicas prueba
		this.practicas.add(new Practica("A00001","Glucosa en sangre",4));
		this.practicas.add(new Practica("D00002","Globulos rojos",2));
	}

	public static PracticasManager getInstancia(){
    	if (instancia == null) {
    		instancia = new PracticasManager()	;
    	}
    	return instancia;
    }
    

    public void removePractica() {
        // TODO implement here
    }
    public void editPractica() {
        // TODO implement here
    }


	public void cargarDatos(String codigo, String nombre, int hs) {
		boolean existing = false;
		for(Practica pra : practicas) {
			if (pra.getCodigo() == codigo) {
				pra.editPractica(codigo, nombre, hs);
				existing = true;
			}
		}
		
		if (!existing){
			practicas.add(new Practica(codigo, nombre, hs));	
		}
	

	}

	public Practica getPractica(String codigo) {	
		for(Practica pra : practicas) {
			if (pra.getCodigo() == codigo) {
				return pra;
		}
	}
		return null;
		
	}

	public ArrayList<PracticaDTO> getPracticasSimples() {
		ArrayList<PracticaDTO> practicasDTO = new ArrayList<PracticaDTO>();
		
		for (Practica pra : practicas) {
			practicasDTO.add(new PracticaDTO(pra.getCodigo(),pra.getNombre(),pra.getCantidadHorasResultados(),pra.isEnabled()));			
		}
		
		//practicasDTO.add(new PracticaDTO(99123456,"Juan Perez"));
		//practicasDTO.add(new PracticaDTO(99789123,"Jose Lopez"));
		
		return practicasDTO;
	}
		
		
		

}