package br.com.jtech.tasklist.application.core.usecases;

import br.com.jtech.tasklist.application.core.domains.Tasklist;
import br.com.jtech.tasklist.application.ports.input.FetchTasklistInputGateway;
import br.com.jtech.tasklist.application.ports.output.FetchTasklistOutputGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchTasklistUseCase implements FetchTasklistInputGateway {

    private final FetchTasklistOutputGateway fetchTasklistOutputGateway;

    @Override
    public List<Tasklist> fetchAll() {
        return fetchTasklistOutputGateway.fetchAll() ;
    }

    @Override
    public Tasklist fetchById(String id) {
        return fetchTasklistOutputGateway.fetchById(id);
    }
}
