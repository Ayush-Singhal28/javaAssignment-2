package edu.knoldus;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

public class ApplicationTest {

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

    List<ClassRoom> classRoomList = Arrays.asList(classRoom1,classRoom2);

    @Test
    public final void Test() {

        List<String> actualStudentList = Operation.getStudentNoSubAssociated(classRoomList);
        List<String> expectedStudentList = Arrays.asList("Shivam");
        assertEquals("Return List of Student who do not have any subject", expectedStudentList, actualStudentList);

        List<String> actualSubjectList = Operation.getStudentRoomXYZ(classRoomList);
        List<String> expectedSubjectList = Arrays.asList("scala", "akka","java8","scala","akka");
        assertEquals("Return List of Subject with particular room", expectedSubjectList,actualSubjectList);

        List<String> actualresult = Operation.helloToStudent(classRoomList);
        List<String> expectedresult = Arrays.asList("Ayush","Vaibhav","Shivam");
        assertEquals("Return list of student room is associated", expectedresult, actualresult);

    }
}
