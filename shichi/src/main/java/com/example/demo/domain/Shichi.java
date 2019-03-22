
package com.example.demo.domain;

public class Shichi {
    public Shichi() {

    }

    public String zuopingming;
    public String zuopinginfo;
    public String zuoche;
    public String zuozheinfo;

    public Shichi(String zuopingming, String zuopinginfo, String zuoche, String zuozheinfo) {
        this.zuopingming = zuopingming;
        this.zuopinginfo = zuopinginfo;
        this.zuoche = zuoche;
        this.zuozheinfo = zuozheinfo;
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

    public String getZuoche() {
        return zuoche;
    }

    public void setZuoche(String zuoche) {
        this.zuoche = zuoche;
    }

    public String getZuozheinfo() {
        return zuozheinfo;
    }

    public void setZuozheinfo(String zuozheinfo) {
        this.zuozheinfo = zuozheinfo;
    }

    @Override
    public String toString() {
        return "Shichi{" +
                "zuopingming='" + zuopingming + '\'' +
                ", zuopinginfo='" + zuopinginfo + '\'' +
                ", zuoche='" + zuoche + '\'' +
                ", zuozheinfo='" + zuozheinfo + '\'' +
                '}';
    }
}
