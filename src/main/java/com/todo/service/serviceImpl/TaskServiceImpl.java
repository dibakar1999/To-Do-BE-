package com.todo.service.serviceImpl;

import com.todo.dto.UpdateRequest;
import com.todo.entity.TaskEntity;
import com.todo.modules.taskboard.usecase.adaptor.TaskResponseDto;
import com.todo.modules.taskboard.usecase.adaptor.TaskResponseDtoBuilder;
import com.todo.modules.taskboard.usecase.list.GetTaskRequest;
import com.todo.modules.taskboard.usecase.list.GetTaskResponse;
import com.todo.modules.taskboard.usecase.list.GetTaskResponseBuilder;
import com.todo.modules.taskboard.usecase.save.ManageTaskRequest;
import com.todo.modules.taskboard.usecase.save.ManageTaskResponse;
import com.todo.modules.taskboard.usecase.save.ManageTaskResponseBuilder;
import com.todo.repositories.TaskRepository;
import com.todo.service.TaskService;
import com.todo.utils.commons.HelperUtils;
import com.todo.utils.commons.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<ManageTaskResponse> save(ManageTaskRequest request) {
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

    @Override
    public GetTaskResponse findByCategory(GetTaskRequest request) {
        List<TaskResponseDto> taskResponseDtoList = new ArrayList<>();
        if (request.code().equals(Task.MY_DAY.code())) {
            var taskEntities = this.taskRepository.findByCategoryCodeAndStatusIsNull(request.code());
            taskEntities.forEach(entity -> taskResponseDtoList.add(toListResponse(entity)));
        } else if (request.code().equals(Task.COMPLETED.code)) {
            var taskEntities = this.taskRepository.findAllByStatus(Task.COMPLETED.code);
            taskEntities.forEach(entity -> taskResponseDtoList.add(toListResponse(entity)));
        }

        return GetTaskResponseBuilder.builder()
                .taskResponseDtoList(taskResponseDtoList)
                .build();
    }

    @Override
    public Optional<String> update(UpdateRequest request) {
        var taskEntity = this.taskRepository.findById(request.id()).orElseThrow(() -> new IllegalArgumentException("Record not found"));
        TaskEntity entity = new TaskEntity();
        entity.setId(taskEntity.getId());
        entity.setActive(taskEntity.isActive());
        entity.setCreatedOn(taskEntity.getCreatedOn());
        entity.setModifiedOn(LocalDateTime.now());
        entity.setDueDate(taskEntity.getDueDate());
        entity.setImageId(taskEntity.getImageId());
        entity.setName(taskEntity.getName());
        entity.setNote(taskEntity.getNote());
        entity.setCategoryCode(taskEntity.getCategoryCode());
        entity.setRepeatTask(taskEntity.getRepeatTask());
        entity.setUserId(taskEntity.getUserId());
        if (request.isImportant())
            entity.setImportant(true);
        if (request.isCompleted())
            entity.setStatus(Task.COMPLETED.code);
        var saved = this.taskRepository.save(entity);
        return Optional.ofNullable(saved.getId());
    }

    private TaskResponseDto toListResponse(TaskEntity entity) {
        TaskResponseDtoBuilder builder = TaskResponseDtoBuilder.builder();
        builder.id(entity.getId())
                .task(entity.getName())
                .status(entity.getStatus())
                .categoryCode(entity.getCategoryCode())
                .categoryName(entity.getName())
                .build();
        builder.isCompleted(HelperUtils.notBlankOrNull(entity.getStatus()) && entity.getStatus().equals(Task.COMPLETED.code));
        return builder.build();
    }
}
