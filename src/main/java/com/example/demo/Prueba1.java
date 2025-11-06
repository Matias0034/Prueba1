package com.example.demo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Prueba1 {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
        
}
