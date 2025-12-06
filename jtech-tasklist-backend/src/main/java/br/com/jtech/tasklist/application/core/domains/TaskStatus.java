package br.com.jtech.tasklist.application.core.domains;

public enum TaskStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED;

    public static TaskStatus fromString(String status) {
        return status == null ? null : TaskStatus.valueOf(status.toUpperCase());
    }
}
