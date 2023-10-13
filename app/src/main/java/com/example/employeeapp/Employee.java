package com.example.employeeapp;

public class Employee {
    private String name;
    private int age;
    private String occupation;

    public Employee(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age + ", occupation: " + occupation;
    }
}
