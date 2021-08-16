package com.solvd.booking.hotel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "user")
public class Hotel {

    @XmlAttribute(name="id")
    private int id;
    @XmlElement(name = "hotel_name")
    private String name;
    @XmlElement(name = "rooms")
    private List<Room> rooms;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "City_id")
    private int cityId;

    public Hotel() {
    }

    public Hotel(int id, String name, int cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
        this.rooms = new ArrayList<>();
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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
    public boolean addRoom(List<Room> room){
        return this.rooms.addAll(room);
    }

    public boolean deleteRoom(Room room){
        return this.rooms.remove(room);
    }

}
