package edu.eci.cnyt.calculadora;



/**
 * Autor Johann Sebastian Paez Campos
 * 2153014 
*/

/**
 * Lista para ser trabajada como una tupla para facilidad del programa
 */
public class Lista {
    private Complejo peso;
    private int adyacencia;
    
    /**
     * El constructor de la clase lista
     * @param adyacencia Es el número de vecinos adyacentes
     * @param peso Es el peso o el número complejo
     */
    public Lista(int adyacencia,Complejo peso){
        this.peso = peso;
        this.adyacencia = adyacencia;        
    }
    
    /**
     * Retorna el peso del complejo
     * @return peso (Que es el número complejo)
     */
    public Complejo getPeso(){
        return peso;
    }
    
    /**
     * Retorna el número de adyacentes dado
     * @return adyacencia
     */
    public int getAdyacencia(){
        return adyacencia;
    }
    
    /**
     * Cambia el peso del complejo en caso de ser necesario
     * @param peso
     */
    public void setPeso(Complejo peso){
        this.peso = peso;        
    }
    
    /**
     * Cambia el número de adyacentes en caso de ser necesario
     * @param adyacencia
     */
    public void setAdyacencia(int adyacencia) {
    	this.adyacencia = adyacencia;
    }
    
    
}