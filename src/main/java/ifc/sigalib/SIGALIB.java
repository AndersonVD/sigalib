package ifc.sigalib;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import ifc.sigalib.models.Aluno;

public class SIGALIB {
    private String user;
    private String password;

    SIGALIB(String user, String password) {
        this.user = user;
        this.password = password;
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

    public String get_user_info() {
        String pageContent = getPage();
        Document doc = Jsoup.parse(pageContent);
        Aluno aluno = new Aluno();
        aluno.setMatricula(Integer
                .parseInt(doc.select("#agenda-docente > table > tbody > tr:nth-child(1) > td:nth-child(2)").text()));
        return aluno.toString();
    }

}
