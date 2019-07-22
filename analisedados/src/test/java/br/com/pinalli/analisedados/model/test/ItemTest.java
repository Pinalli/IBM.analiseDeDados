package br.com.pinalli.analisedados.model.test;
import org.junit.Before;
import org.junit.Test;

import br.com.pinalli.analisedados.model.Item;

import static org.junit.Assert.*;

public class ItemTest {

    Item testItem;

    @Before
    public void newItemTest() {
        testItem = new Item("003", 10, 55.42);
    }

    @Test
    public void newItemgetId() {
        assertEquals("003", testItem.getId());
    }


    @Test
    public void newItemgetQuantity() {
        Integer expected = 10;
        assertEquals(expected, testItem.getQuantity());
    }

    @Test
    public void newItemgetPrice() {
        Double expected = 55.42;
        assertEquals(expected, testItem.getPrice(), 0.1);
    }
}