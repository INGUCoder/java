
package com.example.demo.domain;

public class Shichi {
   private  Integer id;
   private String zuopingming;
   private String zuopinginfo;
   private String zuozhe;
   private String zuozheinfo;
   private Integer dianzhan;
   private String zhushi;
   private String shichitype;

    public Shichi(Integer id, String zuopingming, String zuopinginfo, String zuozhe, String zuozheinfo, Integer dianzhan, String zhushi, String shichitype) {
        this.id = id;
        this.zuopingming = zuopingming;
        this.zuopinginfo = zuopinginfo;
        this.zuozhe = zuozhe;
        this.zuozheinfo = zuozheinfo;
        this.dianzhan = dianzhan;
        this.zhushi = zhushi;
        this.shichitype = shichitype;
    }

    @Override
    public String toString() {
        return "Shichi{" +
                "id=" + id +
                ", zuopingming='" + zuopingming + '\'' +
                ", zuopinginfo='" + zuopinginfo + '\'' +
                ", zuozhe='" + zuozhe + '\'' +
                ", zuozheinfo='" + zuozheinfo + '\'' +
                ", dianzhan=" + dianzhan +
                ", zhushi='" + zhushi + '\'' +
                ", shichitype='" + shichitype + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZuopingming() {
        return zuopingming;
    }

    public void setZuopingming(String zuopingming) {
        this.zuopingming = zuopingming;
    }

    public String getZuopinginfo() {
        return zuopinginfo;
    }

    public void setZuopinginfo(String zuopinginfo) {
        this.zuopinginfo = zuopinginfo;
    }

    public String getZuozhe() {
        return zuozhe;
    }

    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe;
    }

    public String getZuozheinfo() {
        return zuozheinfo;
    }

    public void setZuozheinfo(String zuozheinfo) {
        this.zuozheinfo = zuozheinfo;
    }

    public Integer getDianzhan() {
        return dianzhan;
    }

    public void setDianzhan(Integer dianzhan) {
        this.dianzhan = dianzhan;
    }

    public String getZhushi() {
        return zhushi;
    }

    public void setZhushi(String zhushi) {
        this.zhushi = zhushi;
    }

    public String getShichitype() {
        return shichitype;
    }

    public void setShichitype(String shichitype) {
        this.shichitype = shichitype;
    }

    public Shichi(String zuopingming) {
        this.zuopingming = zuopingming;
    }


}
