package lk.icoder.democompaints.service;

import lk.icoder.democompaints.controller.ComplaintAPI;
import lk.icoder.democompaints.util.ComplaintFiledEvent;
import lk.icoder.democompaints.util.FileComplaintCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * @Project demo-compaints
 * @Author DILAN on 5/13/2018
 */
@Aggregate
public class Complaint {

    @AggregateIdentifier
    private String complaintId;

    @CommandHandler
    public Complaint(FileComplaintCommand cmd) {

        Assert.hasLength(cmd.getCompany());

        apply(new ComplaintFiledEvent(cmd.getId(), cmd.getCompany(), cmd.getDescription()));
    }

    public Complaint() {}

    @EventSourcingHandler
    public void on(ComplaintFiledEvent event) {
        this.complaintId = event.getId();
    }
}
