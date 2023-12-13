/**
 * The SIGALIB class represents a library for accessing and retrieving
 * information from a specific website.
 * It provides methods for retrieving user information, class information,
 * schedule, frequency, and grades.
 */
package ifc.sigalib;

import java.util.ArrayList;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import ifc.sigalib.models.Aluno;

public class SIGALIB {
    private String user;
    private String password;

    /**
     * Constructs a new SIGALIB object with the specified user and password.
     *
     * @param user     the username for authentication
     * @param password the password for authentication
     */
    public SIGALIB(String user, String password) {
        this.user = user;
        this.password = password;
    }

    // public static String lerHtmlComoString(String page) throws IOException {
    // switch (page) {
    // case "home_page":
    // return new
    // String(Files.readAllBytes(Paths.get("src/main/java/ifc/sigalib/home_page.html")));
    // case "disciplina_page":
    // return new
    // String(Files.readAllBytes(Paths.get("src/main/java/ifc/sigalib/disciplina_page.html")));
    // default:
    // break;
    // }
    // return page;
    // }

    /**
     * Retrieves user information from a web page and returns it as a formatted
     * string.
     *
     * @return A string containing the user information.
     * @throws IOException If an I/O error occurs while retrieving the web page
     *                     content.
     */
    public String get_user_info() throws IOException {
        String pageContent = new PageNavigate(false).homePage(user, password);
        Document doc = Jsoup.parse(pageContent);
        Aluno aluno = new Aluno();
        aluno.setMatricula(Integer
                .parseInt(doc.select("#agenda-docente > table > tbody > tr:nth-child(1) > td:nth-child(2)").text()));
        aluno.setNome(doc.select("#agenda-docente > table > tbody > tr:nth-child(3) > td:nth-child(2)").text());
        aluno.setCurso(doc.select("#agenda-docente > table > tbody > tr:nth-child(2) > td:nth-child(2)").text());
        aluno.setNivel(doc.select("#agenda-docente > table > tbody > tr:nth-child(4) > td:nth-child(2)").text());
        aluno.setStatus(doc.select("#agenda-docente > table > tbody > tr:nth-child(4) > td:nth-child(2)").text());
        aluno.setEmail(doc.select("#agenda-docente > table > tbody > tr:nth-child(5) > td:nth-child(2)").text());
        aluno.setEntrada(doc.select("#agenda-docente > table > tbody > tr:nth-child(6) > td:nth-child(2)").text());
        return aluno.toString();
    }

    /**
     * Retrieves a list of classes from the SIGALIB system.
     * 
     * @return An ArrayList of strings representing the class names.
     * @throws IOException if an I/O error occurs while retrieving the classes.
     */
    public ArrayList<String> get_classes() throws IOException {

        String pageContent = new PageNavigate(false).homePage(user, password);
        Document doc = Jsoup.parse(pageContent); // Subtituir por uma classe que limpa o html
        Elements classes_list = doc.select("#turmas-portal > table:nth-child(3) > tbody > tr > td.descricao");
        ArrayList<String> classes = new ArrayList<String>();
        for (int i = 0; i < classes_list.size(); i++) {
            classes.add(classes_list.get(i).text());
        }
        return classes;
    }

    /**
     * Retrieves the schedule from the home page.
     * 
     * @return An ArrayList of Strings representing the schedule.
     * @throws IOException if an I/O error occurs while retrieving the schedule.
     */
    public ArrayList<String> get_schedule() throws IOException {
        String pageContent = new PageNavigate(false).homePage(user, password);
        Document doc = Jsoup.parse(pageContent);
        Elements schedule_list = doc.select("#turmas-portal > table:nth-child(3) > tbody > tr > td > center");
        ArrayList<String> schedule = new ArrayList<String>();
        for (int i = 0; i < schedule_list.size(); i++) {
            schedule.add(schedule_list.get(i).text());
        }
        return schedule;

    }

    /**
     * Retrieves the frequency information from the SIGALIB system.
     * 
     * @return a map containing the frequency information, where the keys represent
     *         the frequencies and the values represent the corresponding results.
     * @throws IOException if an I/O error occurs while retrieving the frequency
     *                     information.
     */
    public Map<String, String> get_frequency() throws IOException {
        Map<String, String> frequencyResult = new PageNavigate(false).frequencyPage(user, password);
        return frequencyResult;
    }

    /**
     * Retrieves the grades for the user.
     *
     * @return a map containing the grades, where the keys are the course names and
     *         the values are maps
     *         containing the grade details (e.g., assignment name and score)
     * @throws IOException if an I/O error occurs while retrieving the grades
     */
    public Map<String, Map<String, String>> get_grades() throws IOException {
        Map<String, Map<String, String>> gradesResult = new PageNavigate(false).gradesPage(user, password);
        return gradesResult;
    }

}
