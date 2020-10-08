package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import util.Util;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public static final int DIM_X = 50;
	public static final int DIM_Y = 50;

	public static final Color BACKGROUND_COLOR = Color.lightGray;

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
		
		for(int i = 0; i < Util.retornaNumeroAleatorio(20, 100); i++) {
			Jogador j1 = new Jogador(squares);
			j1.start();
		}
		
//		Jogador j1 = new Jogador(squares);
//		Jogador j2 = new Jogador(squares);
//		Jogador j3 = new Jogador(squares);
//		Jogador j4 = new Jogador(squares);
//		Jogador j5 = new Jogador(squares);
//		Jogador j6 = new Jogador(squares);
//		Jogador j7 = new Jogador(squares);
//		Jogador j8 = new Jogador(squares);
//		Jogador j9 = new Jogador(squares);
//		Jogador j10 = new Jogador(squares);
//		Jogador j11 = new Jogador(squares);
//		Jogador j12 = new Jogador(squares);
//		Jogador j13 = new Jogador(squares);
//		Jogador j14 = new Jogador(squares);
//		Jogador j15 = new Jogador(squares);
//		Jogador j16 = new Jogador(squares);
//		Jogador j17 = new Jogador(squares);
//		Jogador j18 = new Jogador(squares);
//		Jogador j19 = new Jogador(squares);
//		Jogador j20 = new Jogador(squares);
//		j1.start();
//		j2.start();
//		j3.start();
//		j4.start();
//		j5.start();
//		j6.start();
//		j7.start();
//		j8.start();
//		j9.start();
//		j10.start();
//		j11.start();
//		j12.start();
//		j13.start();
//		j14.start();
//		j15.start();
//		j16.start();
//		j17.start();
//		j18.start();
//		j19.start();
//		j20.start();
	}

	public static void main(String[] args) {
		new Main();
	}
}