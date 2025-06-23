import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.exchangerate-api.com/v4/latest/USD"))
            .header("Authorization", "Bearer e3c756aac965f89b64ace5da")
            .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());

    Gson gson = new Gson();
    Moneda moneda = gson.fromJson(response.body(), Moneda.class);
System.out.println(moneda.getRates());
}
