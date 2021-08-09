package com.solvd.booking.services;

import com.solvd.booking.dao.mysqldao.jbdc.ReservationDAO;
import com.solvd.booking.dao.mysqldao.jbdc.UserDAO;
import com.solvd.booking.dao.IReservationDAO;
import com.solvd.booking.dao.IUserDAO;
import com.solvd.booking.hotel.Reservation;

import java.io.IOException;
import java.sql.SQLException;

public class ReservationService {

    private IReservationDAO reservationDAO = new ReservationDAO();
    private IUserDAO userDAO = new UserDAO();


    public ReservationService() throws InterruptedException, SQLException, ClassNotFoundException, IOException {
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

    public Reservation getReservation(int id) throws InterruptedException, SQLException, ClassNotFoundException, IOException {
        Reservation reservation = reservationDAO.getItemById(id);
        reservation.setClient(userDAO.getUserByReservationId(id));
        return reservation;
    }

}
