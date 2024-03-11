package com.todo.service;

import com.todo.modules.taskboard.usecase.list.GetTaskRequest;
import com.todo.modules.taskboard.usecase.list.GetTaskResponse;
import com.todo.modules.taskboard.usecase.save.ManageTaskRequest;
import com.todo.modules.taskboard.usecase.save.ManageTaskResponse;

import java.util.Optional;

public interface TaskService {
    Optional<ManageTaskResponse> save(ManageTaskRequest request);

    GetTaskResponse findByCategory(GetTaskRequest request);
}
