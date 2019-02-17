package com.cts.assignment.RaboCustomerDetails.util;

import com.cts.assignment.RaboCustomerDetails.domain.TransactionRecord;
import com.cts.assignment.RaboCustomerDetails.domain.TransactionRecords;
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
     * This method parses the csv file date to{@link TransactionRecord}
     *
     * @param csvInputData
     * @throws IOException
     */

    public static TransactionRecords csvParse(StringReader csvInputData) throws IOException {

        TransactionRecords records = new TransactionRecords();

        try (CSVParser csvParser = new CSVParser(csvInputData,
                CSVFormat.DEFAULT.
                        withFirstRecordAsHeader().
                        withIgnoreHeaderCase().
                        withTrim());
        ) {
            List<TransactionRecord> record = new ArrayList<>();

            csvParser.forEach(csvRecord -> record.add(
                    new TransactionRecord(csvRecord.get("Reference"),
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
        TransactionRecords records = new TransactionRecords();
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return jaxbUnmarshaller.unmarshal(xmlInputData);
    }


}

