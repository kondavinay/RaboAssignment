package com.rabo.customerstatment.util;

import com.rabo.customerstatment.domain.CustomerStatmentRecord;
import com.rabo.customerstatment.domain.CustomerStatmentRecords;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


/**
 * This is  utility class for reusable methods
 * @author Vinay Konda
 */

public class FileParsing {

    /**
     * The logger.
     */
    private final Logger logger = LoggerFactory.getLogger(FileParsing.class);

    /**
     * This method parses the csv file date to{@link CustomerStatmentRecord}
     *
     * @param csvInputData
     * @throws IOException
     */

    public static CustomerStatmentRecords csvParse(StringReader csvInputData) throws IOException {

        CustomerStatmentRecords records = new CustomerStatmentRecords();

        try (CSVParser csvParser = new CSVParser(csvInputData,
                CSVFormat.DEFAULT.
                        withFirstRecordAsHeader().
                        withIgnoreHeaderCase().
                        withTrim());
        ) {
            List<CustomerStatmentRecord> record = new ArrayList<>();

            csvParser.forEach(csvRecord -> record.add(
                    new CustomerStatmentRecord(csvRecord.get("Reference"),
                            csvRecord.get("AccountNumber"),
                            csvRecord.get("Description"),
                            csvRecord.get("Mutation"),
                            csvRecord.get("End Balance"),
                            csvRecord.get("Start Balance")))
            );

            records.setRecord(record);
        }
        return records;
    }

    /**
     * To unmarshall the xml
     *
     * @param xmlInputData
     * @param clazz
     * @return Object of type clazz
     * @throws JAXBException
     */
    public static Object xmlParse(StringReader xmlInputData, Class clazz) throws JAXBException {
        CustomerStatmentRecords records = new CustomerStatmentRecords();
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return jaxbUnmarshaller.unmarshal(xmlInputData);
    }


}

