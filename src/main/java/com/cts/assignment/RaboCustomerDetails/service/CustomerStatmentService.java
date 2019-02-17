package com.cts.assignment.RaboCustomerDetails.service;

import com.cts.assignment.RaboCustomerDetails.domain.CustomerStatmentRecord;
import com.cts.assignment.RaboCustomerDetails.domain.CustomerStatmentRecords;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Map;

/**
 * Interface for CustomerStatmentService
 *
 */


@Service
/**
 * This method returns the valid records after validation
 *
 * @param CustomerStatmentRecords
 * @return Map<String, ArrayList<CustomerStatmentRecord>>
 */
public interface CustomerStatmentService {

    Map<String, ArrayList<CustomerStatmentRecord>> validRecords(CustomerStatmentRecords transactionRecords);

}
