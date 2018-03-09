package edu.knoldus;

import java.util.List;
import java.util.Optional;

public class Student {
    String name;
    int rollNumber;
    Optional<List<String>> subjectList;

    public Student(String name, int rollNumber, Optional<List<String>> subject) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectList = subject;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public Optional<List<String>> getSubjectList() {
        return subjectList;
    }
}
