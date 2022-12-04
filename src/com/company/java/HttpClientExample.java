package com.company.java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientExample {
  public static void main(String[] args) throws IOException, InterruptedException {
    HttpClient client = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(1))
        .version(HttpClient.Version.HTTP_2)
        .build();

    HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create("https://official-joke-api.appspot.com/random_joke"))
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    HttpHeaders headers = response.headers();
    headers.map().forEach((k,v) -> System.out.println(k +":" + v));

    System.out.println(response.statusCode());

    System.out.println(response.body());
  }
}
