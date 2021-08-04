package com.solvd.booking.travelcompany;

public class Plan {

    private int id;
    private String name;
    private int minRoom;
    private int maxRoom;
    private int monthlyPrice;
    private String details;

    public Plan() {
    }

    public Plan(int id, String name, int minRoom, int maxRoom) {
        this.id = id;
        this.name = name;
        this.minRoom = minRoom;
        this.maxRoom = maxRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinRoom() {
        return minRoom;
    }

    public void setMinRoom(int minRoom) {
        this.minRoom = minRoom;
    }

    public int getMaxRoom() {
        return maxRoom;
    }

    public void setMaxRoom(int maxRoom) {
        this.maxRoom = maxRoom;
    }

    public int getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(int monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
