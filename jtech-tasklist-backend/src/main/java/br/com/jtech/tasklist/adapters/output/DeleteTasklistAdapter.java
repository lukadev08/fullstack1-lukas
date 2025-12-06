package br.com.jtech.tasklist.adapters.output;

import br.com.jtech.tasklist.adapters.output.repositories.TasklistRepository;
import br.com.jtech.tasklist.application.ports.output.DeleteTasklistOutputGateway;
import br.com.jtech.tasklist.config.infra.exceptions.TasklistNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeleteTasklistAdapter implements DeleteTasklistOutputGateway {

    private final TasklistRepository repository;

    @Override
    public void delete(String id) {
        repository.findById(UUID.fromString(id)).orElseThrow(()
            -> new TasklistNotFoundException(id));

        repository.deleteById(UUID.fromString(id));
    }
}
