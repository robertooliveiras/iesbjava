package br.iesb.posgraduacao.uteis.generics;

import br.iesb.posgraduacao.uteis.generics.adaptador.Adaptador;
import br.iesb.posgraduacao.uteis.generics.adaptador.AdapterItem;
import br.iesb.posgraduacao.uteis.generics.adaptador.SpecialItem;
import br.iesb.posgraduacao.uteis.generics.item.Item1;
import br.iesb.posgraduacao.uteis.generics.item.Item2;
import br.iesb.posgraduacao.uteis.generics.item.Item3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Adaptador<AdapterItem> ad = new Adaptador<AdapterItem>();

        Item1 it1 = new Item1();
        ad.addItem(it1);

        ad.addItem(new Item1());
        ad.addItem(new Item1());

        ad.addItem(new Item2());
        ad.addItem(new Item2());

        //ad.addItem(new Item3());
        //ad.addItem(new Item3());

        System.out.println("Quantidade de Itens: " + ad.quantidadeItens());
        for (int i = 0; i < ad.quantidadeItens(); i++) {
            AdapterItem it = ad.recuperarItem(i);
            System.out.println("\tNome: " + it.getItemName());
        }
    }
}
