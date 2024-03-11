package com.todo.service;

import com.todo.modules.taskcategory.usecase.list.GetCategoryResponse;
import com.todo.modules.taskcategory.usecase.save.ManageCategoryRequest;
import com.todo.modules.taskcategory.usecase.save.ManageCategoryResponse;

import java.util.Optional;

public interface CategoryService {
    Optional<ManageCategoryResponse> save(ManageCategoryRequest request);

    GetCategoryResponse findAllInOrder();
}
