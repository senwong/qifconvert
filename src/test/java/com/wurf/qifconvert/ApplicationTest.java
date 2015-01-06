package com.wurf.qifconvert;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.wurf.qifconvert.dto.Csv;
import com.wurf.qifconvert.dto.hibiscus1.Hibiscus1;

public class ApplicationTest {

    private File inputFile;

    @Before
    public void setup() throws IOException {
        inputFile = new File("target/someQifInputFile.qif");
        inputFile.createNewFile();
    }

    @After
    public void tearDown() throws IOException {
        FileUtils.forceDelete(inputFile);
    }

    @Test
    public void testGetOutputFile() throws Exception {
        Csv<Hibiscus1> hibiscus1Csv = new Csv<Hibiscus1>();
        hibiscus1Csv.setAccountName("Citibank Mastercard");
        File outputFile = Application.getOutputFile(inputFile, hibiscus1Csv);
        Assert.assertFalse(outputFile.exists());
        Assert.assertEquals("someQifInputFile.citibank_mastercard.csv", outputFile.getName());
        Assert.assertEquals(inputFile.getParentFile(), outputFile.getParentFile());

    }
}
