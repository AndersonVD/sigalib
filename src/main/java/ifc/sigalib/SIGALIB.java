package ifc.sigalib;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SIGALIB {

    private static SIGALIB instance;
    private String user;
    private String password;

    private SIGALIB(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static SIGALIB getInstance(String user, String password) {
        if (instance == null) {
            instance = new SIGALIB(user, password);
        }
        return instance;
    }

    public String getPage() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://sig.ifc.edu.br/sigaa/verTelaLogin.do");
            page.fill(
                    ".logon > form:nth-child(2) > table:nth-child(8) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > input:nth-child(1)",
                    user);
            page.fill(
                    ".logon > form:nth-child(2) > table:nth-child(8) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > input:nth-child(1)",
                    password);
            page.click(
                    ".logon > form:nth-child(2) > table:nth-child(8) > tfoot:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > input:nth-child(1)");
            page.waitForURL("https://sig.ifc.edu.br/sigaa/portais/discente/discente.jsf");
            return page.content();
        }
    }

    public void getClassesCommand() {
        System.out.println("Executando o comando de obter as disciplinas...");

    }

    public void getScheduleCommand() {
        System.out.println("Executando o comando de obter o horário...");

    }

    public void getNewsCommand() {
        System.out.println("Executando o comando de obter as notícias...");

    }

    public void getUserInfoCommand() {
        System.out.println("Executando o comando de obter as informações do usuário...");

    }

    public void getGradesCommand() {
        System.out.println("Executando o  comando de obter as notas...");

    }

    public void getFrequencyCommand() {
        System.out.println("Executando o comando de obter a frequência...");
    }

}
