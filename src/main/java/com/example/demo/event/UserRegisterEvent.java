package com.example.demo.event;

import java.util.Date;

public class UserRegisterEvent {
    private String phone;
    private String name;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private Date birthDate;

    @Override
    public String toString() {
        return "UserRegisterEvent{" + "phone='" + phone + '\'' + ", name='" + name + '\'' + ", birthDate=" + birthDate
               + '}';
    }
}
