package model;
import java.time.LocalDateTime;
import java.math.*;
import java.util.*;

import controllers.PacientesManager;
import controllers.PeticionesManager;
import controllers.SucursalesManager;

public class Peticion {

	private int id; 
	private Paciente paciente;
	private String obraSocial;
	private LocalDateTime fechaCarga;
	private LocalDateTime fechaEntrega;
	private List<Practica> practicas;
	private List<Resultado> resultados;
	private Sucursal sucursal;
	private boolean finalizado;
	
    
    public Peticion(String pacienteId, String os, String sucursalId) {
    	this.id = (int) Math.random(); //PeticionesManager.getInstancia().generateId();
    	this.paciente = PacientesManager.getInstancia().getPaciente(pacienteId);
    	this.obraSocial = os;
    	this.fechaCarga = LocalDateTime.now();
    	this.practicas = new ArrayList<Practica>();
    	this.resultados = new ArrayList<Resultado>();
    	this.sucursal = SucursalesManager.getInstancia().getSucursal(sucursalId);
    	this.finalizado = false;
    	
    }
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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

	public List<Practica> getPracticas() {
		return practicas;
	}

	public void setPracticas(List<Practica> practicas) {
		this.practicas = practicas;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
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

    public void editPeticion() {
        // TODO implement here
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

	
	
}
