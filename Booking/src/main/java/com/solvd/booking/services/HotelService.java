package com.solvd.booking.services;

import com.solvd.booking.dao.daoclass.HotelDAO;
import com.solvd.booking.dao.daoclass.RoomDAO;
import com.solvd.booking.dao.idao.IHotelDAO;
import com.solvd.booking.dao.idao.IRoomDAO;
import com.solvd.booking.hotel.Hotel;

public class HotelService {

    private IHotelDAO hotelDAO = new HotelDAO();
    private IRoomDAO roomDAO = new RoomDAO();

    public HotelService() throws InterruptedException {
    }

    public IHotelDAO getHotelDAO() {
        return hotelDAO;
    }

    public void setHotelDAO(IHotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    public IRoomDAO getRoomDAO() {
        return roomDAO;
    }

    public void setRoomDAO(IRoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public Hotel getHotel(int hotelId) throws InterruptedException {
        Hotel hotel = hotelDAO.getItemById(hotelId);
        hotel.addRoom(roomDAO.getRoomsByHotelId(hotelId));
        return hotel;
    }
}
