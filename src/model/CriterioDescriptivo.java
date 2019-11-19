package model;

import java.util.List;

public class CriterioDescriptivo implements ICriterio {

    public List<String> valoresCriticos;
    public List<String> valoresReservados;
    public List<String> valoresAceptados;
	
    public CriterioDescriptivo() {
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
