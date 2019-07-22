package br.com.pinalli.analisedados.model.test;

import org.junit.Before;
import org.junit.Test;

import br.com.pinalli.analisedados.model.Salesmen;

import static org.junit.Assert.*;

public class SalesmenTest {
    Salesmen testSeller;

    @Before
    public void instanceTestSeller() {
        testSeller = new Salesmen("0987654321", "Catarina", 4555.20);
    }
    @Test
    public void getCpfTest() {
        String expected = "0987654321";
        assertEquals(expected, testSeller.getCpf());
    }

    @Test
    public void getNameTest() {
        String expected = "Catarina";
        assertEquals(expected, testSeller.getName());
    }

    @Test
    public void getSalaryTest() {
        Double expected = 4555.2;
        assertEquals(expected, testSeller.getSalary());
    }
}