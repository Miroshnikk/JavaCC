package com.pi;

public class Person {
    private String name;
    private int birthYear;

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Person() {
    }

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public int getAge(){
        return 2022 - birthYear;
    }
    
    public void setPersonParameters(String name, int birthYear){
        this.name = name;
        this.birthYear = birthYear;
    }
    
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
    
    public void changeName(String name){
        this.name = name;
    }
}
