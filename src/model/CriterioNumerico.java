package model;

public class CriterioNumerico implements ICriterio {
	
    public int criticoInf;
    public int criticoSup;
    public int reservadoInf;
    public int reservadoSup;
    
    public CriterioNumerico() {
    	
    }

    public void addCriterio() {
        // TODO implement here
    }

    public void removeCriterio() {
        // TODO implement here
    }


    @Override
    public boolean verificar(String resultado) {
        return false;
    }
}
