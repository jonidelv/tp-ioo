package dto;

public class PracticaDTO {
	public String codigo;
    public String nombre;
    public int cantidadHorasResultados;
    public boolean enabled;

	public PracticaDTO (String codigo, String nombre, int hs, boolean enabled){
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadHorasResultados = hs;
		this.enabled = enabled;
	}

}
