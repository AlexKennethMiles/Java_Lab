package com.Miles.Lab_23_24;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {
    private HttpClient httpClient = HttpClient.newHttpClient();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String path = "src/main/java/com/Miles/Lab_23_24";
    private File file = new File(path);
    private List<Task> tasks;
    private List<Task> completeTasks = new ArrayList<>();
    private int id = 0;

    public Worker() throws IOException {
        file.createNewFile();
    }

    private List<Task> getTasks() {
        Type type = new TypeToken<Collection<Task>>() {
        }.getType();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://80.87.199.76:3000/tasks"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return gson.fromJson(response.body(), type);
    }

    private boolean checkTask(Task task) {
        for (int i = 0; i < completeTasks.size(); i++) {
            if (completeTasks.get(i).getId() == task.getId()) {
                return true;
            }
        }
        return false;
    }

    private void postReport(Report report) {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(report)))
                .uri(URI.create("http://80.87.199.76:3000/reports"))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void saveTasks() {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write("[\n");
            for (int i = 0; i < completeTasks.size(); i++) {
                writer.write(gson.toJson(completeTasks.get(i)));
                if (i != completeTasks.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double calculate(String expression) {
        double first, second;
        double bufR = 0;
        int res = 0;
        double scope = Math.pow(10, 2);
        String expressionWithoutSpace = expression.replace(" ", "");
        Pattern pattern = Pattern.compile("(?<first>[-]*\\d+)(?<operator>[+-/*])(?<second>[-]*\\d+)");
        Matcher matcher = pattern.matcher(expressionWithoutSpace);
        if (matcher.find()) {
            first = Double.valueOf(matcher.group("first"));
            second = Double.valueOf(matcher.group("second"));
            switch (matcher.group("operator")) {
                case "+":
                    bufR = first + second;
                    break;
                case "-":
                    bufR = first - second;
                    break;
                case "/":
                    bufR = first / second;
                    break;
                case "*":
                    bufR = first * second;
                    break;
                default:
                    break;
            }
            res = (int) (Math.round(bufR * scope) / scope);
        }
        return res;
    }

    public void analyze() throws InterruptedException {
        while (true) {
            Thread thread = new Thread(() -> {
                tasks = getTasks();
                for (int i = 0; i < tasks.size(); i++) {
                    if (completeTasks == null) {
                        completeTasks = new ArrayList<>();
                        postReport(new Report(id, tasks.get(i).getId(), calculate(tasks.get(i).getExpression())));
                        completeTasks.add(tasks.get(i));
                        saveTasks();
                    } else if (!checkTask(tasks.get(i))) {
                        postReport(new Report(id, tasks.get(i).getId(), calculate(tasks.get(i).getExpression())));
                        completeTasks.add(tasks.get(i));
                        saveTasks();
                    }
                }
            });
            thread.start();
            thread.join();
            Thread.sleep(10_000);
        }
    }
}