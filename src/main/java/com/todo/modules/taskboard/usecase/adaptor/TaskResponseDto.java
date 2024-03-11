package com.todo.modules.taskboard.usecase.adaptor;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record TaskResponseDto(
        String task,
        String status,
        String categoryCode,
        String categoryName
)  {
}
