package com.todo.service.serviceImpl;

import com.todo.entity.CategoryEntity;
import com.todo.modules.taskcategory.usecase.adaptor.CategoryDto;
import com.todo.modules.taskcategory.usecase.adaptor.CategoryDtoBuilder;
import com.todo.modules.taskcategory.usecase.list.GetCategoryResponse;
import com.todo.modules.taskcategory.usecase.list.GetCategoryResponseBuilder;
import com.todo.modules.taskcategory.usecase.save.ManageCategoryRequest;
import com.todo.modules.taskcategory.usecase.save.ManageCategoryResponse;
import com.todo.modules.taskcategory.usecase.save.ManageCategoryResponseBuilder;
import com.todo.repositories.CategoryRepository;
import com.todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<ManageCategoryResponse> save(ManageCategoryRequest request) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(UUID.randomUUID().toString().toUpperCase());
        entity.setName(request.name());
        CategoryEntity save = this.categoryRepository.save(entity);
        return Optional.ofNullable(ManageCategoryResponseBuilder.builder()
                .id(save.getId())
                .build());
    }

    @Override
    public GetCategoryResponse findAllInOrder() {
        Iterable<CategoryEntity> categoryEntities = this.categoryRepository.findAllInOrder();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryEntities.forEach(categoryEntity -> {
            CategoryDtoBuilder builder = CategoryDtoBuilder.builder();
            builder.id(categoryEntity.getId())
                    .name(categoryEntity.getName())
                    .code(categoryEntity.getCode());
            categoryDtoList.add(builder.build());
        });
        return GetCategoryResponseBuilder.builder()
                .categoryDtoList(categoryDtoList)
                .build();
    }
}
