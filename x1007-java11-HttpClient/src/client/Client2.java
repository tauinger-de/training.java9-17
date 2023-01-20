package client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

public class Client2 {

    public static void main(String[] args) throws Exception {

        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/math?x=40&y=2"))
                .GET()
                .build();

        final HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_2)
                .build();

        final CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, BodyHandlers.ofString());
        // System.out.println("Waiting for response ...");
        // final HttpResponse<String> response = future.get();
        // System.out.println("Response received!");
        // System.out.println("status = " + response.statusCode());
        // System.out.println("body = " + response.body());

        future.thenAccept(response -> {
            System.out.println("Response received!");
            System.out.println("status = " + response.statusCode());
            System.out.println("body   = " + response.body());
        }).join();

    }

}
