package main;

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
	public String toString() {
		return "Ponto: [" + x + ", " + y + " ]";
	}
	
	@Override
	public void run() {
		preencheQuadrado();
	}

	// Método que delega o movimento, com base na direção
	private void preencheQuadrado() {
		if (Direcao.NENHUMA.equals(direcao)) {
			squares[x][y].setBackground(Main.PLAYER_COLOR);
			System.out.println("X: " + x + " , Y: " + y + " preenchido!");
			try {
				Thread.sleep(Main.INTERVALO_MOVIMENTO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			squares[x][y].setBackground(Main.BACKGROUND_COLOR);
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

	private void movimentaParaDireita() {
		int novoX = x + 1;
		if(isCampoDentroDoGrid(novoX, y) && isCampoPreenchido(novoX, y)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, y)) {
			// Caso movimento seja indisponível, aponta para uma nova direção aleatória
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, y);
	}

	private void movimentaParaEsquerda() {
		int novoX = x - 1;
		if(isCampoDentroDoGrid(novoX, y) && isCampoPreenchido(novoX, y)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, y)) {
			// Caso movimento seja indisponível, aponta para uma nova direção aleatória
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, y);
	}

	private void movimentaParaCima() {
		int novoY = y - 1;
		if(isCampoDentroDoGrid(x, novoY) && isCampoPreenchido(x, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(x, novoY)) {
			// Caso movimento seja indisponível, aponta para uma nova direção aleatória
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(x, novoY);
	}

	private void movimentaParaBaixo() {
		int novoY = y + 1;
		if(isCampoDentroDoGrid(x, novoY) && isCampoPreenchido(x, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(x, novoY)) {
			// Caso movimento seja indisponível, aponta para uma nova direção aleatória
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(x, novoY);
	}
	
	private void movimentaParaDiagonalCimaEsquerda() {
		int novoX = x - 1;
		int novoY = y - 1;
		if(isCampoDentroDoGrid(novoX, novoY) && isCampoPreenchido(novoX, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, novoY)) {
			// Caso movimento seja indisponível, aponta para uma nova direção aleatória
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, novoY);
	}
	
	private void movimentaParaDiagonalCimaDireita() {
		int novoX = x + 1;
		int novoY = y - 1;
		if(isCampoDentroDoGrid(novoX, novoY) && isCampoPreenchido(novoX, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, novoY)) {
			// Caso movimento seja indisponível, aponta para uma nova direção aleatória
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, novoY);
	}
	
	private void movimentaParaDiagonalBaixoEsquerda() {
		int novoX = x - 1;
		int novoY = y + 1;
		if(isCampoDentroDoGrid(novoX, novoY) && isCampoPreenchido(novoX, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, novoY)) {
			// Caso movimento seja indisponível, aponta para uma nova direção aleatória
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, novoY);
	}
	
	private void movimentaParaDiagonalBaixoDireita() {
		int novoX = x + 1;
		int novoY = y + 1;
		if(isCampoDentroDoGrid(novoX, novoY) && isCampoPreenchido(novoX, novoY)) {
			sleepPonto(x, y);
		}
		if (!isMovimentoDisponivel(novoX, novoY)) {
			// Caso movimento seja indisponível, aponta para uma nova direção aleatória
			new PontoDoTabuleiro(squares, x, y, Util.geraDirecaoAleatoria()).start();
		}
		movimenta(novoX, novoY);
	}

	private void movimenta(int x, int y) {
		if (isMovimentoDisponivel(x, y)) {
			squares[x][y].setBackground(Main.PLAYER_COLOR);
			try {
				Thread.sleep(Main.INTERVALO_MOVIMENTO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			squares[x][y].setBackground(Main.BACKGROUND_COLOR);
			// Continua andando para a mesma direção
			new PontoDoTabuleiro(squares, x, y, direcao).start();
		} else {
			System.out.println("Não pode preencher no campo : X: " + x + " , Y: " + y);
		}
	}
	
	private void sleepPonto(int x, int y) {
		squares[x][y].setBackground(Main.PLAYER_COLOR);
		try {
			int tempoDeEspera = Util.retornaNumeroAleatorio(Main.TEMPO_DE_ESPERA_MINIMO, Main.TEMPO_DE_ESPERA_MAXIMO);
			System.out.println(this + " está parado por " + tempoDeEspera + " milissegundos.");
			Thread.sleep(tempoDeEspera);
			System.out.println(this + " voltou a se mover");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		squares[x][y].setBackground(Main.BACKGROUND_COLOR);
	}

	private boolean isMovimentoDisponivel(int x, int y) {
		return isCampoDentroDoGrid(x, y) && (!isCampoPreenchido(x, y));
	}
	
	private boolean isCampoDentroDoGrid(int x, int y) {
		return x >= 0 && x < Main.DIM_X && y >= 0 && y < Main.DIM_Y;
	}

	private boolean isCampoPreenchido(int x, int y) {
		return squares[x][y].getBackground().equals(Main.PLAYER_COLOR);
	}

	private void setX(int x) {
		this.x = x;
	}
	private void setY(int y) {
		this.y = y;
	}
}