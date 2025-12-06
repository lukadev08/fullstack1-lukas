package br.com.jtech.tasklist.adapters.input.controllers;

import br.com.jtech.tasklist.adapters.input.protocols.TasklistResponse;
import br.com.jtech.tasklist.application.core.domains.Tasklist;
import br.com.jtech.tasklist.application.ports.input.FetchTasklistInputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasklists")
@RequiredArgsConstructor
public class FetchTasklistController {

    private final FetchTasklistInputGateway fetchTasklistInputGateway;

    @GetMapping("/{id}")
    public ResponseEntity<TasklistResponse> fetchById(@PathVariable String id) {
        Tasklist tasklist = fetchTasklistInputGateway.fetchById(id);
        return ResponseEntity.ok(TasklistResponse.of(tasklist));
     }

    @GetMapping
    public ResponseEntity<List<TasklistResponse>> fetchAllTasklists() {
        List<Tasklist> tasklists = fetchTasklistInputGateway.fetchAll();
        List<TasklistResponse> response = tasklists.stream().map(TasklistResponse::of).toList();
        return ResponseEntity.ok(response);
     }
}
