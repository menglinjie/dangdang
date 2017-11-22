package com.mlj.dangdang.dao;

import com.mlj.dangdang.model.Category;
import com.mlj.dangdang.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDao {

    //查看所有类别（id=0）（或指定类别下所有子类别）
    public List<Category> getAll(@Param("categoryId") int categoryId);

//    //查看类别下的子类别和图书以及父类别（图书分页）
//    public List<Category> getBooks(@Param("categoryId") int categoryId,
//                                   @Param("orderBy") int orderBy,
//                                   @Param("startPos") Integer startPos,
//                                   @Param("pageSize") Integer pageSize);

    //根据类别查找图书1：按上架时间排序 2：按销量排序（热度） 3价格排序
    //ispa 0:无父类别 1：有父类别
    public List<Category> books(@Param("categoryId") int categoryId,
                                @Param("isPa") int isPa,
                                @Param("orderBy") int orderBy,
                                @Param("startPos") int startPos);

    //查询类别下图书数量
    public int count(@Param("categoryId") int categoryId,
                     @Param("isPa") int isPa);
}
