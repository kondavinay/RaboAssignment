package com.rabo.customerstatment.service;

import com.rabo.customerstatment.domain.CustomerStatmentRecord;
import com.rabo.customerstatment.domain.CustomerStatmentRecords;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for {@link CustomerStatmentServiceImpl}
 *
 * @author vinay konda
 */

@RunWith(MockitoJUnitRunner.class)
public class CustomerStatmentServiceImplTest {

    @InjectMocks
    private CustomerStatmentServiceImpl CustomerStatmentServiceImpl;

    @Test
    public void testForValidRecords() {

        CustomerStatmentRecords transactionRecords = new CustomerStatmentRecords();
        List<CustomerStatmentRecord> transactionRecord = new ArrayList<CustomerStatmentRecord>();
        transactionRecord.add(new CustomerStatmentRecord("112806",
                "NL91RABO0315273637",
                "Clothes from Jan Bakker",
                "91.23",
                "15.57",
                "106.8")
        );

        transactionRecord.add(new CustomerStatmentRecord("183049",
                "NL69ABNA0433647324",
                "Clothes for Jan King",
                "86.66",
                "44.5",
                "131.16")
        );
        transactionRecords.setRecord(transactionRecord);
        Map<String, ArrayList<CustomerStatmentRecord>> records = new HashMap<>();
        records = CustomerStatmentServiceImpl.validRecords(transactionRecords);
        assertNotNull(records.containsKey("validRecords"));
        assertEquals(2,records.size());


    }
    @Test
    public void testForInvalidRecords() {

        CustomerStatmentRecords transactionRecords = new CustomerStatmentRecords();

        List<CustomerStatmentRecord> transactionRecord = new ArrayList<CustomerStatmentRecord>();

        transactionRecord.add(new CustomerStatmentRecord("194261",
                "NL91RABO0315273637",
                "Clothes from Jan Bakker",
                "21.6",
                "-41.83",
                "21.6")
        );

        transactionRecord.add(new CustomerStatmentRecord("194261",
                "NL91RABO0315273637",
                "Clothes from Jan Bakker",
                "21.6",
                "-41.83",
                "21.6")
        );
        transactionRecord.add(new CustomerStatmentRecord("112806",
                "NL91RABO0315273637",
                "Clothes from Jan Bakker",
                "91.23",
                "15.57",
                "106.8")
        );

        transactionRecords.setRecord(transactionRecord);

        Map<String, ArrayList<CustomerStatmentRecord>> records = new HashMap<>();
        records = CustomerStatmentServiceImpl.validRecords(transactionRecords);

        assertNotNull(records.containsKey("invalidRecords"));
        assertEquals(2,records.size());


    }
}