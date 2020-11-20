package com.redhat.fuse.boosters.rest.models;


public class Pet {
     
    private Integer id;
    private String name;
    private int age;
    public Pet() {
    }
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Pet{" +
                ", name='" + name + '\'' +
                ", Age=" + age +
                '}';
    }
}