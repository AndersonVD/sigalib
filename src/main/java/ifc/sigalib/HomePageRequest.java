package ifc.sigalib;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HomePageRequest {
        public static void main(String[] args) throws IOException, InterruptedException {
                HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
                                .uri(URI.create("https://sig.ifc.edu.br/sigaa/portais/discente/discente.jsf"))
                                .header("Cookie",
                                                "_ga=GA1.3.1398826142.1702070924; _gid=GA1.3.1409357927.1702258865; JSESSIONID=F18001A255CB2EB02FBA9916B34E5630.sigaa04; _gat=1; _ga_YMZNHGVLFR=GS1.3.1702433086.11.1.1702437043.0.0.0")
                                .header("User-Agent",
                                                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like// Gecko) Chrome/120.0.0.0 Safari/537.36")
                                .method("GET", HttpRequest.BodyPublishers.noBody())
                                .build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                                HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
        }
}
