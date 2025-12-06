package br.com.jtech.tasklist.application.ports.input;

import br.com.jtech.tasklist.application.core.domains.Tasklist;

import java.util.List;

public interface FetchTasklistInputGateway {

    List<Tasklist> fetchAll();

    Tasklist fetchById(String id);
}
