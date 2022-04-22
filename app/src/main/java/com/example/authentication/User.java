package com.example.authentication;

public class User {
    public String name;
    public String password;
    public int normal;
    public int happy;
    public int unhappy;
    public String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getUnhappy() {
        return unhappy;
    }

    public void setUnhappy(int unhappy) {
        this.unhappy = unhappy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, String role, String password, int normal, int happy, int unhappy, String email) {
        this.name = name;
        this.password = password;
        this.normal = normal;
        this.happy = happy;
        this.unhappy = unhappy;
        this.email = email;
    }

    public User(String name, String role, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

}
