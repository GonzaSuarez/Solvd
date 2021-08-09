package com.solvd.booking.dao;

import com.solvd.booking.hotel.Hotel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IHotelDAO extends IBaseDAO<Hotel>{


    List<Hotel> getHotelsByTravelCompanyId(int travelCompanyId) throws SQLException, ClassNotFoundException, IOException;

    void updateName(Hotel hotel);
    void updateDetails(Hotel hotel);
}
