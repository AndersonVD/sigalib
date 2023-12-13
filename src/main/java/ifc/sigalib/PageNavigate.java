package ifc.sigalib;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageNavigate {

    private Playwright playwright;
    private Browser browser;

    public PageNavigate(boolean hideMode) {
        // Inicializa Playwright e Browser
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(hideMode));
    }

    private Page firefoxBrowser() {
        // Cria uma nova página sem fechar o navegador
        return browser.newPage();
    }

    public void close() {
        // Fecha o navegador e o Playwright quando terminar de usar
        browser.close();
        playwright.close();
    }

    private Page login_page(Page page, String user, String password) {
        page.navigate("https://sig.ifc.edu.br/sigaa/verTelaLogin.do");
        page.fill(
                ".logon > form:nth-child(2) > table:nth-child(8) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > input:nth-child(1)",
                user);
        page.fill(
                ".logon > form:nth-child(2) > table:nth-child(8) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > input:nth-child(1)",
                password);
        page.click(
                ".logon > form:nth-child(2) > table:nth-child(8) > tfoot:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > input:nth-child(1)");
        page.waitForLoadState();
        return page;
    }

    public String homePage(String user, String password) throws IOException {
        Page page = firefoxBrowser();
        page = login_page(page, user, password);
        page.waitForURL("https://sig.ifc.edu.br/sigaa/portais/discente/discente.jsf");

        return page.content();
    }

    public Map<String, String> frequencyPage(String user, String password) throws IOException {
        Page page = firefoxBrowser();
        page = login_page(page, user, password);
        Document doc = Jsoup.parse(page.content());
        Elements classes_list = doc.select("#turmas-portal > table:nth-child(3) > tbody > tr > td.descricao");
        Map<String, String> frequency = new HashMap<>();
        for (int i = 0; i < classes_list.size(); i++) {
            page.getByText(classes_list.get(i).text()).first().click();
            page.waitForLoadState();

            // Iniciar parte para pegar frequencia
            if (page.getByText("Alunos").first().isVisible() == true)
                page.getByText("Alunos").first().click();

            page.getByText("Frequência").click();
            page.waitForLoadState();
            frequency.put(classes_list.get(i).text(),
                    page.querySelector(".botoes-show").textContent().split("CH: ")[1].strip());
            page.goBack();
            page.goBack();
        }

        return frequency;

    }

    public Map<String, Map<String, String>> gradesPage(String user, String password) throws IOException {
        Page page = firefoxBrowser();
        page = login_page(page, user, password);
        // Para pegar Notas =============
        Document doc = Jsoup.parse(page.content());
        Elements classes_list = doc.select("#turmas-portal > table:nth-child(3) > tbody > tr > td.descricao");
        Map<String, Map<String, String>> grades = new HashMap<>();
        for (int i = 0; i < classes_list.size(); i++) {
            page.getByText(classes_list.get(i).text()).first().click();
            page.waitForLoadState();

            if (page.getByText("Alunos").first().isVisible() == true)
                page.getByText("Alunos").first().click();

            page.getByText("Ver Notas").click();
            page.waitForLoadState();
            Map<String, String> sub_grade = new HashMap<>();
            List<ElementHandle> linhas = page.querySelectorAll("table tr");

            for (ElementHandle linha : linhas) {
                List<ElementHandle> celulas = linha.querySelectorAll("td");
                for (ElementHandle celula : celulas) {
                    String texto = celula.textContent();
                    sub_grade.put(linha.textContent(), texto);
                }
            } // TODO Contertar a parte do parser

            grades.put(classes_list.get(i).text(),
                    sub_grade);
            page.goBack();
            page.goBack();
        }

        return grades;
    }

}
