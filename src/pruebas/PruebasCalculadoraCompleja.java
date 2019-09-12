package pruebas;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class PruebasCalculadoraCompleja {
	
	public static final double MAXERROR = 0.00000000000001;
	private CalculadoraCompleja calculadora = new CalculadoraCompleja(true);
	private Complejo c1 = new Complejo(2,3), c2 = new Complejo(5,-5), c3 = new Complejo(-4,7), c4 = new Complejo(-2,-2);
	
	private Vector v1 = new Vector(new Complejo[]{new Complejo(5,-5), new Complejo(5,-5), new Complejo(5,-5)});
	private Vector v2 = new Vector(new Complejo[]{new Complejo(5,-5), new Complejo(5,-5), new Complejo(5,-5)});
	private Vector v3 = new Vector(new Complejo[]{new Complejo(2, 1), new Complejo(1,-2)});
	
	private Matriz hermitian = new Matriz(new Complejo[][]{{new Complejo(5,0),new Complejo(4,5),new Complejo(6,-16)},
										   				   {new Complejo(4,-5),new Complejo(13,0),new Complejo(7,0)},
										   				   {new Complejo(6,16),new Complejo(7,0),new Complejo(-2.1,0)}});
	
	private Matriz hermitianUnitaria = new Matriz(new Complejo[][] {{new Complejo(0,0),new Complejo(1,0)}, 
																	{new Complejo(1,0),new Complejo(0,0)}});
	
	private Matriz unitaria = new Matriz(new Complejo[][] {{new Complejo(0, 0),new Complejo(1,0)}, 
														   {new Complejo(1,0),new Complejo(0,0)}});
	
	private Matriz m1 = new Matriz(new Complejo[][] {{new Complejo(1,1),new Complejo(1,1)}, 
													 {new Complejo(1,1),new Complejo(1,1)}});
	
	private Matriz norma = new Matriz(new Complejo[][]{{new Complejo(6.5, 2.7),new Complejo(3.1, -3.8)}});
	
	private Matriz m2 = new Matriz(new Complejo[][] {{new Complejo(1,1),new Complejo(0,0)}, 
													 {new Complejo(1,0),new Complejo(0,1)}});
	
	private Matriz m3 = new Matriz(new Complejo[][] {{new Complejo(-1,2),new Complejo(-2,-2),new Complejo(0,2)}, 
													 {new Complejo(2,3),new Complejo(3,1),new Complejo(2,2)},
													 {new Complejo(-2,1),new Complejo(1,-1),new Complejo(2,1)}});
	
	private Matriz matrizTensor = new Matriz(new Complejo[][] {{new Complejo(-3,1),new Complejo(0,-4),new Complejo(-2,2), 
															   new Complejo(0,0),new Complejo(0,0),new Complejo(0,0)},
															   {new Complejo(-1,5),new Complejo(2,4),new Complejo(0,4),
														       new Complejo(0,0),new Complejo(0,0),new Complejo(0,0)},
														       {new Complejo(-3,-1),new Complejo(2,0),new Complejo(1,3),
														       new Complejo(0,0),new Complejo(0,0),new Complejo(0,0)},
	       
														       {new Complejo(-1,2),new Complejo(-2,-2),new Complejo(0,2), 
															   new Complejo(-2,-1),new Complejo(2,-2),new Complejo(-2,0)},
															   {new Complejo(2,3),new Complejo(3,1),new Complejo(2,2),
														       new Complejo(-3,2),new Complejo(-1,3),new Complejo(-2,2)},
														       {new Complejo(-2,1),new Complejo(1,-1),new Complejo(2,1),
														       new Complejo(-1,-2),new Complejo(1,1),new Complejo(-1,2)}});
	
	
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
	
	
	@Test 
	public void deberiaSumarVectores() { 
		Vector v = new Vector(new Complejo[]{new Complejo(10,-10), new Complejo(10,-10), new Complejo(10,-10)});
		try {
			assertTrue(v.equals(v1.sumarVectores(v2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test 
	public void inversaVectores() { 
		Vector v = new Vector(new Complejo[]{new Complejo(-5,5), new Complejo(-5,5), new Complejo(-5,5)});
		assertTrue(v.equals(v1.inversa()));
	}
	
	
	@Test 
	public void multiplicacionEscalarVectores() { 
		Vector v = new Vector(new Complejo[]{new Complejo(-10,10), new Complejo(-10,10), new Complejo(-10,10)});
		assertTrue(v.equals(v1.inversa().multiplicacionEscalar(2)));
	}

	@Test 
	public void deberiaSumarMatrices() { 
		Matriz m = new Matriz(new Complejo[][] {{new Complejo(0,0),new Complejo(2,0)}, 
												{new Complejo(2,0),new Complejo(0,0)}});
		try {
			assertTrue(m.equals(hermitianUnitaria.sumarMatrices(hermitianUnitaria)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void inversaMatrices() { 
		Matriz m = new Matriz(new Complejo[][] {{new Complejo(0,0),new Complejo(-1,0)}, 
												{new Complejo(-1,0),new Complejo(0,0)}});
		assertTrue(m.equals(hermitianUnitaria.inversa()));
		
	}
	
	@Test 
	public void multiplicacionEscalarMatrices() { 
		Matriz m = new Matriz(new Complejo[][] {{new Complejo(0,0),new Complejo(5,0)}, 
												{new Complejo(5,0),new Complejo(0,0)}});
		assertTrue(m.equals(hermitianUnitaria.multiplicacionEscalar(5)));
		
	}
	
	
	@Test 
	public void matrizTranspuesta() { 
		Matriz m = new Matriz(new Complejo[][] {{new Complejo(0,0),new Complejo(5,0)}, 
												{new Complejo(5,0),new Complejo(0,0)}});
		assertTrue(m.equals(hermitianUnitaria.multiplicacionEscalar(5).inversa()));
		
	}
	
	@Test 
	public void matrizConjugada() { 
		Matriz m = new Matriz(new Complejo[][] {{new Complejo(1,-1),new Complejo(1,-1)}, 
												{new Complejo(1,-1),new Complejo(1,-1)}});
		assertTrue(m.equals(m1.conjugada()));
		
	}
	
	@Test 
	public void matrizAdjunta() { 
		Matriz m = new Matriz(new Complejo[][] {{new Complejo(1,-1),new Complejo(1,-1)}, 
												{new Complejo(1,-1),new Complejo(1,-1)}});
		assertTrue(m.equals(m1.adjunta()));
		
	}
	
	@Test 
	public void accionMatrizVector() { 
		Vector v = new Vector(new Complejo[]{new Complejo(4, 2), new Complejo(4, 2)});		
		assertTrue(v.equals(v3.multiplicacion(m1)));
		
	}
	
	
	@Test 
	public void normaMatrices() { 
		double v = 8.578461400507669;
		assertEquals(v, norma.norma(), MAXERROR);
		
	}
	
	
	@Test 
	public void distanciaEntreMatrices() { 
		double v = 12;
		Vector v1 = new Vector(new Complejo[] {new Complejo(2,7), new Complejo(4,-1), new Complejo(2,-4)});
		Vector v2 = new Vector(new Complejo[] {new Complejo(7,8), new Complejo(2,-8), new Complejo(1,4)});
		Matriz A = new Matriz(new Complejo[][]{v1.getVector()});
		Matriz B = new Matriz(new Complejo[][]{v2.getVector()});
		try {
			assertEquals(A.distanciaEntreMatrices(B), v, MAXERROR);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deberiaSerUnitaria() {
		assertTrue(unitaria.isUnitaria());
	}
	
	@Test
	public void deberiaSerHermitian() {
		assertTrue(hermitian.isHermitian());
	}
	
	
	@Test
	public void productoTensor() {
		assertTrue(m2.productoTensor(m3).equals(matrizTensor));
	}
	
}


//System.out.println(polarGrados.getReal() + " " + polarGrados.getImaginario());