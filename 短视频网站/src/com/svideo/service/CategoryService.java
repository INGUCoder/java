package com.svideo.service;

import com.svideo.domain.TbCategory;

import java.util.List;

public interface CategoryService {
    /**
     * 获取分类列表
     *
     * @return
     */
    List<TbCategory> getTbCateGorys();

    /**
     * 保存分类
     *
     * @param categoryName
     */
    void saveTbCategory(String categoryName);

    /**
     * 通过id插在分类
     *
     * @param id
     * @return
     */
    TbCategory findById(Long id);

    /**
     * 更新分类
     *
     * @param tbCategory
     */
    void updateTbCategory(TbCategory tbCategory);

    /**
     * 删除分类
     *
     * @param id
     * @return
     */
    boolean delTbCateGory(Long id);
}
