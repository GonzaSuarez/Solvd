package com.solvd.booking.travelcompany;

public class Plane {

    private int id;
    private int capacity;

    public Plane() {
    }

    public Plane(int id, int capacity) {
        this.capacity = capacity;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
