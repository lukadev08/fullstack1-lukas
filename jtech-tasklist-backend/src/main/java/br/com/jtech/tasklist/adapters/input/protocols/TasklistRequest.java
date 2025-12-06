/*
 *  @(#)TasklistRequest.java
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
package br.com.jtech.tasklist.adapters.input.protocols;

import br.com.jtech.tasklist.application.core.domains.TaskStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
* class TasklistRequest 
* 
* user angelo.vicente 
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TasklistRequest implements Serializable {

    private String id;

    @NotBlank(message = "A title is required")
    private String title;

    @NotBlank(message = "A description is required")
    @Size(max = 1000, message = "The description must be at most 1000 characters long")
    private String description;

    @NotBlank(message = "A status is required and must be PENDING, IN_PROGRESS, COMPLETED or CANCELLED")
    private TaskStatus status;

    private List<TasklistRequest> requests;
}