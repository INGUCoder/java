package com.example.demo.domain;

public class Comments {
    private Integer id;
    private String  zuopingming;
    private String username;
    private String commnets;

    public Comments(Integer id, String zuopingming, String username, String commnets) {
        this.id = id;
        this.zuopingming = zuopingming;
        this.username = username;
        this.commnets = commnets;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommnets() {
        return commnets;
    }

    public void setCommnets(String commnets) {
        this.commnets = commnets;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", zuopingming='" + zuopingming + '\'' +
                ", username='" + username + '\'' +
                ", commnets='" + commnets + '\'' +
                '}';
    }
}
