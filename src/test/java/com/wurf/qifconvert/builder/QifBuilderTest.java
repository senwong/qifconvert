package com.wurf.qifconvert.builder;

import com.wurf.qifconvert.dto.qif.QifDto;
import com.wurf.qifconvert.util.ResourceParseUtil;
import com.wurf.qifconvert.util.XmlDiff;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class QifBuilderTest {

    private static final String EXPECTED = "com/wurf/qifconvert/builder/expectedDto.xml";

    public static final String RESOURCE = "com/wurf/qifconvert/homebank.qif";

    @Test
    public void getAccounts() throws IOException, SAXException {
        new XmlDiff().compare(getTestDtos(), EXPECTED);
    }

    public static QifDto getTestDtos() {
        List<String> strings = ResourceParseUtil.parseResource(RESOURCE);
        return QifBuilder.getQifDto(strings);
    }
}
