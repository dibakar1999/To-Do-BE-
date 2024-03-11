package com.todo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category", schema = "todo")
public class CategoryEntity {
    @Id
    private String id;
    private String name;
    private String code;
    private Long categoryOrder;

    public CategoryEntity() {
    }

    public CategoryEntity(String id,
                          String name,
                          String code,
                          Long categoryOrder) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.categoryOrder = categoryOrder;
    }

    public CategoryEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Long categoryOrder) {
        this.categoryOrder = categoryOrder;
    }
}
