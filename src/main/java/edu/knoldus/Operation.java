package edu.knoldus;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Operation {

    /**
     * student who do not have any subject associated.
     *
     * @param @classRoomList
     * @return studentNoSubAssociated
     */

    public static List<String> getStudentNoSubAssociated(List<ClassRoom> classRoomList) {
        List<ClassRoom> classRooms = classRoomList.stream()
                .filter(classRoom -> classRoom.getStudentList().isPresent()).collect(toList());
        List<List<Student>> studentLists = classRooms.stream().map(studentList -> studentList.getStudentList().get())
                .collect(Collectors.toList());
        List<Student> studList = studentLists.stream().flatMap(x -> x.stream()).filter(s -> !s.getSubjectList()
                .isPresent()).collect(toList());
        List<String> studentNoSubAssociated = studList.stream().map(x -> x.getName()).collect(toList());
        return studentNoSubAssociated;
    }

    /**
     * students has room xyz.
     *
     * @param @classRoomList
     * @return student
     */

    public static List<String> getStudentRoomXYZ(List<ClassRoom> classRoomList) {

        List<ClassRoom> classRooms = classRoomList.stream().filter(classRoom -> classRoom.getRoomid().equals("xyz"))
                .collect(toList());
        List<List<Student>> studentlistingivenroom = classRooms.stream()
                .filter(classRoom -> classRoom.getStudentList().isPresent())
                .map(classRoom -> classRoom.getStudentList().get()).collect(toList());
        List<List<String>> subjectlist = studentlistingivenroom.stream().flatMap(x -> x.stream())
                .filter(x -> x.getSubjectList().isPresent())
                .map(x -> x.getSubjectList().get()).collect(toList());
        List<String> subject = subjectlist.stream().flatMap(x -> x.stream()).collect(toList());
        return subject;
    }

    /**
     * students say hello if room is associated.
     *
     * @param @classRoomList
     * @return student
     */

    public static List<String> helloToStudent(List<ClassRoom> classRoomList) {
        List<Student> studentdetails = classRoomList.stream().map(c -> c.getStudentList().get())
                .flatMap(x -> x.stream()).collect(toList());
        List<String> studentList = studentdetails.stream().map(c -> c.getName()).collect(toList());
        return studentList;
    }
}



