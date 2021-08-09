package com.solvd.booking.dao;

import com.solvd.booking.hotel.Reservation;

public interface IReservationDAO extends IBaseDAO<Reservation>{

    void updateStartDate(Reservation reservation);
    void updateEndDate(Reservation reservation);
    void updateDiscount(Reservation reservation);
    void updateTotalPrice(Reservation reservation);
}
