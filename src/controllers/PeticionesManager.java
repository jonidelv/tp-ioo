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

import dto.PeticionDTO;
import model.CriterioNumerico;
import model.Peticion;
import model.Practica;
import model.PracticaPedida;

public class PeticionesManager {
	
	private List<Peticion> peticiones;
	private static PeticionesManager instancia;
	
	private PeticionesManager (){
		//recuperarPeticionesGuardadas();
		this.peticiones = new ArrayList<Peticion>();
		Practica practica = new Practica("A00002","Globulos rojos",4,(new CriterioNumerico(100,1000)),(new CriterioNumerico(0,100)));
		List<PracticaPedida> practicas = new ArrayList<PracticaPedida>();
		practicas.add(new PracticaPedida(practica,""));
		addPeticion(0,99789123, "Galeno", "001", practicas);
		guardarPeticiones();
		
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
	
	public void addPeticion(int id,int dni, String os, String idSucursal, List<PracticaPedida> practicasPedidas) {
        peticiones.add(new Peticion(id,dni,os,idSucursal, practicasPedidas));
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

	public List<PracticaPedida> getPracticasPedidas(Integer cod) {
		// TODO Auto-generated method stub
		for (Peticion pet : peticiones){
			if (pet.getId() == cod){
				return pet.getPracticasPedidas();
			}
		}
		return (new ArrayList<PracticaPedida>());
	}

	public void guardarPeticion(int id, int dniPaciente, String os, String sucursalId, List<PracticaPedida> practicasPedidas) {
		boolean existing = false;
		for (Peticion pp : peticiones){
			if (pp.getId() == id){
				pp.setObraSocial(os);
				pp.setSucursal(SucursalesManager.getInstancia().getSucursal(sucursalId));
				pp.setPaciente(PacientesManager.getInstancia().getPaciente(dniPaciente));
				pp.setPracticasPedidas(practicasPedidas);
				existing = true;
			}
			
		}
		
		if(!existing){
			peticiones.add(new Peticion(id,dniPaciente, os, sucursalId, practicasPedidas));
		}
		
		guardarPeticiones();
		
	}

	public void eliminarPeticion(int id) {
		int ind = 0;
		int vic = 0;
		for (Peticion pet:peticiones){
			if (pet.getId() == id ){
				vic = ind;
			}
			ind ++;
		}
		peticiones.remove(vic);	
		guardarPeticiones();
		
	}


	



}