package main;

import java.awt.Color;

import javax.swing.JPanel;

import util.Util;

public class PontoDoTabuleiro extends Thread {

	private JPanel[][] squares;
	private int x;
	private int y;
	private Direcao direcao;
	
	public PontoDoTabuleiro(JPanel[][] squares, int x, int y, Direcao direcao) {
		this.squares = squares;
		this.setX(x);
		this.setY(y);
		this.direcao = direcao;
	}

	@Override
	public void run() {
		preencheQuadrado();
	}

	public void preencheQuadrado() {
		if (Direcao.NENHUMA.equals(direcao)) {
			squares[x][y].setBackground(Color.blue);
			System.out.println("X: " + x + " , Y: " + y + " preenchido!");
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			squares[x][y].setBackground(Color.lightGray);
		}else if (Direcao.DIREITA.equals(direcao)) {
			movimentaParaDireita();
		} else if (Direcao.ESQUERDA.equals(direcao)) {
			movimentaParaEsquerda();
		} else if (Direcao.CIMA.equals(direcao)) {
			movimentaParaCima();
		} else if (Direcao.BAIXO.equals(direcao)) {
			movimentaParaBaixo();
		}else if (Direcao.DIAGONAL_BAIXO_DIREITA.equals(direcao)) {
			movimentaParaDiagonalBaixoDireita();
		} else if (Direcao.DIAGONAL_BAIXO_ESQUERDA.equals(direcao)) {
			movimentaParaDiagonalBaixoEsquerda();
		} else if (Direcao.DIAGONAL_CIMA_DIREITA.equals(direcao)) {
			movimentaParaDiagonalCimaDireita();
		} else if (Direcao.DIAGONAL_CIMA_ESQUERDA.equals(direcao)) {
			movimentaParaDiagonalCimaEsquerda();
		}

	}

	public void movimentaParaDireita() {
		int novoX = x + 1;
		if(isCampoDentroDoGrid(novoX, y) && isCampoPreenchido(novoX, y)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, y)) {
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, y);
	}

	public void movimentaParaEsquerda() {
		int novoX = x - 1;
		if(isCampoDentroDoGrid(novoX, y) && isCampoPreenchido(novoX, y)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, y)) {
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, y);
	}

	public void movimentaParaCima() {
		int novoY = y - 1;
		if(isCampoDentroDoGrid(x, novoY) && isCampoPreenchido(x, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(x, novoY)) {
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(x, novoY);
	}

	public void movimentaParaBaixo() {
		int novoY = y + 1;
		if(isCampoDentroDoGrid(x, novoY) && isCampoPreenchido(x, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(x, novoY)) {
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(x, novoY);
	}
	
	public void movimentaParaDiagonalCimaEsquerda() {
		int novoX = x - 1;
		int novoY = y - 1;
		if(isCampoDentroDoGrid(novoX, novoY) && isCampoPreenchido(novoX, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, novoY)) {
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, novoY);
	}
	
	public void movimentaParaDiagonalCimaDireita() {
		int novoX = x + 1;
		int novoY = y - 1;
		if(isCampoDentroDoGrid(novoX, novoY) && isCampoPreenchido(novoX, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, novoY)) {
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, novoY);
	}
	
	public void movimentaParaDiagonalBaixoEsquerda() {
		int novoX = x - 1;
		int novoY = y + 1;
		if(isCampoDentroDoGrid(novoX, novoY) && isCampoPreenchido(novoX, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, novoY)) {
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, novoY);
	}
	
	public void movimentaParaDiagonalBaixoDireita() {
		int novoX = x + 1;
		int novoY = y + 1;
		if(isCampoDentroDoGrid(novoX, novoY) && isCampoPreenchido(novoX, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, novoY)) {
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, novoY);
	}

	public void movimenta(int x, int y) {
		if (isMovimentoDisponivel(x, y)) {
			squares[x][y].setBackground(Color.blue);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			squares[x][y].setBackground(Color.lightGray);
			new PontoDoTabuleiro(squares, x, y, direcao).start();
		} else {
			System.out.println("Não pode preencher no campo : X: " + x + " , Y: " + y + " preenchido!");
		}
	}
	
	public void sleepPonto(int x, int y) {
		squares[x][y].setBackground(Color.blue);
		try {
			Thread.sleep(Util.retornaNumeroAleatorio(1000, 4000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		squares[x][y].setBackground(Color.lightGray);
	}

	public boolean isMovimentoDisponivel(int x, int y) {
		return isCampoDentroDoGrid(x, y) && (!isCampoPreenchido(x, y));
	}
	
	public boolean isCampoDentroDoGrid(int x, int y) {
		return x >= 0 && x < 50 && y >= 0 && y < 50;
	}

	public boolean isCampoPreenchido(int x, int y) {
		return squares[x][y].getBackground().equals(Color.BLUE);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
