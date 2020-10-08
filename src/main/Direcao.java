package main;

public enum Direcao {
	
	NENHUMA(0),
	ESQUERDA(1),
	DIREITA(2),
	CIMA(3),
	BAIXO(4),
	DIAGONAL_CIMA_ESQUERDA(5),
	DIAGONAL_CIMA_DIREITA(6),
	DIAGONAL_BAIXO_ESQUERDA(7),
	DIAGONAL_BAIXO_DIREITA(8);
	
	private int index;
	private Direcao(int index) {
		this.index = index;
	}
	
	public static Direcao porIndex(int index) {
		for (Direcao direcao : Direcao.values()) {
			if(direcao.index == index) {
				return direcao;
			}
		}
		return Direcao.NENHUMA;
	}
}