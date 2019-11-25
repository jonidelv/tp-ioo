package controllers;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import dto.PracticaDTO;
import model.CriterioDescriptivo;
import model.CriterioNumerico;
import model.ICriterio;
import model.Practica;
import model.Usuario;

public class PracticasManager {
	
	private List<Practica> practicas;
	
	// agregar practicas prueba
   	
	private static PracticasManager instancia;
	
	private PracticasManager (){
//		recuperarPracticasGuardadas();
		
		this.practicas = new ArrayList<Practica>();
		this.practicas.add(new Practica("A00001","Glucosa en sangre",4,(new CriterioNumerico(100,1000)),(new CriterioNumerico(0,100))));
		List<String> valoresCriticos = Arrays.asList("amarillo","ambar");
		List<String> valoresReservados = Arrays.asList("amarillo","ambar");
		this.practicas.add(new Practica("A00002","Color de la orina",2,(new CriterioDescriptivo(valoresCriticos)),(new CriterioDescriptivo(valoresReservados))));
		this.practicas.add(new Practica("D00002","Globulos rojos",2,(new CriterioNumerico(100,1000)),(new CriterioNumerico(0,100))));
		guardarPracticas();
	}

	public static PracticasManager getInstancia(){
    	if (instancia == null) {
    		instancia = new PracticasManager()	;
    	}
    	return instancia;
    }

	private void recuperarPracticasGuardadas() {
		java.lang.reflect.Type listType = new TypeToken<ArrayList<Practica>>(){}.getType();
		try (FileReader reader = new FileReader("practicas.json")) {
			this.practicas = new Gson().fromJson(reader , listType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void guardarPracticas(){
		try (Writer writer = new FileWriter("practicas.json")) {
		    Gson gson = new GsonBuilder().create();
		    gson.toJson(this.practicas, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public void cargarDatos(String codigo, String nombre, int hs, ICriterio critico, ICriterio reservado) {
		boolean existing = false;
		for(Practica pra : practicas) {
			if (pra.getCodigo().equals(codigo)) {
				pra.editPractica(codigo, nombre, hs, critico, reservado);
				existing = true;
			}
		}
		
		if (!existing){
			practicas.add(new Practica(codigo, nombre, hs, critico, reservado));	
		}
		guardarPracticas();

	}

	public Practica getPractica(String codigo) {	
		for(Practica pra : practicas) {
			if (pra.getCodigo().equals(codigo)) {
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
		
		return practicasDTO;
	}

	public List<Practica> getPracticas() {
		return this.practicas;
	}

	public void eliminarPractica(String id) {
		int ind = 0;
		int target = -1;
		for(Practica pra : practicas) {
			if (pra.getCodigo().equals(id)) {
				target = ind;
			}
			ind ++;
		}
		if (target != -1){ this.practicas.remove(target); }
		guardarPracticas();
	}

}