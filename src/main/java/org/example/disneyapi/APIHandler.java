package org.example.disneyapi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

// a class for handling API request & response
public class APIHandler {

    public static String baseUrl = "https://apidisneymovies.bsite.net/api/v1";

    public String callAPI(String endpoint) throws IOException, InterruptedException, URISyntaxException {
        // replace a space to '%20"
        endpoint = endpoint.replaceAll(" ", "%20");

        String url = baseUrl + endpoint;

        /* Make a GET HTTP request */
        // Construct an HttpClient instance
        HttpClient client = HttpClient.newHttpClient();
        // Build HttpRequest (default is GET)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    // a method that return a list of DisneyMovie objects
    public List<DisneyMovie> parseJsonDisneyMovie(String jsonData) {
        Gson gson = new Gson();
        JsonElement jsonElement = gson.fromJson(jsonData, JsonElement.class);
        // Check if the JSON is an array or an object
        if (jsonElement.isJsonArray()) {
            // Parse the JSON as an array of DisneyMovie objects
            Type movieListType = new TypeToken<List<DisneyMovie>>() {}.getType();
            // return a list of DisneyMovie objects
            return gson.fromJson(jsonElement, movieListType);
        } else {
            // If the JSON is not an array, log a message
            System.out.println("No movies found.");
            return new ArrayList<>(); // Return an empty list
        }
    }

    // Get Movie by ID With Details
    public static DisneyMovieDetail getMovieDetails(int movieId) throws IOException, InterruptedException, URISyntaxException {

        // create url to get selected movie details
       String url = baseUrl + "/movies/" + movieId + "?details=true";

        // Construct an HttpClient instance
        HttpClient client = HttpClient.newHttpClient();
        // Build HttpRequest (default is GET)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), DisneyMovieDetail.class);
    }
}
