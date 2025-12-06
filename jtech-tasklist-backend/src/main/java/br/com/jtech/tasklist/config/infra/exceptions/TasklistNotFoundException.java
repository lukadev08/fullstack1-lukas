package br.com.jtech.tasklist.config.infra.exceptions;

public class TasklistNotFoundException extends RuntimeException {
    public TasklistNotFoundException(String id) {
        super("Tasklist with ID [" + id + "] not found.");
    }
}
