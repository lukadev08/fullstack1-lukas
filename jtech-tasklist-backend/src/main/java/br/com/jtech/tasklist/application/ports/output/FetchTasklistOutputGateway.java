package br.com.jtech.tasklist.application.ports.output;

import br.com.jtech.tasklist.application.core.domains.Tasklist;

import java.util.List;

public interface FetchTasklistOutputGateway {
    List<Tasklist> fetchAll();
    Tasklist fetchById(String id);
}
