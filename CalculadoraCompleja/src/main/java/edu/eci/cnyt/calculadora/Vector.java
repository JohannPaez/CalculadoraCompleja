package edu.eci.cnyt.calculadora;

public class Vector {
	private Complejo vector[];
	
	/**
	 * Constructor de la clase vector
	 * @param num Es el numero de elementos aleatorios que tendrá el vector
	 */
	public Vector(int num) {
		vector = new Complejo[num];
		
		for (int i = 0; i < vector.length; i++) {
			double real = Math.floor(Math.random()*(100 - (-100) + 1) - 100);
			double imaginario = Math.floor(Math.random()*(100 - (-100) + 1) - 100);
			vector[i] = new Complejo(real, imaginario);				
		}
		
	}
	
	/**
	 * Constructor de la clase vector para valores dados
	 * @param A Es el vector con los valores dados
	 */
	public Vector(Complejo[] A) {
		vector = new Complejo[A.length];
		
		for (int i = 0; i < vector.length; i++) {
			vector[i] = A[i];
		}
	}
	
	
	/**
	 * Suma dos vectores y los retorna
	 * @param B Es el otro vector a sumar
	 * @return Un nuevo vector con la suma de los vectores
	 * @throws Exception En caso de que los dos vectores sean diferentes
	 */
	public Vector sumarVectores(Vector B) throws Exception {
		if (vector.length !=  B.getVector().length) {
			throw new Exception("No puede sumar matrices que no tengan el mismo tamaï¿½o");
		}
		
		Complejo[] resultado = new Complejo[vector.length];
		for (int i = 0; i < resultado.length; i++) {
			resultado[i] = vector[i].sumar(B.getVector()[i]);
			
		}
		return new Vector(resultado);
	}
	
	
	/**
	 * Realiza la inversa de un vector
	 * @return El nuevo vector con su inversa
	 */
	public Vector inversa() {
		Complejo[] res = new Complejo[vector.length];
		for (int i = 0; i < vector.length; i++) {
			double aux1 = -vector[i].getReal(), aux2 = -vector[i].getImaginario();
			if (vector[i].getReal() == 0) aux1 = 0;
			if (vector[i].getImaginario() == 0) aux2 = 0;
			res[i] = new Complejo(aux1, aux2);
		}
		return new Vector(res);
	}
	
	/**
	 * Multiplica el vector con un escalar y la retorna
	 * @param c Es el escalar a multiplicar por el vector
	 * @return el nuevo vector
	 */
	public Vector multiplicacionEscalar(double c) {
		Complejo[] res = new Complejo[vector.length];
		for (int i = 0; i < vector.length; i++) {
			res[i] = new Complejo(c * vector[i].getReal(), c * vector[i].getImaginario());	
		}
		return new Vector(res);
	}
	
	/**
	 * Multiplica el vector con un escalar y la retorna
	 * @param c Es el numero complejo
	 * @return El nuevo vector
	 */
	public Vector multiplicacionEscalar2(Complejo c) {
		Complejo[] res = new Complejo[vector.length];
		for (int i = 0; i < vector.length; i++) {
			res[i] = vector[i].multiplicar(c);
		}
		return new Vector(res);
	}
	
	
	/**
	 * Multiplica el vector por una matriz (la accion)
	 * @param A Es la matriz
	 * @return El nuevo vector resultante
	 */
	public Vector multiplicacion(Matriz A) {
		Complejo[] res = new Complejo[vector.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = new Complejo(0, 0);
		}
		
		for (int i = 0; i < A.getMatriz().length; i++) {
			for (int j = 0; j < A.getMatriz()[i].length; j++) {
					res[i] = res[i].sumar(A.getMatriz()[i][j].multiplicar(vector[j]));
				}
			}
		
		return new Vector(res);
	}
	
	
	/**
	 * Imprimir el vector
	 */
	public void imprimir() {
		System.out.println();
		for (int i = 0; i < vector.length; i++) {
				System.out.print("("+ vector[i].getReal() + ", " + vector[i].getImaginario() + ")" + " ");
		}
		System.out.println();
	}
	
	
	/**
	 * Retorna el vector en lista
	 * @return vector
	 */
	public Complejo[] getVector() {
		return vector;
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
		for (int i = 0; i < vector.length; i++) {
			hash = 53 * hash + (int) (Double.doubleToLongBits(vector[i].getReal()) ^ (Double.doubleToLongBits(vector[i].getReal()) >>> 32));
			hash = 53 * hash + (int) (Double.doubleToLongBits(vector[i].getImaginario()) ^ (Double.doubleToLongBits(vector[i].getImaginario()) >>> 32));
		}
		return hash;
	}
}
