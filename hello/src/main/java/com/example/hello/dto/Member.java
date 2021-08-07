package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {

    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public Member(){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Member(String name, int age,String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Member defaultMember(){
        return new Member("default",0,"010-1111-1111");
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
