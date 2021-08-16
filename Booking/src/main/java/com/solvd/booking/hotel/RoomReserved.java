package com.solvd.booking.hotel;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "room_reserved")
@JsonRootName("roomreserved")
public class RoomReserved {

    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name= "price")
    private float price;
    @XmlElement(name= "idroom")
    private int idRoom;
    @XmlElement(name="idrevervation")
    private int idReservation;

    public RoomReserved() {
    }

    public RoomReserved(int id, int idRoom, int idReservation) {
        this.id = id;
        this.idRoom = idRoom;
        this.idReservation = idReservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }
}
