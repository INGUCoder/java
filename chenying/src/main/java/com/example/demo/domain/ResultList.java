package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;


public class ResultList {
    /*code": 0,t
  "msg": "",
  "count": 15,
  "data": [*/
    private Integer code;
    private String msg;
    private Integer count;
    private List<?> data = new ArrayList<>();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }


}
