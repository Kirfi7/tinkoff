package edu.hw6.Task5;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс Task5 предоставляет статические методы для получения информации о топовых новостях с Hacker News.
 */
public class Task5 {
    // URI-адрес сайта Hacker News
    private static final String SITE_URI = "https://hacker-news.firebaseio.com/v0/";
    // Конечная точка для получения списка топовых новостей в формате JSON
    private static final String NEWS_JSON = "topstories.json";
    // Шаблон для формирования URI для получения информации о конкретной новости по её ID
    private static final String NEW_ON_NUMBER = "item/%d.json";

    // Приватный конструктор, чтобы предотвратить создание экземпляров класса
    private Task5() {
    }

    /**
     * Метод для получения ID топовых новостей с Hacker News.
     *
     * @return Массив Long с ID топовых новостей.
     * @throws RuntimeException в случае ошибок при выполнении HTTP-запроса или парсинге JSON.
     */
    public static Long[] hackerNewsTopStories() {
        String body;
        try {
            // Получаем JSON с ID топовых новостей
            body = getBody(new URI(SITE_URI + NEWS_JSON));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        // Обрабатываем JSON, выделяя ID и преобразуя их в Long
        var idList = Arrays.stream(
                body.substring(1, body.length() - 1)
                    .split(",")
            )
            .map(Long::parseLong)
            .toList();
        return idList.toArray(new Long[0]);
    }

    /**
     * Метод для получения названия новости по её ID.
     *
     * @param id ID новости.
     * @return Название новости.
     * @throws RuntimeException в случае ошибок при выполнении HTTP-запроса или парсинге JSON.
     */
    public static String news(long id) {
        String body;

        try {
            // Получаем JSON с информацией о новости по её ID
            body = getBody(new URI(SITE_URI + String.format(NEW_ON_NUMBER, id)));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        // Используем регулярное выражение для выделения названия новости из JSON
        var pattern = Pattern.compile("\"title\":\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(body);

        // Если совпадение найдено, возвращаем название новости, иначе выбрасываем исключение
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }

        return matcher.group(1);
    }

    /**
     * Метод для выполнения HTTP-запроса и получения тела ответа в виде строки.
     *
     * @param uri URI-адрес запроса.
     * @return Тело ответа в виде строки.
     * @throws RuntimeException в случае ошибок при выполнении HTTP-запроса.
     */
    private static String getBody(URI uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(uri)
            .build();

        try {
            // Отправляем запрос и получаем тело ответа
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
