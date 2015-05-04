package br.iesb.posgraduacao.uteis.generics.adaptador;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class Adaptador<TipoDoItem extends AdapterItem> {

    private List<TipoDoItem> listaItems;

    public Adaptador() {
        listaItems = new ArrayList<TipoDoItem>();
    }

    public void addItem(TipoDoItem item) {
        String temp = "" + System.currentTimeMillis();
        String _id = Base64.getEncoder().encodeToString(temp.getBytes());
        item.setItemId(_id);
        listaItems.add(item);
    }

    public List<TipoDoItem> recuperarItens() {
        return listaItems;
    }

    public TipoDoItem recuperarItem(int index) {
        return listaItems.get(index);
    }

    public int quantidadeItens() {
        return listaItems.size();
    }

}
