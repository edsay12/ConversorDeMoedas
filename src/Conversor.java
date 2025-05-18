import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    private Double taxa;
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/bd01f97a98b1e93bb65c0645/latest/";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final Gson gson = new Gson();
    private Double resultado;
    private String de;
    private String para;
    private Double valor;

    // Buscar taxa de câmbio da API
    public void buscarTaxa(String de, String para) {
        this.de = de;
        this.para = para;

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + de))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ExchangeResponse valor = gson.fromJson(response.body(), ExchangeResponse.class);

            if ("success".equalsIgnoreCase(valor.result())) {
                this.taxa = valor.conversion_rates().get(para);
            } else {
                System.out.println("Erro ao buscar taxa de câmbio.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao acessar a API: " + e.getMessage());

        }
    }

    public void calcularConversao(Double valor) {
        this.valor = valor;
        this.resultado = valor * this.taxa;
    }

    public void mostrarResultado() {
        System.out.printf("Valor %.2f [%s] corresponde ao valor final de >>> %.2f [%s]%n",
                this.valor, de, this.resultado, para);
    }
}