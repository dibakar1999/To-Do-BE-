package com.todo.repositories;

import com.todo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    @Query("SELECT c FROM CategoryEntity c ORDER BY c.categoryOrder ASC")
    List<CategoryEntity> findAllInOrder();
}
