package com.wurf.qifconvert;

import com.wurf.qifconvert.builder.QifBuilderTest;
import com.wurf.qifconvert.dto.Csv;
import com.wurf.qifconvert.dto.hibiscus1.Hibiscus1;
import com.wurf.qifconvert.dto.qif.QifDto;
import com.wurf.qifconvert.util.XmlDiff;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class QifMapperTest {

    private static final String EXPECTED = "com/wurf/qifconvert/expectedHibiscusDto.xml";

    @Test
    public void test() throws IOException, SAXException {
        XmlDiff.compare(getTestDtos(), EXPECTED);
    }

    public static List<Csv<Hibiscus1>> getTestDtos() {
        QifDto qifDto = QifBuilderTest.getTestDtos();
        return new QifMapper().toCsv(qifDto, Hibiscus1.class);
    }
}
