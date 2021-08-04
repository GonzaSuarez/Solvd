package com.solvd.booking.services;

import com.solvd.booking.dao.daoclass.ReservationDAO;
import com.solvd.booking.dao.daoclass.UserDAO;
import com.solvd.booking.dao.idao.IReservationDAO;
import com.solvd.booking.dao.idao.IUserDAO;
import com.solvd.booking.hotel.Reservation;

public class ReservationService {

    private IReservationDAO reservationDAO = new ReservationDAO();
    private IUserDAO userDAO = new UserDAO();


    public ReservationService() throws InterruptedException {
    }

    public IReservationDAO getReservationDAO() {
        return reservationDAO;
    }

    public void setReservationDAO(IReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    public IUserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Reservation getReservation(int id) throws InterruptedException {
        Reservation reservation = reservationDAO.getItemById(id);
        reservation.setClient(userDAO.getUserByReservationId(id));
        return reservation;
    }

}
