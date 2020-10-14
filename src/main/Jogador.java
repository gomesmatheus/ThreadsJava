package main;

import javax.swing.JPanel;

import util.Util;

public class Jogador extends Thread{

	private JPanel[][] squares;
	private int posicaoAtualX;
	private int posicaoAtualY;
	
	public Jogador(JPanel[][] squares) {
		this.squares = squares;
	}
	
	@Override
	public void run() {
		// Inicia o jogador em uma coordenada aleat�ria
		posicaoAtualX = Util.retornaNumeroAleatorio(0, Main.DIM_X - 1);
		posicaoAtualY = Util.retornaNumeroAleatorio(0, Main.DIM_Y - 1);
		new PontoDoTabuleiro(squares, posicaoAtualX, posicaoAtualY, Direcao.NENHUMA).start();
		// Aponta o jogador para uma dire��o aleat�ria
		new PontoDoTabuleiro(squares, posicaoAtualX, posicaoAtualY, Util.geraDirecaoAleatoria()).start();
	}

	public void preencheQuadrado(int x, int y) {
		squares[x][y].setBackground(Main.PLAYER_COLOR);
		try {
			Thread.sleep(Main.INTERVALO_MOVIMENTO);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isCampoPreenchido(int x, int y) {
		return squares[x][y].getBackground().equals(Main.PLAYER_COLOR);
	}

	public int getPosicaoAtualX() {
		return posicaoAtualX;
	}
	public void setPosicaoAtualX(int posicaoAtualX) {
		this.posicaoAtualX = posicaoAtualX;
	}
	public int getPosicaoAtualY() {
		return posicaoAtualY;
	}
	public void setPosicaoAtualY(int posicaoAtualY) {
		this.posicaoAtualY = posicaoAtualY;
	}
}
