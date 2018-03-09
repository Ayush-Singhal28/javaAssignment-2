package edu.knoldus;

import java.util.List;
import java.util.Optional;

public class ClassRoom {
    String roomID;
    Optional<List<Student>> studentList;

    public ClassRoom(String roomID, Optional<List<Student>> studentList) {
        this.roomID = roomID;
        this.studentList = studentList;
    }

    public String getRoomid() {
        return roomID;
    }

    public Optional<List<Student>> getStudentList() {
        return studentList;
    }
}
