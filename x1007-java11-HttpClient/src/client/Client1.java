// https://golb.hplar.ch/2019/01/java-11-http-client.html

package client;

import jj.util.log.Log;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

public class Client1 {

    static final HttpClient client;

    static {
        client = HttpClient.newBuilder()
                .version(Version.HTTP_2)
                .build();
    }

    public static void main(String[] args) throws Exception {
        final HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.discogs.com/releases/249504"))
                .build();
        demoBlocking(request);
        demoAsync(request);
    }

    private static void demoBlocking(HttpRequest request) throws IOException, InterruptedException {
        Log.logMethodCall();
        System.out.println("Waiting for response ...");
        final HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println("Blocking response received!");
        dumpResponse(response);
    }

    private static void demoAsync(HttpRequest request) throws InterruptedException {
        Log.logMethodCall();
        // or
        CompletableFuture<HttpResponse<String>> completableFuture = client.sendAsync(request, BodyHandlers.ofString());
        completableFuture.handle((resp, err) -> {
            System.out.println("Async response received!");
            if (err != null) {
                System.err.println("Got error: " + err.getMessage());
                return null;
            } else {
                dumpResponse(resp);
                return resp;
            }
        });
        System.out.println("Request has been dispatched... Sleeping now");
        Thread.sleep(2000); // give future time to complete
    }

    private static void dumpResponse(HttpResponse<String> response) {
        var statusReport = """
                status = %s
                body length = %d
                body first 100 chars = '%s'
                """.formatted(
                response.statusCode(),
                response.body().length(),
                response.body().substring(0, 100)
        );
        System.out.println(statusReport.indent(4));
    }

}
