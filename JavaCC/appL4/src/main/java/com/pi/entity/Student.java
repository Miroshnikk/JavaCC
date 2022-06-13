package com.pi.entity;

public class Student extends Person{
    private final String group;
    int[] grades;


    public String getGroup() {
        return group;
    }

    public int[] getGrades() {
        return grades;
    }

    public Student(String lastName, String name, String patronymic, int age, String group, int[] grades) {
        super(lastName, name, patronymic, age);
        this.group = group;
        this.grades = grades;
    }


    public int getMarksAverage(){
        int sum = 0;
        for(int i = 0; i < grades.length; i++){
            sum += grades[i];
        }

        return sum / grades.length;
    }

    public static Student getBetterStudentByAverage
            (Student student1, Student student2, Student student3){
        int average1 = student1.getMarksAverage();
        int average2 = student2.getMarksAverage();
        int average3 = student3.getMarksAverage();

        if(average1 > average2 && average1 > average3){
            return student1;
        }
        if(average2 > average1 && average2 > average3){
            return student2;
        }
        else{
            return student3;
        }
    }

    public boolean isExcelentStudent(){
        for(int i = 0; i < grades.length; i++){
            if(grades[i] < 10){
                return false;
            }
        }
        return true;
    }
}
