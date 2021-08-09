package com.solvd.booking.hotel;

public class RoomReserved {

    private int id;
    private float price;
    private int idRoom;
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
