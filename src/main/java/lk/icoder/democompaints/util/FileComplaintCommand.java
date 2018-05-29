package lk.icoder.democompaints.util;

import org.springframework.stereotype.Component;

/**
 * @Project demo-compaints
 * @Author DILAN on 5/13/2018
 */
@Component
public class FileComplaintCommand {

    private String id;
    private String company;
    private String description;

    public FileComplaintCommand() {
    }

    public FileComplaintCommand(String id, String company, String description) {
        this.id = id;
        this.company = company;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public FileComplaintCommand setId(String id) {
        this.id = id;
        return this;
    }

    public FileComplaintCommand setCompany(String company) {
        this.company = company;
        return this;
    }

    public FileComplaintCommand setDescription(String description) {
        this.description = description;
        return this;
    }
}
