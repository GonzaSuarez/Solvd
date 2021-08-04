package com.solvd.booking.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private int id;
    private String name;
    private List<Room> rooms;
    private String description;
    private List<Reservation> reservations;

    public Hotel() {
    }

    public Hotel(int id, String name) {
        this.id = id;
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    public List<Reservation> getReservations() {
        return reservations;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean addRoom(Room room){
        return this.rooms.add(room);
    }

    public boolean deleteRoom(Room room){
        return this.rooms.remove(room);
    }

    public void reserveRoom(int id, float price, User user){
        this.reservations.add(new Reservation(id, price, user));
    }
}
