package com.example.demo.domain;

public class zhibuinfo {
    private Integer id;
    private String name;
    private String bianhao;
    private String people;
    private String phone;
    private String address;

    public zhibuinfo(Integer id, String name, String bianhao, String people, String phone, String address) {
        this.id = id;
        this.name = name;
        this.bianhao = bianhao;
        this.people = people;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "zhibuinfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bianhao='" + bianhao + '\'' +
                ", people='" + people + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
