package com.cts.assignment.RaboCustomerDetails.util;

import com.cts.assignment.RaboCustomerDetails.domain.CustomerStatmentRecords;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import javax.xml.bind.JAXBException;
import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.io.StringReader;

/**
 * Unit test for {@link FileParsing}
 *
 * @author vinay konda
 */

@RunWith(MockitoJUnitRunner.class)
public class FileParsingTest {


    @Test
    public void testCSVData() throws IOException {
        StringReader reader = new StringReader
                (new String("Reference,AccountNumber,Description,Start Balance,Mutation,End Balance\n194261,NL91RABO0315273637,Clothes from Jan Bakker,21.6,-41.83,-20.23"));

        CustomerStatmentRecords transactionRecords = FileParsing.csvParse(reader);

        assertNotNull(transactionRecords);
    }

    @Test
    public void testxmlData() throws JAXBException {

        StringReader reader = new StringReader
                (new String("<records><record reference=\"130498\"><accountNumber>NL69ABNA0433647324</accountNumber><description>Tickets for Peter Theuß</description><startBalance>26.9</startBalance><mutation>-18.78</mutation><endBalance>8.12</endBalance></record></records>"));

        CustomerStatmentRecords transactionRecords = (CustomerStatmentRecords) FileParsing.xmlParse(reader,
                CustomerStatmentRecords.class);

        assertNotNull(transactionRecords);


    }
}
