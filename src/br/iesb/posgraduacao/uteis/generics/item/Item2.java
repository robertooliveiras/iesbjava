package br.iesb.posgraduacao.uteis.generics.item;

import br.iesb.posgraduacao.uteis.generics.adaptador.AdapterItem;

public class Item2 implements AdapterItem {
    private String name;
    private String id;

    public String getItemName() {
        return "Item_2_" + getItemId();
    }

    public String getItemId() {
        return id;
    }

    public void setItemId(String id) {
        this.id = id;
    }
}
