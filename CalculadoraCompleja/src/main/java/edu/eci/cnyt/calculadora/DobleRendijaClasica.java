
package edu.eci.cnyt.calculadora;


/**
 * Autor Johann Sebastian Paez Campos
 * 2153014 
*/

public class DobleRendijaClasica {
    private double[][] matriz;
    private double[] estado0;
    private int blancos,rendijas;
    
    
    /**
     * Constructor de la clase DobleRendijaClasica
     * @param rendijas Es el númeor de rendijas 
     * @param blancos Es el número de blancos
     * @param adyacencia Es la lista de adyacencia
     */
    public DobleRendijaClasica(int rendijas, int blancos, int[][] adyacencia) { 
        this.rendijas = rendijas;
        this.blancos = blancos;
        estado0 = calcularEstadoInicial();
        matriz = new double[adyacencia.length][adyacencia.length];
        for(int i = 0; i < adyacencia.length; i++) for(int j: adyacencia[i]) {
            if(j>=rendijas && i == 0) matriz[j-1][i] = (double)Math.round((1d/rendijas) * 10d) / 10d ;
            else if(i>0 && i<=rendijas) matriz[j-1][i] = (double)Math.round((1d/3) * 10d) / 10d;
            else matriz[j-1][i] = 1;
        }
    
        
    }
    
    /**
     * Imprime la matriz 
     * @param matriz
     */
    public static void imprimirMatriz(double [][] matriz){
        System.out.print("\n ");
        for (int i = 0; i < matriz.length; i++) System.out.print("   "+(i));
        for(int i = 0; i< matriz.length; i++) {
            System.out.print("\n"+(i)+"| ");
            for (int j = 0; j<matriz.length;j++)System.out.print(matriz[i][j]+" ");
            System.out.print("|");
        }
    }
    
    /**
     * Imprime el estado actual o el estado0 por defecto
     * @param estado0
     */
    public static void imprimirEstado(double[] estado0){
        System.out.print("\n  ");
        for(int i = 0; i< estado0.length; i++) {
            System.out.print("\n"+(i)+"| ");
            System.out.print(estado0[i]+" ");
            System.out.print("|");
        }
    }
    
    /**
     * Da un click en la simulacion
     * @param n Es el número de clicks
     * @return Una lista que será el número estado
     */
    public double[] click(int n){
        double[] y = estado0;
        for(int i=0; i<n; i++){
            y = multiplicarVector(y);
        }
        return y;
    }
    
    /**
     * Retorna el estado
     * @return estado0
     */
    public double[] getEstado(){
        return estado0;
    }
    
    /**
     * Retorna la matriz
     * @return matriz
     */
    public double[][] getMatriz(){
        return matriz;
    }
    
    /**
     * multiplica el vector con la matriz
     * @param y Es el vector "Estado"
     * @return aux que es el nuevo estado
     */
    private double[] multiplicarVector(double[] y){
        double[] aux =  new double[y.length];
        for (int i = 0; i < matriz.length; i++){
            double cont = 0;
            for (int j = 0; j < matriz.length; j++){
                cont += (double)Math.round(matriz[i][j]*y[j]*10d)/10d; 
            }
            aux[i] = cont;
        }
        return aux;
    }
    
    /**
     * Calcula el estado inicial del sistema
     * @return
     */
    private double[] calcularEstadoInicial(){
    	int l = this.blancos;
        double[] aux = new double[rendijas+l+1];
        aux[0] = 1;
        return aux;
    }
}
