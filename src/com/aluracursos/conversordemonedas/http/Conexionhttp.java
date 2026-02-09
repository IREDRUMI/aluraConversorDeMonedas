package com.aluracursos.conversordemonedas.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexionhttp {

    private String apiKey = "9eca69c09f82d9d2d113fa30";
    private String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(direccion))
            .build();


    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    private String json =  response.body();

    public String getJson() {
        return this.json;
    }
    public Conexionhttp() throws IOException, InterruptedException {
    }




}
