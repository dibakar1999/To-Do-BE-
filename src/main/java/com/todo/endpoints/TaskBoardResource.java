package com.todo.endpoints;

import com.todo.dto.UpdateRequest;
import com.todo.service.TaskService;
import com.todo.utils.constants.Response;
import com.todo.modules.taskboard.usecase.list.GetTaskRequest;
import com.todo.modules.taskboard.usecase.list.GetTaskUsecase;
import com.todo.modules.taskboard.usecase.save.ManageTaskRequest;
import com.todo.modules.taskboard.usecase.save.ManageTaskResponse;
import com.todo.modules.taskboard.usecase.save.ManageTaskUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskBoardResource {
    private final ManageTaskUsecase manageTaskUsecase;
    private final GetTaskUsecase getTaskUsecase;
    private final TaskService taskService;

    public TaskBoardResource(ManageTaskUsecase manageTaskUsecase,
                             GetTaskUsecase getTaskUsecase, TaskService taskService) {
        this.manageTaskUsecase = manageTaskUsecase;
        this.getTaskUsecase = getTaskUsecase;
        this.taskService = taskService;
    }

    @PostMapping
    public Response<Object> saveTask(@RequestBody ManageTaskRequest request) {
        try {
            Optional<ManageTaskResponse> response = this.manageTaskUsecase.execute(request);
            if (response.isPresent())
                return Response.success(HttpStatus.OK.value(), "Success", response);
            else return Response.error(HttpStatus.BAD_REQUEST.value(), "Fail");
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @PostMapping("/list")
    public Response<Object> getByCategoryId(@RequestBody GetTaskRequest request) {
        try {
            var response = this.taskService.findByCategory(request);
            if (response != null)
                return Response.success(HttpStatus.OK.value(), "Success", response);
            else return Response.error(HttpStatus.BAD_REQUEST.value(), "Fail");
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @PostMapping("/update")
    public Response<Object> update(@RequestBody UpdateRequest request) {
        try {
            var response = this.taskService.update(request);
            if (response.isPresent())
                return Response.success(HttpStatus.OK.value(), "Success", response);
            else return Response.error(HttpStatus.BAD_REQUEST.value(), "Fail");
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
