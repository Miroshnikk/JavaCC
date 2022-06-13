package com.pi;

import com.pi.entity.Student;

public class Main {
    public static Student student = new Student("Filipchuk", "Alina", "Michailovna", 32, "312G", new int[] {12,11,10,12,10});

    public static void main(String[] args) {
        System.out.println(student.getMarksAverage());
        System.out.println(student.getFullName());
    }

}
