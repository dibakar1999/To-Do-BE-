package com.todo.modules.taskboard.usecase.list;

import com.todo.repositories.CategoryRepository;
import com.todo.utils.commons.UseCase;
import com.todo.entity.TaskEntity;
import com.todo.repositories.TaskRepository;
import com.todo.modules.taskboard.usecase.adaptor.TaskResponseDto;
import com.todo.modules.taskboard.usecase.adaptor.TaskResponseDtoBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetTaskUsecase implements UseCase<GetTaskRequest, GetTaskResponse> {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    public GetTaskUsecase(TaskRepository taskRepository,
                          CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<GetTaskResponse> execute(GetTaskRequest request) {
        List<TaskEntity> taskEntityList = this.taskRepository.findByCategoryCodeOrderByCreatedOnDesc(request.code());
        List<TaskResponseDto> taskResponseDtoList = new ArrayList<>();
        taskEntityList.forEach(taskEntity -> {
            var categoryEntity = this.categoryRepository.findById(taskEntity.getCategoryCode())
                    .orElseThrow(() -> new IllegalArgumentException("Record not found!"));
            TaskResponseDtoBuilder builder = TaskResponseDtoBuilder.builder();
            builder.task(taskEntity.getName())
                    .status(taskEntity.getStatus())
                    .categoryCode(taskEntity.getCategoryCode())
                    .categoryName(categoryEntity.getName());
            taskResponseDtoList.add(builder.build());
        });
        return Optional.ofNullable(GetTaskResponseBuilder.builder()
                .taskResponseDtoList(taskResponseDtoList)
                .build());
    }
}
