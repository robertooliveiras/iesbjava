package br.iesb.posgraduacao.android.compras;

public class Verdura extends ItemBase{

	public Verdura(String nome, String categoria, float preco, int quantidade) {
		this.setNome(nome);
		this.setCategoria(categoria);
		this.setPreco(preco);
		this.setQuantidade(quantidade);
	}

}
