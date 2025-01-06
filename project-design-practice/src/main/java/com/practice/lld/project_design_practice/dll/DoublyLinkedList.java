package com.practice.lld.project_design_practice.dll;

public class DoublyLinkedList<K> {

    private final Node<K> head;

    private final Node<K> tail;

    public DoublyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public Node<K> addElementAtLast(K key) {

        Node<K> node = new Node<>(key);
        addNodeAtLast(node);
        return node;
    }

    public Node<K> getFirstNode() {
        if (!isItemPresent()) {
            return null;
        }
        return head.getNext();
    }

    public void detachNode(Node<K> node) {
        if (node != null) {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    public void addNodeAtLast(Node<K> node) {
        tail.getPrev().setNext(node);
        node.setPrev(tail.getPrev());
        tail.setPrev(node);
        tail.setNext(node);
    }

    private boolean isItemPresent() {
        return head.getNext() == tail;
    }

}
