package edu.eci.cnyt.calculadora;

public class DobleRendijaCuantica {
	private Complejo[][] matriz;
	private Complejo[] estado0;
	private int blancos, rendijas;

	public DobleRendijaCuantica(int rendijas, int blancos, Lista[][] ady) {
		if ((rendijas + blancos + 1) != ady.length)
			;
		this.rendijas = rendijas;
		this.blancos = blancos;
		estado0 = hallarEstadoInicial();
		matriz = hallarMatrizInicial();
		for (int i = 0; i < ady.length; i++)
			for (Lista j : ady[i]) {
				if (j.getAdy() >= rendijas && i >= 0 && i <= rendijas)
					matriz[j.getAdy() - 1][i] = j.getPeso();
				else
					matriz[j.getAdy() - 1][i] = new Complejo(1, 0);
			}

	}

	public static void imprimirMatriz(Complejo[][] matriz) {
		System.out.print("\n ");
		// for (int i = 0; i < matriz.length; i++) System.out.print(" "+(i));
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("\n" + (i) + "| ");
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j].imprimir();
			}
			System.out.print("|\n");
		}
	}

	public static void printearEstado(Complejo[] estado0) {
		System.out.print("\n  ");
		for (int i = 0; i < estado0.length; i++) {
			System.out.print("\n" + (i) + "| ");
			estado0[i].imprimir();
			System.out.print("|");
		}
	}

	public Complejo[] click(int n) {
		Complejo[] y = estado0;
		for (int i = 0; i < n; i++) {
			y = multiplicarVector(y);
		}
		return y;
	}

	public Complejo[] getEstado() {
		return estado0;
	}

	public Complejo[][] getMatriz() {
		return matriz;
	}

	private Complejo[] multiplicarVector(Complejo[] y) {
		Complejo[] aux = new Complejo[y.length];
		for (int i = 0; i < matriz.length; i++) {
			Complejo cont = new Complejo(0, 0);
			for (int j = 0; j < matriz.length; j++) {
				CalculadoraCompleja.sumar(cont, CalculadoraCompleja.multiplicar(y[j], matriz[i][j]));
			}
			aux[i] = cont;
		}
		return aux;
	}

	private Complejo[][] hallarMatrizInicial() {
		Complejo[][] aux = new Complejo[rendijas + blancos + 1][rendijas + blancos + 1];
		for (int i = 0; i < rendijas + blancos + 1; i++)
			for (int j = 0; j < rendijas + blancos + 1; j++)
				aux[i][j] = new Complejo(0, 0);
		return aux;
	}

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