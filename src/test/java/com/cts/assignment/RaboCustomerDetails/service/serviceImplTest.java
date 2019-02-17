package com.cts.assignment.RaboCustomerDetails.service;

import com.cts.assignment.RaboCustomerDetails.domain.TransactionRecord;
import com.cts.assignment.RaboCustomerDetails.domain.TransactionRecords;
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
 * Unit test for {@link RaboCustomerStatmentServiceImpl}
 *
 * @author vinay konda
 */

@RunWith(MockitoJUnitRunner.class)
public class serviceImplTest {

    @InjectMocks
    private RaboCustomerStatmentServiceImpl transactionServiceimpl;

    @Test
    public void testForValidRecords() {

        TransactionRecords transactionRecords = new TransactionRecords();
        List<TransactionRecord> transactionRecord = new ArrayList<TransactionRecord>();
        transactionRecord.add(new TransactionRecord("112806",
                "NL91RABO0315273637",
                "Clothes from Jan Bakker",
                "91.23",
                "15.57",
                "106.8")
        );

        transactionRecord.add(new TransactionRecord("183049",
                "NL69ABNA0433647324",
                "Clothes for Jan King",
                "86.66",
                "44.5",
                "131.16")
        );
        transactionRecords.setRecord(transactionRecord);
        Map<String, ArrayList<TransactionRecord>> records = new HashMap<>();
        records = transactionServiceimpl.validRecords(transactionRecords);
        assertNotNull(records.containsKey("validRecords"));
        assertEquals(2,records.size());


    }
    @Test
    public void testForInvalidRecords() {

        TransactionRecords transactionRecords = new TransactionRecords();

        List<TransactionRecord> transactionRecord = new ArrayList<TransactionRecord>();

        transactionRecord.add(new TransactionRecord("194261",
                "NL91RABO0315273637",
                "Clothes from Jan Bakker",
                "21.6",
                "-41.83",
                "21.6")
        );

        transactionRecord.add(new TransactionRecord("194261",
                "NL91RABO0315273637",
                "Clothes from Jan Bakker",
                "21.6",
                "-41.83",
                "21.6")
        );
        transactionRecord.add(new TransactionRecord("112806",
                "NL91RABO0315273637",
                "Clothes from Jan Bakker",
                "91.23",
                "15.57",
                "106.8")
        );

        transactionRecords.setRecord(transactionRecord);

        Map<String, ArrayList<TransactionRecord>> records = new HashMap<>();
        records = transactionServiceimpl.validRecords(transactionRecords);

        assertNotNull(records.containsKey("invalidRecords"));
        assertEquals(2,records.size());


    }
}