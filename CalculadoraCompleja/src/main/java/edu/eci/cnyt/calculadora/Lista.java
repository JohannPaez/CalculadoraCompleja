package edu.eci.cnyt.calculadora;


public class Lista {
    private Complejo peso;
    private int adyacencia;
    
    public Lista(int adyacencia,Complejo peso){
        this.peso = peso;
        this.adyacencia = adyacencia;        
    }
    public Complejo getPeso(){
        return peso;
    }
    public int getAdy(){
        return adyacencia;
    }
    public void setPeso(Complejo peso){
        this.peso = peso;        
    }
    
    
}