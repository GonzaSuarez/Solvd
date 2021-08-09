package com.solvd.booking.dao;

import com.solvd.booking.hotel.User;

import java.io.IOException;
import java.sql.SQLException;

public interface IUserDAO extends IBaseDAO<User>{

    User getUserByReservationId(int id) throws SQLException, ClassNotFoundException, IOException;

    void updateFirstName(User user);
    void updateLastName(User user);
    void updateEmail(User user);
    void updatePhone(User user);
    void updateAddress(User user);
    void updateDetails(User user);
}
