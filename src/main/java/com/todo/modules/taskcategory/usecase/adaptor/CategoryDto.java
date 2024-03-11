package com.todo.modules.taskcategory.usecase.adaptor;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record CategoryDto(
        String id,
        String name,
        String code
) {
}
