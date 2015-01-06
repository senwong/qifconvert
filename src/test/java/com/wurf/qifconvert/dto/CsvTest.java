package com.wurf.qifconvert.dto;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wurf.qifconvert.QifMapperTest;
import com.wurf.qifconvert.dto.hibiscus1.Hibiscus1;

public class CsvTest {

    private Hibiscus1 transaction;

    @Before
    public void setup() {
        List<Csv<Hibiscus1>> testDtos = QifMapperTest.getTestDtos();
        transaction = testDtos.iterator().next().getTransactions().iterator().next();
    }

    @Test
    public void testHibiscusToString() {
        Assert.assertEquals(";10.11.2009;10.11.2009;;10,00;Ich;;;;;;Einkommen:Umbuchung;UWE FRICKE UMBUCHUNG;;;;;;;;;;;;;", transaction.toString().trim());
    }

    @Test
    public void testHeader() {
        Csv<Hibiscus1> csv = new Csv<>();
        csv.addTransaction(transaction);
        Assert.assertTrue(csv.toString().startsWith(Hibiscus1.HEADER));
    }
}
