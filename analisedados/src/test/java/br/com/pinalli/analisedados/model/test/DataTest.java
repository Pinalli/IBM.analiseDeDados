package br.com.pinalli.analisedados.model.test;

import org.junit.Before;
import org.junit.Test;

import br.com.pinalli.analisedados.model.Data;

import static org.junit.Assert.*;


public class DataTest {
     Data data;

    @Before
    public void TestData() {
        String[] salesman = {"001", "123456789", "Paulo", "3765.89"};
        String[] salesman1 = {"001", "987654321", "Abrão", "5497.56"};
        String[] client = {"002", "891728000186","Maria","Rural"};
        String[] client1 = {"002", "432122000177","Adão","Indrustrial" };
        String[] sale = {"003", "12", "[1-10-100,2-30-2.50,3-40-3.10]", "Murilo"};
        String[] sale1 = {"003", "06", "[1-34-10,2-33-1.50,3-40-0.10]", "Adriano" };
        data = new Data();
        data.addSalesmen(salesman);
        data.addSalesmen(salesman1);
        data.addClient(client);
        data.addClient(client1);
        data.addSale(sale);
        data.addSale(sale1);
    }

    @Test
    public void MinMaxTest() {
        data.computeMinMax();
        String expected = "12";
        assertEquals(expected, data.getMax().getId());
        expected = "06";
        assertEquals(expected, data.getMin().getId());
    }

    @Test
    public void getSalesmenTest() {
        String[] salesman1 = {"001", "987654321", "Abrão", "5497.56"};
        assertEquals(salesman1[2], data.getSalesmen().get(1).getName());
    }

    @Test
    public void getClientsTest() {
        String[] client = {"002", "891728000186","Maria","Rural"};
        assertEquals(client[2], data.getClients().get(0).getName());
    }

    @Test
    public void testMaxCondition() {
        String[] sale = {"003", "12", "[1-10-100,2-30-2.50,3-40-3.10]", "Murilo" };
        Double expected = 1199.0;
        data.addSale(sale);
        data.computeMinMax();
        assertEquals(expected, data.getMax().getTotal());
    }
}