package edu.eci.cnyt.calculadora;

public class Complejo {
	private double real;
	private double imaginario;
	private boolean polar = false;
	
	/**
	 * Constructor de un número complejo
	 * @param real Es la parte real del número
	 * @param imaginario Es la parte imaginaria del número
	 */
	public Complejo(double real, double imaginario) {
		if (real == 0) real = 0;
		if (imaginario == 0) imaginario = 0;
		this.real = real;
		this.imaginario = imaginario;
	}
	
	/**
	 * Retorna la parte real del número
	 * @return real
	 */
	public double getReal() {
		return real;
	}
	
	/**
	 * Retorna la parte imaginaria del número
	 * @return imaginario
	 */
	public double getImaginario() {
		return imaginario;
	}
	
	/**
	 * Retorna el módulo del número
	 * @return modulo
	 */
	public double modulo() {
		return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginario, 2));
	}
	
	/**
	 * Retorna el conjugado del numero
	 * @return conjugado
	 */
	public Complejo conjugado() {
		double aux = -imaginario;
		if (imaginario == 0) aux = 0;
		return new Complejo(real, aux);
	}
	
	/**
	 * Retorna el número convertido en Polar con el ángulo en radianes
	 * @return complejo
	 */
	public Complejo polarRadianes() {
		double modulo = modulo();
		double angulo = Math.atan(imaginario / real);
		Complejo complejo = new Complejo(modulo, angulo);
		complejo.setEstado();
		return complejo;
		
	}
	
	/**
	 * Retorna el número convertido en Polar con el ángulo en grados
	 * @return complejo
	 */
	public Complejo polarGrados() {
		double modulo = modulo();
		double angulo = 0;
		double arco = Math.atan(imaginario / real);
		arco = (arco * 180) / Math.PI;
		if (real == 0 && imaginario == 0) angulo = 0;
		else if (imaginario == 0 && real > 0) angulo = 0;
		else if (imaginario == 0 && real < 0) angulo = 180;
		else if (real == 0 && imaginario > 0) angulo = 90;
	    else if (real == 0 && imaginario < 0) angulo = 270;
	    else if (real > 0 && imaginario >0) angulo = arco;
	    else if (real < 0 && imaginario < 0) angulo = 180 + arco;
	    else if (real < 0) angulo = 180 + arco;
	    else if (imaginario < 0) angulo = 360 + arco;
		Complejo complejo = new Complejo(modulo, angulo);
		complejo.setEstado();
		return complejo;
	}
	
	/**
	 * Convierte el número de polar a cartesiano si el angulo está en radianes
	 * @return cartesiano
	 */
	public Complejo cartesianoRadianes() {
		double modulo = real;
		double angulo = imaginario;
		this.real = modulo * Math.cos(angulo);
		this.imaginario = modulo * Math.sin(angulo);
		return new Complejo(this.real, this.imaginario);
	}
	
	/**
	 * Convierte el número de polar a cartesiano si el angulo está en grados
	 * @return cartesiano
	 */
	public Complejo cartesianoGrados() {
		double modulo = real;
		double angulo = imaginario;
		angulo = (angulo * Math.PI) / 180;
		this.real = modulo * Math.cos(angulo);
		this.imaginario = modulo * Math.sin(angulo);
		return new Complejo(this.real, this.imaginario);
	}
	
	/**
	 * Retorna la fase del numero complejo
	 * @return angulo
	 */
	public Double fase() {
		double angulo = Math.atan(imaginario/real);
		
		return angulo;
	}
	
	/**
	 * Cambia el estado del numero. De polar a cartesiano y viceversa
	 */
	public void setEstado() {
		if (polar) {
			polar = false;
		} else {
			polar = true;
		}
	}
	
	/**
	 * Retorna el estado del numero
	 * @return true si es Polar, false si es cartesiano
	 */
	public boolean getEstado() {
		return polar;
	}
	
	
	/**
	 * Suma el número complejo con otro
	 * @param c1 Es el otro número complejo
	 * @return resultado De la suma de los numeros complejos 
	 */
	public Complejo sumar(Complejo c1) {
		Complejo resultado = new Complejo(this.real + c1.getReal(), this.imaginario + c1.getImaginario());
		return resultado;
	}
	
	/**
	 * Resta el número complejo con otro
	 * @param c1 Es el otro número complejo
	 * @return resultado De la resta de los numeros complejos 
	 */
	public Complejo restar(Complejo c1) {
		Complejo resultado = new Complejo(this.real - c1.getReal(), this.imaginario - c1.getImaginario());
		return resultado;
	}
	
	/**
	 * Multiplica dos numeros complejos
	 * @param c2 Es el segundo numero
	 * @return resultado que es la multiplicacion de c1 * c2 donde c1 es this
	 */
	public Complejo multiplicar(Complejo c2) {
		double real = (this.real * c2.getReal()) - (this.imaginario * c2.getImaginario());
		double imaginario = this.real * c2.getImaginario() + this.imaginario * c2.getReal();
		Complejo resultado = new Complejo(real, imaginario);
		return resultado;
	}
	
	
	/**
	 * Divide dos numeros complejos 
	 * @param c2 Es el segundo numero
	 * @return resultado que es la division de c1 / c2 donde c1 es this 
	 */
	public Complejo division(Complejo c2) {
		try {
			double real = (this.real * c2.getReal() + this.imaginario * c2.getImaginario()) / (Math.pow(c2.getReal(), 2) + (Math.pow(c2.getImaginario(), 2)));
			double imaginario = (this.imaginario * c2.getReal() - this.real * c2.getImaginario()) / (Math.pow(c2.getReal(), 2) + (Math.pow(c2.getImaginario(), 2)));
			Complejo resultado = new Complejo(real, imaginario);
			return resultado;
		} catch (Exception e) {
			System.out.println("División por cero");
			return null;
		}
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
		hash = 53 * hash + (int) (Double.doubleToLongBits(this.real) ^ (Double.doubleToLongBits(this.real) >>> 32));
		hash = 53 * hash + (int) (Double.doubleToLongBits(this.imaginario) ^ (Double.doubleToLongBits(this.imaginario) >>> 32));
		return hash;
	}
	
}
