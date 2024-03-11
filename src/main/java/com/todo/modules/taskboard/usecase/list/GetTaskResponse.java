package com.todo.modules.taskboard.usecase.list;

import com.todo.utils.commons.UseCaseResponse;
import com.todo.modules.taskboard.usecase.adaptor.TaskResponseDto;
import io.soabase.recordbuilder.core.RecordBuilder;

import java.util.List;

@RecordBuilder
public record GetTaskResponse(
        List<TaskResponseDto> taskResponseDtoList
) implements UseCaseResponse {
}
