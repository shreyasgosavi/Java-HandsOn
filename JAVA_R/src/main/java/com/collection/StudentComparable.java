package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentComparable implements Comparable<StudentComparable>{

    private int studentId;
    private String studentName;
    private char gender;

    public StudentComparable() {
    }

    public StudentComparable(int studentId, String studentName, char gender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    @Override
    public int compareTo(StudentComparable studentComparable) {
        return this.studentName.compareTo(studentComparable.getStudentName());
    }

    @Override
    public String toString() {
        return "Student : "+this.getStudentName();
    }
}

class MainRunningClass{
    public static void main(String[] args) {
        StudentComparable studentComparable = new StudentComparable(1, "Shreyas", 'M');
        StudentComparable studentComparable2 = new StudentComparable(2, "Shubham", 'M');
        StudentComparable studentComparable3 = new StudentComparable(3, "Virat", 'M');
        StudentComparable studentComparable4 = new StudentComparable(4, "Akshay", 'M');

        List<StudentComparable> students = new ArrayList<>(Arrays.asList(studentComparable,studentComparable2, studentComparable3,studentComparable4));

        students.sort(null);
        System.out.println(students);

    }
}
