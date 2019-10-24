package edu.eci.cnyt.calculadora;


/**
 * Autor Johann Sebastian Paez Campos
 * 2153014 
*/

public class Matriz {
	private Complejo matriz[][];
	
	/**
	 * Crea una matriz de numeros aleatorios
	 * @param filas Es el numero de filas a crear 
	 * @param columnas Es el numero de columnas a crear
	 */
	public Matriz(int filas, int columnas) {
		matriz = new Complejo[filas][columnas];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				double real = Math.floor(Math.random()*(100 - (-100) + 1) - 100);
				double imaginario = Math.floor(Math.random()*(100 - (-100) + 1) - 100);
				matriz[i][j] = new Complejo(real, imaginario);				
			}
		}
		
	}
	
	/**
	 * Constructor de la clase matriz para valores dados
	 * @param A Es la lista de numeros que se quiere tener
	 */
	public Matriz(Complejo[][] A) {
		matriz = new Complejo[A.length][A[0].length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = A[i][j];
			}
		}
	}
	
	/**
	 * Suma la matriz con una dada
	 * @param B Es la matriz a sumar 
	 * @return resultado que es la matriz resultante
	 * @throws Exception En caso de que las matrices no se puedan sumar
	 */
	public Matriz sumarMatrices(Matriz B) throws Exception {
		if (matriz.length !=  B.getMatriz().length || matriz[0].length != B.getMatriz()[0].length) {
			throw new Exception("No puede sumar matrices que no tengan las mismas lontigutdes");
		}
		
		Complejo[][] resultado = new Complejo[matriz.length][matriz[0].length];
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				resultado[i][j] = matriz[i][j].sumar(B.getMatriz()[i][j]);
			}
		}
		
		return new Matriz(resultado);
	}
	
	/**
	 * Saca la inversa de la matriz 
	 * @return retorna la matriz inversa
	 */
	public Matriz inversa() {
		Complejo[][] res = new Complejo[matriz.length][matriz[0].length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				double aux1 = -matriz[i][j].getReal(), aux2 = -matriz[i][j].getImaginario();
				if (matriz[i][j].getReal() == 0) aux1 = 0;
				if (matriz[i][j].getImaginario() == 0) aux2 = 0;
				res[i][j] = new Complejo(aux1, aux2);
			}
		}
		return new Matriz(res);
	}
	
	/**
	 * Multiplica la matriz con un escalar y la retorna
	 * @param c Es el escalar a multiplicar por la matriz
	 * @return la nueva matriz
	 */
	public Matriz multiplicacionEscalar(double c) {
		Complejo[][] res = new Complejo[matriz.length][matriz[0].length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				res[i][j] = new Complejo(c * matriz[i][j].getReal(), c * matriz[i][j].getImaginario());
			}
		}
		return new Matriz(res);
	}
	
	/**
	 * Multiplica la matriz por un escalar complejo
	 * @param c Es el numero complejo
	 * @return La matriz multiplicada por ese escalar 
	 */
	public Matriz multiplicacionEscalar2(Complejo c) {
		Complejo[][] res = new Complejo[matriz.length][matriz[0].length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				res[i][j] = matriz[i][j].multiplicar(c);
			}
		}
		return new Matriz(res);
	}
	/**
	 * Transpone la matriz
	 * @return retorna la matriz transpuesta
	 */
	public Matriz transpuesta() {
		Complejo[][] res = new Complejo[matriz[0].length][matriz.length];
		for (int i = 0; i < res.length; i ++) {
			for (int j = 0; j < res[i].length; j++) {
				res[i][j] = matriz[j][i];
			}
		}
		return new Matriz(res);
	}
	
	/**
	 * Saca la matriz conjugada
	 * @return La matriz conjugada 
	 */
	public Matriz conjugada() {
		Complejo[][] res = new Complejo[matriz.length][matriz[0].length];
		for (int i = 0; i < res.length; i ++) {
			for (int j = 0; j < res[i].length; j++) {
				res[i][j] = matriz[i][j].conjugado();
			}
		}
		return new Matriz(res);
	}
	
	/**
	 * Saca la matriz adjunta
	 * @return La matriz adjunta
	 */
	public Matriz adjunta() {
		return new Matriz(conjugada().transpuesta().getMatriz());
	}
	
	
	/**
	 * Multiplica la matriz con una dada
	 * @param B Es la matriz a multiplicar con la actual
	 * @return La nueva matriz a modificar
	 */
	public Matriz multiplicar(Matriz B) {
		Complejo[][] res = new Complejo[matriz.length][B.getMatriz()[0].length];

		for (int i = 0; i < res.length; i++) {
	    	for (int j = 0; j < res[i].length; j++) {
	    		res[i][j] = new Complejo(0,0);
	    	}
		}
		
		for (int i = 0; i < res.length; i++) {
	    	for (int j = 0; j < res[i].length; j++) {
	    		for (int k = 0; k < B.getMatriz().length; k++) {
	    			res[i][j] = res[i][j].sumar(matriz[i][k].multiplicar(B.getMatriz()[k][j]));
	    		}
	    	}
	    }

		return new Matriz(res);
	}
	
	
	/**
	 * Retorna la norma de una matriz
	 * @return retorna la raiz cuadrada del trace de la matriz con ella misma
	 */
	public double norma() {	
		return Math.sqrt(trace(this).getReal());
	}
	
	/**
	 * Retorna el trace de una matriz con otra
	 * @param B Es la otra matriz para hacer trace
	 * @return res Que es la suma de la diagonal de la adjunta multiplicada por la otra matriz
	 */
	public Complejo trace(Matriz B) {
		Complejo[][] matrizA = adjunta().multiplicar(B).getMatriz();
		Complejo res =  new Complejo(0, 0);
		for (int i = 0; i < matrizA.length; i++) {
	    	for (int j = 0; j < matrizA[i].length; j++) {
	    		if (i == j) {
	    			res = res.sumar(matrizA[i][j]);
	    		}
	    	}
		}
		return res;	
	}
	
	/**
	 * Da la distancia entre dos matrices
	 * @param B Es la otra matriz a comprar
	 * @return La distancia entre this y la otra matriz
	 * @throws Exception En caso de que no se puedan sumar las matrices
	 */
	public double distanciaEntreMatrices(Matriz B) throws Exception {
		return new Matriz(this.sumarMatrices(B.inversa()).getMatriz()).norma();
	}
	
	/**
	 * Dice si la matriz es unitaria
	 * @return true, false dependiendo de la condicion
	 */
	public boolean isUnitaria() {
		if (matriz.length != matriz[0].length) return false;
		return (this.multiplicar(adjunta()).equals(crearIdentidad(matriz.length)));
	}
	
	/**
	 * Dice si una matriz es hermitiana o no
	 * @return true, false dependiendo de la condición
	 */
	public boolean isHermitian() {
		return this.equals(adjunta());
	}
	
	/**
	 * Crea la matriz identidad de tamaño n para verificar casos de prueba y otras funcionalidades
	 * @param n Es el tamaño de la matriz identidad nxn
	 * @return Una matriz identidad de tamaño nxn
	 */
	private Matriz crearIdentidad(int n) {
		Complejo[][] res = new Complejo[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = new Complejo(0, 0);
				if (i == j) {
					res[i][j] = new Complejo(1, 0);
				}
			}
		}
		return new Matriz(res);
	}
	
	/**
	 * Imprimir la matriz
	 */
	public void imprimir() {
		System.out.println();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print("("+ matriz[i][j].getReal() + ", " + matriz[i][j].getImaginario() + ")" + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Retorna el producto tensor de la matriz con otra dada
	 * @param B Es la otra matriz
	 * @return La nueva matriz con el producto tensor
	 */
	public Matriz productoTensor(Matriz B) {
		Complejo[][] res =  new Complejo[matriz.length * B.getMatriz().length][matriz[0].length * B.getMatriz()[0].length];
		int cont = 0, cont2 = 0, auxInt = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				Complejo[][] aux = B.multiplicacionEscalar2(matriz[i][j]).getMatriz();
				auxInt = aux.length;
				for (int k = 0; k < aux.length; k++) {
					for (int l = 0; l < aux[k].length; l++) {
						res[k + cont][l + cont2] = aux[k][l];
					} 
				}
				cont2 += aux[i].length;
				if (cont2 >= res[i].length) cont2 = 0;
			}
			cont += auxInt;
			if (cont >= res.length) cont = 0;
		}
		
		return new Matriz(res);
	}
	
	
	/**
	 * Imprime la matriz deseada separada en un formato especial
	 * @param res
	 */
	public void imprimirRes(Complejo[][] res) {
		System.out.println();
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				if (res[i][j] == null) {
					System.out.println("(0,0)");
					continue;
				}
				System.out.print("("+ res[i][j].getReal() + ", " + res[i][j].getImaginario() + ")" + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Calcula el experimento de las canicas 
	 * @param clicks Es el número de clicks
	 * @param m Es la matriz del sistema
	 * @param v Es el vector estado (Estado inicial o estado0)
	 * @return Vector con el sistema ya calculado en el número de clicks dado
	 */
	public Vector experimentoCanicas(int clicks, Matriz m, Vector v) {
		for (int i = 0; i < clicks; i++) {
			v = v.multiplicacion(m);
		}
		return v;
	}
	
	/**
	 * Retorna la matriz en lista
	 * @return matriz
	 */
	public Complejo[][] getMatriz() {
		return matriz;
	}
	
	/**
	 * Verifica que el hascode de ambos objetos sea igual
	 * @param obj
	 * @return true, false depndiendo de la condicion
	 */
	@Override
	public boolean equals(Object obj) {
		return (this.hashCode() == obj.hashCode());
	}
	/**
	 * Muestra la informacion del hashcode del objeto
	 * @return hash Es la informacion obtenida
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				hash = 53 * hash + (int) (Double.doubleToLongBits(matriz[i][j].getReal()) ^ (Double.doubleToLongBits(matriz[i][j].getReal()) >>> 32));
				hash = 53 * hash + (int) (Double.doubleToLongBits(matriz[i][j].getImaginario()) ^ (Double.doubleToLongBits(matriz[i][j].getImaginario()) >>> 32));
			}
		}
		return hash;
	}
}
