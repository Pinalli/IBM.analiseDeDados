package br.com.pinalli.analisedados.model;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class Data {
	private ArrayList<Salesmen> salesmen;
	    private ArrayList<Sale> sales;
	    private ArrayList<Client> clients;
	    private Sale maxima;
	    private Sale minima;
	
	    public Data() {
	        salesmen = new ArrayList<Salesmen>();
	        sales = new ArrayList<Sale>();
	        clients = new ArrayList<Client>();
	    
	    }
	
	    public Sale getMax() {
	        if (maxima == null){
	            this.computeMinMax();
	        }
	        return maxima;
	    }
	
	    public Sale getMin() {
	        if (minima == null){
	            this.computeMinMax();
	        }
	        return minima;
	    }
	
	    public void computeMinMax(){
	        if(!sales.isEmpty()) {
	            maxima = this.getSales().get(0);
	            minima = maxima;
	
	            for (Sale sale : this.getSales()) {
	                if (sale.getTotal() > maxima.getTotal()) {
	                    maxima = sale;
	                }
	                if (sale.getTotal() < minima.getTotal()) {
	                    minima = sale;
	                }
	            }
	        }
	    }
	
	    public ArrayList<Salesmen> getSalesmen() {
	        return salesmen;
	    }
	
	    public ArrayList<Sale> getSales() {
	        return sales;
	    }
	
	    public ArrayList<Client> getClients() {
	        return clients;
	    }
	
	    public void addSalesmen(String[] salesman) {
	        salesmen.add(new Salesmen(salesman[1], salesman[2], Double.parseDouble(salesman[3])));
	    }
	
	    public void addClient(String[] client) {
	        clients.add(new Client( client[1],  client[2], client[3]));
	    }
	
	    public void addSale(String[] sale) {
	
	        sale[2] = sale[2].split(Pattern.quote("["))[1];
	        sale[2] = sale[2].split("]")[0];
	
	        ArrayList<Item> items = new ArrayList<Item>();
	        String[] line_items = sale[2].split(",");
	        for(String item : line_items) {
	            String[] i = item.split("-");
	            items.add(new Item(i[0], Integer.parseInt(i[1]), Double.parseDouble(i[2])));
	        }
	
	        sales.add(new Sale(sale[1], items, sale[3]));
	    }
	
	}


