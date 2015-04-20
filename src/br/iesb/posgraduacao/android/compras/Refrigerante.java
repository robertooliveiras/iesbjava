package br.iesb.posgraduacao.android.compras;

public class Refrigerante extends ItemBase {

	public Refrigerante(String nome, String categoria, float preco, int quantidade) {
		this.setNome(nome);
		this.setCategoria(categoria);
		this.setPreco(preco);
		this.setQuantidade(quantidade);
	}

}
