package com.solvd.booking.dao;

import com.solvd.booking.hotel.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IRoomDAO extends IBaseDAO<Room>{

    List<Room> getRoomsByHotelId(int hotelId) throws SQLException, ClassNotFoundException, IOException;

    void updateName(Room room);
    void updateDescription(Room room);
    void updatePrice(Room room);
}
