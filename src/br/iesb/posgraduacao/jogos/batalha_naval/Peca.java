package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

public class Peca <T extends Agua, PedacoNavioGuerra, PedacoPortaAvioes>{
	private ArrayList<T> pecas = new ArrayList<T>();
	private T pecateste;

	public void adicionarPeca(T item){
		pecas.add(item);
	}
	
	public ArrayList<T> getPecas(){
		return this.pecas;
	}
	
	public T getPeca(int i){
		return this.pecas.get(i);
	}
	
	public void removePeca(int i){
		this.pecas.remove(i);
	}

	/**
	 * @return the pecateste
	 */
	public T getPecaTeste() {
		return pecateste;
	}

	/**
	 * @param pecateste the pecateste to set
	 */
	public void setPecaTeste(T peca) {
		this.pecateste = peca;
	}
	
}
