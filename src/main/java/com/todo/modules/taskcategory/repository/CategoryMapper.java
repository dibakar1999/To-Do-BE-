package com.todo.modules.taskcategory.repository;

import com.todo.entity.CategoryEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryEntity> {
    @Override
    public CategoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(rs.getString("id"));
        entity.setName(rs.getString("name"));
        entity.setCategoryOrder(rs.getLong("order"));
        return entity;
    }
}
