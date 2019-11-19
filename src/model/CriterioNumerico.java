package model;

public class CriterioNumerico implements ICriterio {
	
    private int min;
    private int max;
    
    public CriterioNumerico(int min, int max) {
    	this.min = min;
    	this.max = max;
    }

    public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Override
    public boolean verificar(String resultado) {
        int numRes = Integer.parseInt(resultado);

        return min >= numRes && numRes <= max;
    }
}
