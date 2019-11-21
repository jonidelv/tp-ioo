package controllers;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import dto.PacienteDTO;
import model.Paciente;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class PacientesManager {
	
	private List<Paciente> pacientes;
   	
	private static PacientesManager instancia;
	
	private PacientesManager (){
		recuperarPacientesGuardados();
//		this.pacientes = new ArrayList<Paciente>();
//		this.pacientes.add(new Paciente(99123456,"Juan Perez","Ejemplo 123","masculino",28));
//		this.pacientes.add(new Paciente(99789123,"Jose Lopez","Ejemplo 456","masculino",82));
//		guardarPacientes();
				
	}

	private void recuperarPacientesGuardados() {
		java.lang.reflect.Type listType = new TypeToken<ArrayList<Paciente>>(){}.getType();
		try (FileReader reader = new FileReader("pacientes.json")) {
			this.pacientes = new Gson().fromJson(reader , listType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void guardarPacientes(){
		try (Writer writer = new FileWriter("pacientes.json")) {
		    Gson gson = new GsonBuilder().create();
		    gson.toJson(this.pacientes, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public static PacientesManager getInstancia(){
    	if (instancia == null) {
    		instancia = new PacientesManager()	;
    	}
    	return instancia;
    }
    

    public void removePaciente() {
        // TODO implement here
    }
    public void editPaciente() {
        // TODO implement here
    }


	public void cargarDatos(int dni, String nombre, String domicilio, String sexo, int edad) {
		boolean existing = false;
		for(Paciente pac : pacientes) {
			if (pac.getDni() == dni) {
				pac.editPaciente(dni, nombre, domicilio, sexo, edad);
				existing = true;
			}
		}
		
		if (!existing){
			pacientes.add(new Paciente(dni,nombre,domicilio,sexo,edad));	
		}
		guardarPacientes();

	}

	public Paciente getPaciente(int dni) {		
		for(Paciente pac : pacientes) {
			if (pac.getDni() == dni) {
				return pac;
		}
	}
		return null;
		
	}

	public ArrayList<PacienteDTO> getPacientesSimples() {
		ArrayList<PacienteDTO> pacientesDTO = new ArrayList<PacienteDTO>();
		
		for (Paciente pac : pacientes) {
			pacientesDTO.add(new PacienteDTO(pac.getDni(),pac.getNombre()));			
		}
		
		return pacientesDTO;
	}

	public boolean eliminarPaciente(int dni) {
		int ind = 0;
		for (Paciente pac : this.pacientes){
			if (pac.getDni() == dni) {
				if (!pac.tienePeticiones()){
					this.pacientes.remove(ind);
					guardarPacientes();
					return true;
				} else {
					return false;
				}
			}
			ind++;
		}		
		return false;
		
	}
		
		
		

}