package mx.edu.itspa.tics.indicemasacorporal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian Rodriguez
 */
public class ServicioIMC {
    private List <TareaIMC> listaCalculos = new ArrayList<>();
    
    public boolean agregarCalculo(TareaIMC calculo){
        listaCalculos.add(calculo);
        return true;
    }
    
    public List<TareaIMC> obtenerCalculos(){
        return listaCalculos;
    }
    
    public boolean eliminarCalculo (int indice){
        if(indice >= 0 && indice < listaCalculos.size()) {
            listaCalculos.remove(indice);
            return true;
        }
        return false;
    }
}
