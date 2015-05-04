package br.iesb.posgraduacao.uteis.generics.item;

import br.iesb.posgraduacao.uteis.generics.adaptador.AdapterItem;
import br.iesb.posgraduacao.uteis.generics.adaptador.SpecialItem;

public class Item1 implements SpecialItem {
    private String name;
    private String id;

    public String getItemName() {
        return "Item_1_" + getItemId();
    }

    public String getItemId() {
        return id;
    }

    public void setItemId(String id) {
        this.id = id;
    }

    public void metodoEspecial() {

    }
}
