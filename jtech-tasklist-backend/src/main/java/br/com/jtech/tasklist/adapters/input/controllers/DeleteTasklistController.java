package br.com.jtech.tasklist.adapters.input.controllers;

import br.com.jtech.tasklist.application.ports.input.DeleteTasklistInputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasklists")
@RequiredArgsConstructor
public class DeleteTasklistController {

    private final DeleteTasklistInputGateway deleteTasklistInputGateway;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTasklist(@PathVariable String id) {
        deleteTasklistInputGateway.delete(id);
        return ResponseEntity.noContent().build();
    }
}