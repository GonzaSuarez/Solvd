package com.solvd.linkedlist;

public class Node<T> {

    private Node<T> previous;
    private Node<T> next;
    private T value;

    public Node() {
    }

    public Node(T value){
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    public Node(Node previous,  Node next) {
        this.previous = previous;
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public T getValue() {
        return this.value ;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasNext(){
        return this.next != null;
    }

    public boolean hasPrevious(){
        return this.previous != null;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
