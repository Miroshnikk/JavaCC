package com.pi;


import com.pi.entity.Person;
import com.pi.entity.Student;
import com.pi.exceptions.IncorrectUsernameException;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    public static Student student = new Student("", "Alina", "Michailovna", 32, "312G", new int[] {11,12,10});

    @Test(expected = IncorrectUsernameException.class)
    public void testGetFullName(){
        student.getFullName();
    }

    @Test
    public void testIsAdult(){
        Assert.assertTrue(Person.isAdult(student));
    }
}
