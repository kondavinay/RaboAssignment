package com.cts.assignment.RaboCustomerDetails.domain;


import lombok.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Domain class for holding record data
 *
 * @author Vinay Konda
 *
 */

@Data

/**
 * @param reference
 * @param accountNumber
 * @param description
 * @param mutation
 * @param endBalance
 * @param startBalance
 */

@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "record")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionRecord
{
    @XmlAttribute(name= "reference")
    private String reference;

    @XmlElement(name= "accountNumber")
    private String accountNumber;

    @XmlElement(name= "description")
    private String description;

    @XmlElement(name= "mutation")
    private String mutation;

    @XmlElement(name= "endBalance")
    private String endBalance;

    @XmlElement(name= "startBalance")
    private String startBalance;


}