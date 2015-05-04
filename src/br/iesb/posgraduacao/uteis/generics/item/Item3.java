package br.iesb.posgraduacao.uteis.generics.item;

public class Item3 {
    private String name;
    private String id;

    public String getItemName() {
        return "Item_3_" + getItemId();
    }

    public String getItemId() {
        return id;
    }

    public void setItemId(String id) {
        this.id = id;
    }
}
