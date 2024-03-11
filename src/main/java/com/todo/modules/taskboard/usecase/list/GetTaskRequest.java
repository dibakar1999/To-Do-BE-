package com.todo.modules.taskboard.usecase.list;

import com.todo.utils.commons.UseCaseRequest;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record GetTaskRequest(
        String code
) implements UseCaseRequest {
}
