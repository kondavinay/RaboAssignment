package com.cts.assignment.RaboCustomerDetails.Controller;


import com.cts.assignment.RaboCustomerDetails.domain.CustomerStatmentRecord;
import com.cts.assignment.RaboCustomerDetails.domain.CustomerStatmentRecords;
import com.cts.assignment.RaboCustomerDetails.service.CustomerStatmentService;
import com.cts.assignment.RaboCustomerDetails.util.FileParsing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Map;


/**
 * CustomerStatmentController used for mapping report related requests
 *
 * @author VinayKonda
 */

@RestController
@RequestMapping("/rabo")

public class CustomerStatmentController {
    @Autowired
    CustomerStatmentService transactionService;

    private final Logger logger = LoggerFactory.getLogger(CustomerStatmentController.class);

    @PostMapping("/customerdetails")
    public Map<String, ArrayList<CustomerStatmentRecord>> fileUpload(@RequestParam("file") MultipartFile file
    ) {
        CustomerStatmentRecords transactionRecords = null;

        try {

            StringReader fileReader = new StringReader(new String(file.getBytes()));


            if (file.getOriginalFilename().endsWith(".xml")) {
                logger.info("processing the xml file reader");

                transactionRecords = (CustomerStatmentRecords) FileParsing.xmlParse(fileReader, CustomerStatmentRecords.class);

            } else {
                logger.info("processing the csv file reader");

                transactionRecords = FileParsing.csvParse(fileReader);

            }

            logger.info("CustomerStatmentRecords: {}", transactionRecords.getRecord());
        } catch (Exception e) {

            logger.info("Error occured while processing the file");

            e.printStackTrace();
        }

        return transactionService.validRecords(transactionRecords);

    }
}