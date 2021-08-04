package com.solvd.booking.dao.idao;

import com.solvd.booking.hotel.Hotel;

import java.util.List;

public interface IHotelDAO extends IBaseDAO<Hotel>{


    List<Hotel> getHotelsByTravelCompanyId(int travelCompanyId);
}
