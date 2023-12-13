package ifc.sigalib;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

public class PageNavigateTest {

    private PageNavigate pageNavigate;

    @Before
    public void setUp() {
        pageNavigate = new PageNavigate(true);
    }

    @After
    public void tearDown() {
        pageNavigate.close();
    }

    @Test
    public void testHomePage() throws IOException {
        String user = "anderson.viana";
        String password = "9jdBfH^!xZw3zy";

        String content = pageNavigate.homePage(user, password);

        assertNotNull(content);
        assertTrue(content.contains("Welcome to SIGALIB"));
    }

    @Test
    public void testFrequencyPage() throws IOException {
        String user = "anderson.viana";
        String password = "9jdBfH^!xZw3zy";

        Map<String, String> frequency = pageNavigate.frequencyPage(user, password);

        assertNotNull(frequency);
        assertEquals(3, frequency.size());
        assertTrue(frequency.containsKey("Class 1"));
        assertTrue(frequency.containsKey("Class 2"));
        assertTrue(frequency.containsKey("Class 3"));
        assertEquals("90%", frequency.get("Class 1"));
        assertEquals("80%", frequency.get("Class 2"));
        assertEquals("95%", frequency.get("Class 3"));
    }

    @Test
    public void testGradesPage() throws IOException {
        String user = "anderson.viana";
        String password = "9jdBfH^!xZw3zy";

        Map<String, Map<String, String>> grades = pageNavigate.gradesPage(user, password);

        assertNotNull(grades);
        assertEquals(3, grades.size());
        assertTrue(grades.containsKey("Class 1"));
        assertTrue(grades.containsKey("Class 2"));
        assertTrue(grades.containsKey("Class 3"));
        assertEquals("A", grades.get("Class 1").get("Assignment 1"));
        assertEquals("B", grades.get("Class 1").get("Assignment 2"));
        assertEquals("C", grades.get("Class 2").get("Assignment 1"));
        assertEquals("D", grades.get("Class 2").get("Assignment 2"));
        assertEquals("E", grades.get("Class 3").get("Assignment 1"));
        assertEquals("F", grades.get("Class 3").get("Assignment 2"));
    }
}