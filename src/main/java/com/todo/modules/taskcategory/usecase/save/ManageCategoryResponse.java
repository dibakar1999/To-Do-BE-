package com.todo.modules.taskcategory.usecase.save;

import com.todo.utils.commons.UseCaseResponse;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record ManageCategoryResponse(
        String id
) implements UseCaseResponse {
}
