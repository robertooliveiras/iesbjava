package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

public class Peca <T>{
	private ArrayList<T> peca = new ArrayList<T>();

	public void adicionarPeca(T item){
		peca.add(item);
	}
	
}
