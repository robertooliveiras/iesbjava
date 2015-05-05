package br.iesb.posgraduacao.jogos.batalha_naval;

import java.util.ArrayList;

public class Peca <T extends Agua, PedacoNavioGuerra, PedacoPortaAvioes>{
	private ArrayList<T> pecas = new ArrayList<T>();
	private T peca;

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
	 * @return devolve o objeto do tipo genérico peca
	 */
	public T getTPeca() {
		return peca;
	}

	/**
	 * @param recebe um objeto do tipo genérico e preenche o atributo peca com sua instância
	 */
	public void setTPeca(T peca) {
		this.peca = peca;
	}
	
}
