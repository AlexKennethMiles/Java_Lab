package com.Miles.Lab_25_26;

import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<K, V> implements HashMapInterface<K, V> {
    private ArrayList<ArrayList<Item<K, V>>> list;
    private int MapSize = 127;

    public MyHashMap() {
        list = new ArrayList<>();
        for (int i = 0; i < MapSize; i++) {
            list.add(new ArrayList<Item<K, V>>());
        }
    }

    @Override
    public void add(K key, V value) {
        int index = key.hashCode() % list.size();
        if (list.get(index).size() == 0) {
            list.get(index).add(new Item<K, V>(key, value));
        } else {
            boolean flag = false;
            for (int i = 0; i < list.get(index).size(); i++) {
                if (list.get(index).get(i).getKey().equals(key)) {
                    list.get(index).set(i, new Item<>(key, value));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.get(index).add(new Item<>(key, value));
            }
        }
    }

    @Override
    public V get(K key) {
        int index = key.hashCode() % list.size();
        for (int i = 0; i < list.get(index).size(); i++) {
            if (list.get(index).get(i).getKey().equals(key)) {
                return list.get(index).get(i).getValue();
            }
        }
        return null;
    }


    @Override
    public V remove(K key) {
        int index = key.hashCode() % list.size();
        for (int i = 0; i < list.get(index).size(); i++) {
            if (list.get(index).get(i).getKey().equals(key)) {
                Item<K, V> item = new Item<>();
                item.setValue(list.get(index).get(i).getValue());
                list.get(index).remove(list.get(index).get(i));
                return item.getValue();
            }
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return new CustomIterator<V>();
    }

    private class CustomIterator<V> implements Iterator<V> {
        private int currentIndexOfArray = 0, currentIndexOfItem = 0;

        @Override
        public boolean hasNext() {
            if (currentIndexOfItem == list.get(currentIndexOfArray).size()) {
                currentIndexOfItem = 0;
                do {
                    currentIndexOfArray++;
                } while (currentIndexOfArray < MapSize && list.get(currentIndexOfArray).size() == 0);
            }
            return currentIndexOfArray < MapSize;
        }

        @Override
        public V next() {
            return (V) list.get(currentIndexOfArray).get(currentIndexOfItem++).getValue();
        }
    }
}
