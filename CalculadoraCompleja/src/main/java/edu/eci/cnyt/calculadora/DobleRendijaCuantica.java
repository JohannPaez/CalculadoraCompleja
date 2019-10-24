package edu.eci.cnyt.calculadora;


/**
 * Autor Johann Sebastian Paez Campos
 * 2153014 
*/

public class DobleRendijaCuantica {
	private Complejo[][] matriz;
	private Complejo[] estado0;
	private int blancos, rendijas;

	
	/**
	 * Constructor de la clase DobleRendijaCuantica
	 * @param rendijas Es el número de rendijas
	 * @param blancos Es el númeor de blancos
	 * @param adyacencia Es la lista de adyacencia que se utiliza como una tupla
	 */
	public DobleRendijaCuantica(int rendijas, int blancos, Lista[][] adyacencia) {
		this.rendijas = rendijas;
		this.blancos = blancos;
		estado0 = hallarEstadoInicial();
		matriz = hallarMatrizInicial();
		for (int i = 0; i < adyacencia.length; i++)
			for (Lista j : adyacencia[i]) {
				if (j.getAdyacencia() >= rendijas && i >= 0 && i <= rendijas)
					matriz[j.getAdyacencia() - 1][i] = j.getPeso();
				else
					matriz[j.getAdyacencia() - 1][i] = new Complejo(1, 0);
			}

	}
	
	/**
	 * Imprime la matriz
	 * @param matriz
	 */
	public static void imprimirMatriz(Complejo[][] matriz) {
		System.out.print("\n ");
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("\n" + (i) + "| ");
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j].imprimir();
			}
			System.out.print("|\n");
		}
	}
	
	/**
	 * Imprime el estado actual o el estado inicial (estado0) por defecto
	 * @param estado0
	 */
	public static void imprimirEstado(Complejo[] estado0) {
		System.out.print("\n  ");
		for (int i = 0; i < estado0.length; i++) {
			System.out.print("\n" + (i) + "| ");
			estado0[i].imprimir();
			System.out.print("|");
		}
	}

	/**
	 * Da clicks en el sistema
	 * @param n Es el npumero de clicks
	 * @return El nuevo estado
	 */
	public Complejo[] click(int n) {
		Complejo[] y = estado0;
		for (int i = 0; i < n; i++) {
			y = multiplicarVector(y);
		}
		return y;
	}
	
	
	/**
	 * Retorna el estado actual o el estado inicial (estado0) por defecto
	 * @return estado0
	 */
	public Complejo[] getEstado() {
		return estado0;
	}
	
	/**
	 * Retorna la matriz del sistema
	 * @return matriz
	 */
	public Complejo[][] getMatriz() {
		return matriz;
	}
	
	
	/**
	 * Multiplica el vector con la matriz para calcular el estado
	 * @param estado Es el estado actual
	 * @return retorna el nuevo estado
	 */
	private Complejo[] multiplicarVector(Complejo[] estado) {
		Complejo[] aux = new Complejo[estado.length];
		for (int i = 0; i < matriz.length; i++) {
			Complejo cont = new Complejo(0, 0);
			for (int j = 0; j < matriz.length; j++) {
				CalculadoraCompleja.sumar(cont, CalculadoraCompleja.multiplicar(estado[j], matriz[i][j]));
			}
			aux[i] = cont;
		}
		return aux;
	}
	
	/**
	 * Halla la matriz del estaod inicial del sistema
	 * @return Retorna una matriz de complejos
	 */
	private Complejo[][] hallarMatrizInicial() {
		Complejo[][] aux = new Complejo[rendijas + blancos + 1][rendijas + blancos + 1];
		for (int i = 0; i < rendijas + blancos + 1; i++)
			for (int j = 0; j < rendijas + blancos + 1; j++)
				aux[i][j] = new Complejo(0, 0);
		return aux;
	}
	
	/**
	 * Halla el estado inicial
	 * @return Retorna una lista de complejos
	 */
	private Complejo[] hallarEstadoInicial() {
		Complejo[] aux = new Complejo[rendijas + blancos + 1];
		for (int i = 0; i < aux.length; i++) {
			if (i == 0)
				aux[i] = new Complejo(1, 0);
			else
				aux[i] = new Complejo(0, 0);
		}
		return aux;
	}
}