package com.codingdojo.coldcall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev1 on 12/11/15.
 */
public class StudentsFactory {
    List<Student> students;

    public StudentsFactory() {
        students = new ArrayList<Student>();

        students.add(new Student("Iverson"));
        students.add(new Student("Nowitzki"));
        students.add(new Student("Carter"));
        students.add(new Student("McGrady"));
        students.add(new Student("Kobe"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public String findRandomStudentName() {
        int randomIndex = (int) (Math.random() * students.size());
        return students.get(randomIndex).getName();
    }
}
