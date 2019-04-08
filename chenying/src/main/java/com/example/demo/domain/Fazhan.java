package com.example.demo.domain;

public class Fazhan {
    private Integer id;
    private String bianhao;
    private String name;
    private String sex;
    private String status;
    private String biaoxian;
    private String chuqing;
    private String workstatus;
    private String sixiang;
    private String idcard;

    public Fazhan(Integer id, String bianhao, String name, String sex, String status, String biaoxian, String chuqing, String workstatus, String sixiang, String idcard) {
        this.id = id;
        this.bianhao = bianhao;
        this.name = name;
        this.sex = sex;
        this.status = status;
        this.biaoxian = biaoxian;
        this.chuqing = chuqing;
        this.workstatus = workstatus;
        this.sixiang = sixiang;
        this.idcard = idcard;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBiaoxian() {
        return biaoxian;
    }

    public void setBiaoxian(String biaoxian) {
        this.biaoxian = biaoxian;
    }

    public String getChuqing() {
        return chuqing;
    }

    public void setChuqing(String chuqing) {
        this.chuqing = chuqing;
    }

    public String getWorkstatus() {
        return workstatus;
    }

    public void setWorkstatus(String workstatus) {
        this.workstatus = workstatus;
    }

    public String getSixiang() {
        return sixiang;
    }

    public void setSixiang(String sixiang) {
        this.sixiang = sixiang;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "Fazhan{" +
                "id=" + id +
                ", bianhao='" + bianhao + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", status='" + status + '\'' +
                ", biaoxian='" + biaoxian + '\'' +
                ", chuqing='" + chuqing + '\'' +
                ", workstatus='" + workstatus + '\'' +
                ", sixiang='" + sixiang + '\'' +
                ", idcard='" + idcard + '\'' +
                '}';
    }
}
