package com.example.demo.domain;


//党员信息
public class Users {

   private Integer id;
   private String username;
    private String sex;
    private String minzu;
    private String jiguan;
    private String phone;
    private String idcard;
    private String birthday;
    private String work;
    private String education;
    private String address;
    private String rudangtime;
    private String people;
    private String zhibu;
    private String status;
    private String bianhao;
    private String zhibubianhao;

    public Users(Integer id, String username, String sex, String minzu, String jiguan, String phone, String idcard, String birthday, String work, String education, String address, String rudangtime, String people, String zhibu, String status, String bianhao, String zhibubianhao) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.minzu = minzu;
        this.jiguan = jiguan;
        this.phone = phone;
        this.idcard = idcard;
        this.birthday = birthday;
        this.work = work;
        this.education = education;
        this.address = address;
        this.rudangtime = rudangtime;
        this.people = people;
        this.zhibu = zhibu;
        this.status = status;
        this.bianhao = bianhao;
        this.zhibubianhao = zhibubianhao;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMinzu() {
        return minzu;
    }

    public void setMinzu(String minzu) {
        this.minzu = minzu;
    }

    public String getJiguan() {
        return jiguan;
    }

    public void setJiguan(String jiguan) {
        this.jiguan = jiguan;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRudangtime() {
        return rudangtime;
    }

    public void setRudangtime(String rudangtime) {
        this.rudangtime = rudangtime;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getZhibu() {
        return zhibu;
    }

    public void setZhibu(String zhibu) {
        this.zhibu = zhibu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public String getZhibubianhao() {
        return zhibubianhao;
    }

    public void setZhibubianhao(String zhibubianhao) {
        this.zhibubianhao = zhibubianhao;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", minzu='" + minzu + '\'' +
                ", jiguan='" + jiguan + '\'' +
                ", phone='" + phone + '\'' +
                ", idcard='" + idcard + '\'' +
                ", birthday='" + birthday + '\'' +
                ", work='" + work + '\'' +
                ", education='" + education + '\'' +
                ", address='" + address + '\'' +
                ", rudangtime='" + rudangtime + '\'' +
                ", people='" + people + '\'' +
                ", zhibu='" + zhibu + '\'' +
                ", status='" + status + '\'' +
                ", bianhao='" + bianhao + '\'' +
                ", zhibubianhao='" + zhibubianhao + '\'' +
                '}';
    }
}
