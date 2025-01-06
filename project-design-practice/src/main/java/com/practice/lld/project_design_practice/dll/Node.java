package com.practice.lld.project_design_practice.dll;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<K> {

    private K key;
    private Node<K> next;
    private Node<K> prev;

    public Node(K key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}
