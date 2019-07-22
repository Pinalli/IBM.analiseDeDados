package br.com.pinalli.analisedados.moldeltest;

import org.junit.Before;
import org.junit.Test;
import br.com.pinalli.analisedados.model.Item;
import br.com.pinalli.analisedados.model.Sale;
import java.util.ArrayList;
import static org.junit.Assert.*;



public class SaleTest {
    Sale testSale;
    ArrayList<Item> ArrayItem;

    @Before
    public void newTestSale() {
        ArrayItem = new ArrayList<>();
        ArrayItem.add(new Item("0001", 3, 12.5));
        ArrayItem.add(new Item("0002", 4, 5.25));
        ArrayItem.add(new Item("0003", 5, 3.30));
        testSale = new Sale("002", ArrayItem, "Gustavo");
    }


    @Test
    public void newTotaSalelRight() {
        Double expected = 75.0;
        assertEquals(expected, testSale.getTotal());
    }

    @Test
    public void newgetId() {
        String expected = "002";
        assertEquals(expected, testSale.getId());
    }


    @Test
    public void getSalesman() {
        String expected = "Gustavo";
        assertEquals(expected, testSale.getSalesman());
    }

    @Test
    public void testGetItemsSold() {
        assertEquals(ArrayItem, testSale.getItemsSold());
    }
}