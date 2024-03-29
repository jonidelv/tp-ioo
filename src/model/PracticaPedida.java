package model;

public class PracticaPedida {

    private Practica practica;
    private String resultado;

    public PracticaPedida(Practica practica, String resultado) {
		this.practica = practica;
		this.resultado = resultado;
	}

	public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public boolean esCritica() {
        return practica.getCriterioCritico().verificar(resultado);
    }

    public boolean esReservada() {
        return  practica.getCriterioReservado().verificar(resultado);
    }
    
    public String toString(){
    	return this.practica.getNombre();
    }
}
