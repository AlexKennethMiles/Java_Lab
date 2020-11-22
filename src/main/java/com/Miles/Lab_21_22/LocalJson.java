package com.Miles.Lab_21_22;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.File;
import java.io.Writer;

public class LocalJson implements ItemStore {
    Gson gs = new Gson();
    private JsonParser parser = new JsonParser();
    private FileReader reader;
    JsonArray jsonArray = new JsonArray();
    File file = new File("G:\\IntelliJ IDEA\\MainFolder\\Java_Lab\\src\\main\\java\\com\\Miles\\Lab_21_22file.json");

    @Override
    public List<Item> getAll() {
        List<Item> array = null;
        Type type = new TypeToken<List<Item>>() {
        }.getType();
        try (FileReader reader = new FileReader(file)) {
            array = gs.fromJson(reader, type);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public Item get(int id) {
        List<Item> array = getAll();
        for (Item i : array) {
            if (i.getId() == id) return i;
        }
        return null;
    }

    @Override
    public Item addItem(Item item) {
        List<Item> array = getAll();
        item.setId(NewId(item));
        array.add(item);
        sort(array);
        try (Writer writer = new FileWriter(file)) {
            writer.write("[\n");
            for (Item i : array) {
                if (array.indexOf(i) != array.size() - 1) {
                    writer.write(gs.toJson(i) + ",\n");
                } else {
                    writer.write(gs.toJson(i) + "\n");
                }
            }
            writer.write("]\n");

        } catch (IOException e) {
            e.printStackTrace();

        }
        return item;
    }

    @Override
    public Item editItem(Item item, int id) {
        List<Item> array = getAll();
        array.removeIf(i -> i.getId() == id);
        item.setId(NewId(item));
        array.add(item);
        sort(array);
        try (Writer writer = new FileWriter(file)) {
            writer.write("[\n");
            for (Item i : array) {
                if (array.indexOf(i) != array.size() - 1) {
                    writer.write(gs.toJson(i) + ",\n");
                } else {
                    writer.write(gs.toJson(i) + "\n");
                }
            }
            writer.write("]\n");
        } catch (IOException e) {
            e.printStackTrace();

        }
        return item;
    }

    @Override
    public void deleteItem(int id) {
        List<Item> array = getAll();
        array.removeIf(i -> i.getId() == id);
        sort(array);
        try (Writer writer = new FileWriter(file)) {
            writer.write("[\n");
            for (Item i : array) {
                if (array.indexOf(i) != array.size() - 1) {
                    writer.write(gs.toJson(i) + ",\n");
                } else {
                    writer.write(gs.toJson(i) + "\n");
                }
            }
            writer.write("]\n");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void sort(List<Item> list) {
        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return (int) Math.signum(o1.getId() - o2.getId());
            }
        });
    }

    public int NewId(Item item) {
        List<Item> array = getAll();
        int newid = 1;
        ArrayList<Integer> ids = new ArrayList<>();
        for (Item i : array) {
            ids.add(i.getId());
        }
        while (ids.contains(newid)) newid++;
        return newid;
    }
}

