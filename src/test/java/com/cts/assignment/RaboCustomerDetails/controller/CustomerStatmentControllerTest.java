package com.cts.assignment.RaboCustomerDetails.controller;

import com.cts.assignment.RaboCustomerDetails.Controller.CustomerStatmentController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

/**
 * Unit test for {@link CustomerStatmentController}
 *
 * @author vinay konda
 */

@RunWith(MockitoJUnitRunner.class)
public class CustomerStatmentControllerTest {


    @InjectMocks
    CustomerStatmentController CustomerStatmentController;

    @Mock
    com.cts.assignment.RaboCustomerDetails.service.CustomerStatmentServiceImpl CustomerStatmentServiceImpl;

    @Mock
    MultipartFile multipartFile;


    @Test
    public void initiateTransaction_withValidCsvData_WillProcessAndReturnReport() throws IOException {

        when(multipartFile.getBytes()).thenReturn(
                "Reference,AccountNumber,Description,Start Balance,Mutation,End Balance\n194261,NL91RABO0315273637,Clothes from Jan Bakker,21.6,-41.83,-20.23"
                        .getBytes());
        when(multipartFile.getOriginalFilename()).thenReturn("file.csv");
        assertNotNull(CustomerStatmentController.fileUpload(multipartFile));
    }

    @Test
    public void initiateTransaction_withValidXmlData_WillProcessAndReturnReport() throws IOException {

        when(multipartFile.getBytes()).thenReturn(
                "<records><record reference=\"130498\"><accountNumber>NL69ABNA0433647324</accountNumber><description>Tickets for Peter Theuß</description><startBalance>26.9</startBalance><mutation>-18.78</mutation><endBalance>8.12</endBalance></record></records>"
                        .getBytes());
        when(multipartFile.getOriginalFilename()).thenReturn("file.xml");
        assertNotNull(CustomerStatmentController.fileUpload(multipartFile));
    }

/*
        * this methods tests the negative scenerio by passing the incorrect data
        * the error message should be displayed.
 */
    @Test
    public void initiateTransaction_withInValidCsvData_willReturnErrorReport() throws Exception {

        when(multipartFile.isEmpty()).thenReturn(false);
        when(multipartFile.getBytes()).thenReturn(
                "Reference,AccountNumber,Descriptin,Start Balance,Mutation,End Balance\n194261,NL91RABO0315273637,Clothes from Jan Bakker,21.6,-41.83,-20.23"
                        .getBytes());
        when(multipartFile.getOriginalFilename()).thenReturn("file.csv");
        assertNotNull(CustomerStatmentController.fileUpload(multipartFile));
    }

    @Test
    public void initiateTransaction_withInValidXmlData_willReturnErrorReport() throws Exception {

        when(multipartFile.isEmpty()).thenReturn(false);
        when(multipartFile.getBytes()).thenReturn(
                "<record><record reference=\"130498\"><accountNumber>NL69ABNA0433647324</accountNumber><description>Tickets for Peter Theuß</description><startBalance>26.9</startBalance><mutation>-18.78</mutation><endBalance>8.12</endBalance></record></records>"
                        .getBytes());
        when(multipartFile.getOriginalFilename()).thenReturn("file.xml");
        assertNotNull(CustomerStatmentController.fileUpload(multipartFile));
    }
}
