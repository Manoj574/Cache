package com.practice.lld.project_design_practice.cache;

import com.practice.lld.project_design_practice.evictionpolicy.IEvictionPolicy;
import com.practice.lld.project_design_practice.exception.KeyNotFoundException;
import com.practice.lld.project_design_practice.exception.StorageFullException;
import com.practice.lld.project_design_practice.storage.IStorage;
import org.springframework.stereotype.Component;

@Component
public class Cache<Key, Value> {

    private final IEvictionPolicy<Key> evictionPolicy;

    private final IStorage<Key, Value> storage;

    public Cache(IEvictionPolicy<Key> evictionPolicy, IStorage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {

        try {
            storage.add(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (StorageFullException e) {
            Key evictedKey  = evictionPolicy.evict();
            if (evictedKey == null) {
                throw new RuntimeException("Storage full but no key to evict.");
            }
            storage.remove(key);
            storage.add(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        } catch (KeyNotFoundException e) {
            return null;
        }
    }
}
