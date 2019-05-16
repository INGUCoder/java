package com.example.demo.domain;

public class DangFei {
    private Integer id;
    private String bianhao;
    private String name;
    private String idcard;
    private String zhibu;
    private Integer totalmoney;

    private String time;

    public DangFei(Integer id, String bianhao, String name, String idcard, String zhibu, Integer totalmoney, String time) {
        this.id = id;
        this.bianhao = bianhao;
        this.name = name;
        this.idcard = idcard;
        this.zhibu = zhibu;
        this.totalmoney = totalmoney;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getZhibu() {
        return zhibu;
    }

    public void setZhibu(String zhibu) {
        this.zhibu = zhibu;
    }

    public Integer getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Integer totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DangFei{" +
                "id=" + id +
                ", bianhao='" + bianhao + '\'' +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", zhibu='" + zhibu + '\'' +
                ", totalmoney=" + totalmoney +
                ", time='" + time + '\'' +
                '}';
    }
}