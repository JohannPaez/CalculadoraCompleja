package pruebas;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class PruebasCalculadoraCompleja {
	
	public static final double MAXERROR = 0.00000000000001;
	private Complejo c1 = new Complejo(2,3), c2 = new Complejo(5,-5), c3 = new Complejo(-4,7), c4 = new Complejo(-2,-2);
	private CalculadoraCompleja calculadora = new CalculadoraCompleja(true);	
	
	@Test
	public void deberiaSumarComplejos() {
		Complejo suma = calculadora.sumar(c1, c2);
		Complejo resultado = new Complejo(7, -2);
		assertTrue(suma.equals(resultado));
		suma = calculadora.sumar(c3, c2);
		assertTrue(suma.equals(new Complejo(1, 2)));
	}
	
	@Test
	public void deberiaRestarComplejos() {
		Complejo resta = calculadora.restar(c1, c2);
		Complejo resultado = new Complejo(-3, 8);
		assertTrue(resta.equals(resultado));
		resta = calculadora.restar(c3, c2);
		assertTrue(resta.equals(new Complejo(-9, 12)));
	}
	
	@Test
	public void deberiaMultiplicarComplejos() {
		Complejo multiplicacion = calculadora.multiplicar(c2, c4);
		Complejo resultado = new Complejo(-20, 0);
		assertTrue(multiplicacion.equals(resultado));
		multiplicacion = calculadora.multiplicar(c3, c2);
		assertTrue(multiplicacion.equals(new Complejo(15, 55)));
	}
	
	@Test
	public void deberiaDividirComplejos() {
		Complejo dividir = calculadora.division(c2, c4);
		Complejo resultado = new Complejo(0, 5/2.0);
		assertTrue(dividir.equals(resultado));
		dividir = calculadora.division(c3, c2);
		assertTrue(dividir.equals(new Complejo(-11/10.0, 3/10.0)));
	}
	
	@Test
	public void deberiaDarModulo() {
		double modulo1 = calculadora.modulo(c1);
		double modulo2 = calculadora.modulo(c2);
		double modulo3 = calculadora.modulo(c3);
		double modulo4 = calculadora.modulo(c4);
		
		assertTrue(modulo1 == Math.sqrt(13));
		assertTrue(modulo2 == 5 * Math.sqrt(2));
		assertTrue(modulo3 == Math.sqrt(65));
		assertTrue(modulo4 == 2 * Math.sqrt(2));
	}
	
	@Test
	public void deberiaDarConjugado() {
		Complejo conjugado = calculadora.conjugado(c1);
		Complejo conjugado2 = calculadora.conjugado(c2);
		
		assertTrue(conjugado.getReal() == 2);
		assertTrue(conjugado.getImaginario() == -3);
		assertTrue(conjugado2.getReal() == 5);
		assertTrue(conjugado2.getImaginario() == 5);
	}
	
	@Test
	public void deberiaConvertirPolarRadianes() {
		Complejo polarRadianes = calculadora.polarRadianes(c1);
		
		assertTrue(polarRadianes.getReal() == Math.sqrt(13));
		assertEquals(polarRadianes.getImaginario(), 0.982793723247329, MAXERROR);
		
	}
	
	@Test
	public void deberiaConvertirPolarGrados() {
		Complejo polarGrados = calculadora.polarGrados(c2);
		
		assertTrue(polarGrados.getReal() == 5 * Math.sqrt(2));
		assertEquals(polarGrados.getImaginario(), 315, MAXERROR);
	}
	
	@Test
	public void deberiaConvertirCartesianoRadianes() {
		Complejo cartesianoRadianes = calculadora.cartesianoRadianes(c3);
		
		assertEquals(cartesianoRadianes.getReal(), -4 * Math.cos(7), MAXERROR);
		assertEquals(cartesianoRadianes.getImaginario(), -4 * Math.sin(7), MAXERROR);
		
	}
	
	@Test
	public void deberiaConvertirCartesianoGrados() {
		Complejo cartesianoGrados = calculadora.cartesianoGrados(c4);
		
		assertEquals(cartesianoGrados.getReal(), -1.9987816540381915, MAXERROR);
		assertEquals(cartesianoGrados.getImaginario(), 0.06979899340500194, MAXERROR);

	}
	
	@Test
	public void deberiaDarFase() {
		double fase = calculadora.fase(c4);
		assertEquals(fase, 0.7853981633974483, MAXERROR);
	}
	
	
}


//System.out.println(polarGrados.getReal() + " " + polarGrados.getImaginario());