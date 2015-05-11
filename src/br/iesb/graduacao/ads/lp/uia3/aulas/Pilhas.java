package br.iesb.graduacao.ads.lp.uia3.aulas;

public class Pilhas {
    public Object[] pilha;
    /*
     * valor -1 indica que está nula, vazia, pois a posição zero do array já 
     * armazena informação
     */
    public int posicaoPilha;

    public Pilhas() {
        this.posicaoPilha = -1;
        this.pilha = new Object[10]; 
    }
    
    public boolean isPilhaVazia( ) {
        if (this.posicaoPilha == -1) {
            return true;
        }
        return false;
    }
    
    public int tamanho() {
        if (this.isPilhaVazia()) {
            return 0;
        }
        return this.posicaoPilha + 1;
    }
    
    public void empilhar(Object valor) {
	if (this.posicaoPilha < this.pilha.length - 1) {
	    this.pilha[++this.posicaoPilha] = valor;
	}
    }
    
    public Object desempilhar() {
	if (isPilhaVazia()) {
	    return null;
	}
	return this.pilha[this.posicaoPilha--];
    }
}
