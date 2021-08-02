package com.solvd.booking.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private List<Room> rooms;
    private String description;
    private List<Reservation> reservations;

    public Hotel() {
    }

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
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

    public void reserveRoom(Room room, User user){
        this.reservations.add(new Reservation(room, user));
    }
}
