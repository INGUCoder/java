package com.example.demo.domain;
import java.util.Date;

//党员信息
public class Users {

    private Integer id;

    private String username;

    private Integer age;

    private String sex;

    private String zhibu;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZhibu() {
        return zhibu;
    }

    public void setZhibu(String zhibu) {
        this.zhibu = zhibu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", zhibu='" + zhibu + '\'' +
                ", date=" + date +
                '}';
    }
}
