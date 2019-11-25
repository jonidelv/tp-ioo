package model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controllers.PacientesManager;
import controllers.SucursalesManager;

public class Peticion {

	private int id; 
	private transient Paciente paciente;
	private String obraSocial;
	private LocalDateTime fechaCarga;
	private LocalDateTime fechaEntrega;
	private List<PracticaPedida> practicasPedidas;
	private transient Sucursal sucursal;
	private boolean finalizado;
	


	public Peticion(int id, int pacienteId, String os, String sucursalId, List<PracticaPedida> practicasPedidas) {
    	this.id = id; //PeticionesManager.getInstancia().generateId();
    	this.paciente = PacientesManager.getInstancia().getPaciente(pacienteId);
    	
    	this.obraSocial = os;
    	this.fechaCarga = LocalDateTime.now();
    	
    	if (!practicasPedidas.isEmpty()){
    		this.practicasPedidas = practicasPedidas;
    	} else {
    		this.practicasPedidas = new ArrayList<PracticaPedida>();
    	}
    	
    	this.sucursal = SucursalesManager.getInstancia().getSucursal(sucursalId);  	
    	this.finalizado = false;
    	
    	this.paciente.addPeticion(this);
    	this.sucursal.addPeticion(this);
    }
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

    
    public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public ArrayList<PracticaPedida> getPracticasPedidas() {
		return (ArrayList<PracticaPedida>) practicasPedidas;
	}

	public void setPracticasPedidas(List<PracticaPedida> practicas) {
		this.practicasPedidas = practicas;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getFechaCarga() {
		return fechaCarga;
	}

    public void cargarResultados() {
        // TODO implement here
    }

    public void esCritico() {
        // TODO implement here
    }

    public void esReservado() {
        // TODO implement here
    }

    public void listarResultados() {
        // TODO implement here
    }

	public boolean esCritica() {
		return practicasPedidas.stream().anyMatch(PracticaPedida::esCritica);
	}

	public boolean esReservada() {
		return practicasPedidas.stream().anyMatch(PracticaPedida::esReservada);
	}

	public boolean tieneResultadosCriticos() {
		for (PracticaPedida pp : this.practicasPedidas)		{
			if (pp.esCritica()){
				return true;
			}
		}
		
		return false;
	}
	
	
}
