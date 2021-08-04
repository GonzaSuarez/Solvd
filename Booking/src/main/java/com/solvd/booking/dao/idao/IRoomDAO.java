package com.solvd.booking.dao.idao;

import com.solvd.booking.hotel.Room;

import java.util.List;

public interface IRoomDAO extends IBaseDAO<Room>{
    List<Room> getRoomsByHotelId(int hotelId);
}
