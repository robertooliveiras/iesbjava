package br.iesb.posgraduacao.android.compras;

public class ItemBase implements InterfaceItem {
	private String nome;
	private String categoria;
	private float preco;
	private int quantidade;
	
	public void getFichaProduto(){
		
		System.out.println("");
		System.out.println("Produto: "+getNome());
		System.out.println("Categoria: "+getCategoria());
		System.out.println("Preço unitário: "+getPreco());
		System.out.println("Quantidade: "+getQuantidade());
		
		//subtotal
		System.out.println("Subtotal: "+getSubtotal());
		
		System.out.println("");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getSubtotal() {
		return getPreco() * getQuantidade();
	}


}
