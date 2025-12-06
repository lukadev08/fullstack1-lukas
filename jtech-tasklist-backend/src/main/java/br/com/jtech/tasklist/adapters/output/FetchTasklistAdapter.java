package br.com.jtech.tasklist.adapters.output;

import br.com.jtech.tasklist.adapters.output.repositories.TasklistRepository;
import br.com.jtech.tasklist.application.core.domains.Tasklist;
import br.com.jtech.tasklist.application.ports.output.FetchTasklistOutputGateway;
import br.com.jtech.tasklist.config.infra.exceptions.TasklistNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FetchTasklistAdapter implements FetchTasklistOutputGateway {

    private final TasklistRepository repository;

    @Override
    public List<Tasklist> fetchAll() {
        return Tasklist.of(repository.findAll());
    }

    public Tasklist fetchById(String id) {
        return repository.findById(UUID.fromString(id)).map(Tasklist::of).orElseThrow(()
                -> new TasklistNotFoundException(id));
    }
}
