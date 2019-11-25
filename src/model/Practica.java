package model;

public class Practica {
	
    private String codigo;
    private String nombre;
    private String grupo;
    private ICriterio criterioCritico;
    private ICriterio criterioReservado;
    private int cantidadHorasResultados;
    private boolean enabled;
    
	public Practica(String codigo, String nombre, int hs, ICriterio critico, ICriterio reservado) {
	    this.codigo = codigo;
	    this.nombre = nombre;
	    this.grupo = "";
	    this.criterioCritico = critico;
	    this.criterioReservado = reservado;
	    this.cantidadHorasResultados = hs;
	    this.enabled = true;
    }
	
	public void editPractica(String codigo, String nombre, int hs, ICriterio critico, ICriterio reservado) {
	    this.codigo = codigo;
	    this.nombre = nombre;
	    this.criterioCritico = critico;
	    this.criterioReservado = reservado;
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

	public ICriterio getCriterioCritico() {
		return criterioCritico;
	}

	public void setCriterioCritico(ICriterio criterioCritico) {
		this.criterioCritico = criterioCritico;
	}

	public ICriterio getCriterioReservado() {
		return criterioReservado;
	}

	public void setCriterioReservado(ICriterio criterioReservado) {
		this.criterioReservado = criterioReservado;
	}
	
	public String toString(){
		return this.nombre.toString();
	}
}
