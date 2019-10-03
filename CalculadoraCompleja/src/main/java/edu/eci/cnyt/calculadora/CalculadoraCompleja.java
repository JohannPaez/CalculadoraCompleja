package edu.eci.cnyt.calculadora;

import java.util.*;

public class CalculadoraCompleja {
	/**
	 * Constructor de la calculadora que muestra solo algunos datos deseados
	 * @param pruebas Dice si se muestran o no los datos en caso de que sea prueba
	 */
	public CalculadoraCompleja(boolean pruebas) {
		if (pruebas) return;
		Complejo resultado;
		Complejo c1 =  new Complejo(4, 3);
		Complejo c2=  new Complejo(-4, -5);
		resultado = sumar(c1, c2);
		System.out.println("El resultado de sumar c1 con c2 es: " + resultado.getReal() + " " + resultado.getImaginario() + "i");
		resultado = restar(c1, c2);
		System.out.println("El resultado de restar c1 con c2 es: " + resultado.getReal() + " " + resultado.getImaginario() + "i");
		resultado = multiplicar(c1, c2);
		System.out.println("El resultado de multiplicar c1 con c2 es: " + resultado.getReal() + " " + resultado.getImaginario() + "i");
		resultado = division(c1, c2);
		System.out.println("El resultado de dividir c1 entre c2 es: " + resultado.getReal() + " " + resultado.getImaginario() + "i");
		double resultadoModulo = modulo(c1);
		System.out.println("El resultado del modulo de c1 es: " + resultadoModulo);
		resultado = conjugado(c2);
		System.out.println("El conjugado de c2 es: " + resultado.getReal() + " " + resultado.getImaginario() + "i");
		/*Complejo[][] C = new Complejo[][] {{new Complejo(1,0),new Complejo(2,0),new Complejo(3,0)}, {new Complejo(4,0),new Complejo(5,0),new Complejo(6,0)}};
		Complejo[][] D = new Complejo[][] {{new Complejo(1,0),new Complejo(2,0)},{new Complejo(3,0), new Complejo(4,0)},{new Complejo(5,0),new Complejo(6,0)}};
		Complejo[][] E = new Complejo[][] {{new Complejo(1,0), new Complejo(1,0)}, {new Complejo(0,0), new Complejo(1,0)}};
		
		boolean isTrue = new Matriz(E).isUnitaria();
		System.out.println(isTrue);
		isTrue = new Matriz(E).isHermitian();
		System.out.println(isTrue);
		
		Matriz A = new Matriz(C);
		Matriz B = new Matriz(D);
		Matriz z = A.multiplicar(B);
		z.imprimir();
		
		Matriz prueba = new Matriz(E);
		
		//prueba.transpuesta().imprimir();
		System.out.println(prueba.norma());
		prueba.imprimir();
		
		System.out.println(new Complejo(8, -3).fase());
		
		//Matriz sumarMatrices = sumarMatrices(A, B);
		
		//A.imprimir();
		//B.imprimir();
		//sumarMatrices.imprimir();
		//new Vector();*/
		double[][] Alista = new double[][] {{-1,-4},{2,-3},{-7,6},{-1,1},{-5,-3},{5,0},{5,8},{4,-4},{8,-7},{2,-7}};
		Vector A = new Vector(Alista);
		double[][] Blista = new double[][] {{2,1},{-1,2},{0,1},{1,0},{3,-1},{2,0},{0,-2},{-2,1},{1,-3},{0,-1}};
		Vector B = new Vector(Blista);
		Complejo C = A.multiplicacion(B);
		C.imprimir();
		
	}
	

	
	/**
	 * Suma dos numeros complejos
	 * @param c1 Es el primer numero 
	 * @param c2 Es el segundo numero
	 * @return resultado que es la suma de c1 + c2
	 */
	public Complejo sumar(Complejo c1, Complejo c2) {
		return c1.sumar(c2);
	}
	
	/**
	 * Resta dos numeros complejos
	 * @param c1 Es el primer numero 
	 * @param c2 Es el segundo numero
	 * @return resultado que es la resta de c1 - c2
	 */
	public Complejo restar(Complejo c1, Complejo c2) {
		return c1.restar(c2);
	}
	
	/**
	 * Multiplica dos numeros complejos
	 * @param c1 Es el primer numero 
	 * @param c2 Es el segundo numero
	 * @return resultado que es la multiplicacion de c1 * c2
	 */
	public Complejo multiplicar(Complejo c1, Complejo c2) {
		return c1.multiplicar(c2);
	}
	
	
	/**
	 * Divide dos numeros complejos
	 * @param c1 Es el primer numero 
	 * @param c2 Es el segundo numero
	 * @return resultado que es la division de c1 / c2
	 */
	public Complejo division(Complejo c1, Complejo c2) {
		return c1.division(c2);
	}
	
	/**
	 * Da el modulo o magnitud de un numero complejo
	 * @param c1 Es el numero
	 * @return El modulo del numero complejo
	 */
	public double modulo(Complejo c1) {
		return c1.modulo();
	}
	
	/**
	 * Retorna el conjugado de un numero complejo
	 * @param c1 Es el numero
	 * @return El conjugado del numero 
	 */
	public Complejo conjugado(Complejo c1) {
		return c1.conjugado();
	}
	
