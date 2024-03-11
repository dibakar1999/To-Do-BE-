package com.todo.endpoints;

import com.todo.service.CategoryService;
import com.todo.utils.constants.Response;
import com.todo.modules.taskcategory.usecase.list.GetCategoryResponse;
import com.todo.modules.taskcategory.usecase.list.GetCategoryUsecase;
import com.todo.modules.taskcategory.usecase.save.ManageCategoryRequest;
import com.todo.modules.taskcategory.usecase.save.ManageCategoryResponse;
import com.todo.modules.taskcategory.usecase.save.ManageCategoryUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryResource {
    private final ManageCategoryUsecase manageCategoryUsecase;
    private final GetCategoryUsecase getCategoryUsecase;
    private final CategoryService categoryService;

    public CategoryResource(ManageCategoryUsecase manageCategoryUsecase,
                            GetCategoryUsecase getCategoryUsecase, CategoryService categoryService) {
        this.manageCategoryUsecase = manageCategoryUsecase;
        this.getCategoryUsecase = getCategoryUsecase;
        this.categoryService = categoryService;
    }

    @PostMapping
    public Response<Object> saveCategory(@RequestBody ManageCategoryRequest request) {
        try {
            Optional<ManageCategoryResponse> response = this.manageCategoryUsecase.execute(request);
            if (response.isPresent())
                return Response.success(HttpStatus.OK.value(), "Success", response);
            else return Response.error(HttpStatus.BAD_REQUEST.value(), "Fail");
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @GetMapping
    public Response<Object> getAllCategory() {
        try {
            var response = this.categoryService.findAllInOrder();
            if (response != null)
                return Response.success(HttpStatus.OK.value(), "Success", response);
            else return Response.error(HttpStatus.BAD_REQUEST.value(), "Fail");
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
