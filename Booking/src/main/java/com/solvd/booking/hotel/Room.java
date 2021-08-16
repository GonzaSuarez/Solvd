package com.solvd.booking.hotel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "room")
public class Room {

    @XmlAttribute(name= "id")
    private int id;
    @XmlElement(name= "room_name")
    private String roomName;
    @XmlElement(name = "Hotel_id")
    private int idHotel;
    @XmlElement(name = "current_name")
    private double price;
    @XmlElement(name = "description")
    private String description;
    

    public Room() {
    }

    public Room(int id, String roomName, int idHotel) {
        this.id = id;
        this.roomName = roomName;
        this.idHotel = idHotel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
