package br.iesb.posgraduacao.android.compras;

public class PastaDente extends ItemBase{

	public PastaDente(String nome, String categoria, float preco, int quantidade) {
		this.setNome(nome);
		this.setCategoria(categoria);
		this.setPreco(preco);
		this.setQuantidade(quantidade);
	}

}
