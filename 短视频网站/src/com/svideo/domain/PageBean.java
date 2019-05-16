package com.svideo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后端分页封装类
 *
 * @param <T>
 */
@Setter
@Getter
public class PageBean<T> {
    //当前页
    private Integer currentPage;
    //一页多少数据
    private Integer pageSize;
    //当前查询的页数
    private Integer index;
    //总记录数
    private Integer totalCount;
    //总页数
    private Integer totalPage;
    private List<T> list;

    public void setCurrentPage(Integer currentPage) {
        if (currentPage == null) {
            currentPage = 1;
        }
        this.currentPage = currentPage;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 5;
        }
        this.pageSize = pageSize;
    }

    public Integer getIndex(Integer index) {
        int i = (currentPage - 1) * pageSize;
        return i;
    }

    public Integer getTotalPage() {
        double ceil = Math.ceil(totalCount * 1.0 / pageSize);
        return (int) ceil;
    }

}
