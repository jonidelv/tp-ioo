package dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import controllers.PeticionesManager;
import model.Paciente;
import model.Practica;
import model.Resultado;
import model.Usuario;

public class PeticionDTO {
	
	public int id; 
	public Paciente paciente;
	public String obraSocial;
	public LocalDateTime fechaCarga;
	public LocalDateTime fechaEntrega;
	public boolean finalizado;
	
	
	public PeticionDTO (int id, Paciente paciente, String os, LocalDateTime fechaCarga, LocalDateTime fechaEntrega, boolean finalizado ){
		this.id = id;
		this.paciente = paciente;
		this.obraSocial = os;
		this.fechaCarga = fechaCarga;
		this.fechaEntrega = fechaEntrega;
		this.finalizado = finalizado;
		

	}

}
