package util;

import java.util.Random;

import main.Direcao;

public class Util {
	
	public static int retornaNumeroAleatorio(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Maximo tem que ser menor que o minimo");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public static Direcao geraDirecaoAleatoria() {
		return Direcao.porIndex(Util.retornaNumeroAleatorio(1, 8));
	}
}