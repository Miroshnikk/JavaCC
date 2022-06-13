package com.pi;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();

        person1.setPersonParameters("Max", 2004);
        person2.setPersonParameters("Sasha", 2013);
        person3.setPersonParameters("Aleks", 1989);
        person4.setPersonParameters("Joy", 2002);
        person5.setPersonParameters("Anastasiya", 2007);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
        System.out.println(person5);
    }
}
