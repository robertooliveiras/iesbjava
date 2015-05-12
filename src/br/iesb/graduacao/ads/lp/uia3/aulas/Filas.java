package br.iesb.graduacao.ads.lp.uia3.aulas;

import java.util.LinkedList;
import java.util.List;

public class Filas {
    public static class Aluno{
	public static void main(String[] args) {
	}
	
	public Aluno(){
	}
    }
    
    public List<Aluno> alunos = new LinkedList<Aluno>();

    /**
     * @param args
     */
    public static void main(String[] args) {
	Filas fila = new Filas();
	Aluno aluno = new Aluno();
	fila.insere(aluno);
	Aluno alunoRemovido = fila.remove();
	if (fila.vazia()) {
	    System.out.println("A fila está vazia");
	}
    }
    
    public void insere(Aluno aluno) {
	this.alunos.add(aluno);
    }
    
    public Aluno remove() {
	return this.alunos.remove(0);
    }
    
    public boolean vazia() {
        if (this.alunos.size() == 0){
            return true;
        }
        return false;
    }
}
