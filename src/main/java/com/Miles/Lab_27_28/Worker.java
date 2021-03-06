package com.Miles.Lab_27_28;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Worker {
    private final static String path = "http://gitlessons2020.rtuitlab.ru:3000/reflectionTasks";
    private static HttpClient client = HttpClient.newHttpClient();
    private static Gson gson = new Gson();

    public List<ReflectionTask> getTasks() {
        List<ReflectionTask> tasks = null;
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(path))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            tasks = gson.fromJson(response.body(), new TypeToken<List<ReflectionTask>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @TypeOfOperation(name = "sum")
    public void sum(Data data) {
        int s = 0;
        for (int i : data.getNumbers()) {
            s += i;
        }
        System.out.println(s);
    }

    @TypeOfOperation(name = "print")
    public void printWords(Data data) {
        for (String word : data.getWords()) {
            if (data.getWords().indexOf(word) != data.getWords().size() - 1)
                System.out.print(word + " " + data.getDelimeter() + " ");
            else
                System.out.print(word);
        }
    }
}