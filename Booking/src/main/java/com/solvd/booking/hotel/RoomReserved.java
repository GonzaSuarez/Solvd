package com.solvd.booking.hotel;

public class RoomReserved {

    private int idRoomReserved;
    private float price;
    private int idRoom;
    private int idReservation;

    public RoomReserved() {
    }

    public RoomReserved(int idRoomReserved, int idRoom, int idReservation) {
        this.idRoomReserved = idRoomReserved;
        this.idRoom = idRoom;
        this.idReservation = idReservation;
    }

    public int getIdRoomReserved() {
        return idRoomReserved;
    }

    public void setIdRoomReserved(int idRoomReserved) {
        this.idRoomReserved = idRoomReserved;
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
