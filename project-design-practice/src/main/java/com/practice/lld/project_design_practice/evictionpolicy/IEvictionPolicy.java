package com.practice.lld.project_design_practice.evictionpolicy;


public interface IEvictionPolicy<Key> {

    void keyAccessed(Key key);

    Key evict();
}