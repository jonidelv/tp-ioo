package model;

import java.util.List;

public class CriterioDescriptivo implements ICriterio {

    public List<String> valoresAceptados;

    public CriterioDescriptivo(List<String> valoresAceptados) {
        this.valoresAceptados = valoresAceptados;
    }

    @Override
    public boolean verificar(String resultado) {
        return valoresAceptados.stream().anyMatch(valor -> valor.equals(resultado));
    }
}
