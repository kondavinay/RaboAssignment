package com.rabo.customerstatment.service;

import com.rabo.customerstatment.domain.CustomerStatmentRecord;
import com.rabo.customerstatment.domain.CustomerStatmentRecords;
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
