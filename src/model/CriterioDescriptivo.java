package model;

import java.util.List;

public class CriterioDescriptivo implements ICriterio {

    private List<String> valoresAceptados;

    public List<String> getValoresAceptados() {
		return valoresAceptados;
	}

	public void setValoresAceptados(List<String> valoresAceptados) {
		this.valoresAceptados = valoresAceptados;
	}

	public CriterioDescriptivo(List<String> valoresAceptados) {
        this.valoresAceptados = valoresAceptados;
    }

    @Override
    public boolean verificar(String resultado) {
        return valoresAceptados.stream().anyMatch(valor -> valor.equals(resultado));
    }
    
    public String toString(){
    	StringBuilder builder = new StringBuilder();
    	for (String s : this.valoresAceptados){
    		builder.append(s);
    		builder.append(",");
    	}
    	
    	return builder.toString();
    }

	@Override
	public int getMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMin() {
		// TODO Auto-generated method stub
		return 0;
	}
}
