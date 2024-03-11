package com.todo.modules.taskcategory.usecase.list;

import com.todo.repositories.CategoryRepository;
import com.todo.utils.commons.UseCase;
import com.todo.entity.CategoryEntity;
import com.todo.modules.taskcategory.usecase.adaptor.CategoryDto;
import com.todo.modules.taskcategory.usecase.adaptor.CategoryDtoBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetCategoryUsecase implements UseCase<GetCategoryRequest, GetCategoryResponse> {
    private final CategoryRepository categoryRepository;

    public GetCategoryUsecase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<GetCategoryResponse> execute(GetCategoryRequest request) {
        Iterable<CategoryEntity> categoryEntities = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryEntities.forEach(categoryEntity -> {
            CategoryDtoBuilder builder = CategoryDtoBuilder.builder();
            builder.id(categoryEntity.getId())
                    .name(categoryEntity.getName());
            categoryDtoList.add(builder.build());
        });
        return Optional.ofNullable(GetCategoryResponseBuilder.builder()
                .categoryDtoList(categoryDtoList)
                .build());
    }
}