	/**
	 * Convierte un numero complejo en coordenadas cartesianas a polares (angulo en radianes)
	 * @param c1 Es el numero complejo
	 * @return El numero en coordenadas polares 
	 */
	public Complejo polarRadianes(Complejo c1) {
		return c1.polarRadianes();
	}
	
	
	/**
	 * Convierte un numero complejo en coordenadas cartesianas a polares (angulo en grados)
	 * @param c1 Es el numero complejo
	 * @return El numero en coordenadas polares 
	 */
	public Complejo polarGrados(Complejo c1) {
		return c1.polarGrados();
	}
	
	/**
	 * Convierte un numero complejo en coordenadas polares a cartesianas (angulo en radianes)
	 * @param c1 Es el numero complejo
	 * @return El numero en coordenadas cartesianas 
	 */
	public Complejo cartesianoRadianes(Complejo c1) {
		return c1.cartesianoRadianes();
	}
	
	/**
	 * Convierte un numero complejo en coordenadas polares a cartesianas (angulo en grados)
	 * @param c1 Es el numero complejo
	 * @return El numero en coordenadas cartesianas 
	 */
	public Complejo cartesianoGrados(Complejo c1) {
		return c1.cartesianoGrados();
	}
	
	/**
	 * Retorna la fase de un numero complejo
	 * @param c1 Es el numero 
	 * @return La fase del numero complejo
	 */
	public double fase(Complejo c1) {
		return c1.fase(); 
	}
	
	
	/**
	 * Suma dos vectores 
	 * @param A Es el vector A 
	 * @param B Es el vector B
	 * @return Retorna un vector con la suma
	 */
	public Vector sumarVectores(Vector A, Vector B) {
		try {
			return A.sumarVectores(B);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Calcula la inversa de un vector
	 * @param A Es el vector
	 * @return La inversa del vector A
	 */
	public Vector inversaVector(Vector A) {
		return A.inversa();
	}
	
	/**
	 * Multiplica un vector por un escalar
	 * @param A Es el vector
	 * @param c Es el escalar 
	 * @return Un vector con la multiplicacion escalar
	 */
	public Vector multiplicacionEscalarVector(Vector A, double c) {
		return A.multiplicacionEscalar(c);
	}
	
	/**
	 * Suma matrices
 	 * @param A Es la matriz A
	 * @param B Es la matriz B
	 * @return Una matriz con la suma de A y B
	 */
	public Matriz sumarMatrices(Matriz A, Matriz B) {
		try {
			return A.sumarMatrices(B);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * Saca la inversa de una matriz
	 * @param A Es la matriz
	 * @return Una matriz que es la inversa de A
	 */
	public Matriz inversaMatriz(Matriz A) {
		return A.inversa();
	}
	
	/**
	 * Multiplica una matriz por un escalar
	 * @param A Es la matriz
	 * @param c Es el escalar 
	 * @return Una matriz con la multiplicacion escalar 
	 */
	public Matriz multiplicacionEscalaMatriz(Matriz A, double c) {
		return A.multiplicacionEscalar(c);
	}

	/**
	 * Transpone la matriz deseada
	 * @param A Es la matriz 
	 * @return La nueva matriz que es la transpuesta de A
	 */
	public Matriz matrizTranspuesta(Matriz A) {
		return A.transpuesta();
	}
	
	/**
	 * Conjuga la matriz deseada
	 * @param A Es la matriz 
	 * @return La conjugada de A
	 */
	public Matriz matrizConjugada(Matriz A) {
		return A.conjugada();
	}
	
	/**
	 * Calcula la matriz adjunta
	 * @param A Es la matriz procesar
	 * @return La matriz adjaunta de A
	 */
	public Matriz matrizAdjunta(Matriz A) {
		return A.adjunta();
	}
	
	
	/**
	 * Calcula la accion de una matriz sobre un vector
	 * @param A Es la matriz
	 * @param B Es el vector
	 * @return Retorna un vector que es la accion de la matriz sobre el vector
	 */
	public Vector accionMatrizVector(Matriz A, Vector B) {
		return B.multiplicacion(A);
	}
	
	
	/**
	 * Calcula la norma de la matriz deseada
	 * @param A Es la matriz
	 * @return Un double que es la norma de la matriz
	 */
	public double normaMatriz(Matriz A) {
		return A.norma();
	}
	
	/**
	 * Calcula la distancia entre dos matrices
	 * @param A Es la matriz A 
	 * @param B Es la matriz B
	 * @return Retorna un double con la distancia entre A y B
	 */
	public double distanciaEntreMatrices(Matriz A, Matriz B) {
		try {
			return A.distanciaEntreMatrices(B);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Dice si la matriz deseada es unitaria
	 * @param A Es la matriz a revisar
	 * @return true, false dependiendo de la condicion
	 */
	public boolean esMatrizUnitaria(Matriz A) {
		return A.isUnitaria();
	}
	
	/**
	 * Dice si una matriz es hermitiana
	 * @param A Es la matriz a revisar
	 * @return true, false dependiendo de la condicion
	 */
	public boolean esMatrizHermitian(Matriz A) {
		return A.isHermitian();
	}
	
	
	/**
	 * Calcula el producto tensor entre dos matrices
	 * @param A Es la matriz A
	 * @param B Es la matriz B
	 * @return Una matriz con el producto tensor entre A y B
	 */
	public Matriz productoTensor(Matriz A, Matriz B) {
		return A.productoTensor(B);
	}
	
	
	public static void main(String[] args) {
		new CalculadoraCompleja(false);
	}
}
