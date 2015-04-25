package br.iesb.posgraduacao.jogos.batalhanaval;

public class Navio {
	public int type;
	public boolean placed;
	public boolean destroyed;
	public String location;
	public char orientation;

	public Navio(int tipo) {
		type = tipo;
		placed = false;
		destroyed = false;
		location = "";
		orientation = ' ';
	}

}
