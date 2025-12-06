package br.com.jtech.tasklist.adapters.output;

import br.com.jtech.tasklist.adapters.output.repositories.TasklistRepository;
import br.com.jtech.tasklist.adapters.output.repositories.entities.TasklistEntity;
import br.com.jtech.tasklist.application.core.domains.Tasklist;
import br.com.jtech.tasklist.application.ports.output.UpdateTasklistOutputGateway;
import br.com.jtech.tasklist.config.infra.exceptions.TasklistNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UpdateTasklistAdapter implements UpdateTasklistOutputGateway {

    private final TasklistRepository repository;

    @Override
    public Tasklist update(String id, Tasklist tasklist) {
        repository.findById(UUID.fromString(id)).orElseThrow(() ->
                new TasklistNotFoundException(id));

        TasklistEntity targetEntity = tasklist.toEntity();
        targetEntity.setId(UUID.fromString(id));

        TasklistEntity updatedEntity = repository.save(targetEntity);

        return Tasklist.of(updatedEntity);
    }
}
