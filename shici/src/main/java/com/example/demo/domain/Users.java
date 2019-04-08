

package com.example.demo.domain;

public class Users {
    private Integer id;
    private String email;
    private String password;
    private String username;
    private String sex;
    private Integer age;
    private String birthdaty;
    private String phone;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthdaty() {
        return birthdaty;
    }

    public void setBirthdaty(String birthdaty) {
        this.birthdaty = birthdaty;
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
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthdaty='" + birthdaty + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Users(Integer id, String email, String password, String username, String sex, Integer age, String birthdaty, String phone, String address) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.sex = sex;
        this.age = age;
        this.birthdaty = birthdaty;
        this.phone = phone;
        this.address = address;
    }
}