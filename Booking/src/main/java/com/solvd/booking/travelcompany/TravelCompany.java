package com.solvd.booking.travelcompany;

import com.solvd.booking.hotel.Hotel;
import com.solvd.booking.places.City;

import java.util.ArrayList;
import java.util.List;

public class TravelCompany {

    private int id;
    private String name;
    private String email;
    private List<Plane> planes;
    private List<Hotel> hotels;
    private City city;
    private List<UserAccount> userAccounts;

    public TravelCompany() {
    }

    public TravelCompany(int id, String name,  City city) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.planes = new ArrayList<>();
        this.hotels = new ArrayList<>();
        this.userAccounts = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }
}
