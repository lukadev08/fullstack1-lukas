package br.com.jtech.tasklist.adapters.input.controllers;

import br.com.jtech.tasklist.adapters.input.protocols.TasklistRequest;
import br.com.jtech.tasklist.adapters.input.protocols.TasklistResponse;
import br.com.jtech.tasklist.application.core.domains.Tasklist;
import br.com.jtech.tasklist.application.ports.input.UpdateTasklistInputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasklists")
@RequiredArgsConstructor
public class UpdateTasklistController {

    private final UpdateTasklistInputGateway updateTasklistInputGateway;

    @PutMapping("/{id}")
    public ResponseEntity<TasklistResponse> updateTasklist(@PathVariable String id, @RequestBody TasklistRequest request) {
        Tasklist updatedTasklist = updateTasklistInputGateway.update(id, Tasklist.of(request));
        return ResponseEntity.ok(TasklistResponse.of(updatedTasklist));
    }
}
