package br.com.jtech.tasklist.application.core.usecases;

import br.com.jtech.tasklist.application.core.domains.Tasklist;
import br.com.jtech.tasklist.application.ports.input.UpdateTasklistInputGateway;
import br.com.jtech.tasklist.application.ports.output.UpdateTasklistOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTasklistUseCase implements UpdateTasklistInputGateway {

    private final UpdateTasklistOutputGateway updateTasklistOutputGateway;

    @Override
    public Tasklist update(String id, Tasklist tasklist) {
        return updateTasklistOutputGateway.update(id, tasklist);
    }
}
