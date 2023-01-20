// https://golb.hplar.ch/2019/01/java-11-http-client.html

package client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Client1 {

    public static void main(String[] args) throws Exception {
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/math?x=40&y=2"))
                .GET()
                .build();

        final HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_2)
                .build();

        System.out.println("Waiting for response ...");
        final HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println("Response received!");

        System.out.println("status = " + response.statusCode());
        System.out.println("body   = " + response.body());
    }

}
