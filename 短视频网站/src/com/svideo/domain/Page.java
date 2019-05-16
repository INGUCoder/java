package com.svideo.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 前端分页封装类
 *
 * @param
 */
@Setter
@Getter
public class Page implements Serializable {
    /**
     * 每页显示条数
     */
    private int pageSize = 6;
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 总记录数
     */
    private int totalRecords;

    /**
     * limit起始位置
     */
    private int startLimitPos;

    public void setStartLimitPos(int startLimitPos) {
        this.startLimitPos = startLimitPos;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage == 0) {
            currentPage = 1;
        }
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        if (getTotalRecords() == 0) {
            return 0;
        }
        this.totalPage = (getTotalRecords() + getPageSize() - 1) / getPageSize();

        return totalPage;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getStartLimitPos() {
        if (getCurrentPage() < 1) {
            return 0;
        }
        return (getCurrentPage() - 1) * getPageSize();
    }
}
