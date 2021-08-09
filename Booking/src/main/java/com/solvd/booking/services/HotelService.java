package com.solvd.booking.services;

import com.solvd.booking.dao.mysqldao.jbdc.HotelDAO;
import com.solvd.booking.dao.mysqldao.jbdc.RoomDAO;
import com.solvd.booking.dao.IHotelDAO;
import com.solvd.booking.dao.IRoomDAO;
import com.solvd.booking.hotel.Hotel;

import java.io.IOException;
import java.sql.SQLException;

public class HotelService {

    private IHotelDAO hotelDAO = new HotelDAO();
    private IRoomDAO roomDAO = new RoomDAO();

    public HotelService() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
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

    public Hotel getHotel(int hotelId) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        Hotel hotel = hotelDAO.getItemById(hotelId);
        hotel.addRoom(roomDAO.getRoomsByHotelId(hotelId));
        return hotel;
    }
}
