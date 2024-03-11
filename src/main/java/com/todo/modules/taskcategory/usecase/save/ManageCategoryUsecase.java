package com.todo.modules.taskcategory.usecase.save;

import com.todo.repositories.CategoryRepository;
import com.todo.utils.commons.UseCase;
import com.todo.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ManageCategoryUsecase implements UseCase<ManageCategoryRequest, ManageCategoryResponse> {
    private final CategoryRepository categoryRepository;

    public ManageCategoryUsecase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<ManageCategoryResponse> execute(ManageCategoryRequest request) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(UUID.randomUUID().toString().toUpperCase());
        entity.setName(request.name());
        CategoryEntity save = this.categoryRepository.save(entity);
        return Optional.ofNullable(ManageCategoryResponseBuilder.builder()
                .id(save.getId())
                .build());
    }
}
