package com.todo.modules.taskboard.usecase.save;

import com.todo.entity.TaskEntity;
import com.todo.repositories.TaskRepository;
import com.todo.utils.commons.UseCase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Component
public class ManageTaskUsecase implements UseCase<ManageTaskRequest, ManageTaskResponse> {
    private final TaskRepository taskRepository;

    public ManageTaskUsecase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<ManageTaskResponse> execute(ManageTaskRequest request) {
        TaskEntity entity = new TaskEntity();
        entity.setId(UUID.randomUUID().toString().toUpperCase());
        entity.setName(request.task());
        entity.setActive(true);
        entity.setCategoryCode(request.categoryCode());
        entity.setDueDate(request.dueDate());
        entity.setRepeatTask(request.repeatDate());
        entity.setDueDate(request.dueDate());
        entity.setCreatedOn(LocalDateTime.now());
        TaskEntity saved = this.taskRepository.save(entity);
        return Optional.ofNullable(ManageTaskResponseBuilder.builder()
                .id(saved.getId())
                .build());
    }
}
