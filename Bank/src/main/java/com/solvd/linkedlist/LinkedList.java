package com.solvd.linkedlist;

public class LinkedList<T>{ //implements Iterable<LinkedList<T>>{

    private LinkedList<T> previous; //previous
    private T value;
    private LinkedList<T> next; //next
    private LinkedList<T> last;
    private int size;

    public LinkedList(){this.size = 0;}

    public LinkedList(LinkedList<T> previous, T value, LinkedList<T> next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

    public LinkedList<T> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedList<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedList<T> getNext() {
        return next;
    }

    public void setNext(LinkedList<T> next) {
        this.next = next;
    }

    public void add(T value){
        if(this.value == null){
            this.value = value;
            this.last = this;
        }
        else {
            LinkedList<T> insert = new LinkedList<>(this.last, value, null);
            this.last.setNext(insert);
            this.last = this.last.getNext();
        }
        size++;
    }

    public boolean add(T value, int i){
        int j = 0;
        LinkedList<T> searcher = this;
        while (searcher.hasNext()){
            if(j == i){
                LinkedList<T> inserted = new LinkedList<T>(this.next, value, searcher);
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

    public LinkedList<T> remove(int i){
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

    public LinkedList<T> next(){
        return this.getNext();
    }

    public boolean hasNext(){
        return this.getNext() != null;
    }

    public LinkedList<T> lastNode(){
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
    @Override
    public String toString() {
        return this.value.toString();
    }
}
