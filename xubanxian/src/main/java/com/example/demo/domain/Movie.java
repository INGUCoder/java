package com.example.demo.domain;


public class Movie {
    public String moviename;
    public String pictureaddress;
    public String aiqiyi;
    public String tengxun;
    public String youku;
    public String info;

    public Movie(String moviename, String pictureaddress, String aiqiyi, String tengxun, String youku, String info) {
        this.moviename = moviename;
        this.pictureaddress = pictureaddress;
        this.aiqiyi = aiqiyi;
        this.tengxun = tengxun;
        this.youku = youku;
        this.info = info;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getPictureaddress() {
        return pictureaddress;
    }

    public void setPictureaddress(String pictureaddress) {
        this.pictureaddress = pictureaddress;
    }

    public String getAiqiyi() {
        return aiqiyi;
    }

    public void setAiqiyi(String aiqiyi) {
        this.aiqiyi = aiqiyi;
    }

    public String getTengxun() {
        return tengxun;
    }

    public void setTengxun(String tengxun) {
        this.tengxun = tengxun;
    }

    public String getYouku() {
        return youku;
    }

    public void setYouku(String youku) {
        this.youku = youku;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "moviename='" + moviename + '\'' +
                ", pictureaddress='" + pictureaddress + '\'' +
                ", aiqiyi='" + aiqiyi + '\'' +
                ", tengxun='" + tengxun + '\'' +
                ", youku='" + youku + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
