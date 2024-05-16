package com.jude;

import java.util.Arrays;
import java.util.Objects;

public record Student(String name, short age, byte level, String address) {
    public Student(String name, short age, byte level ){
        this(name,age, level,null);

    }

     public Student(String name, short age, byte level, String address){
        this.name = name;
        this.age = age;
        this.level = level;
        this.address = address;
    }


}

