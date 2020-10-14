package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import util.Util;

/*
 * Grupo:
 * 	Matheus Vinicius de Souza Gomes
 * 	Leonardo Lopes Lotaif
 * 	Guilherme Quittó
 * 	Jonathan Dias
 * 	Leandro almeida
 */

@SuppressWarnings("serial")
public class Main extends JFrame {

	public static final int DIM_X = 50;
	public static final int DIM_Y = 50;

	public static final Color BACKGROUND_COLOR = Color.lightGray;
	public static final Color PLAYER_COLOR = Color.blue;
	
	public static final int MINIMO_DE_JOGADORES = 20;
	public static final int MAXIMO_DE_JOGADORES = 75;
	
	public static final int INTERVALO_MOVIMENTO = 250;
	
	public static final int TEMPO_DE_ESPERA_MINIMO = 1000;
	public static final int TEMPO_DE_ESPERA_MAXIMO = 4000;

	private JPanel[][] squares = new JPanel[DIM_X][DIM_Y];
	private JPanel mainPanel = new JPanel(new GridLayout(DIM_X, DIM_Y));

	public Main() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.init();
		this.pack();
		this.setVisible(true);
	}

	private void init() {
		Container c = getContentPane();

		for (int y = 0; y < DIM_Y; y++) {
			for (int x = 0; x < DIM_X; x++) {
				squares[x][y] = new JPanel();
				squares[x][y].setPreferredSize(new Dimension(12, 12));
				squares[x][y].setBackground(BACKGROUND_COLOR);
				squares[x][y].setBorder(BorderFactory.createLineBorder(Color.white));
				mainPanel.add(squares[x][y]);
			}
		}
		c.add(mainPanel);
		
		// Iniciando os jogadores
		for(int i = 0; i < Util.retornaNumeroAleatorio(MINIMO_DE_JOGADORES, MAXIMO_DE_JOGADORES); i++) {
			Jogador j1 = new Jogador(squares);
			j1.start();
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}