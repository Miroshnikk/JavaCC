package com.pi.entity;

import com.pi.exceptions.IncorrectUsernameException;

public class Person {
    protected String lastName;
    protected String name;
    protected String patronymic;
    protected int age;

    public String getFullName(){
        if(lastName.isEmpty() || name.isEmpty() || patronymic.isEmpty()){
            throw new IncorrectUsernameException("Incorrect username");
        } else{
            return lastName + ", " + name + " " + patronymic;
        }
    }

    public static boolean isAdult(Person person){
        return person.age >= 18;
    }

    public Person(String lastName, String name, String patronymic, int age) {
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
    }
}
