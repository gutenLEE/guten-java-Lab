package chap5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author gutenlee
 * @since 2022/05/23
 */
public class CardNumberValidator {

    public CardValidity validate(String cardNumber) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("hhtps://some-external-pg.com/card"))
                .header("Content-Type", "text/plain")
                .POST(HttpRequest.BodyPublishers.ofString(cardNumber))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            switch (response.body()) {
                case "ok":
                    return CardValidity.VALID;
                case "bad":
                    return CardValidity.INVALID;
                case "expired":
                    return CardValidity.EXPIRED;
                case "theft":
                    return CardValidity.THEFT;
                default: return CardValidity.UNKNOWN;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return CardValidity.ERROR;
        }
    }
}
