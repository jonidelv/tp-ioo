package model;

import java.util.ArrayList;
import java.util.List;

import controllers.PeticionesManager;

public class Paciente {

    private int dni;
    private String nombre;
    private String domicilio;
    private String sexo;
	private int edad;
	private List<Peticion> peticiones;
	
	public Paciente(int dni, String nombre, String domicilio, String sexo, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.sexo = sexo;
		this.edad = edad;
		this.peticiones = new ArrayList<Peticion>();
	}
    
    public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void editPaciente (int dni, String nombre, String domicilio, String sexo, int edad) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.sexo = sexo;
		this.edad = edad;
	}
    
    public boolean tienePeticiones() {
    	List<Peticion> peticionesPaciente = PeticionesManager.getInstancia().getPeticionesPorDNI(this.dni);    	
    	if (peticionesPaciente.size() == 0){
        	return false ; 
        } else { return true ; }
    }

	public void addPeticion(Peticion peticion) {
		this.peticiones.add(peticion);		
	}

	
}
