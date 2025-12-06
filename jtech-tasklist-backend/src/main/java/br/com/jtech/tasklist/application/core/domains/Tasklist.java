/*
*  @(#)Tasklist.java
*
*  Copyright (c) J-Tech Solucoes em Informatica.
*  All Rights Reserved.
*
*  This software is the confidential and proprietary information of J-Tech.
*  ("Confidential Information"). You shall not disclose such Confidential
*  Information and shall use it only in accordance with the terms of the
*  license agreement you entered into with J-Tech.
*
*/
package br.com.jtech.tasklist.application.core.domains;

import br.com.jtech.tasklist.adapters.input.protocols.TasklistRequest;
import br.com.jtech.tasklist.adapters.output.repositories.entities.TasklistEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


/**
* class Tasklist
*
* user angelo.vicente
*/
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Tasklist {

    private String id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static List<Tasklist> of(List<TasklistEntity> entities) {
        return entities.stream().map(Tasklist::of).toList();
     }

    public TasklistEntity toEntity() {
        return TasklistEntity.builder()
            .id(getId() != null ? UUID.fromString(getId()) : null)
                .title(getTitle())
                .description(getDescription())
                .status(getStatus())
                .createdAt(createdAt)
                .updatedAt(updatedAt)
            .build();
     }

    public static Tasklist of(TasklistEntity entity) {
        return Tasklist.builder()
            .id(entity.getId().toString())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
            .build();
     }

    public static Tasklist of(TasklistRequest request) {
        return Tasklist.builder()
            .id(request.getId())
            .title(request.getTitle())
            .description(request.getDescription())
            .status(request.getStatus() != null ? request.getStatus() : TaskStatus.PENDING)
            .build();
     }
 }