package com.rabo.customerstatment.service;

import com.rabo.customerstatment.domain.CustomerStatmentRecord;
import com.rabo.customerstatment.domain.CustomerStatmentRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class CustomerStatmentServiceImpl implements CustomerStatmentService {

    /**
     * The logger.
     */
    private final Logger logger = LoggerFactory.getLogger(CustomerStatmentServiceImpl.class);

    /*
     ** This method returns the valid records and invalid records after proper validation
     ** @param CustomerStatmentRecords
     ** @return records
     */

    public Map<String, ArrayList<CustomerStatmentRecord>> validRecords(CustomerStatmentRecords transactionRecords) {

        logger.info("valid and invalid on the records based on reference and endbalance");

        ArrayList<CustomerStatmentRecord> validRecords = new ArrayList<>();
        ArrayList<CustomerStatmentRecord> inValidRecords = new ArrayList<>();
        Map<String, ArrayList<CustomerStatmentRecord>> records = new HashMap<>();

        transactionRecords.getRecord().forEach(record -> {
            if (validateRecords(record, validRecords)) {
                validRecords.add(record);
            } else {
                inValidRecords.add(record);

            }

        });

        records.put("validrecords", validRecords);
        records.put("invalidRecords", inValidRecords);

        return records;


    }
    /*
     ** This method validates the records based on refernce and end balance
     * @param CustomerStatmentRecord
     */

    public boolean validateRecords(CustomerStatmentRecord record, ArrayList<CustomerStatmentRecord> validRecords) {

        double endBalance = Double.parseDouble(record.getStartBalance()) + Double.parseDouble(record.getMutation());

        endBalance = BigDecimal.valueOf(endBalance).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        boolean isReferenceExists = validRecords.stream()
                .anyMatch(validRecord -> validRecord.getReference().equals(record.getReference()));

        if (endBalance == Double.parseDouble(record.getEndBalance()) && !isReferenceExists) {
            return true;
        } else {
            return false;
        }
    }

}




