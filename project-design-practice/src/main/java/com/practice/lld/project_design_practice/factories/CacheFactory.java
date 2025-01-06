package com.practice.lld.project_design_practice.factories;

import com.practice.lld.project_design_practice.cache.Cache;
import com.practice.lld.project_design_practice.evictionpolicy.LRUEvictionPolicy;
import com.practice.lld.project_design_practice.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {

    public Cache<Key, Value> getDefaultCache() {
        return new Cache<>(new LRUEvictionPolicy<>(), new HashMapBasedStorage<>(10));
    }
}
