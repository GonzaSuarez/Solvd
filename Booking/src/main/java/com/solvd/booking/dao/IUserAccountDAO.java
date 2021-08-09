package com.solvd.booking.dao;

import com.solvd.booking.travelcompany.UserAccount;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IUserAccountDAO extends IBaseDAO<UserAccount> {
    List<UserAccount> getUserAccountsByTravelCompanyId(int travelCompanyId) throws SQLException, ClassNotFoundException, IOException;

    void updateFirstName(UserAccount userAccount);
    void updateLastName(UserAccount userAccount);
    void updateEmail(UserAccount userAccount);
    void updateUserName(UserAccount userAccount);
    void updatePassword(UserAccount userAccount);
}
