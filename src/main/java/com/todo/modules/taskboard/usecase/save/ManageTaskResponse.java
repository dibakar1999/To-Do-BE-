package com.todo.modules.taskboard.usecase.save;

import com.todo.utils.commons.UseCaseResponse;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record ManageTaskResponse(
        String id
) implements UseCaseResponse {
}
