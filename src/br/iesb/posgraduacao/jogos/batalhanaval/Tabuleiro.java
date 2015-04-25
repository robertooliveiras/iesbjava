package br.iesb.posgraduacao.jogos.batalhanaval;

public class Tabuleiro {
	public String piece;
	public char player;
	public boolean used;
	public boolean selected;
	public int type;

	public Tabuleiro() {
		piece = "~~~|";
		used = false;
		selected = false;
		type = 0;
	}
	
	public Tabuleiro[][] criaTabuleiro(int tamanho){
		Tabuleiro[][] tabuleiro = new Tabuleiro[tamanho][tamanho];
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				tabuleiro[i][j] = new Tabuleiro();
			}
		}
		return tabuleiro;
	}

}
