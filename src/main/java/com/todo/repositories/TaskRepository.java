package com.todo.repositories;

import com.todo.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> {
    List<TaskEntity> findByCategoryCodeOrderByCreatedOnDesc(String categoryCode);

    List<TaskEntity> findAllByStatus(String status);

    List<TaskEntity> findByCategoryCode(String categoryCode);

    List<TaskEntity> findByCategoryCodeAndStatus(String categoryCode, String status);
    List<TaskEntity> findByCategoryCodeAndStatusIsNull(String categoryCode);
}
