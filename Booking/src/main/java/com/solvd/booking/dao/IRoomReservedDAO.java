package com.solvd.booking.dao;

import com.solvd.booking.hotel.RoomReserved;

public interface IRoomReservedDAO extends IBaseDAO<RoomReserved> {

    void updatePrice(RoomReserved roomReserved);
}
