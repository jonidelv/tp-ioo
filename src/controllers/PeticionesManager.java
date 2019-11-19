package controllers;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.awt.Window.Type;

import org.apache.commons.lang3.ArrayUtils;


import dto.PeticionDTO;
import model.Paciente;
import model.Peticion;
import model.Sucursal;

public class PeticionesManager {
	
	private List<Peticion> peticiones;
	private static PeticionesManager instancia;
	
	private PeticionesManager (){
		//recuperarPeticionesGuardadas();
		
		this.peticiones.add()
		
	}

	public static PeticionesManager getInstancia(){
    	if (instancia == null) {
    		instancia = new PeticionesManager()	;
    	}
    	return instancia;
    }
	
	private void recuperarPeticionesGuardadas() {
		Gson gson = new Gson();
		java.lang.reflect.Type listType = new TypeToken<ArrayList<Peticion>>(){}.getType();
		try (FileReader reader = new FileReader("peticiones.json")) {
			this.peticiones = new Gson().fromJson(reader , listType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void guardarPeticiones(){
		try (Writer writer = new FileWriter("peticiones.json")) {
		    Gson gson = new GsonBuilder().create();
		    gson.toJson(this.peticiones, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public int generateId() {
		return this.peticiones.size();
	}

	public List<PeticionDTO> getPeticionesSimples() {		
		ArrayList<PeticionDTO> peticionesDTO = new ArrayList<PeticionDTO>();
		
		for (Peticion pet : peticiones) {
			peticionesDTO.add(new PeticionDTO(pet.getId(), pet.getPaciente(), pet.getObraSocial(), pet.getFechaCarga(), pet.getFechaEntrega(), pet.isFinalizado()));			
		}
		
		return peticionesDTO;
	}
	
	public Peticion getPeticion(int id) {		
		for(Peticion pet : peticiones) {
			if (pet.getId() == id) {
				return pet;
		}
	}
		return null;
		
	}
	
	public List<Peticion> getPeticionesPorDNI(int dniPaciente) {		
		List<Peticion> peticionesPaciente = new ArrayList<Peticion>();
		for(Peticion pet : peticiones) {
			if (pet.getPaciente().getDni() == dniPaciente) {
				peticionesPaciente.add(pet);
		}
	}
		return peticionesPaciente;
		
	}
	
	public void addPeticion(String dni, String os, String idSucursal) {
        peticiones.add(new Peticion(dni,os,idSucursal));
        this.guardarPeticiones();
    }

    public void removePeticion() {
        // TODO implement here
    }

    public void editPeticion() {
        // TODO implement here
    }

    public void cargarResultados() {
        // TODO implement here
    }

    public void listarCriticos() {
        // TODO implement here
    }

    public void listarResultados() {
        // TODO implement here
    }


	



}