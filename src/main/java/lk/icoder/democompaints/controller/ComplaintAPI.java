package lk.icoder.democompaints.controller;

import lk.icoder.democompaints.entity.ComplaintQueryObject;
import lk.icoder.democompaints.repository.ComplaintQueryObjectRepository;
import lk.icoder.democompaints.util.FileComplaintCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * @Project demo-compaints
 * @Author DILAN on 5/13/2018
 */
@RestController
public class ComplaintAPI {

    private final ComplaintQueryObjectRepository complaintQueryObjectRepository;
    private final CommandGateway commandGateway;
    private FileComplaintCommand fileComplaintCommand;

    public ComplaintAPI(ComplaintQueryObjectRepository complaintQueryObjectRepository,
                        CommandGateway commandGateway,
                        FileComplaintCommand fileComplaintCommand) {
        this.complaintQueryObjectRepository = complaintQueryObjectRepository;
        this.commandGateway = commandGateway;
        this.fileComplaintCommand = fileComplaintCommand;
    }

    @PostMapping
    private CompletableFuture<String> fileComplaint(@RequestBody Map<String, String> request) {
        String id = UUID.randomUUID().toString();
        return commandGateway.send(fileComplaintCommand.setId(id)
                .setCompany(request.get("company"))
                .setDescription(request.get("description")));
    }

    @GetMapping("/")
    private List<ComplaintQueryObject> getAll() {
        return complaintQueryObjectRepository.findAll();
    }

    @GetMapping("/{id}")
    private ComplaintQueryObject find(@PathVariable String id) {
        return complaintQueryObjectRepository.getOne(id);
    }

}
