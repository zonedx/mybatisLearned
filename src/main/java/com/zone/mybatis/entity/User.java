package com.zone.mybatis.entity;

import java.util.Date;

/**
 * @ClassName User
 * @Author ZONE
 * @Date 2019/7/15 9:33
 * @Version 1.0
 **/
public class User {
    private int id;
    private String name;
    private String sex;
    private Date birthday;
    private int iss;

    public int getIss() {
        return iss;
    }

    public void setIss(int iss) {
        this.iss = iss;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
