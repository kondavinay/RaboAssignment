package com.cts.assignment.RaboCustomerDetails.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Domain class for holding {@link List} of {@link TransactionRecord}'s
 *
 * @author Vinay Konda
 *
 */

@XmlRootElement(name = "records")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionRecords {

    @XmlElement(name = "record")
    private List<TransactionRecord> record;

    public List<TransactionRecord> getRecord() {
        return record;
    }

    public void setRecord(List<TransactionRecord> record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "Records [record = " + record + "]";
    }

}
