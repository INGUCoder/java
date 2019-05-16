package com.svideo.service.impl;

import com.svideo.domain.TbCategory;
import com.svideo.domain.TbCategoryExample;
import com.svideo.mapper.TbCategoryMapper;
import com.svideo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private TbCategoryMapper tbCategoryMapper;

    @Override
    public List<TbCategory> getTbCateGorys() {
        TbCategoryExample example = new TbCategoryExample();
        return this.tbCategoryMapper.selectByExample(example);

    }

    @Override
    public void saveTbCategory(String categoryName) {
        TbCategory tbCategory = new TbCategory();
        tbCategory.setCategoryName(categoryName);
        tbCategory.setCreateDate(new Date());
        this.tbCategoryMapper.insert(tbCategory);
    }

    @Override
    public TbCategory findById(Long id) {
        return tbCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateTbCategory(TbCategory tbCategory) {
        //补全跟新信息
        tbCategory.setCreateDate(new Date());
        tbCategoryMapper.updateByPrimaryKey(tbCategory);
    }

    @Override
    public boolean delTbCateGory(Long id) {
        try {
            tbCategoryMapper.deleteByPrimaryKey(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
}
