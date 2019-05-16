package com.svideo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TbComment {
    private Long cid;

    private Long vedioId;

    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date commentDate;

    private Long creator;

    public Long getId() {
        return cid;
    }

    public void setId(Long cid) {
        this.cid = cid;
    }

    public Long getVedioId() {
        return vedioId;
    }

    public void setVedioId(Long vedioId) {
        this.vedioId = vedioId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }
}