
import org.junit.Test;

import ifc.sigalib.SIGALIB;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class SIGALIBTest {

    @Test
    public void testGetUserInfo() throws IOException {
        SIGALIB sigalib = new SIGALIB("anderson.viana", "9jdBfH^!xZw3zy");
        String userInfo = sigalib.get_user_info();
        assertNotNull(userInfo);
        // assertEquals("User: anderson.viana", userInfo);
    }

    @Test
    public void testGetClasses() throws IOException {
        SIGALIB sigalib = new SIGALIB("anderson.viana", "9jdBfH^!xZw3zy");
        ArrayList<String> classes = sigalib.get_classes();
        assertNotNull(classes);
        // assertEquals(3, classes.size());
        // assertTrue(classes.contains("Class 1"));
        // assertTrue(classes.contains("Class 2"));
        // assertTrue(classes.contains("Class 3"));
    }

    @Test
    public void testGetSchedule() throws IOException {
        SIGALIB sigalib = new SIGALIB("anderson.viana", "9jdBfH^!xZw3zy");
        ArrayList<String> schedule = sigalib.get_schedule();
        assertNotNull(schedule);
        // assertEquals(5, schedule.size());
        // assertTrue(schedule.contains("Monday: 9:00 AM - 10:30 AM"));
        // assertTrue(schedule.contains("Tuesday: 2:00 PM - 3:30 PM"));
        // assertTrue(schedule.contains("Wednesday: 11:00 AM - 12:30 PM"));
        // assertTrue(schedule.contains("Thursday: 4:00 PM - 5:30 PM"));
        // assertTrue(schedule.contains("Friday: 10:00 AM - 11:30 AM"));
    }

    @Test
    public void testGetFrequency() throws IOException {
        SIGALIB sigalib = new SIGALIB("anderson.viana", "9jdBfH^!xZw3zy");
        Map<String, String> frequency = sigalib.get_frequency();
        assertNotNull(frequency);
        assertEquals(3, frequency.size());
        // assertEquals("90%", frequency.get("Class 1"));
        // assertEquals("80%", frequency.get("Class 2"));
        // assertEquals("95%", frequency.get("Class 3"));
    }

    @Test
    public void testGetGrades() throws IOException {
        SIGALIB sigalib = new SIGALIB("anderson.viana", "9jdBfH^!xZw3zy");
        Map<String, Map<String, String>> grades = sigalib.get_grades();
        assertNotNull(grades);
        // assertEquals(3, grades.size());
        // assertTrue(grades.containsKey("Class 1"));
        // assertTrue(grades.containsKey("Class 2"));
        // assertTrue(grades.containsKey("Class 3"));
        // assertEquals("A", grades.get("Class 1").get("Assignment 1"));
        // assertEquals("B", grades.get("Class 1").get("Assignment 2"));
        // assertEquals("C", grades.get("Class 2").get("Assignment 1"));
        // assertEquals("D", grades.get("Class 2").get("Assignment 2"));
        // assertEquals("E", grades.get("Class 3").get("Assignment 1"));
        // assertEquals("F", grades.get("Class 3").get("Assignment 2"));
    }
}