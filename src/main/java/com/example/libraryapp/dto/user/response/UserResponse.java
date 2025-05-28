package com.example.libraryapp.dto.user.response;

import com.example.libraryapp.domain.user.User;

public class UserResponse {
    private long id;
    private String name;
    private Integer age;

    public UserResponse(long id, User user) {
        this.id = id;
        this.age = user.getAge();
        this.name = user.getName();
    }

    public UserResponse(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
