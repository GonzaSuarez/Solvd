package com.solvd.booking.hotel;

import java.util.Calendar;

public class Reservation {

    private Calendar startingDate;
    private Calendar endingDate;
    private double price;
    private float discount;
    private User client;
    private Room room;

    public Reservation() {
    }

    public Reservation(Room room,  User client) {
        this.price = room.getPrice();
        this.client = client;
        this.room = room;
        this.startingDate = Calendar.getInstance();
    }

    public Calendar getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Calendar startingDate) {
        this.startingDate = startingDate;
    }

    public Calendar getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Calendar endingDate) {
        this.endingDate = endingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
