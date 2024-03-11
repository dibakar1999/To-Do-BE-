package com.todo.modules.taskcategory.usecase.list;

import com.todo.utils.commons.UseCaseResponse;
import com.todo.modules.taskcategory.usecase.adaptor.CategoryDto;
import io.soabase.recordbuilder.core.RecordBuilder;

import java.util.List;

@RecordBuilder
public record GetCategoryResponse(
        List<CategoryDto> categoryDtoList
) implements UseCaseResponse {

}
