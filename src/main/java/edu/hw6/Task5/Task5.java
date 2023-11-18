package edu.hw6.Task5;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private static final String SITE_URI = "https://hacker-news.firebaseio.com/v0/";
    private static final String NEWS_JSON = "topstories.json";
    private static final String NEW_ON_NUMBER = "item/%d.json";

    private Task5() {
    }

    public static Long[] hackerNewsTopStories() {
        String body;
        try {
            body = getBody(new URI(SITE_URI + NEWS_JSON));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        var a = Arrays.stream(
                body.substring(1, body.length() - 1)
                    .split(",")
            )
            .map(Long::parseLong)
            .toList();
        return a.toArray(new Long[0]);
    }

    public static String news(long id) {
        String body;

        try {
            body = getBody(new URI(SITE_URI + String.format(NEW_ON_NUMBER, id)));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        var pattern = Pattern.compile("\"title\":\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(body);

        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }

        return matcher.group(1);
    }

    private static String getBody(URI uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(uri)
            .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
