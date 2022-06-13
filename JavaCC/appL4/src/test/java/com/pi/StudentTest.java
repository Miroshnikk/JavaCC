package com.pi;

import com.pi.entity.Student;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    Student student = PersonTest.student; // the same student

    @Test
    public void testGetMarksAverage(){
        Assert.assertEquals(11, student.getMarksAverage());
    }

    @Test
    public void testGetBetterStudentByAverage(){
        Student student2 = new Student("", "", "",0,"",new int[]{10,11,6});
        Student student3 = new Student("", "", "",0,"",new int[]{7,9,12});
        Assert.assertEquals(Student.getBetterStudentByAverage(student,student2,student3), student);
    }

    @Test
    public void testIsExcelentStudent(){
        Assert.assertTrue(student.isExcelentStudent());
    }
}
