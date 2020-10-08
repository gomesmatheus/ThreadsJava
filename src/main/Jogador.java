package main;

import java.awt.Color;

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
		posicaoAtualX = Util.retornaNumeroAleatorio(0, 49);
		posicaoAtualY = Util.retornaNumeroAleatorio(0, 49);
		new PontoDoTabuleiro(squares, posicaoAtualX, posicaoAtualY, Direcao.NENHUMA).start();
		new PontoDoTabuleiro(squares, posicaoAtualX, posicaoAtualY, Util.geraDirecaoAleatoria()).start();
	}
	
	public void iniciaJogador() {
	}

	public void preencheQuadrado(int x, int y) {
		squares[x][y].setBackground(Color.BLUE);
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void andaPraDirecaoAleatoria() {
		new PontoDoTabuleiro(squares, posicaoAtualX, posicaoAtualY, Direcao.DIREITA).start();
	}

	public void movimentaParaDireita(int x, int y) {
		int novoX = x + 1;
		if(isMovimentoDisponivel(novoX, y)) {
			new PontoDoTabuleiro(squares, novoX, y, Direcao.DIREITA).start();
			movimentaParaDireita(novoX, y);
		}else {
			System.out.println("Não pode preencher no campo : X: " + novoX +  " , Y: " + y + " preenchido!");
		}
	}

	public void movimentaParaEsquerda(int x, int y) {

	}

	public void movimentaParaCima(int x, int y) {

	}

	public void movimentaParaBaixo(int x, int y) {

	}

	public boolean isMovimentoDisponivel(int x, int y) {
		return x > 0 && x < 50 && y > 0 && y < 50 && (!isCampoPreenchido(x, y));
	}

	public boolean isCampoPreenchido(int x, int y) {
		return squares[x][y].getBackground().equals(Color.BLUE);
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
