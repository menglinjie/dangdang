package com.mlj.dangdang.service;

import com.mlj.dangdang.model.Category;
import com.mlj.dangdang.util.Page;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


public interface CategoryService {

    /**
     * @param categoryId //类别id或者为空（查询所有类别）
     * @return
     */
    public List<Category> getAll(int categoryId);

    /**
     * 分页查询类别下的图书（大类别和小类别）
     *
     * @param categoryId                   //类别id
     * @param isPa//0：无父类别（大类别的所有图书）1：有父类别 （子类别的图书）
     * @param orderBy//按上架时间排序             2：按销量排序（热度） 3价格排序
     * @param pageNow//当前页
     * @return
     */
    public Page<Category> getBooks(int categoryId,
                                   int isPa,
                                   int orderBy,
                                   int pageNow);

}
