package com.cts.assignment.RaboCustomerDetails.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Domain class for holding {@link List} of {@link CustomerStatmentRecord}'s
 *
 * @author Vinay Konda
 *
 */

@XmlRootElement(name = "records")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerStatmentRecords {

    @XmlElement(name = "record")
    private List<CustomerStatmentRecord> record;

    public List<CustomerStatmentRecord> getRecord() {
        return record;
    }

    public void setRecord(List<CustomerStatmentRecord> record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "Records [record = " + record + "]";
    }

}
