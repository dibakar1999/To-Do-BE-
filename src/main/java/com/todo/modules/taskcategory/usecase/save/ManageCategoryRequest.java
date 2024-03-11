package com.todo.modules.taskcategory.usecase.save;

import com.todo.utils.commons.UseCaseRequest;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record ManageCategoryRequest(
        String name
) implements UseCaseRequest {
}
