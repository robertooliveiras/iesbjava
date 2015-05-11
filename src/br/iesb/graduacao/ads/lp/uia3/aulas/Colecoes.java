package br.iesb.graduacao.ads.lp.uia3.aulas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Colecoes {
    /**
     * Para agregar ao exemplo de HashMap
     *
     */
    public class Livro {
	    private String codigo = "";
	    private String nome = "";
	    public String getCodigo() {
		return codigo;
	    }
	    public void setCodigo(String codigo) {
		this.codigo = codigo;
	    }
	    public String getNome() {
		return nome;
	    }
	    public void setNome(String nome) {
		this.nome = nome;
	    }
	}

    /**
     * @param args
     */
    public static void main(String[] args) {
	Colecoes c = new Colecoes();
	System.exit(0);
    }
    
    public Colecoes() {
	/*
	 * tipo Set para a implementação das coleções
	 */
	Collection<String> c1 = exemploHashSet();
	Collection<String> c2 = exemploTreeSet(c1);
	Collection<String> c3 = exemploLinkedHashSet(c2);
	
	/*
	 * tipo List para a implementação das coleções
	 */
	ArrayList<String> l1 = exemploArrayList();
	LinkedList<String> l2 = exemploLinkedList();
	
	/*
	 * tipo Map para  a implementação das coleções
	 */
	HashMap<String, Livro> hm1 = exemploHashMap();
	// Acessando um valor através de uma chave
	Livro livro = hm1.get("Html3");
	System.out.println(livro.getNome());
	
	
    }
    
    public Collection<String> exemploHashSet() {
	// Utilizando HashSet
	Collection<String> c1 = new HashSet<String>();
	c1.add("Andre");
	c1.add("Carlos");
	c1.add("Bruno");
	c1.add("Daniel");
	c1.add("Daniel");
	c1.add("Almir");
	System.out.println("==== HashSet ====");
	for(String str : c1) {
	    System.out.println(str);
	}
	return c1;
    }
    
    public Collection<String> exemploTreeSet(Collection<String> c1) {
	// Utilizando HashSet
	System.out.println("==== TreeSet ====");
	Collection<String> c2 = new TreeSet<String>(c1);
	for(String str : c2) {
	    System.out.println(str);
	}
	return c2;
    }
    
    public Collection<String> exemploLinkedHashSet(Collection<String> c2) {
	// Utilizando LinkedHashSet
	System.out.println("==== LinkedHashSet ====");
	Collection<String> c3 = new LinkedHashSet<String>(c2);
	for(String str : c3) {
	System.out.println(str);
	}
	return c3;
    }
    
    public ArrayList<String> exemploArrayList() {
	System.out.println("\n==== ArrayList ====");
	//Criando um ArrayList.
	ArrayList<String> lista = new ArrayList<String>();
	//Para adicionar elementos ao final da lista, usamos o método add
	lista.add("Sao Paulo");
	lista.add("Belo Horizonte");
	lista.add("Rio de Janeiro");
	lista.add("Bahia");
	lista.add("Amazonas");
	imprime("Elementos adicionados ate agora", lista);
	
	//Para adicionar em uma posicão especifica utilizamos o indice
	lista.add(1, "Parana");
	lista.add(3, "Acre");
	imprime("Lista depois de adicionar mais dois elementos", lista);
	//Podemos acessar um elemento da lista usando get
	System.out.println("\tO 3° elemento da lista é: " + lista.get(2));
	//Podemos obter o tamanho da lista utilizando o método size()
	System.out.println("\tO tamanho da lista é: " + lista.size());
	System.out.println();
	
	//Utilizamos remove para remover um elemento da lista
	lista.remove("Bahia");
	imprime("Lista depois de remover 'Bahia'", lista);
	
	//Podemos verificar se existe algum elemento na lista
	if(lista.contains("Sao Paulo")) {
	    System.out.println("Sao Paulo existe");
	} else {
	    System.out.println("Sao Paulo não existe");
	}
	
	if(lista.contains("Ceara")) {
	    System.out.println("Ceara existe");
	} else {
	    System.out.println("Ceara não existe");
	}
	
	//Podemos ordenar uma lista utilizando o sort
	Collections.sort(lista);
	imprime("Lista ordenada", lista);
	
	return lista;
    }
    
    private static void imprime(String titulo, ArrayList<String>
    lista) {
	System.out.println("------------------------------------------");
	System.out.println(titulo + ":");
	System.out.println("------------------------------------------");
	for(String str : lista) {
	    System.out.println(str);
	}
	System.out.println();
    }
    
    private static void imprime(String titulo, LinkedList<String>
    lista) {
	System.out.println("------------------------------------------");
	System.out.println(titulo + ":");
	System.out.println("------------------------------------------");
	for(String str : lista) {
	    System.out.println(str);
	}
	System.out.println();
    }
    
    public LinkedList<String> exemploLinkedList() {
	System.out.println("\n==== LinkedList ====");
	//Criando um ArrayList.
	LinkedList<String> lista = new LinkedList<String>();
	//Para adicionar elementos ao final da lista, usamos o método add
	lista.add("Sao Paulo");
	lista.add("Belo Horizonte");
	lista.add("Rio de Janeiro");
	lista.add("Bahia");
	lista.add("Amazonas");
	imprime("Elementos adicionados ate agora", lista);
	
	//Para adicionar em uma posicão especifica utilizamos o indice
	lista.add(1, "Parana");
	lista.add(3, "Acre");
	imprime("Lista depois de adicionar mais dois elementos", lista);
	//Podemos acessar um elemento da lista usando get
	System.out.println("\tO 3° elemento da lista é: " + lista.get(2));
	//Podemos obter o tamanho da lista utilizando o método size()
	System.out.println("\tO tamanho da lista é: " + lista.size());
	System.out.println();
	
	//Utilizamos remove para remover um elemento da lista
	lista.remove("Bahia");
	imprime("Lista depois de remover 'Bahia'", lista);
	
	//Podemos verificar se existe algum elemento na lista
	if(lista.contains("Sao Paulo")) {
	    System.out.println("Sao Paulo existe");
	} else {
	    System.out.println("Sao Paulo não existe");
	}
	
	if(lista.contains("Ceara")) {
	    System.out.println("Ceara existe");
	} else {
	    System.out.println("Ceara não existe");
	}
	
	//Podemos ordenar uma lista utilizando o sort
	Collections.sort(lista);
	imprime("Lista ordenada", lista);
	
	return lista;
    }
    
    public HashMap<String, Livro> exemploHashMap() {
	System.out.println("\n==== HashMap ====");
	// os objetos entre as tags < > definem os valores fixos de chave
	// e valor que usaremos durante todo nosso programa
	HashMap<String, Livro> mp = new HashMap<String, Livro>();
	Livro livro1 = new Livro();
	livro1.setCodigo("java1");
	livro1.setNome("Java como programar");
	mp.put("java1", livro1);
	Livro livro2 = new Livro();
	livro2.setCodigo("BD2");
	livro2.setNome("Aprendendo MySQL");
	mp.put("BD2", livro2);
	Livro livro3 = new Livro();
	livro3.setCodigo("Html3");
	livro3.setNome("Joomla fácil");
	mp.put("Html3", livro3);
	
	for (String key : mp.keySet()) { 
	    System.out.print(mp.get(key).getCodigo()+": ");
	    System.out.println(mp.get(key).getNome());
	}
	System.out.println();
	return mp;
    }

}


