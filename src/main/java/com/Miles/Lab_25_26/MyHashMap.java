package com.Miles.Lab_25_26;

import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<K, V> implements HashMapInterface<K, V> {
    private ArrayList<ArrayList<Item<K, V>>> list;
    private ArrayList<V> realValues = new ArrayList<>();

    public MyHashMap() {
        list = new ArrayList<>();
        for (int i = 0; i < 127; i++) {
            list.add(new ArrayList<Item<K, V>>());
        }
    }

    @Override
    public void add(K key, V value) {
        int index = key.hashCode() % list.size();
        if (list.get(index).size() == 0) {
            list.get(index).add(new Item<K, V>(key, value));
            realValues.add(value);
        } else if (list.get(index).size() != 0) {
            for (int i = 0; i < list.get(index).size(); i++) {
                Item<K, V> item = list.get(index).get(i);
                if (key.hashCode() == item.getKey().hashCode()) {
                    for (int j = 0; j < realValues.size(); j++) {
                        if (realValues.get(j) == item.getValue()) {
                            realValues.set(j, value);
                            break;
                        }
                    }
                    item = new Item<K, V>(key, value);
                    list.get(index).set(i, item);
                    break;
                } else {
                    list.get(index).add(item);
                    realValues.add(value);
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        if (getLastItem(key) != null) {
            return getLastItem(key).getValue();
        } else {
            return null;
        }
    }


    @Override
    public V remove(K key) {
        if (getLastItem(key) != null) {
            V value = get(key);
            list.get(key.hashCode() % list.size()).remove(getLastItem(key));
            realValues.remove(value);
            return value;
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return new CustomIterator<V>();
    }

    private Item<K, V> getLastItem(K key) {
        int index = key.hashCode() % list.size();
        if (list.get(index) != null) {
            if (list.get(index).size() != 0) {
                return list.get(index).get(list.get(index).size() - 1);
            }
        }
        return null;
    }

    private class CustomIterator<V> implements Iterator<V>
    {
        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            if(currentIndex < realValues.size())
                return true;
            else
            {
                currentIndex = 0;
                return false;
            }
        }

        @Override
        public V next() {
            return (V) realValues.get(currentIndex++);
        }
    }
}
