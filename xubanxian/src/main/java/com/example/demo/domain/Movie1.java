package com.example.demo.domain;

public class Movie1 {
    public int id;
    public String name;
    public String info;
    public String pictureaddress;
    public String href;

    public Movie1(int id, String name, String info, String pictureaddress, String href) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.pictureaddress = pictureaddress;
        this.href = href;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPictureaddress() {
        return pictureaddress;
    }

    public void setPictureaddress(String pictureaddress) {
        this.pictureaddress = pictureaddress;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Movie1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", pictureaddress='" + pictureaddress + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
