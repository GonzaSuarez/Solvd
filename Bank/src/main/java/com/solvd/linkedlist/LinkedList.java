package com.solvd.linkedlist;

public class LinkedList<T>{ //implements Iterable<LinkedList<T>>{

    private Node<T> head;
    private Node<T> last;
    private int size;

    public LinkedList() {
        size = 0;
    }

    public int size(){
        return this.size;
    }

    public Node<T> getNext(){
        return this.head.getNext();
    }


    public Node<T> getPrevious(){
        return this.head.getPrevious();
    }

    public T get(int i){
        if(this.head == null || i<0){
            return null;
        }
        else {
            Node<T> searcher = head;
            for (int j = 0; j < i; j++) {
                if(!searcher.hasNext()){
                    return null;
                }
                searcher =searcher.getNext();
            }
            return searcher.getValue();
        }
    }

    public Node<T> getLast() {
        return last;
    }

    public void add(Node<T> node){
        if(head==null){
            head = node;
            last = head;
        }
        else {
            Node<T> searcher = head;
            while(searcher.hasNext()){
                searcher = searcher.getNext();
            }
            searcher.setNext(node);
            node.setPrevious(searcher);
            this.last = node;
        }
        size++;
    }

    public void add(Node<T> node, int i){
        if(head==null){
            head = node;
            last = head;
        }
        else {
            Node<T> searcher = head;
            int j = 0;
            while (searcher.hasNext()){
                if(j == i){
                    node.setNext(searcher);
                    node.setPrevious(searcher.getPrevious());
                    searcher.getPrevious().setNext(node);
                }
                j++;
            }
            searcher.setNext(node);
            node.setPrevious(searcher);
            if(!node.hasNext()){
                this.last = node;
            }
        }
        size++;
    }

    public void add(T value){
        Node<T> node = new Node<>(value);
        if(head==null){
            head = node;
            last = head;
        }
        else {
            Node<T> searcher = head;
            while(searcher.hasNext()){
                searcher = searcher.getNext();
            }
            searcher.setNext(node);
            node.setPrevious(searcher);
            this.last = node;
        }
        size++;
    }

    public boolean add(T value, int i){
        Node<T> node = new Node<>(value);
        if(head==null){
            head = node;
            last = head;
        }
        else {
            Node<T> searcher = head;
            int j = 0;
            while (searcher.hasNext()){
                if(j == i){
                    node.setNext(searcher);
                    node.setPrevious(searcher.getPrevious());
                    searcher.getPrevious().setNext(node);
                    searcher.setPrevious(node);
                    size++;
                    return true;
                }
                searcher = searcher.getNext();
                j++;
            }
            searcher.setNext(node);
            node.setPrevious(searcher);
            if(!node.hasNext()){
                this.last = node;
                size++;
                return true;
            }
        }
        return false;
    }

    public boolean remove(int index){
        if(this.head == null || index<0 || index >this.size){
            return false;
        }
        else {
            Node<T> searchear = head;
            for (int i = 0; i < index; i++) {
                if(!searchear.hasNext()){
                    return false;
                }
                searchear = searchear.getNext();
            }
            searchear.getPrevious().setNext(searchear.getNext());
            searchear.getNext().setPrevious(searchear.getPrevious());
            searchear.setPrevious(null);
            searchear.setNext(null);
            this.size--;
            return true;
        }
    }

    public String toStringBackwards(){
        String output = "";
        if(this.head != null){
            Node<T> searchear = last;
            while (searchear.hasPrevious()){
                output += " [ " + searchear.getValue().toString() + "]";
                searchear = searchear.getPrevious();
            }
            output += " [ " + searchear.getValue().toString() + "]";
        }
        return output;
    }

    @Override
    public String toString() {
        String output = "";
        if(this.head != null){
            Node<T> searchear = head;
            while (searchear.hasNext()){
                output += " [ " + searchear.getValue().toString() + "]";
                searchear = searchear.getNext();
            }
            output += " [ " + searchear.getValue().toString() + "]";
        }
        return output;
    }

/*
    public LinkedList(){this.size = 0;}

    public LinkedList(Node previous, T value, Node next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
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

    public void add(T value){
        if(this.value == null){
            this.value = value;
            this.last = this;
        }
        else {
            Node insert = new LinkedList<>(this.last, value, null);
            this.last.setNext(insert);
            this.last = this.last.getNext();
        }
        size++;
    }

    public boolean add(T value, int i){
        int j = 0;
        Node searcher = this;
        while (searcher.hasNext()){
            if(j == i){
                Node inserted = new Node(this.next, value, searcher);
                searcher.getPrevious().setNext(inserted);
                searcher.setPrevious(inserted);
                size++;
                return true;
            }
            else{
                j++;
                searcher = searcher.getNext();
            }
        }
        return false;
    }

    public Node remove(int i){
        int j = 0;
        LinkedList<T> searcher = this;
        while (searcher.hasNext()){
            if(j == i){
                searcher.getNext().setPrevious(searcher.getPrevious());
                searcher.getPrevious().setNext(searcher.getNext());
                size--;
                return searcher;
            }
            else{
                j++;
                searcher = searcher.getNext();
            }
        }
        return searcher;
    }


    public int size(){
        return this.size;
    }

    public Node next(){
        return this.getNext();
    }

    public boolean hasNext(){
        return this.getNext() != null;
    }

    public Node lastNode(){
        return this.last;
    }
    /*@Override
    public Iterator<LinkedList<T>> iterator() {

        LinkedList<T> list = this;
        Iterator<LinkedList<T>> i= new Iterator<T>() {

            @Override
            public boolean hasNext() {

                if (list.getNext() != null) {
                    return true;
                }
                else {
                    return false;
                }

            }

            @Override
            public LinkedList<T> next() {
                return list.getNext();
            }
        };
        return i;
    }
*/

}
