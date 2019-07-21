package br.com.pinalli.analisedados.model;

import java.util.ArrayList;

public class Sale {

    private String id;
    private ArrayList<Item> itemsld;
    private String salesman;
    private Double total = 0.0;

    public Sale(String id, ArrayList<Item> itemsld, String salesman) {
        this.id = id;
        this.itemsld = itemsld;
        this.salesman = salesman;

        computeTotal();
    }

    public void computeTotal() {
        for(Item i : itemsld)
            total += i.getPrice() * i.getQuantity();
    }

    public String getId()
    {

        return id;
    }

    public ArrayList<Item> getItemsSold()
    {

        return itemsld;
    }

    public String getSalesman()

    {
        return salesman;
    }

    public Double getTotal() {
        return total;
    }
}
