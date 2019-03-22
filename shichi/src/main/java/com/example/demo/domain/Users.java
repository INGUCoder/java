

package com.example.demo.domain;

public class Users {

    public String email;
    public  String nicheng;
    public String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNicheng() {
        return nicheng;
    }

    public void setNicheng(String nicheng) {
        this.nicheng = nicheng;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(String email, String nicheng, String password) {
        this.email = email;
        this.nicheng = nicheng;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + email + '\'' +
                ", nicheng='" + nicheng + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
