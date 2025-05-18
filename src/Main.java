import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        String Currency = "USD";
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://v6.exchangerate-api.com/v6/bd01f97a98b1e93bb65c0645/latest/"+ Currency)).build();

    }
}