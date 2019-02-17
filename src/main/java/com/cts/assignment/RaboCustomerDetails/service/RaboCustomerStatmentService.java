package com.cts.assignment.RaboCustomerDetails.service;

import com.cts.assignment.RaboCustomerDetails.domain.TransactionRecord;
import com.cts.assignment.RaboCustomerDetails.domain.TransactionRecords;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Map;

/**
 * Interface for RaboCustomerStatmentService
 *
 */


@Service
/**
 * This method returns the valid records after validation
 *
 * @param transactionRecords
 * @return Map<String, ArrayList<TransactionRecord>>
 */
public interface RaboCustomerStatmentService {

    Map<String, ArrayList<TransactionRecord>> validRecords(TransactionRecords transactionRecords);

}
