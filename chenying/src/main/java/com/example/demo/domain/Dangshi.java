package com.example.demo.domain;

public class Dangshi {
    public int id;
    public  String info;
    public  String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Dangshi(int id, String info, String url) {
        this.id = id;
        this.info = info;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Dangshi{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
