package com.svideo.domain;

import java.io.Serializable;
import java.util.Date;

public class TbCategory implements Serializable {
    private Long id;
    private Long numberId;

    public Long getNumberId() {
        return numberId;
    }

    public void setNumberId(Long numberId) {
        if (numberId == null) {
            numberId = 0L;
        }
        this.numberId = numberId;
    }

    private String categoryName;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}