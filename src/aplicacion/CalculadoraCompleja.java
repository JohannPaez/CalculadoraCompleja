package aplicacion;

import java.util.*;

public class CalculadoraCompleja {
	
	private Complejo A[][] = new Complejo[3][4]; // Matriz A
	//private ArrayList<ArrayList<Complejo>> MatrizB;
	private Complejo B[][] = new Complejo[3][4]; // Matriz B
	
	
	
	
	/**
	 * Constructor de la calculadora que muestra solo algunos datos deseados
	 * @param pruebas Dice si se muestran o no los datos en caso de que sea prueba
	 */
	public CalculadoraCompleja(boolean pruebas) {
		if (pruebas) return;
		Complejo resultado;
		Complejo c1 =  new Complejo(0, 1);
		Complejo c2=  new Complejo(0, -1);
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
		prepareMatrices();
		try {
			sumarMatrices(A, B);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void prepareMatrices() {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				double real = Math.floor(Math.random()*(100 - (-100) + 1) - 100);
				double imaginario = Math.floor(Math.random()*(100 - (-100) + 1) - 100);
				A[i][j] = new Complejo(real, imaginario);				
			}
		}
		
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[i].length; j++) {
				double real = Math.floor(Math.random()*(100 - (-100) + 1) - 100);
				double imaginario = Math.floor(Math.random()*(100 - (-100) + 1) - 100);
				B[i][j] = new Complejo(real, imaginario);				
			}
		}
		
		System.out.println("Matriz A");
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				System.out.print("("+ A[i][j].getReal() + ", " + A[i][j].getImaginario() + ")" + " ");
			}
			System.out.println();
		}
		
		System.out.println("Matriz B");
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[i].length; j++) {
				System.out.print("("+ B[i][j].getReal() + ", " + B[i][j].getImaginario() + ")" + " ");
			}
			System.out.println();
		}
	}
	
	
	public void sumarMatrices(Complejo[][] A, Complejo[][] B) throws Exception {
		if (A.length !=  B.length || A[0].length != B[0].length) {
			throw new Exception("No puede sumar matrices que no tengan el mismo tamaño");
		}
		
		Complejo[][] resultado = new Complejo[A.length][A[0].length];
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				resultado[i][j] = sumar(A[i][j], B[i][j]);
			}
		}
		
		System.out.println("Resultado");
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				System.out.print("("+ resultado[i][j].getReal() + ", " + resultado[i][j].getImaginario() + ")" + " ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * Suma dos numeros complejos
	 * @param c1 Es el primer numero 
	 * @param c2 Es el segundo numero
	 * @return resultado que es la suma de c1 + c2
	 */
	public Complejo sumar(Complejo c1, Complejo c2) {
		Complejo resultado = new Complejo(c1.getReal() + c2.getReal(), c1.getImaginario() + c2.getImaginario());
		return resultado;
	}
	
	/**
	 * Resta dos numeros complejos
	 * @param c1 Es el primer numero 
	 * @param c2 Es el segundo numero
	 * @return resultado que es la resta de c1 - c2
	 */
	public Complejo restar(Complejo c1, Complejo c2) {
		Complejo resultado = new Complejo(c1.getReal() - c2.getReal(), c1.getImaginario() - c2.getImaginario());
		return resultado;
	}
	
	/**
	 * Multiplica dos numeros complejos
	 * @param c1 Es el primer numero 
	 * @param c2 Es el segundo numero
	 * @return resultado que es la multiplicacion de c1 * c2
	 */
	public Complejo multiplicar(Complejo c1, Complejo c2) {
		double real = (c1.getReal() * c2.getReal()) - (c1.getImaginario() * c2.getImaginario());
		double imaginario = c1.getReal() * c2.getImaginario() + c1.getImaginario() * c2.getReal();
		Complejo resultado = new Complejo(real, imaginario);
		return resultado;
	}
	
	
	/**
	 * Divide dos numeros complejos
	 * @param c1 Es el primer numero 
	 * @param c2 Es el segundo numero
	 * @return resultado que es la division de c1 / c2
	 */
	public Complejo division(Complejo c1, Complejo c2) {
		try {
			double real = (c1.getReal() * c2.getReal() + c1.getImaginario() * c2.getImaginario()) / (Math.pow(c2.getReal(), 2) + (Math.pow(c2.getImaginario(), 2)));
			double imaginario = (c1.getImaginario() * c2.getReal() - c1.getReal() * c2.getImaginario()) / (Math.pow(c2.getReal(), 2) + (Math.pow(c2.getImaginario(), 2)));
			Complejo resultado = new Complejo(real, imaginario);
			return resultado;
		} catch (Exception e) {
			System.out.println("División por cero");
			return null;
		}
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
	
	
	public static void main(String[] args) {
		new CalculadoraCompleja(false);
	}
}
