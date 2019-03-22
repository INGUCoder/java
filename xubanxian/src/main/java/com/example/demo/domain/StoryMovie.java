package com.example.demo.domain;

public class StoryMovie {

    public int id;
    public String name;
    public String pictureaddress;
    public int years;
    public String href;

    public StoryMovie(int id, String name, String pictureaddress, int years, String href) {
        this.id = id;
        this.name = name;
        this.pictureaddress = pictureaddress;
        this.years = years;
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

    public String getPictureaddress() {
        return pictureaddress;
    }

    public void setPictureaddress(String pictureaddress) {
        this.pictureaddress = pictureaddress;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Movie2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pictureaddress='" + pictureaddress + '\'' +
                ", years=" + years +
                ", href='" + href + '\'' +
                '}';
    }
}
