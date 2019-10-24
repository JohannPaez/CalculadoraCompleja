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
     * @param adyacencia Es el n�mero de vecinos adyacentes
     * @param peso Es el peso o el n�mero complejo
     */
    public Lista(int adyacencia,Complejo peso){
        this.peso = peso;
        this.adyacencia = adyacencia;        
    }
    
    /**
     * Retorna el peso del complejo
     * @return peso (Que es el n�mero complejo)
     */
    public Complejo getPeso(){
        return peso;
    }
    
    /**
     * Retorna el n�mero de adyacentes dado
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
     * Cambia el n�mero de adyacentes en caso de ser necesario
     * @param adyacencia
     */
    public void setAdyacencia(int adyacencia) {
    	this.adyacencia = adyacencia;
    }
    
    
}