package com.todo.dto;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record UpdateRequest(
        String id,
        boolean isImportant,
        boolean isCompleted
) {
}
