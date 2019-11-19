package model;
import java.util.*;

public class Practica {
	
    private String codigo;
    private String nombre;
    private String grupo;
    //private Criterio criterio;
    private int cantidadHorasResultados;
    private boolean enabled;
    
	public Practica(String codigo, String nombre, int hs) {
	    this.codigo = codigo;
	    this.nombre = nombre;
	    this.grupo = "";
	    //this.criterio = null;
	    this.cantidadHorasResultados = hs;
	    this.enabled = true;
    }
	
	public void editPractica(String codigo, String nombre, int hs) {
	    this.codigo = codigo;
	    this.nombre = nombre;
	    //this.grupo = "";
	    this.cantidadHorasResultados = hs;
	    //this.enabled = true;
    }

    

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

//	public Criterio getCriterio() {
//		return criterio;
//	}
//
//	public void setCriterio(Criterio criterio) {
//		this.criterio = criterio;
//	}

	public int getCantidadHorasResultados() {
		return cantidadHorasResultados;
	}

	public void setCantidadHorasResultados(int cantidadHorasResultados) {
		this.cantidadHorasResultados = cantidadHorasResultados;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


    public void addPractica() {
        // TODO implement here
    }

    public void disablePractica() {
        // TODO implement here
    }


}
