package edu.knoldus;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {

        Student student1 = new Student("Ayush", 27,
                Optional.of(Arrays.asList("scala", "akka")));
        Student student2 = new Student("Vaibhav", 35,
                Optional.of(Arrays.asList("java8", "scala", "akka")));
        Student student3 = new Student("Shivam", 34,
                Optional.empty());
        ClassRoom classRoom1 = new ClassRoom("xyz",
                Optional.of(Arrays.asList(student1, student2)));
        ClassRoom classRoom2 = new ClassRoom("pqr",
                Optional.of(Arrays.asList(student3)));
        System.out.println("Students associated with a room that have no subjects associated.");
        List<ClassRoom> classRoomList = Arrays.asList(classRoom1,classRoom2);
        System.out.println(Operation.getStudentNoSubAssociated(classRoomList));
        System.out.println("The subjects of students associated with a room that has roomID xyz.");
        System.out.println(Operation.getStudentRoomXYZ(classRoomList));
        System.out.println("hello Student if a room has students associated");
        System.out.println("Hello" + Operation.helloToStudent(classRoomList));

    }

}
