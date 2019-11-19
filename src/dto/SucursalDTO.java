package dto;

import model.Usuario;

public class SucursalDTO {
	public int num;
	public String direccion;
	public Usuario responsableTecnico;
	
	public SucursalDTO (int num, String direccion, Usuario responsableTecnico){
		this.num = num;
		this.direccion = direccion;
		this.responsableTecnico = responsableTecnico;
	}

}
