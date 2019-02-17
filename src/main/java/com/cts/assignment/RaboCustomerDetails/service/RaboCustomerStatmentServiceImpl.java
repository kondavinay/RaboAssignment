package com.cts.assignment.RaboCustomerDetails.service;

import com.cts.assignment.RaboCustomerDetails.domain.TransactionRecord;
import com.cts.assignment.RaboCustomerDetails.domain.TransactionRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class RaboCustomerStatmentServiceImpl implements RaboCustomerStatmentService {

    /**
     * The logger.
     */
    private final Logger logger = LoggerFactory.getLogger(RaboCustomerStatmentServiceImpl.class);

    public Map<String, ArrayList<TransactionRecord>> validRecords(TransactionRecords transactionRecords) {

        logger.info("valid and invalid on the records based on reference and endbalance");

        ArrayList<TransactionRecord> validRecords = new ArrayList<>();
        ArrayList<TransactionRecord> inValidRecords = new ArrayList<>();
        Map<String, ArrayList<TransactionRecord>> records = new HashMap<>();

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


    public boolean validateRecords(TransactionRecord record, ArrayList<TransactionRecord> validRecords) {

        double endBalance = Double.parseDouble(record.getStartBalance()) + Double.parseDouble(record.getMutation());

        //precession conververion for accurate value
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




