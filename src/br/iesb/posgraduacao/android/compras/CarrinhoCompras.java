package br.iesb.posgraduacao.android.compras;

import java.util.ArrayList;

public class CarrinhoCompras<T extends ItemBase> {
	
	private ArrayList<T> carrinho = new ArrayList<T>();
	private float total = 0;
	
	public void adicionarItem(T item){
		carrinho.add(item);
	}
	
	public void listaItens(){
		for (int i = 0; i < carrinho.size(); i++) {
			T item = carrinho.get(i);
			total += item.getSubtotal();
			item.getFichaProduto();
		}
	}

}
