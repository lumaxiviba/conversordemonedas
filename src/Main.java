import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangerate-api.com/v4/latest/USD"))
                .header("Authorization", "Bearer e3c756aac965f89b64ace5da")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            Moneda moneda = gson.fromJson(response.body(), Moneda.class);

            // Iniciar el conversor con los datos descargados
            Conversor conversor = new Conversor();
            conversor.iniciar(moneda); // Inicia el bucle del menú

        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la solicitud HTTP.");
            e.printStackTrace();
        }
    }
}