package br.iesb.posgraduacao.android.compras;

public class Cliente {
	public static void main(String[] args){
		CarrinhoCompras carrinho = new CarrinhoCompras();
		
		Celular celular = new Celular("IPhone 6 Plus 128Gb", "Eletrônicos", 4000, 2);
		PastaDente pastadente = new PastaDente("Colgate Total 12 100g", "Higiene", 4, 5);
		Refrigerante refri = new Refrigerante("Coca-cola lata", "Bebidas", 3, 15);
		Verdura alface = new Verdura("Alface", "Verdura", 1.2f, 3);
		
		carrinho.adicionarItem(celular);
		carrinho.adicionarItem(pastadente);
		carrinho.adicionarItem(refri);
		carrinho.adicionarItem(alface);
		
		System.out.println("--------------------------------------------------- ");
		System.out.println("--------------- Carrinho de compras --------------- ");
		System.out.println("--------------------------------------------------- ");
		
		carrinho.listaItens();
		
		System.out.println("---------------------------------------------------- ");
		System.out.println("------------ Fim do carrinho de compras ------------ ");
		System.out.println("---------------------------------------------------- ");
		
	}

}
