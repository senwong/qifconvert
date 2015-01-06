package com.wurf.qifconvert.util;

import java.io.IOException;
import java.util.List;

import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Assert;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;

public class XmlDiff {

    public static void compare(final Object o, final String expectedResource) throws IOException, SAXException {
        String expected = ResourceParseUtil.getResourceAsString(expectedResource);
        String actual = new XStream().toXML(o);
        compareXml(expected, actual);
    }

    private static void compareXml(String expected, String actual) throws SAXException, IOException {
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setNormalizeWhitespace(true);
        Diff diff = new Diff(expected, actual);
        DetailedDiff detDiff = new DetailedDiff(diff);
        List differences = detDiff.getAllDifferences();
        for (Object difference : differences) {
            System.out.println(difference);
        }
        if(!diff.similar() && !diff.identical()) {
            XMLTestCase.assertEquals(expected, actual);
        }
        Assert.assertTrue(diff.similar());
        Assert.assertTrue(diff.identical());
    }

}
