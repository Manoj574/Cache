package com.practice.lld.project_design_practice.storage;

import com.practice.lld.project_design_practice.exception.KeyNotFoundException;
import com.practice.lld.project_design_practice.exception.StorageFullException;

public interface IStorage<Key, Value> {

    void add(Key key, Value value) throws StorageFullException;

    Value get(Key key) throws KeyNotFoundException;

    void remove(Key key) throws KeyNotFoundException;
}
