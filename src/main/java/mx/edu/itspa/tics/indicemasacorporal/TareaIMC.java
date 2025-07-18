package mx.edu.itspa.tics.indicemasacorporal;

import java.time.LocalDate;


/**
 *
 * @author Adrian Rodriguez
 */
public class TareaIMC {

    private String nombre;
    private double peso;
    private double estatura;
    private double imc;
    private String resultado;
    private LocalDate fecha;

    public TareaIMC(String nombre, double peso, double estatura) {
        this.nombre = nombre;
        this.peso = peso;
        this.estatura = estatura;
        this.fecha = LocalDate.now();
        calcularImc();
    }

    private void calcularImc() {
        this.imc = peso / (estatura*estatura);
        if(imc<18.5){
            resultado = "Bajo peso"; 
        } else if(imc >=18.5 && imc < 24.9) {
            resultado = "Peso normal";
        } else if (imc >=25 && imc < 29.9){
            resultado = "Sobrepeso";
        } else {
            resultado = "Obesidad";
        } 
    }
    /**
     *
     * @return
     */
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
         this.fecha = fecha;
     }

    public String getNombre(){
        return nombre;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public double getEstatura(){
        return estatura;
    }
    
    public double getImc(){
        return imc;
    }
    
    public String getResultado(){
        return resultado;
    }
}
