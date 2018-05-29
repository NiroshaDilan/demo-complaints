package lk.icoder.democompaints.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Project demo-compaints
 * @Author DILAN on 5/13/2018
 */
@Entity
public class ComplaintQueryObject {

    @Id
    private String complaintId;
    private String company;
    private String description;

    public ComplaintQueryObject() {
    }

    public ComplaintQueryObject(String complaintId, String company, String description) {
        this.complaintId = complaintId;
        this.company = company;
        this.description = description;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }
}
