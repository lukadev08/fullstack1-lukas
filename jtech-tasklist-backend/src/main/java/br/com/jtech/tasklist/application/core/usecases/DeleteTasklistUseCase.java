package br.com.jtech.tasklist.application.core.usecases;

import br.com.jtech.tasklist.application.ports.input.DeleteTasklistInputGateway;
import br.com.jtech.tasklist.application.ports.output.DeleteTasklistOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTasklistUseCase implements DeleteTasklistInputGateway {

    private final DeleteTasklistOutputGateway deleteTasklistOutputGateway;

    @Override
    public void delete(String id) {
        deleteTasklistOutputGateway.delete(id);
    }
}
