package com.practice.lld.project_design_practice.evictionpolicy;

import com.practice.lld.project_design_practice.dll.DoublyLinkedList;
import com.practice.lld.project_design_practice.dll.Node;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key> {

    private DoublyLinkedList<Key> linkedList;

    private Map<Key, Node<Key>> map;

    @Override
    public void keyAccessed(Key key) {
        if (map.containsKey(key)) {
            linkedList.detachNode(map.get(key));
            linkedList.addNodeAtLast(map.get(key));
        } else {
            Node<Key> node = linkedList.addElementAtLast(key);
            map.put(key, node);
        }
    }

    @Override
    public Key evict() {
        Node<Key> firstNode = linkedList.getFirstNode();
        if (firstNode == null) {
            return null;
        }
        linkedList.detachNode(firstNode);
        return firstNode.getKey();
    }


}
