package com.cts.assignment.RaboCustomerDetails.Controller;


import com.cts.assignment.RaboCustomerDetails.domain.TransactionRecord;
import com.cts.assignment.RaboCustomerDetails.domain.TransactionRecords;
import com.cts.assignment.RaboCustomerDetails.service.RaboCustomerStatmentService;
import com.cts.assignment.RaboCustomerDetails.util.FileParsing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Map;


/**
 * RaboCustomerStatmentController used for mapping report related requests
 *
 * @author
 */

@RestController
@RequestMapping("/rabo")
public class RaboCustomerStatmentController {


    @Autowired
    RaboCustomerStatmentService transactionService;

    private final Logger logger = LoggerFactory.getLogger(RaboCustomerStatmentController.class);

    @PostMapping("/customerdetails")
    public Map<String, ArrayList<TransactionRecord>> singleFileUpload(@RequestParam("file") MultipartFile file
    ) {
        TransactionRecords transactionRecords = null;

        try {

            StringReader fileReader = new StringReader(new String(file.getBytes()));


            if (file.getOriginalFilename().endsWith(".xml")) {
                logger.info("processing the xml file reader");

                transactionRecords = (TransactionRecords) FileParsing.xmlParse(fileReader, TransactionRecords.class);

            } else {
                logger.info("processing the csv file reader");

                transactionRecords = FileParsing.csvParse(fileReader);

            }

            logger.info("TransactionRecords: {}", transactionRecords.getRecord());
        } catch (Exception e) {

            logger.info("Error occured while processing the file");

            e.printStackTrace();
        }

        return transactionService.validRecords(transactionRecords);

    }
}