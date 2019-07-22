package br.com.pinalli.analisedados.moldeltest;
import org.junit.Before;
import org.junit.Test;

import br.com.pinalli.analisedados.model.Client;

import static org.junit.Assert.*;

public class ClientTest {
     Client clientTest;

    @Before
    public void instanceTestCustomer() {
        clientTest = new Client("45677000123", "Padilha", "Rural");
    }

    @Test
    public void getCnpjTest() {
        String expected = "45677000123";
        assertEquals(expected,  clientTest.getCnpj());
    }

    @Test
    public void getName() {
        String expected = "Rural";
        assertEquals(expected, clientTest.getBusinessArea());
    }

    @Test
    public void getBusinessArea() {
    }
}