package com.solvd.booking.hotel;

import java.util.Calendar;

public class Reservation {

    private int id;
    private Calendar startingDate;
    private Calendar endingDate;
    private double price;
    private float discount;
    private User client;

    public Reservation() {
    }

    public Reservation(int id, float price,  User client) {
        this.price = price;
        this.client = client;
        this.id = id;
        this.startingDate = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
