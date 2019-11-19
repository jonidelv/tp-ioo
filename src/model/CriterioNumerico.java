package model;

public class CriterioNumerico implements ICriterio {
	
    public int min;
    public int max;
    
    public CriterioNumerico(int min, int max) {
    	this.min = min;
    	this.max = max;
    }

    @Override
    public boolean verificar(String resultado) {
        int numRes = Integer.parseInt(resultado);

        return min >= numRes && numRes <= max;
    }
}
