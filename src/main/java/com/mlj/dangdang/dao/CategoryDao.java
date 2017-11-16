package com.mlj.dangdang.dao;

import com.mlj.dangdang.model.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDao {

    //查看所有类别（id=0）（或指定类别下所有子类别）
    public List<Category> getAll(@Param("categoryId") int categoryId);

    //查看某个类别数量
    public int countById(int categoryId);
}
