package com.todo.modules.taskcategory.usecase.list;

import com.todo.utils.commons.UseCaseRequest;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record GetCategoryRequest() implements UseCaseRequest {
}
