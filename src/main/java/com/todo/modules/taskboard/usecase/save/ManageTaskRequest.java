package com.todo.modules.taskboard.usecase.save;

import com.todo.utils.commons.UseCaseRequest;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record ManageTaskRequest(
        String categoryCode,
        String task,
        String dueDate,
        String repeatDate
) implements UseCaseRequest {
}
