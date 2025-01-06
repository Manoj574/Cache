package com.practice.lld.project_design_practice.storage;

import com.practice.lld.project_design_practice.exception.KeyNotFoundException;
import com.practice.lld.project_design_practice.exception.StorageFullException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HashMapBasedStorage<Key, Value> implements IStorage<Key,Value> {

    private final Integer CAPACITY;

    private final Map<Key, Value> map;

    public HashMapBasedStorage(Integer capacity) {
        CAPACITY = capacity;
        this.map = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if (isStorageFull()) {
            throw new StorageFullException("Storage is Full");
        }
        map.put(key, value);
    }

    @Override
    public Value get(Key key) throws KeyNotFoundException {
        if (!map.containsKey(key)) {
            throw new KeyNotFoundException("Given Key Not Found");
        }
        return null;
    }

    @Override
    public void remove(Key key) throws KeyNotFoundException {
        if (!map.containsKey(key)) {
            throw new KeyNotFoundException("Given Key Not Found");
        }
        map.remove(key);
    }

    private boolean isStorageFull() {
        return map.size() == CAPACITY;
    }
}
